package com.cloud.common.sign.security;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.DecoderException;
/**
 *
 * @ClassName: AESUtils
 * @Description: AES加密/解密工具类
 * @author S.J.
 * @date 2016年7月20日 下午3:48:01
 *
 */
public class AESUtils {

	/**
     * AES加密算法
     */
	private static final String KEY_ALGORITHM = "AES";

	/**
     * CBC加密模式
     */
	private static final String CIPHER_ALGORITHM_CBC = "AES/CBC/PKCS5Padding";

	/**
     * ECB加密模式

    private static final String CIPHER_ALGORITHM_ECB = "AES/ECB/PKCS5Padding";
    */

	/**
     * 获取key的map-key
     */
    private static final String AESKEY_KEY = "AESKeyKey";

    /**
     * 获取vi的map-key
     */
    private static final String AESIV_KEY = "AESIvKey";

    /**
	 * 默认字符集(UTF-8)
	 */
	private static final String defaultCharset = Charsets.UTF_8;

	/**
	 * 默认编码方式(HEX)
	 */
	private static final String defaultEncoder = EncodeUtils.ENCODER_HEX;

    /**
     * @Title: initKey
     * @Description: 				初始化生成密钥向量对
     * @return Map<String, String>	密钥向量对Map
     * @throws NoSuchAlgorithmException
     */
    public static Map<String, String> initKey() throws NoSuchAlgorithmException {

    	KeyGenerator keyGen = KeyGenerator.getInstance(KEY_ALGORITHM);
    	keyGen.init(128);
    	// 生成key
        SecretKey key = keyGen.generateKey();
        // 生成key，使用key作为iv初始值
        SecretKey iv = keyGen.generateKey();

        Map<String, String> keyMap = new HashMap<String, String>(2);
        keyMap.put(AESKEY_KEY, EncodeUtils.encode(key.getEncoded(), defaultEncoder));
        keyMap.put(AESIV_KEY, EncodeUtils.encode(iv.getEncoded(), defaultEncoder));

        return keyMap;
    }

    /**
     * @Title: getKey
     * @Description: 	获取key
     * @param map		key、iv
     * @return String
     */
    public static String getKey(Map<String, String> map) {

    	if (null == map) {
    		throw new RuntimeException("map is null");
    	}

        return map.get(AESKEY_KEY);
    }

    /**
     * @Title: getIv
     * @Description: 	获取iv
     * @param map		key、iv
     * @return String
     */
    public static String getIv(Map<String, String> map) {

    	if (null == map) {
    		throw new RuntimeException("map is null");
    	}

        return map.get(AESIV_KEY);
    }

    /**
     * @Title: generateIvByKey
     * @Description: 		通过key生成iv(默认编码方式)
     * @return String		密钥向量iv
     * @throws UnsupportedEncodingException
     */
    public static String generateIvByKey(String key) throws UnsupportedEncodingException {

    	if (null == key || "".equals(key.trim())) {
    		throw new RuntimeException("key is empty");
    	}

    	String iv = DigestUtils.md5(key, defaultEncoder);

        return iv;
    }

    /**
     * @Title: generateIvByKey
     * @Description: 		通过key生成iv
     * @return String		密钥向量iv
     * @throws UnsupportedEncodingException
     */
    public static String generateIvByKey(String key, String encoder) throws UnsupportedEncodingException {

    	if (null == key || "".equals(key.trim())) {
    		throw new RuntimeException("key is empty");
    	}
    	if (null == encoder || "".equals(encoder.trim())) {
    		throw new RuntimeException("encoder is empty");
    	}

    	String iv = DigestUtils.md5(key, encoder);

        return iv;
    }

    /**
     * @Title: encrypt
     * @Description: 	AES加密（AES/CBC/PKCS5Padding）
     * @param data		待加密数据
     * @param key		加密秘钥(长度32的16进制字符串)
     * @param iv		加密向量(长度32的16进制字符串)
     * @return String	16进制字符串
     * @throws DecoderException
     * @throws UnsupportedEncodingException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     * @throws InvalidAlgorithmParameterException
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws Exception
     */
	public static String encrypt(String data, String key, String iv) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException, DecoderException {

		return encrypt(data, key, iv, defaultEncoder);
	}

	/**
     * @Title: encrypt
     * @Description: 	AES加密（AES/CBC/PKCS5Padding）
     * @param data		待加密数据
     * @param key		加密秘钥(长度32的16进制字符串)
     * @param iv		加密向量(长度32的16进制字符串)
     * @return String	16进制字符串
	 * @throws DecoderException
	 * @throws BadPaddingException
	 * @throws IllegalBlockSizeException
	 * @throws InvalidAlgorithmParameterException
	 * @throws NoSuchPaddingException
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeyException
     * @throws Exception
     */
	public static String encrypt(byte[] data, String key, String iv) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, DecoderException {

		return encrypt(data, key, iv, defaultEncoder);
	}

