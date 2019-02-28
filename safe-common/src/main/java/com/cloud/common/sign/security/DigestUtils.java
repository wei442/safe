package com.cloud.common.sign.security;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.DecoderException;

/**
 *
 * @ClassName: DigestUtils
 * @Description: 数据摘要生成工具类
 * @author S.J.
 * @date 2016年7月18日 下午6:38:52
 *
 */
public class DigestUtils {

	/**
	 * 消息摘要算法
	 */
	private static final String MD5 = "MD5";
	private static final String SHA1 = "SHA-1";
	private static final String SHA256 = "SHA-256";
	private static final String SHA384 = "SHA-384";
	private static final String SHA512 = "SHA-512";

	/**
	 * 带密钥的消息摘要算法
	 */
	private static final String HmacMD5 = "HmacMD5";
	private static final String HmacSHA1 = "HmacSHA1";
	private static final String HmacSHA256 = "HmacSHA256";
	private static final String HmacSHA384 = "HmacSHA384";
	private static final String HmacSHA512 = "HmacSHA512";

	/**
	 * 默认字符集(UTF-8)
	 */
	private static final String defaultCharset = Charsets.UTF_8;

	/**
	 * 默认编码方式(HEX)
	 */
	private static final String defaultEncoder = EncodeUtils.ENCODER_HEX;


	/**
	 * @Title: md5
	 * @Description: MD5数据摘要生成(默认编码方式)
	 * @param data	数据源字符串
	 * @return String	摘要结果
	 * @throws UnsupportedEncodingException
	 */
	public static final String md5(String data) throws UnsupportedEncodingException {

		if (null == data || "".equals(data)) {
    		throw new RuntimeException("data is empty");
    	}

        return md5(data.getBytes(defaultCharset));
    }

	/**
	 * @Title: md5
	 * @Description: MD5数据摘要生成
	 * @param data	数据源字符串
	 * @param encoder	编码方式
	 * @return String	摘要结果
	 * @throws UnsupportedEncodingException
	 */
	public static final String md5(String data, String encoder) throws UnsupportedEncodingException {

		if (null == data || "".equals(data)) {
    		throw new RuntimeException("data is empty");
    	}

		return md5(data.getBytes(defaultCharset), encoder);
    }

	/**
	 * @Title: md5
	 * @Description: MD5数据摘要生成(默认编码方式)
	 * @param data		数据源字节数组
	 * @return String	摘要结果
	 */
	public static final String md5(byte[] data) {

        return md5(data, defaultEncoder);
    }

	/**
	 * @Title: md5
	 * @Description: MD5数据摘要生成
	 * @param data		数据源字节数组
	 * @param encoder	编码方式
	 * @return String	摘要结果
	 */
	public static final String md5(byte[] data, String encoder) {

		if (null == data || data.length == 0) {
    		throw new RuntimeException("data is empty");
    	}
		if (null == encoder || "".equals(encoder.trim())) {
    		throw new RuntimeException("encoder is empty");
    	}

		byte[] secret = digest(data, MD5);
        // 把密文编码为字符串形式
        return EncodeUtils.encode(secret, encoder);
    }

	/**
	 * @Title: sha1
	 * @Description: SHA1数据摘要生成(默认编码方式)
	 * @param data	数据源字符串
	 * @return String	摘要结果
	 * @throws UnsupportedEncodingException
	 */
	public static final String sha1(String data) throws UnsupportedEncodingException {

		if (null == data || "".equals(data)) {
    		throw new RuntimeException("data is empty");
    	}

        return sha1(data.getBytes(defaultCharset));
    }

	/**
	 * @Title: sha1
	 * @Description: SHA1数据摘要生成
	 * @param data	数据源字符串
	 * @param encoder	编码方式
	 * @return String	摘要结果
	 * @throws UnsupportedEncodingException
	 */
	public static final String sha1(String data, String encoder) throws UnsupportedEncodingException {

		if (null == data || "".equals(data)) {
    		throw new RuntimeException("data is empty");
    	}

		return sha1(data.getBytes(defaultCharset), encoder);
    }

