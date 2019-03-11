package com.cloud.consumer.safe.util;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum OrderNoUtil {

	INSTANCE;

	protected static final Logger logger = LoggerFactory.getLogger(OrderNoUtil.class);

	//订单序号最大值
	public AtomicInteger ORDER_SN_MAX = new AtomicInteger(999);

	/**
	 * 序列号转编号
	 * @param sn
	 * @return String
	 */
	public String getSNCode(long sn) {
		int snMaxLen = Objects.toString(ORDER_SN_MAX).length();//序列号最大值字符串长度
		int snIncrLen = Objects.toString(sn).length();//序列号自增值字符串长度
		int len = snMaxLen - snIncrLen;//补0长度
		StringBuffer snCode = new StringBuffer(snMaxLen);
		if (len > 0) {
			for (int i=0; i<len; i++){
				snCode.append("0");
			}
		}
		snCode.append(sn);
		return snCode.toString();
	}

}