package com.cloud.provider.safe.util;

import com.cloud.common.enums.ResultEnum;
import com.cloud.common.exception.SafeException;

/**
 * 校验参数结果
 * @author wei.yong
 */
public class Assert {

	/**
    * 小于或登录0，抛出自定义异常
    * @param i
    * @param result
    */
	public static void thanOrEqualZreo(Integer i, ResultEnum result) {
		if(i <= 0) {
			throw new SafeException(result);
		}
	}

}