	/**
	 * @Title: sha1
	 * @Description: SHA1数据摘要生成(默认编码方式)
	 * @param data		数据源字节数组
	 * @return String	摘要结果
	 */
	public static final String sha1(byte[] data) {

        return sha1(data, defaultEncoder);
    }

	/**
	 * @Title: sha1
	 * @Description: SHA1数据摘要生成
	 * @param data		数据源字节数组
	 * @param encoder	编码方式
	 * @return String	摘要结果
	 */
	public static final String sha1(byte[] data, String encoder) {

		if (null == data || data.length == 0) {
    		throw new RuntimeException("data is empty");
    	}
		if (null == encoder || "".equals(encoder.trim())) {
    		throw new RuntimeException("encoder is empty");
    	}

		byte[] secret = digest(data, SHA1);
        // 把密文编码为字符串形式
        return EncodeUtils.encode(secret, encoder);
    }

	/**
	 * @Title: sha256
	 * @Description: SHA256数据摘要生成(默认编码方式)
	 * @param data	数据源字符串
	 * @return String	摘要结果
	 * @throws UnsupportedEncodingException
	 */
	public static final String sha256(String data) throws UnsupportedEncodingException {

		if (null == data || "".equals(data)) {
    		throw new RuntimeException("data is empty");
    	}

        return sha256(data.getBytes(defaultCharset));
    }

	/**
	 * @Title: sha256
	 * @Description: SHA256数据摘要生成
	 * @param data	数据源字符串
	 * @param encoder	编码方式
	 * @return String	摘要结果
	 * @throws UnsupportedEncodingException
	 */
	public static final String sha256(String data, String encoder) throws UnsupportedEncodingException {

		if (null == data || "".equals(data)) {
    		throw new RuntimeException("data is empty");
    	}

		return sha256(data.getBytes(defaultCharset), encoder);
    }

	/**
	 * @Title: sha256
	 * @Description: SHA256数据摘要生成(默认编码方式)
	 * @param data		数据源字节数组
	 * @return String	摘要结果
	 */
	public static final String sha256(byte[] data) {
        return sha256(data, defaultEncoder);
    }

	/**
	 * @Title: sha256
	 * @Description: SHA256数据摘要生成
	 * @param data		数据源字节数组
	 * @param encoder	编码方式
	 * @return String
	 */
	public static final String sha256(byte[] data, String encoder) {

		if (null == data || data.length == 0) {
    		throw new RuntimeException("data is empty");
    	}
		if (null == encoder || "".equals(encoder.trim())) {
    		throw new RuntimeException("encoder is empty");
    	}

		byte[] secret = digest(data, SHA256);
        // 把密文编码为字符串形式
        return EncodeUtils.encode(secret, encoder);
    }

	/**
	 * @Title: sha384
	 * @Description: SHA384数据摘要生成(默认编码方式)
	 * @param data	数据源字符串
	 * @return String	摘要结果
	 * @throws UnsupportedEncodingException
	 */
	public static final String sha384(String data) throws UnsupportedEncodingException {

		if (null == data || "".equals(data)) {
    		throw new RuntimeException("data is empty");
    	}

        return sha384(data.getBytes(defaultCharset));
    }

	/**
	 * @Title: sha384
	 * @Description: SHA384数据摘要生成
	 * @param data	数据源字符串
	 * @param encoder	编码方式
	 * @return String	摘要结果
	 * @throws UnsupportedEncodingException
	 */
	public static final String sha384(String data, String encoder) throws UnsupportedEncodingException {

		if (null == data || "".equals(data)) {
    		throw new RuntimeException("data is empty");
    	}

		return sha384(data.getBytes(defaultCharset), encoder);
    }

	/**
	 * @Title: sha384
	 * @Description: SHA384数据摘要生成(默认编码方式)
	 * @param data		数据源字节数组
	 * @return String	摘要结果
	 */
	public static final String sha384(byte[] data) {
        return sha384(data, defaultEncoder);
    }

