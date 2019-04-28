package com.cloud.queue.safe.service.impl;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.enums.redis.RedisResultEnum;
import com.cloud.common.exception.RedisException;
import com.cloud.queue.safe.service.IRedisLockService;
import com.cloud.queue.safe.service.IRedisService;

@Service
public class RedisLockServiceImpl implements IRedisLockService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//redis 客户端连接池
	@Autowired
	private IRedisService redisService;

	//加锁标志
	private static final String LOCKED = "true";

    //默认超时时间（毫秒）-30毫秒
    private static final long DEFAULT_TIME_OUT = 30;

    //锁的超时时间（秒），过期删除 3秒
    private static final int EXPIRE_TIME = 3;

    //锁状态标志
    private volatile boolean locked = false;

    /**
     * 锁定
     * @param key
     * @return boolean
     */
    @Override
	public boolean lock(String key) throws RedisException {
    	//系统当前时间，纳秒 1纳秒==0.000001毫秒
    	long nowTime = System.nanoTime();
        //请求锁超时时间，1毫秒=1000000纳秒
        long timeout = DEFAULT_TIME_OUT * 1000000;
        final Random r = new Random();
        try {
            //不断循环向Master节点请求锁，当请求时间(System.nanoTime() - nano)超过设定的超时时间则放弃请求锁
            //这个可以防止一个客户端在某个宕掉的master节点上阻塞过长时间
            //如果一个master节点不可用了，应该尽快尝试下一个master节点
        	//获取当前时间和开始的时间差值
        	long cost = System.nanoTime() - nowTime;
			//循环判断锁是否一直存在
    		while (cost < timeout) {
                //将锁作为key存储到redis缓存中，存储成功则获得锁
        		long i = redisService.setnx(key, LOCKED);
                if (i == 1) {
                	redisService.expire(key, EXPIRE_TIME);
                    logger.info("[BootRedisLockService.lock():获得锁成功], key:{}, expire:{}", key, EXPIRE_TIME);

                    this.locked = true;
                    return this.locked;
                } else {
                	// 存在锁（会一直执行（在最大等待时间范围内）等待该锁释放）
                    String result = redisService.get(key);
                    logger.info("[BootRedisLockService.lock():获得锁成功], key:{}, result:{}", key, result);
                }

                //ttl小于0 表示key上没有设置生存时间（key是不会不存在的，因为前面setnx会自动创建）
                //如果出现这种状况，那就是进程的某个实例setnx成功后crash 导致紧跟着的expire没有被调用
                long ttl = redisService.ttl(key);
                if(ttl < 0) {
            		redisService.expire(key, EXPIRE_TIME);
                }

                //获取锁失败时，应该在随机延时后进行重试，避免不同客户端同时重试导致谁都无法拿到锁的情况出现
                //睡眠3毫秒后继续请求锁
                Thread.sleep(3, r.nextInt(500));
            }
        } catch (Exception e) {
            logger.error("[BootRedisLockService.lock():获得锁-异常], Exception={}, message={}", e, e.getMessage());
            throw new RedisException(RedisResultEnum.REDIS_ERROR);
		}
        return false;
	}

    /**
     * 释放锁
     * @param key
     * @return boolean
     */
	@Override
	public boolean unlock(String key) throws RedisException {
		boolean unlocked = false;
        try {
        	if (this.locked) {
        		redisService.del(key);
        		locked = false;
        		unlocked = true;
        	}
         	logger.info("[BootRedisLockService.unlock():释放锁成功], key:{}", key);
        } catch (Exception e) {
        	logger.error("[BootRedisLockService.unlock():释放锁-异常], Exception={}, message={}", e, e.getMessage());
        	throw new RedisException(RedisResultEnum.REDIS_ERROR);
        }
		return unlocked;
    }

}