package com.cloud.common.constants.third;

/**
 * 加密变量类 CryptoConstants
 * @author wei.yong
 * @2017年03月02日
 */
public class CryptoConstants {

	public static final String AES_RAW_KEY = "f20724f79cbc62eceae130f65a1a5cc364ecf82e17cb291bdf54e049767ae63cca1f2adfce614e5769c1f6c73f045872";
	public static String AES_KEY;
	public static String AES_IV;

	public static void setAesKey(String aesKey) {
		AES_KEY = aesKey;
	}

	public static void setAesIv(String aesIv) {
		AES_IV = aesIv;
	}


}