package com.cloud.queue.safe.hook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName: ShutdownHandler
 * @Description: 线程关闭处理器
 * @author wei.yong
 * @date 2017年3月27日 下午12:16:45
 */
public enum ShutdownHandler {

	INSTANCE;

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	private volatile boolean keepRunning = true;

	/**
	 * @Title: keepRunning
	 * @Description: 线程运行开关标识
	 * @return boolean
	 */
	public boolean keepRunning() {
		return keepRunning;
	}

	public void setKeepRunning(boolean keepRunning) {
		this.keepRunning = keepRunning;
	}

}