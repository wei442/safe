package com.cloud.queue.safe.service;

import com.cloud.common.exception.RedisException;

public interface IRedisLockService {

	/**
     * 锁定
     * @param key
     * @return boolean
     */
    public boolean lock(String key) throws RedisException;

    /**
     * 释放锁
     * @param key
     * @return boolean
     */
	public boolean unlock(String key) throws RedisException;

}