	/**
	 * @Title: sha384
	 * @Description: SHA384数据摘要生成
	 * @param data		数据源字节数组
	 * @param encoder	编码方式
	 * @return String	摘要结果
	 */
	public static final String sha384(byte[] data, String encoder) {

		if (null == data || data.length == 0) {
    		throw new RuntimeException("data is empty");
    	}
		if (null == encoder || "".equals(encoder.trim())) {
    		throw new RuntimeException("encoder is empty");
    	}

		byte[] secret = digest(data, SHA384);
        // 把密文编码为字符串形式
        return EncodeUtils.encode(secret, encoder);
    }

	/**
	 * @Title: sha512
	 * @Description: SHA512数据摘要生成(默认编码方式)
	 * @param data	数据源字符串
	 * @return String	摘要结果
	 * @throws UnsupportedEncodingException
	 */
	public static final String sha512(String data) throws UnsupportedEncodingException {

		if (null == data || "".equals(data)) {
    		throw new RuntimeException("data is empty");
    	}

        return sha512(data.getBytes(defaultCharset));
    }

	/**
	 * @Title: sha512
	 * @Description: SHA512数据摘要生成
	 * @param data	数据源字符串
	 * @param encoder	编码方式
	 * @return String	摘要结果
	 * @throws UnsupportedEncodingException
	 */
	public static final String sha512(String data, String encoder) throws UnsupportedEncodingException {

		if (null == data || "".equals(data)) {
    		throw new RuntimeException("data is empty");
    	}

		return sha512(data.getBytes(defaultCharset), encoder);
    }

	/**
	 * @Title: sha512
	 * @Description: SHA512数据摘要生成(默认编码方式)
	 * @param data		数据源字节数组
	 * @return String	摘要结果
	 */
	public static final String sha512(byte[] data) {
        return sha512(data, defaultEncoder);
    }

	/**
	 * @Title: sha512
	 * @Description: SHA512数据摘要生成
	 * @param data		数据源字节数组
	 * @param encoder	编码方式
	 * @return String	摘要结果
	 */
	public static final String sha512(byte[] data, String encoder) {

		if (null == data || data.length == 0) {
    		throw new RuntimeException("data is empty");
    	}
		if (null == encoder || "".equals(encoder.trim())) {
    		throw new RuntimeException("encoder is empty");
    	}

		byte[] secret = digest(data, SHA512);
        // 把密文编码为字符串形式
        return EncodeUtils.encode(secret, encoder);
    }

