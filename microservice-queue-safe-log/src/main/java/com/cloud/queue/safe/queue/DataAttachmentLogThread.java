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
import com.cloud.queue.safe.service.IAttachmentLogService;
import com.cloud.queue.safe.service.IRedisService;

/**
 * @ClassName: DataAttachmentLogThread
 * @Description: 附件日志队列监听类
 * @author wei.yong
 * @date 2017年3月23日 下午15:37:58
 */
@Component
public class DataAttachmentLogThread extends Thread {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	private String queueKey = RedisKeysUtil.QN_CLOUD_SAFE_USER_LOGIN_ATTACHMENT_LOG;

	//附件日志 Service
	@Autowired
	private IAttachmentLogService attachmentLogService;

	//redis Service
	@Autowired
    private IRedisService redisService;

	@Override
	public void run() {
		String threadName = Thread.currentThread().getName();
		logger.info("[DataAttachmentLogThread.run():附件日志数据队列-线程已启动:{}]: queueKey={}", threadName, queueKey);
		while(ShutdownHandler.INSTANCE.keepRunning()) {
			String value = null;
			try {
				value = redisService.brpop(queueKey);
				logger.info("[DataAttachmentLogThread.run():附件日志数据队列-redis获取数据]: value={}", value);
			} catch (Exception e) {
				logger.error("[DataAttachmentLogThread.run():{} 线程-队列取值异常，进入下一循环] Exception = {}, message = {}", threadName, e, e.getMessage());
				continue ;
			}
			if (StringUtils.isBlank(value)) {
	    		continue;
		    }

			JSONObject params = null;
			try {
				params = JSONObject.parseObject(value);
				logger.info("[DataAttachmentLogThread.run():附件日志数据队列-json数据解析]: params={}", params);
			} catch (JSONException e) {
				logger.error("[DataAttachmentLogThread.run():{} 线程-队列值解析异常，进入下一循环] Exception = {}, message = {}", threadName, e, e.getMessage());
				continue ;
			}

			try {
				JSONObject jsoAttachmentLog = attachmentLogService.add(params);
				logger.info("[DataAttachmentLogThread.run():附件日志数据队列-返回信息, jsoAttachmentLog:{}", jsoAttachmentLog);
			} catch (Exception e) {
				logger.error("[DataAttachmentLogThread.run():附件日志数据队列{} 线程处理异常, 已结束] queueKey={}, Exception={}, message={}", threadName, queueKey, e, e.getMessage());
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