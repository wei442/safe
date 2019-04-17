package com.cloud.provider.safe.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 功能描述：json_search结果处理函数
 * @Package: com.cloud.provider.safe.util
 * @author: TM.WANG
 * @date: 2018年7月20日
 */
public class PositionRankUtil {

	protected final static Logger logger = LoggerFactory.getLogger(PositionRankUtil.class);

	/**
	 * 获取json_search结果中得位置信息
	 * @param String
	 * @return String
	 */
	public static String getPositionFromStr(String positionStr) {
		String poString = StringUtils.substringBefore(positionStr, ".") + "\"";
		String position = StringUtils.deleteWhitespace(poString);
		return position;
	}

}