	/**
	 * @Title: digest
	 * @Description: 获取数据源的摘要
	 * @param data		数据源字节数组
	 * @param algorithm	摘要算法名称
	 * @return byte[]	摘要结果
	 */
	public static final byte[] digest(byte[] data, String algorithm) {

		if (null == data || data.length == 0) {
    		throw new RuntimeException("data is empty");
    	}
		if (null == algorithm || "".equals(algorithm.trim())) {
    		throw new RuntimeException("algorithm is empty");
    	}

		try {
			// 获得摘要算法的 MessageDigest 对象
			MessageDigest mdInst = MessageDigest.getInstance(algorithm);
			// 使用指定的字节更新摘要
			mdInst.update(data);
			// 获得密文
			byte[] md = mdInst.digest();
			return md;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
    }


	/******************************** 带密钥的消息摘要生成  *********************************/

    /**
     * @Title: generateHmacMD5Key
     * @Description: HmacMD5密钥生成(默认Base64编码)
     * @return String	输出Key
     * @throws NoSuchAlgorithmException
     */
    public static String generateHmacMD5Key() throws NoSuchAlgorithmException {

    	return generateHmacMD5Key(defaultEncoder);
    }

    /**
     * @Title: generateHmacMD5Key
     * @Description: HmacMD5密钥生成
     * @param encoder	编码方式
     * @return String	输出Key
     * @throws NoSuchAlgorithmException
     */
    public static String generateHmacMD5Key(String encoder) throws NoSuchAlgorithmException {

    	if (null == encoder || "".equals(encoder.trim())) {
    		throw new RuntimeException("encoder is empty");
    	}

    	byte[] data = generateHmacKey(HmacMD5);

    	return EncodeUtils.encode(data, encoder);
    }

    /**
     * @Title: hmacMD5
     * @Description: MD5带密钥摘要生成(默认Base64编码)
     * @param data		数据源(字符串)
     * @param key		摘要密钥(字符串)
     * @return String	摘要结果
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException String
     * @throws DecoderException
     * @throws UnsupportedEncodingException
     */
    public static String hmacMD5(String data, String key) throws NoSuchAlgorithmException, InvalidKeyException, DecoderException, UnsupportedEncodingException {

    	if (null == data || "".equals(data)) {
    		throw new RuntimeException("data is empty");
    	}
    	if (null == key || "".equals(key.trim())) {
    		throw new RuntimeException("key is empty");
    	}

    	return hmacMD5(data.getBytes(defaultCharset), EncodeUtils.decode(key, defaultEncoder), defaultEncoder);
    }

    /**
     * @Title: hmacMD5
     * @Description: MD5带密钥摘要生成
     * @param data		数据源(字符串)
     * @param key		摘要密钥(字符串)
     * @param encoder	编码方式
     * @return String	摘要结果
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws DecoderException
     * @throws UnsupportedEncodingException
     */
    public static String hmacMD5(String data, String key, String encoder) throws NoSuchAlgorithmException, InvalidKeyException, DecoderException, UnsupportedEncodingException {

    	if (null == data || "".equals(data)) {
    		throw new RuntimeException("data is empty");
    	}
    	if (null == key || "".equals(key.trim())) {
    		throw new RuntimeException("key is empty");
    	}
    	if (null == encoder || "".equals(encoder.trim())) {
    		throw new RuntimeException("encoder is empty");
    	}

    	return hmacMD5(data.getBytes(defaultCharset), EncodeUtils.decode(key, encoder), encoder);
    }

    /**
     * @Title: hmacMD5
     * @Description: MD5带密钥摘要生成(默认Base64编码)
     * @param data		数据源(字节数组)
     * @param key		摘要密钥
     * @return String	摘要结果
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException String
     */
    public static String hmacMD5(byte[] data, byte[] key) throws NoSuchAlgorithmException, InvalidKeyException {

    	return hmacDigest(data, key, HmacMD5);
    }

    /**
     * @Title: hmacMD5
     *@Description: MD5带密钥摘要生成
     * @param data		数据源(字节数组)
     * @param key		摘要密钥(字节数组)
     * @param encoder	编码方式
     * @return String	摘要结果
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException String
     */
    public static String hmacMD5(byte[] data, byte[] key, String encoder) throws NoSuchAlgorithmException, InvalidKeyException {

    	return hmacDigest(data, key, HmacMD5, encoder);
    }

    /**
     * @Title: generateHmacSHA1Key
     * @Description: HmacSHA1密钥生成(默认Base64编码)
     * @return String	输出Key
     * @throws NoSuchAlgorithmException
     */
    public static String generateHmacSHA1Key() throws NoSuchAlgorithmException {

    	return generateHmacSHA1Key(defaultEncoder);
    }

    /**
     * @Title: generateHmacSHA1Key
     * @Description: HmacSHA1密钥生成
     * @param encoder	编码方式
     * @return String	输出Key
     * @throws NoSuchAlgorithmException
     */
    public static String generateHmacSHA1Key(String encoder) throws NoSuchAlgorithmException {

    	if (null == encoder || "".equals(encoder.trim())) {
    		throw new RuntimeException("encoder is empty");
    	}

    	byte[] data = generateHmacKey(HmacSHA1);

    	return EncodeUtils.encode(data, encoder);
    }

    /**
     * @Title: hmacSHA1
     * @Description: SHA1带密钥摘要生成(默认Base64编码)
     * @param data		数据源(字符串)
     * @param key		摘要密钥(字符串)
     * @return String	摘要结果
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException String
     * @throws DecoderException
     * @throws UnsupportedEncodingException
     */
    public static String hmacSHA1(String data, String key) throws NoSuchAlgorithmException, InvalidKeyException, DecoderException, UnsupportedEncodingException {

    	if (null == data || "".equals(data)) {
    		throw new RuntimeException("data is empty");
    	}
    	if (null == key || "".equals(key.trim())) {
    		throw new RuntimeException("key is empty");
    	}

    	return hmacSHA1(data.getBytes(defaultCharset), EncodeUtils.decode(key, defaultEncoder), defaultEncoder);
    }

    /**
     * @Title: hmacSHA1
     * @Description: SHA1带密钥摘要生成
     * @param data		数据源(字符串)
     * @param key		摘要密钥(字符串)
     * @param encoder	编码方式
     * @return String	摘要结果
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws DecoderException
     * @throws UnsupportedEncodingException
     */
    public static String hmacSHA1(String data, String key, String encoder) throws NoSuchAlgorithmException, InvalidKeyException, DecoderException, UnsupportedEncodingException {

    	if (null == data || "".equals(data)) {
    		throw new RuntimeException("data is empty");
    	}
    	if (null == key || "".equals(key.trim())) {
    		throw new RuntimeException("key is empty");
    	}
    	if (null == encoder || "".equals(encoder.trim())) {
    		throw new RuntimeException("encoder is empty");
    	}

    	return hmacSHA1(data.getBytes(defaultCharset), EncodeUtils.decode(key, encoder), encoder);
    }

    /**
     * @Title: hmacSHA1
     * @Description: SHA1带密钥摘要生成(默认Base64编码)
     * @param data		数据源(字节数组)
     * @param key		摘要密钥(字节数组)
     * @return String	摘要结果
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException String
     */
    public static String hmacSHA1(byte[] data, byte[] key) throws NoSuchAlgorithmException, InvalidKeyException {

    	return hmacDigest(data, key, HmacSHA1);
    }

    /**
     * @Title: hmacSHA1
     *@Description: SHA1带密钥摘要生成
     * @param data		数据源(字节数组)
     * @param key		摘要密钥(字节数组)
     * @param encoder	编码方式
     * @return String	摘要结果
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException String
     */
    public static String hmacSHA1(byte[] data, byte[] key, String encoder) throws NoSuchAlgorithmException, InvalidKeyException {

    	return hmacDigest(data, key, HmacSHA1, encoder);
    }

    /**
     * @Title: generateHmacSHA256Key
     * @Description: HmacSHA256密钥生成(默认Base64编码)
     * @return String	输出Key
     * @throws NoSuchAlgorithmException
     */
    public static String generateHmacSHA256Key() throws NoSuchAlgorithmException {

    	return generateHmacSHA256Key(defaultEncoder);
    }

    /**
     * @Title: generateHmacSHA256Key
     * @Description: HmacSHA256密钥生成
     * @param encoder	编码方式
     * @return String	输出Key
     * @throws NoSuchAlgorithmException
     */
    public static String generateHmacSHA256Key(String encoder) throws NoSuchAlgorithmException {

    	if (null == encoder || "".equals(encoder.trim())) {
    		throw new RuntimeException("encoder is empty");
    	}

    	byte[] data = generateHmacKey(HmacSHA256);

    	return EncodeUtils.encode(data, encoder);
    }

    /**
     * @Title: hmacSHA256
     * @Description: SHA256带密钥摘要生成(默认Base64编码)
     * @param data		数据源(字符串)
     * @param key		摘要密钥(字符串)
     * @return String	摘要结果
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException String
     * @throws DecoderException
     * @throws UnsupportedEncodingException
     */
    public static String hmacSHA256(String data, String key) throws NoSuchAlgorithmException, InvalidKeyException, DecoderException, UnsupportedEncodingException {

    	if (null == data || "".equals(data)) {
    		throw new RuntimeException("data is empty");
    	}
    	if (null == key || "".equals(key.trim())) {
    		throw new RuntimeException("key is empty");
    	}

    	return hmacSHA256(data.getBytes(defaultCharset), EncodeUtils.decode(key, defaultEncoder), defaultEncoder);
    }

    /**
     * @Title: hmacSHA256
     * @Description: SHA256带密钥摘要生成
     * @param data		数据源(字符串)
     * @param key		摘要密钥(字符串)
     * @param encoder	编码方式
     * @return String	摘要结果
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws DecoderException
     * @throws UnsupportedEncodingException
     */
    public static String hmacSHA256(String data, String key, String encoder) throws NoSuchAlgorithmException, InvalidKeyException, DecoderException, UnsupportedEncodingException {

    	if (null == data || "".equals(data)) {
    		throw new RuntimeException("data is empty");
    	}
    	if (null == key || "".equals(key.trim())) {
    		throw new RuntimeException("key is empty");
    	}
    	if (null == encoder || "".equals(encoder.trim())) {
    		throw new RuntimeException("encoder is empty");
    	}

    	return hmacSHA256(data.getBytes(defaultCharset), EncodeUtils.decode(key, encoder), encoder);
    }

    /**
     * @Title: hmacSHA256
     * @Description: SHA256带密钥摘要生成(默认Base64编码)
     * @param data		数据源(字节数组)
     * @param key		摘要密钥(字节数组)
     * @return String	摘要结果
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException String
     */
    public static String hmacSHA256(byte[] data, byte[] key) throws NoSuchAlgorithmException, InvalidKeyException {

    	return hmacDigest(data, key, HmacSHA256);
    }

    /**
     * @Title: hmacSHA256
     *@Description: SHA256带密钥摘要生成
     * @param data		数据源(字节数组)
     * @param key		摘要密钥(字节数组)
     * @param encoder	编码方式
     * @return String	摘要结果
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException String
     */
    public static String hmacSHA256(byte[] data, byte[] key, String encoder) throws NoSuchAlgorithmException, InvalidKeyException {

    	return hmacDigest(data, key, HmacSHA256, encoder);
    }

    /**
     * @Title: generateHmacSHA384Key
     * @Description: HmacSHA384密钥生成(默认Base64编码)
     * @return String	输出Key
     * @throws NoSuchAlgorithmException
     */
    public static String generateHmacSHA384Key() throws NoSuchAlgorithmException {

    	return generateHmacSHA384Key(defaultEncoder);
    }

    /**
     * @Title: generateHmacSHA384Key
     * @Description: HmacSHA384密钥生成
     * @param encoder	编码方式
     * @return String	输出Key
     * @throws NoSuchAlgorithmException
     */
    public static String generateHmacSHA384Key(String encoder) throws NoSuchAlgorithmException {

    	if (null == encoder || "".equals(encoder.trim())) {
    		throw new RuntimeException("encoder is empty");
    	}

    	byte[] data = generateHmacKey(HmacSHA384);

    	return EncodeUtils.encode(data, encoder);
    }

    /**
     * @Title: hmacSHA384
     * @Description: SHA384带密钥摘要生成(默认Base64编码)
     * @param data		数据源(字符串)
     * @param key		摘要密钥(字符串)
     * @return String	摘要结果
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException String
     * @throws DecoderException
     * @throws UnsupportedEncodingException
     */
    public static String hmacSHA384(String data, String key) throws NoSuchAlgorithmException, InvalidKeyException, DecoderException, UnsupportedEncodingException {

    	if (null == data || "".equals(data)) {
    		throw new RuntimeException("data is empty");
    	}
    	if (null == key || "".equals(key.trim())) {
    		throw new RuntimeException("key is empty");
    	}

    	return hmacSHA384(data.getBytes(defaultCharset), EncodeUtils.decode(key, defaultEncoder), defaultEncoder);
    }

    /**
     * @Title: hmacSHA384
     * @Description: SHA384带密钥摘要生成
     * @param data		数据源(字符串)
     * @param key		摘要密钥(字符串)
     * @param encoder	编码方式
     * @return String	摘要结果
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws DecoderException
     * @throws UnsupportedEncodingException
     */
    public static String hmacSHA384(String data, String key, String encoder) throws NoSuchAlgorithmException, InvalidKeyException, DecoderException, UnsupportedEncodingException {

    	if (null == data || "".equals(data)) {
    		throw new RuntimeException("data is empty");
    	}
    	if (null == key || "".equals(key.trim())) {
    		throw new RuntimeException("key is empty");
    	}
    	if (null == encoder || "".equals(encoder.trim())) {
    		throw new RuntimeException("encoder is empty");
    	}

    	return hmacSHA384(data.getBytes(defaultCharset), EncodeUtils.decode(key, encoder), encoder);
    }

    /**
     * @Title: hmacSHA384
     * @Description: SHA384带密钥摘要生成(默认Base64编码)
     * @param data		数据源(字节数组)
     * @param key		摘要密钥(字节数组)
     * @return String	摘要结果
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException String
     */
    public static String hmacSHA384(byte[] data, byte[] key) throws NoSuchAlgorithmException, InvalidKeyException {

    	return hmacDigest(data, key, HmacSHA384);
    }

    /**
     * @Title: hmacSHA384
     *@Description: SHA384带密钥摘要生成
     * @param data		数据源(字节数组)
     * @param key		摘要密钥(字节数组)
     * @param encoder	编码方式
     * @return String	摘要结果
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException String
     */
    public static String hmacSHA384(byte[] data, byte[] key, String encoder) throws NoSuchAlgorithmException, InvalidKeyException {

    	return hmacDigest(data, key, HmacSHA384, encoder);
    }

    /**
     * @Title: generateHmacSHA512Key
     * @Description: HmacSHA512密钥生成(默认Base64编码)
     * @return String	输出Key
     * @throws NoSuchAlgorithmException
     */
    public static String generateHmacSHA512Key() throws NoSuchAlgorithmException {

    	return generateHmacSHA512Key(defaultEncoder);
    }

    /**
     * @Title: generateHmacSHA512Key
     * @Description: HmacSHA512密钥生成
     * @param encoder	编码方式
     * @return String	输出Key
     * @throws NoSuchAlgorithmException
     */
    public static String generateHmacSHA512Key(String encoder) throws NoSuchAlgorithmException {

    	if (null == encoder || "".equals(encoder.trim())) {
    		throw new RuntimeException("encoder is empty");
    	}

    	byte[] data = generateHmacKey(HmacSHA512);

    	return EncodeUtils.encode(data, encoder);
    }

    /**
     * @Title: hmacSHA512
     * @Description: SHA512带密钥摘要生成(默认Base64编码)
     * @param data		数据源(字符串)
     * @param key		摘要密钥(字符串)
     * @return String	摘要结果
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException String
     * @throws DecoderException
     * @throws UnsupportedEncodingException
     */
    public static String hmacSHA512(String data, String key) throws NoSuchAlgorithmException, InvalidKeyException, DecoderException, UnsupportedEncodingException {

    	if (null == data || "".equals(data)) {
    		throw new RuntimeException("data is empty");
    	}
    	if (null == key || "".equals(key.trim())) {
    		throw new RuntimeException("key is empty");
    	}

    	return hmacSHA512(data.getBytes(defaultCharset), EncodeUtils.decode(key, defaultEncoder), defaultEncoder);
    }

    /**
     * @Title: hmacSHA512
     * @Description: SHA512带密钥摘要生成
     * @param data		数据源(字符串)
     * @param key		摘要密钥(字符串)
     * @param encoder	编码方式
     * @return String	摘要结果
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws DecoderException
     * @throws UnsupportedEncodingException
     */
    public static String hmacSHA512(String data, String key, String encoder) throws NoSuchAlgorithmException, InvalidKeyException, DecoderException, UnsupportedEncodingException {

    	if (null == data || "".equals(data)) {
    		throw new RuntimeException("data is empty");
    	}
    	if (null == key || "".equals(key.trim())) {
    		throw new RuntimeException("key is empty");
    	}
    	if (null == encoder || "".equals(encoder.trim())) {
    		throw new RuntimeException("encoder is empty");
    	}

    	return hmacSHA512(data.getBytes(defaultCharset), EncodeUtils.decode(key, encoder), encoder);
    }

    /**
     * @Title: hmacSHA512
     * @Description: SHA512带密钥摘要生成(默认Base64编码)
     * @param data		数据源(字节数组)
     * @param key		摘要密钥(字节数组)
     * @return String	摘要结果
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException String
     */
    public static String hmacSHA512(byte[] data, byte[] key) throws NoSuchAlgorithmException, InvalidKeyException {

    	return hmacDigest(data, key, HmacSHA512);
    }

    /**
     * @Title: hmacSHA512
     * @Description: SHA512带密钥摘要生成
     * @param data		数据源(字节数组)
     * @param key		摘要密钥(字节数组)
     * @param encoder	编码方式
     * @return String	摘要结果
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException String
     */
    public static String hmacSHA512(byte[] data, byte[] key, String encoder) throws NoSuchAlgorithmException, InvalidKeyException {

    	return hmacDigest(data, key, HmacSHA512, encoder);
    }

    /**
     * @Title: generateHmacKey
     * @Description: 摘要算法的密钥生成
     * @param algorithm	需要生成key的算法名称
     * @return byte[]	生成key字节数组
     * @throws NoSuchAlgorithmException
     */
    public static byte[] generateHmacKey(String algorithm) throws NoSuchAlgorithmException {

    	if (null == algorithm || "".equals(algorithm.trim())) {
    		throw new RuntimeException("algorithm is empty");
    	}

    	// 初始化摘要算法的密钥产生器
        KeyGenerator generator = KeyGenerator.getInstance(algorithm);
        // 产生密钥
        SecretKey secretKey = generator.generateKey();
        // 获得密钥
        byte[] key = secretKey.getEncoded();
        return key;
    }

    /**
     * @Title: hmacDigest
     * @Description: 带密钥摘要生成(默认Base64编码)
     * @param data		数据源(字节数组)
     * @param key		摘要密钥(字节数组)
     * @param algorithm	摘要算法名称
     * @return String	摘要字符串
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     */
    public static String hmacDigest(byte[] data, byte[] key, String algorithm) throws NoSuchAlgorithmException, InvalidKeyException {

    	return hmacDigest(data, key, algorithm, defaultEncoder);
    }

    /**
     * @Title: hmacDigest
     * @Description: 带密钥摘要生成
     * @param data		数据源(字节数组)
     * @param key		摘要密钥(字节数组)
     * @param algorithm	摘要算法名称
     * @param encoder	编码方式
     * @return String	摘要字符串
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     */
    public static String hmacDigest(byte[] data, byte[] key, String algorithm, String encoder) throws NoSuchAlgorithmException, InvalidKeyException {

    	if (null == data || data.length == 0) {
    		throw new RuntimeException("data is empty");
    	}
    	if (null == key || key.length == 0) {
    		throw new RuntimeException("key is empty");
    	}
    	if (null == algorithm || "".equals(algorithm.trim())) {
    		throw new RuntimeException("algorithm is empty");
    	}
    	if (null == encoder || "".equals(encoder.trim())) {
    		throw new RuntimeException("encoder is empty");
    	}

    	// 还原密钥
        SecretKey secretKey = new SecretKeySpec(key, algorithm);
        // 实例化Mac
        Mac mac = Mac.getInstance(secretKey.getAlgorithm());
        // 初始化mac
        mac.init(secretKey);
        // 执行消息摘要
        byte[] digest = mac.doFinal(data);
        // 对摘要编码
        String result = EncodeUtils.encode(digest, encoder);
        return result;
    }

}
