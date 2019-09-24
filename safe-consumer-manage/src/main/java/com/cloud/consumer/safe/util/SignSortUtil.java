package com.cloud.consumer.safe.util;

import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

import org.apache.commons.lang3.StringUtils;

public class SignSortUtil {

	/**
	 * sign字符串参数按自然顺序拼接，空值不做参数拼接
	 * @param map
	 * @return String
	 * @author han.zhifeng
	 * @date 2016年9月28日 下午6:15:07
	 */
	public static String sign(TreeMap<String, Object> map) {
		if(map == null || map.isEmpty()) {
			return null;
		}

		StringBuffer param = new StringBuffer();
		for (Map.Entry<String, Object> entry : map.entrySet()) {
		   String key = entry.getKey();
		   String value = Objects.toString(entry.getValue(), "");
		   if(StringUtils.isNotBlank(value)) {
			   param.append(key).append("=").append(value).append("&");
		   }
		}

		String params = StringUtils.removeEnd(param.toString(), "&");
		return params;
	}

}