package com.cloud.provider.safe.util;

import java.util.Collection;
import java.util.Map;

import com.cloud.common.enums.ResultEnum;
import com.cloud.common.exception.SafeException;

/**
 * 校验参数结果
 * @author
 */
public class Assert {

	/**
	 * 小于或登录0，对象为null，抛出自定义异常
	 * @param obj
	 * @param result
	 */
	public static void thanOrEqualZreo(Object obj, ResultEnum result) {
		if(obj == null) {
			throw new SafeException(result);
		}
		if (obj instanceof Integer) {
			Integer i = (Integer) obj;
			if(i <= 0) {
				throw new SafeException(result);
			}
		}
		if (obj instanceof Collection) {
			Collection<?> collection = (Collection<?>) obj;
			if(collection == null || collection.isEmpty()) {
				throw new SafeException(result);
			}
		}
		if (obj instanceof Map) {
			Map<?, ?> map = (Map<?, ?>) obj;
			if(map == null || map.isEmpty()) {
				throw new SafeException(result);
			}
		}
	}

}