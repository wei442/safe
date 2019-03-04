package com.cloud.provider.safe.util;

import java.util.UUID;

/**
 * 获取系统中的UUID
 */
public enum UUIDUtil {

	INSTANCE;

	/**
	 * 获取UUID
	 * @return String
	 */
	public String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}

}