package com.cloud.consumer.safe.service;

public interface IRedisLockService {

	/**
	 * 锁定
	 * @param key
	 * @return boolean
	 */
	public boolean lock(String key);

	/**
	 * 解锁
	 * @param key
	 * @return boolean
	 */
	public boolean unlock(String key);

}