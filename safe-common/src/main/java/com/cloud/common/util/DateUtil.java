package com.cloud.common.util;

import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 * @author wei.yong
 */
public class DateUtil {

	/**
	 * 获取当天开始时间,如：2000-1-1 00:00:00
	 * @param date
	 * @return Date
	 */
	public static Date getDateTimeStart(final Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

	/**
	 * 获取当天结束时间,如：2000-1-1 23:59:59
	 * @param date
	 * @return Date
	 */
	public static Date getDateTimeEnd(final Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		return calendar.getTime();
	}

}