    /**
     * @Title: encrypt
     * @Description: 	AES加密（AES/CBC/PKCS5Padding）
     * @param data		待加密数据
     * @param key		加密秘钥(长度32的16进制字符串)
     * @param iv		加密向量(长度32的16进制字符串)
     * @param encoder	编码方式
     * @return String	16进制字符串
     * @throws DecoderException
     * @throws UnsupportedEncodingException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     * @throws InvalidAlgorithmParameterException
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     * @throws Exception
     */
	public static String encrypt(String data, String key, String iv, String encoder) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException, DecoderException {

		if (null == data || "".equals(data)) {
    		throw new RuntimeException("data is empty");
    	}
		if (null == key || "".equals(key.trim())) {
    		throw new RuntimeException("key is empty");
    	}
		if (null == iv || "".equals(iv.trim())) {
    		throw new RuntimeException("iv is empty");
    	}
    	if (null == encoder || "".equals(encoder.trim())) {
    		throw new RuntimeException("encoder is empty");
    	}

		byte[] encrypted = encrypt(data.getBytes(defaultCharset), EncodeUtils.decode(key, encoder), EncodeUtils.decode(iv, encoder));

	    return EncodeUtils.encode(encrypted, encoder);
	}

	/**
     * @Title: encrypt
     * @Description: 	AES加密（AES/CBC/PKCS5Padding）
     * @param data		待加密数据
     * @param key		加密秘钥(长度32的16进制字符串)
     * @param iv		加密向量(长度32的16进制字符串)
     * @param encoder	编码方式
     * @return String	16进制字符串
	 * @throws DecoderException
	 * @throws BadPaddingException
	 * @throws IllegalBlockSizeException
	 * @throws InvalidAlgorithmParameterException
	 * @throws NoSuchPaddingException
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeyException
     * @throws Exception
     */
	public static String encrypt(byte[] data, String key, String iv, String encoder) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, DecoderException {

		if (null == data || data.length == 0) {
    		throw new RuntimeException("data is empty");
    	}
		if (null == key || "".equals(key.trim())) {
    		throw new RuntimeException("key is empty");
    	}
		if (null == iv || "".equals(iv.trim())) {
    		throw new RuntimeException("iv is empty");
    	}
    	if (null == encoder || "".equals(encoder.trim())) {
    		throw new RuntimeException("encoder is empty");
    	}

		byte[] encrypted = encrypt(data, EncodeUtils.decode(key, encoder), EncodeUtils.decode(iv, encoder));

	    return EncodeUtils.encode(encrypted, encoder);
	}

	/**
     * @Title: encrypt
     * @Description: 	AES加密（AES/CBC/PKCS5Padding）
     * @param data		待加密数据
     * @param keyBytes	加密秘钥(长度16的字节数组)
     * @param ivBytes	加密向量(长度16的字节数组)
     * @return byte[]	加密结果
	 * @throws NoSuchPaddingException
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidAlgorithmParameterException
	 * @throws InvalidKeyException
	 * @throws BadPaddingException
	 * @throws IllegalBlockSizeException
     * @throws Exception
     */
	public static byte[] encrypt(byte[] data, byte[] key, byte[] iv) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {

		if (null == data || data.length == 0) {
    		throw new RuntimeException("data is empty");
    	}
		if (null == key || key.length == 0) {
    		throw new RuntimeException("key is empty");
    	}
		if (null == iv || iv.length == 0) {
    		throw new RuntimeException("iv is empty");
    	}

		Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM_CBC);
        SecretKeySpec keySpec = new SecretKeySpec(key, KEY_ALGORITHM);
        IvParameterSpec ivSpec = new IvParameterSpec(iv);

        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
        byte[] encrypted = cipher.doFinal(data);

