package com.cloud.queue.safe.queue;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.cloud.common.redis.keys.RedisKeysUtil;
import com.cloud.queue.safe.hook.ShutdownHandler;
import com.cloud.queue.safe.service.IBaseUserLoginLogService;
import com.cloud.queue.safe.service.IRedisService;

/**
 * @ClassName: DataBaseUserLoginLogThread
 * @Description: 基础用户登录日志队列监听类
 * @author wei.yong
 * @date 2017年3月23日 下午15:37:58
 */
@Component
public class DataBaseUserLoginLogThread implements Runnable {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	private String queueKey = RedisKeysUtil.QN_CLOUD_SAFE_BASE_USER_LOGIN_LOG;

//	//数据 Service
//	@Autowired
//	private DataBaseService dataBaseService;

	//redis Service
	@Autowired
    private IRedisService redisService;

	//基础用户登录日志 Service
	@Autowired
	private IBaseUserLoginLogService baseUserLoginLogService;

	@Override
	public void run() {
		String threadName = Thread.currentThread().getName();
		logger.info("[DataBaseUserLoginLogThread.run():基础用户登录日志数据队列-线程已启动:{}]: queueKey={}", threadName, queueKey);
		while(ShutdownHandler.INSTANCE.keepRunning()) {
			String value = null;
			try {
				value = redisService.brpop(queueKey);
				logger.info("[DataBaseUserLoginLogThread.run():基础用户登录日志数据队列-redis获取数据]: value={}", value);
			} catch (Exception e) {
				logger.error("[DataBaseUserLoginLogThread.run():{} 线程-队列取值异常，进入下一循环] Exception = {}, message = {}", threadName, e, e.getMessage());
				continue ;
			}
			if (StringUtils.isBlank(value)) {
	    		continue;
		    }

			JSONObject params = null;
			try {
				params = JSONObject.parseObject(value);
				logger.info("[DataBaseUserLoginLogThread.run():基础用户登录日志数据队列-json数据解析]: params={}", params);
			} catch (JSONException e) {
				logger.error("[DataBaseUserLoginLogThread.run():{} 线程-队列值解析异常，进入下一循环] Exception = {}, message = {}", threadName, e, e.getMessage());
				continue ;
			}

			try {
				JSONObject jsoBaseUserLoginLog = baseUserLoginLogService.add(params);
				logger.info("[DataBaseUserLoginLogThread.run():基础用户登录日志数据队列-返回信息, jsoBaseUserLoginLog:{}", jsoBaseUserLoginLog);
			} catch (Exception e) {
				logger.error("[DataBaseUserLoginLogThread.run():基础用户登录日志数据队列{} 线程处理异常, 已结束] queueKey={}, Exception={}, message={}", threadName, queueKey, e, e.getMessage());
				continue ;
			}
		}
	}

	/**
	 * 设置当前线程名称
	 * @param threadName
	 */
	public void setCurrentThreadName(String threadName) {
		Thread.currentThread().setName(threadName);
	}

}