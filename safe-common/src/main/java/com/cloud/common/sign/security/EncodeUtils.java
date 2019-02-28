package com.cloud.common.sign.security;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

/**
 *
 * @ClassName: EncodeUtils
 * @Description: 字符编码工具类
 * @author S.J.
 * @date 2016年7月19日 下午5:28:57
 *
 */
public class EncodeUtils {

	/**
	 * 十六进制编码方式
	 */
	public static final String ENCODER_HEX = "hex";
	/**
	 * Base64编码方式
	 */
	public static final String ENCODER_BASE64 = "base64";

    /**
     * @Title: encode
     * @Description: 字节数组数据按照编码器进行字符串编码
     * @param data		字节数组数据
     * @param encoder	编码方式
     * @return String	输出结果
     */
    public static String encode(byte[] data, String encoder) {

    	String result = null;

    	if (ENCODER_BASE64.equals(encoder)) {
    		result = Base64.encodeBase64String(data);
    	}
    	else if (ENCODER_HEX.equals(encoder)) {
    		result = Hex.encodeHexString(data);
    	}

        return result;
    }

    /**
     * @Title: decode
     * @Description: 字符串按照编码器进行字节数组数据解码
     * @param data		字符串数据
     * @param encoder	编码方式
     * @return byte[]	输出结果
     * @throws DecoderException
     */
    public static byte[] decode(String data, String encoder) throws DecoderException {

    	byte[] result = null;

    	if (ENCODER_BASE64.equals(encoder)) {
    		result = Base64.decodeBase64(data);
    	}
    	else if (ENCODER_HEX.equals(encoder)) {
    		result = Hex.decodeHex(data.toCharArray());
    	}

        return result;
    }


	/**
	 * @Title: byteArry2HexString
	 * @Description: 字节数组转十六进制字符串
	 * @param data		数据源字节数组
	 * @return String	转换结果(十六进制字符串)
	 */
    public static String byteArry2HexString(byte[] data) {

    	char[] hexDigits = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};

    	int len = data.length;
        char[] out = new char[len << 1];
        for (int i = 0, j = 0; i < len; i++) {
            out[j++] = hexDigits[(0xF0 & data[i]) >>> 4];
            out[j++] = hexDigits[0x0F & data[i]];
        }
        String result = new String(out).toLowerCase();

        return result;
    }
}
