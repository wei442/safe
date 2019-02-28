package com.cloud.common.util;

import java.math.BigDecimal;

/**
 * 数字计算工具类
 * @author weiyong
 */
public enum MathUtil {

	INSTANCE;

	/**
	 * 精确的加法计算 不四舍五入
	 * @param v1
	 * @param v2
	 * @return BigDecimal
	 */
	public BigDecimal add(String v1, String v2) {
		if(v1 == null || v1.length() ==0 || v2 == null || v2.length() ==0) {
			return null;
		}

		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.add(b2);
	}
	/**
	 * 精确的加法计算  根据输入参数留取小数计算
	 * @param v1
	 * @param v2
	 * @param scale
	 * @param roundingMode
	 * @return BigDecimal
	 */
	public BigDecimal add(String v1, String v2, int scale, int roundingMode) {
		if(v1 == null || v1.length() ==0 || v2 == null || v2.length() ==0) {
			return null;
		}

		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.add(b2).setScale(scale, roundingMode);
	}

	/**
	 * 提供精确的减法运算 不四舍五入
	 * @param v1  被减数
	 * @param v2  减数
	 * @return BigDecimal
	 */
	public BigDecimal sub(String v1, String v2) {
		if(v1 == null || v1.length() ==0 || v2 == null || v2.length() ==0) {
			return null;
		}

		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.subtract(b2);
	}

	/**
	 * 提供精确的减法运算 根据输入参数留取小数计算
	 * @param v1  被减数
	 * @param v2  减数
	 * @param scale
	 * @param roundingMode
	 * @return BigDecimal
	 */
	public BigDecimal sub(String v1, String v2, int scale, int roundingMode) {
		if(v1 == null || v1.length() ==0 || v2 == null || v2.length() ==0) {
			return null;
		}

		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.subtract(b2).setScale(scale, roundingMode);
	}

	/**
	 * 提供精确的乘法运算 不四舍五入
	 * @param v1
	 * @param v2
	 * @return BigDecimal
	 */
	public BigDecimal multiply(String v1, String v2) {
		if(v1 == null || v1.length() ==0 || v2 == null || v2.length() ==0) {
			return null;
		}

		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.multiply(b2);
	}

	/**
	 * 提供精确的乘法运算 根据输入参数留取小数计算
	 * @param v1
	 * @param v2
	 * @param scale
	 * @param roundingMode
	 * @return BigDecimal
	 */
	public BigDecimal multiply(String v1, String v2, int scale, int roundingMode) {
		if(v1 == null || v1.length() ==0 || v2 == null || v2.length() ==0) {
			return null;
		}

		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.multiply(b2).setScale(scale, roundingMode);
	}

	/**
	 * 提供精确的除法运算  不四舍五入
	 * @param v1
	 * @param v2
	 * @return BigDecimal
	 */
	public BigDecimal divide(String v1, String v2) {
		if(v1 == null || v1.length() ==0 || v2 == null || v2.length() ==0) {
			return null;
		}

		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.divide(b2);
	}

	/**
	 * 提供精确的除法运算 根据输入参数留取小数计算
	 * @param v1
	 * @param v2
	 * @param scale
	 * @param roundingMode
	 * @return BigDecimal
	 */
	public BigDecimal divide(String v1, String v2, int scale, int roundingMode) {
	    if(v1 == null || v1.length() ==0 || v2 == null || v2.length() ==0) {
	        return null;
	    }

	    BigDecimal b1 = new BigDecimal(v1);
	    BigDecimal b2 = new BigDecimal(v2);
	    return b1.divide(b2, scale, roundingMode);
	}

	/**
	 *
	 * <p>double类型的比较</p>
	 *
	 * @param val1
	 * @param val2
	 * @return String
	 * @author: yang.tongjie
	 * @date: Created on 2016年6月8日 下午3:21:51
	 */
	public String compare(String d1, String d2) {
		BigDecimal val1=new BigDecimal(d1);
		BigDecimal val2=new BigDecimal(d2);
	    String result = "";
	    if (val1.compareTo(val2) < 0) {
	        result = "-1";
	    }
	    if (val1.compareTo(val2) == 0) {
	        result = "0";
	    }
	    if (val1.compareTo(val2) > 0) {
	        result = "1";
	    }
	    return result;
	}

}