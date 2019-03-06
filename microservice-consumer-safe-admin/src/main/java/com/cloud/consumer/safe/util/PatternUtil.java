package com.cloud.consumer.safe.util;

import java.util.regex.Pattern;
/**
 * 正则验证工具类
 * @author yue.li3
 * @date 2016年7月8日 下午6:05:52
 */
public class PatternUtil {

    /**
     * 判断是整数 ，第一个数字不能为 0
     */
    public static Pattern INTEGER = Pattern.compile("^(0|[1-9][0-9]*)$");
//    零和非零开头的数字：^(0|[1-9][0-9]*)$

    /**
     * 判断是正整数 可以带+号，第一个数字不能为 0
     * ^\\+{0,1}[1-9]\\d*
     */
    public static Pattern INTEGER_POSITIVE = Pattern.compile("^\\+{0,1}[1-9]\\d*");

    /**
     * 判断是负整数 必须带负号，第一个数字也不能为 0
     */
    public static Pattern INTEGER_NEGATIVE = Pattern.compile("^-[1-9]\\d*");

    /**
     * 判断是小数
     */
    public static Pattern DECIMAL = Pattern.compile("[-+]{0,1}\\d+\\.\\d*|[-+]{0,1}\\d*\\.\\d+");

    /**
     * 判断是正浮点数，大于0，
     */
    public static Pattern DECIMAL_POSITIVE = Pattern.compile("^[1-9]\\d*\\.\\d*|0\\.\\d*[1-9]\\d*$");

    /**
     * 负浮点数，小于0
     */
    public static Pattern DECIMAL_NEGATIVE = Pattern.compile("^-([1-9]\\d*\\.\\d*|0\\.\\d*[1-9]\\d*)$");

    /**
     * 判断图片格式
     */
    public static Pattern IMG = Pattern.compile("([^\\s]+(\\.(?i)(jpg|jpeg|png|gif|bmp|JPG|JPEG|PNG|GIF|BMP))$)");

}