	    return encrypted;
	}

	/**
     * @Title: decrypt
     * @Description: 	AES解密（AES/CBC/PKCS5Padding）
     * @param data		待解密数据
     * @param key		解密秘钥(长度32的16进制字符串)
     * @param iv		解密向量(长度32的16进制字符串)
     * @return String	16进制字符串
	 * @throws DecoderException
	 * @throws UnsupportedEncodingException
	 * @throws BadPaddingException
	 * @throws IllegalBlockSizeException
	 * @throws InvalidAlgorithmParameterException
	 * @throws NoSuchPaddingException
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeyException
     */
	public static String decrypt(String data, String key, String iv) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException, DecoderException {

		return decrypt(data, key, iv, defaultEncoder);
	}

	/**
     * @Title: decrypt
     * @Description: 	AES解密（AES/CBC/PKCS5Padding）
     * @param data		待解密数据
     * @param key		解密秘钥(长度32的16进制字符串)
     * @param iv		解密向量(长度32的16进制字符串)
     * @return String	16进制字符串
	 * @throws DecoderException
	 * @throws UnsupportedEncodingException
	 * @throws BadPaddingException
	 * @throws IllegalBlockSizeException
	 * @throws InvalidAlgorithmParameterException
	 * @throws NoSuchPaddingException
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeyException
     */
	public static String decrypt(byte[] data, String key, String iv) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException, DecoderException {

		return decrypt(data, key, iv, defaultEncoder);
	}

	/**
     * @Title: decrypt
     * @Description: 	AES解密（AES/CBC/PKCS5Padding）
     * @param data		待解密数据
     * @param key		解密秘钥(长度32的16进制字符串)
     * @param iv		解密向量(长度32的16进制字符串)
     * @param encoder	编码方式
     * @return String	16进制字符串
	 * @throws DecoderException
	 * @throws BadPaddingException
	 * @throws IllegalBlockSizeException
	 * @throws InvalidAlgorithmParameterException
	 * @throws NoSuchPaddingException
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeyException
	 * @throws UnsupportedEncodingException
     */
	public static String decrypt(String data, String key, String iv, String encoder) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, DecoderException, UnsupportedEncodingException {

		if (null == data || "".equals(data.trim())) {
    		throw new RuntimeException("data is empty");
    	}
		if (null == key || "".equals(key.trim())) {
    		throw new RuntimeException("key is empty");
    	}
		if (null == iv || "".equals(iv.trim())) {
    		throw new RuntimeException("iv is empty");
    	}
    	if (null == encoder || "".equals(encoder.trim())) {
    		throw new RuntimeException("encoder is empty");
    	}

		byte[] decrypted = decrypt(EncodeUtils.decode(data, encoder), EncodeUtils.decode(key, encoder), EncodeUtils.decode(iv, encoder));

	    return new String(decrypted, defaultCharset);
	}

	/**
     * @Title: decrypt
     * @Description: 	AES解密（AES/CBC/PKCS5Padding）
     * @param data		待解密数据
     * @param key		解密秘钥(长度32的16进制字符串)
     * @param iv		解密向量(长度32的16进制字符串)
     * @param encoder	编码方式
     * @return String	16进制字符串
	 * @throws DecoderException
	 * @throws BadPaddingException
	 * @throws IllegalBlockSizeException
	 * @throws InvalidAlgorithmParameterException
	 * @throws NoSuchPaddingException
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeyException
	 * @throws UnsupportedEncodingException
     */
	public static String decrypt(byte[] data, String key, String iv, String encoder) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, DecoderException, UnsupportedEncodingException {

		if (null == data || data.length == 0) {
    		throw new RuntimeException("data is empty");
    	}
		if (null == key || "".equals(key.trim())) {
    		throw new RuntimeException("key is empty");
    	}
		if (null == iv || "".equals(iv.trim())) {
    		throw new RuntimeException("iv is empty");
    	}
    	if (null == encoder || "".equals(encoder.trim())) {
    		throw new RuntimeException("encoder is empty");
    	}

		byte[] decrypted = decrypt(data, EncodeUtils.decode(key, encoder), EncodeUtils.decode(iv, encoder));

	    return new String(decrypted, defaultCharset);
	}

	/**
     * @Title: decrypt
     * @Description: 	AES解密（AES/CBC/PKCS5Padding）
     * @param data		待解密数据
     * @param key		解密秘钥(长度16的字节数组)
     * @param iv		解密向量(长度16的字节数组)
     * @return byte[]	解密结果字节数组
	 * @throws NoSuchPaddingException
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidAlgorithmParameterException
	 * @throws InvalidKeyException
	 * @throws BadPaddingException
	 * @throws IllegalBlockSizeException
     */
	public static byte[] decrypt(byte[] data, byte[] key, byte[] iv) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {

		if (null == data || data.length == 0) {
    		throw new RuntimeException("data is empty");
    	}
		if (null == key || key.length == 0) {
    		throw new RuntimeException("key is empty");
    	}
		if (null == iv || iv.length == 0) {
    		throw new RuntimeException("iv is empty");
    	}

		Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM_CBC);
        SecretKeySpec keySpec = new SecretKeySpec(key, KEY_ALGORITHM);
        IvParameterSpec ivSpec = new IvParameterSpec(iv);

        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
	    byte[] decrypted = cipher.doFinal(data);

	    return decrypted;
	}

}