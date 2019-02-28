package com.cloud.common.sign.security;

import java.io.ByteArrayOutputStream;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher;

/**
 *
 * @ClassName: RSAUtils
 * @Description: RSA加密/解密工具
 * @author S.J.
 * @date 2016年7月19日 下午4:35:37
 *
 */
public class RSAUtils {

	/**
     * 加密算法RSA
     */
    private static final String KEY_ALGORITHM = "RSA";

    /**
     * 签名算法
     */
    private static final String SIGNATURE_ALGORITHM = "MD5withRSA";

    /**
     * 获取公钥的map-key
     */
    private static final String PUBLIC_KEY = "RSAPublicKey";

    /**
     * 获取私钥的map-key
     */
    private static final String PRIVATE_KEY = "RSAPrivateKey";

    /**
     * RSA最大加密明文大小
     */
    private static final int MAX_ENCRYPT_BLOCK = 117;

    /**
     * RSA最大解密密文大小
     */
    private static final int MAX_DECRYPT_BLOCK = 128;

    /**
	 * 默认字符集(UTF-8)
	 */
	private static final String defaultCharset = Charsets.UTF_8;

	/**
	 * 默认编码方式(Base64)
	 */
	private static final String defaultEncoder = EncodeUtils.ENCODER_BASE64;

    /**
     * @Title: initKey
     * @Description: 				初始化生成密钥对(公钥和私钥)
     * @return Map<String,Object>	公钥私钥对Map
     * @throws NoSuchAlgorithmException
     */
    public static Map<String, Object> initKey() throws NoSuchAlgorithmException {

    	KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);

    	keyPairGen.initialize(1024);
        KeyPair keyPair = keyPairGen.generateKeyPair();

        //公钥
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        //私钥
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();

        Map<String, Object> keyMap = new HashMap<String, Object>(2);
        keyMap.put(PUBLIC_KEY, publicKey);
        keyMap.put(PRIVATE_KEY, privateKey);

        return keyMap;
    }

    /**
     * @Title: getPrivateKey
     * @Description: 	获取私钥(默认编码方式)
     * @param keyMap	密钥对Map
     * @return String	私钥字符串
     */
    public static String getPrivateKey(Map<String, Object> keyMap) {

        return getPrivateKey(keyMap, defaultEncoder);
    }

    /**
     * @Title: getPrivateKey
     * @Description: 	获取私钥
     * @param keyMap	密钥对Map
     * @param encoder	编码方式
     * @return String	私钥字符串
     */
    public static String getPrivateKey(Map<String, Object> keyMap, String encoder) {

    	if (null == keyMap) {
    		throw new RuntimeException("keyMap is null");
    	}
    	if (null == encoder || "".equals(encoder.trim())) {
    		throw new RuntimeException("encoder is empty");
    	}

    	Key key = (Key) keyMap.get(PRIVATE_KEY);

        return EncodeUtils.encode(key.getEncoded(), encoder);
    }

    /**
     * @Title: getPublicKey
     * @Description: 	获取公钥(默认编码方式)
     * @param keyMap	密钥对Map
     * @return String	公钥字符串
     */
    public static String getPublicKey(Map<String, Object> keyMap) {

        return getPublicKey(keyMap, defaultEncoder);
    }

    /**
     * @Title: getPublicKey
     * @Description: 	获取公钥
     * @param keyMap	密钥对Map
     * @param encoder	编码方式
     * @return String	公钥字符串
     */
    public static String getPublicKey(Map<String, Object> keyMap, String encoder) {

    	if (null == keyMap) {
    		throw new RuntimeException("keyMap is null");
    	}
    	if (null == encoder || "".equals(encoder.trim())) {
    		throw new RuntimeException("encoder is empty");
    	}

    	Key key = (Key) keyMap.get(PUBLIC_KEY);

        return EncodeUtils.encode(key.getEncoded(), encoder);
    }

    /**
     * @Title: sign
     * @Description:  		用私钥对信息生成数字签名(默认编码方式)
     * @param data			已加密数据
     * @param privateKey	私钥
     * @return String		签名结果
     * @throws Exception
     */
    public static String sign(String data, String privateKey) throws Exception {

        return sign(EncodeUtils.decode(data, defaultEncoder), privateKey, defaultEncoder);
    }

    /**
     * @Title: sign
     * @Description:  		用私钥对信息生成数字签名
     * @param data			已加密数据
     * @param privateKey	私钥
     * @param encoder		编码方式
     * @return String		签名结果
     * @throws Exception
     */
    public static String sign(String data, String privateKey, String encoder) throws Exception {

    	return sign(EncodeUtils.decode(data, encoder), privateKey, encoder);

    }

    /**
     * @Title: sign
     * @Description:  		用私钥对信息生成数字签名(默认编码方式)
     * @param data			已加密数据
     * @param privateKey	私钥
     * @return String		签名结果
     * @throws Exception
     */
    public static String sign(byte[] data, String privateKey) throws Exception {

        return sign(data, privateKey, defaultEncoder);
    }

    /**
     * @Title: sign
     * @Description:  		用私钥对信息生成数字签名
     * @param data			已加密数据
     * @param privateKey	私钥
     * @param encoder		编码方式
     * @return String		签名结果
     * @throws Exception
     */
    public static String sign(byte[] data, String privateKey, String encoder) throws Exception {

    	if (null == data || data.length == 0) {
    		throw new RuntimeException("data is empty");
    	}
    	if (null == privateKey || "".equals(privateKey.trim())) {
    		throw new RuntimeException("privateKey is empty");
    	}
    	if (null == encoder || "".equals(encoder.trim())) {
    		throw new RuntimeException("encoder is empty");
    	}

    	byte[] keyBytes = EncodeUtils.decode(privateKey, encoder);

    	// 采用PKCS8私钥编码规范生成私钥数据
    	PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
    	KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        PrivateKey privateK = keyFactory.generatePrivate(pkcs8KeySpec);

        //对加密数据签名
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initSign(privateK);
        signature.update(data);

        //签名结果转码
        String result = EncodeUtils.encode(signature.sign(), encoder);

        return result;
    }

    /**
     * @Title: verify
     * @Description: 		用公钥校验数字签名(默认编码方式)
     * @param data			已加密数据
     * @param publicKey		公钥
     * @param sign			待校验数字签名
     * @return boolean		校验结果
     * @throws Exception
     */
    public static boolean verify(String data, String publicKey, String sign) throws Exception {

        return verify(EncodeUtils.decode(data, defaultEncoder), publicKey, sign, defaultEncoder);
    }

    /**
     * @Title: verify
     * @Description: 		用公钥校验数字签名
     * @param data			已加密数据
     * @param publicKey		公钥
     * @param sign			待校验数字签名
     * @param encoder		编码方式
     * @return boolean		校验结果
     * @throws Exception
     */
    public static boolean verify(String data, String publicKey, String sign, String encoder) throws Exception {

        return verify(EncodeUtils.decode(data, encoder), publicKey, sign, encoder);
    }

    /**
     * @Title: verify
     * @Description: 		用公钥校验数字签名(默认编码方式)
     * @param data			已加密数据
     * @param publicKey		公钥
     * @param sign			待校验数字签名
     * @return boolean		校验结果
     * @throws Exception
     */
    public static boolean verify(byte[] data, String publicKey, String sign) throws Exception {

        return verify(data, publicKey, sign, defaultEncoder);
    }

    /**
     * @Title: verify
     * @Description: 		用公钥校验数字签名
     * @param data			已加密数据
     * @param publicKey		公钥
     * @param sign			待校验数字签名
     * @param encoder		编码方式
     * @return boolean		校验结果
     * @throws Exception
     */
    public static boolean verify(byte[] data, String publicKey, String sign, String encoder) throws Exception {

    	if (null == data || data.length == 0) {
    		throw new RuntimeException("data is empty");
    	}
    	if (null == publicKey || "".equals(publicKey.trim())) {
    		throw new RuntimeException("publicKey is empty");
    	}
    	if (null == sign || "".equals(sign.trim())) {
    		throw new RuntimeException("sign is empty");
    	}
    	if (null == encoder || "".equals(encoder.trim())) {
    		throw new RuntimeException("encoder is empty");
    	}

    	byte[] keyBytes = EncodeUtils.decode(publicKey, encoder);

    	// 采用X509公钥编码规范生成公钥数据
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        PublicKey publicK = keyFactory.generatePublic(keySpec);

        // 对加密数据签名
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initVerify(publicK);
        signature.update(data);

        // 待校验签名转码
        byte[] signBytes = EncodeUtils.decode(sign, encoder);

        return signature.verify(signBytes);
    }

    /**
     * @Title: encryptByPublicKey
     * @Description: 		公钥加密(默认编码方式)
     * @param data			源数据
     * @param publicKey		公钥
     * @return String		加密结果
     * @throws Exception
     */
    public static String encryptByPublicKey(String data, String publicKey) throws Exception {

        return encryptByPublicKey(data, publicKey, defaultEncoder);
    }

    /**
     * @Title: encryptByPublicKey
     * @Description: 		公钥加密
     * @param data			源数据
     * @param publicKey		公钥
     * @param encoder		编码方式
     * @return String		加密结果
     * @throws Exception
     */
    public static String encryptByPublicKey(String data, String publicKey, String encoder) throws Exception {

    	if (null == data || "".equals(data)) {
    		throw new RuntimeException("data is empty");
    	}

    	byte[] encryptedData = encryptByPublicKey(data.getBytes(defaultCharset), publicKey, encoder);

        return EncodeUtils.encode(encryptedData, encoder);
    }

    /**
     * @Title: encryptByPublicKey
     * @Description: 		公钥加密(默认编码方式)
     * @param data			源数据
     * @param publicKey		公钥
     * @return byte[]		加密结果
     * @throws Exception
     */
    public static byte[] encryptByPublicKey(byte[] data, String publicKey) throws Exception {

        return encryptByPublicKey(data, publicKey, defaultEncoder);
    }

    /**
     * @Title: encryptByPublicKey
     * @Description: 		公钥加密
     * @param data			源数据
     * @param publicKey		公钥
     * @param encoder		编码方式
     * @return byte[]		加密结果
     * @throws Exception
     */
    public static byte[] encryptByPublicKey(byte[] data, String publicKey, String encoder) throws Exception {

    	if (null == data || data.length == 0) {
    		throw new RuntimeException("data is empty");
    	}
    	if (null == publicKey || "".equals(publicKey.trim())) {
    		throw new RuntimeException("publicKey is empty");
    	}
    	if (null == encoder || "".equals(encoder.trim())) {
    		throw new RuntimeException("encoder is empty");
    	}

    	byte[] keyBytes = EncodeUtils.decode(publicKey, encoder);

    	// 采用X509公钥编码规范生成公钥数据
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key publicK = keyFactory.generatePublic(x509KeySpec);

        // 对数据加密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, publicK);

        int inputLen = data.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] cache;
        int i = 0;
        // 对数据分段加密
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
                cache = cipher.doFinal(data, offSet, MAX_ENCRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(data, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * MAX_ENCRYPT_BLOCK;
        }
        byte[] encryptedData = out.toByteArray();
        out.close();

        return encryptedData;
    }

    /**
     * @Title: encryptByPrivateKey
     * @Description: 		私钥加密(默认编码方式)
     * @param data			源数据
     * @param privateKey	私钥
     * @return String		加密结果
     * @throws Exception
     */
    public static String encryptByPrivateKey(String data, String privateKey) throws Exception {

        return encryptByPrivateKey(data, privateKey, defaultEncoder);
    }

    /**
     * @Title: encryptByPrivateKey
     * @Description: 		私钥加密
     * @param data			源数据
     * @param privateKey	私钥
     * @param encoder		编码方式
     * @return String		加密结果
     * @throws Exception
     */
    public static String encryptByPrivateKey(String data, String privateKey, String encoder) throws Exception {

    	if (null == data || "".equals(data)) {
    		throw new RuntimeException("data is empty");
    	}

    	byte[] encryptedData = encryptByPrivateKey(data.getBytes(defaultCharset), privateKey, encoder);

        return EncodeUtils.encode(encryptedData, encoder);
    }

    /**
     * @Title: encryptByPrivateKey
     * @Description: 		私钥加密(默认编码方式)
     * @param data			源数据
     * @param privateKey	私钥
     * @return byte[]		加密结果
     * @throws Exception
     */
    public static byte[] encryptByPrivateKey(byte[] data, String privateKey) throws Exception {

        return encryptByPrivateKey(data, privateKey, defaultEncoder);
    }

    /**
     * @Title: encryptByPrivateKey
     * @Description: 		私钥加密
     * @param data			源数据
     * @param privateKey	私钥
     * @param encoder		编码方式
     * @return byte[]		加密结果
     * @throws Exception
     */
    public static byte[] encryptByPrivateKey(byte[] data, String privateKey, String encoder) throws Exception {

    	if (null == data || data.length == 0) {
    		throw new RuntimeException("data is empty");
    	}
    	if (null == privateKey || "".equals(privateKey.trim())) {
    		throw new RuntimeException("privateKey is empty");
    	}
    	if (null == encoder || "".equals(encoder.trim())) {
    		throw new RuntimeException("encoder is empty");
    	}

    	byte[] keyBytes = EncodeUtils.decode(privateKey, encoder);

    	// 采用PKCS8私钥编码规范生成公钥数据
    	PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key privateK = keyFactory.generatePrivate(pkcs8KeySpec);

        // 对数据加密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, privateK);

        int inputLen = data.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] cache;
        int i = 0;
        // 对数据分段加密
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > MAX_ENCRYPT_BLOCK) {
                cache = cipher.doFinal(data, offSet, MAX_ENCRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(data, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * MAX_ENCRYPT_BLOCK;
        }
        byte[] encryptedData = out.toByteArray();
        out.close();

        return encryptedData;
    }

    /**
     * @Title: decryptByPrivateKey
     * @Description: 		私钥解密(默认编码方式)
     * @param data			已加密数据
     * @param privateKey	私钥
     * @return String		解密结果
     * @throws Exception
     */
    public static String decryptByPrivateKey(String data, String privateKey) throws Exception {

        return decryptByPrivateKey(data, privateKey, defaultEncoder);
    }

    /**
     * @Title: decryptByPrivateKey
     * @Description: 		私钥解密
     * @param data			已加密数据
     * @param privateKey	私钥
     * @param encoder		编码方式
     * @return String		解密结果
     * @throws Exception
     */
    public static String decryptByPrivateKey(String data, String privateKey, String encoder) throws Exception {

    	if (null == data || "".equals(data.trim())) {
    		throw new RuntimeException("data is empty");
    	}

    	byte[] decryptedData = decryptByPrivateKey(EncodeUtils.decode(data, encoder), privateKey, encoder);

        return new String(decryptedData, defaultCharset);
    }

    /**
     * @Title: decryptByPrivateKey
     * @Description: 		私钥解密(默认编码方式)
     * @param data			已加密数据
     * @param privateKey	私钥
     * @return byte[]		解密结果
     * @throws Exception
     */
    public static byte[] decryptByPrivateKey(byte[] data, String privateKey) throws Exception {

        return decryptByPrivateKey(data, privateKey, defaultEncoder);
    }

    /**
     * @Title: decryptByPrivateKey
     * @Description: 		私钥解密
     * @param data			已加密数据
     * @param privateKey	私钥
     * @param encoder		编码方式
     * @return byte[]		解密结果
     * @throws Exception
     */
    public static byte[] decryptByPrivateKey(byte[] data, String privateKey, String encoder) throws Exception {

    	if (null == data || data.length == 0) {
    		throw new RuntimeException("data is empty");
    	}
    	if (null == privateKey || "".equals(privateKey.trim())) {
    		throw new RuntimeException("privateKey is empty");
    	}
    	if (null == encoder || "".equals(encoder.trim())) {
    		throw new RuntimeException("encoder is empty");
    	}

    	byte[] keyBytes = EncodeUtils.decode(privateKey, encoder);

    	// 采用PKCS8私钥编码规范生成公钥数据
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key privateK = keyFactory.generatePrivate(pkcs8KeySpec);

        // 对数据解密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, privateK);

        int inputLen = data.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] cache;
        int i = 0;
        // 对数据分段解密
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
                cache = cipher.doFinal(data, offSet, MAX_DECRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(data, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * MAX_DECRYPT_BLOCK;
        }
        byte[] decryptedData = out.toByteArray();
        out.close();

        return decryptedData;
    }

    /**
     * @Title: decryptByPublicKey
     * @Description: 		公钥解密(默认编码方式)
     * @param data			已加密数据
     * @param publicKey		公钥
     * @return String		解密结果
     * @throws Exception
     */
    public static String decryptByPublicKey(String data, String publicKey) throws Exception {

        return decryptByPublicKey(data, publicKey, defaultEncoder);
    }

    /**
     * @Title: decryptByPublicKey
     * @Description: 		公钥解密
     * @param data			已加密数据
     * @param publicKey		公钥
     * @param encoder		编码方式
     * @return String		解密结果
     * @throws Exception
     */
    public static String decryptByPublicKey(String data, String publicKey, String encoder) throws Exception {

    	if (null == data || "".equals(data.trim())) {
    		throw new RuntimeException("data is empty");
    	}

    	byte[] decryptedData = decryptByPublicKey(EncodeUtils.decode(data, encoder), publicKey, encoder);

        return new String(decryptedData, defaultCharset);
    }

    /**
     * @Title: decryptByPublicKey
     * @Description: 		公钥解密(默认编码方式)
     * @param data			已加密数据
     * @param publicKey	公钥
     * @return byte[]		解密结果
     * @throws Exception
     */
    public static byte[] decryptByPublicKey(byte[] data, String publicKey) throws Exception {

        return decryptByPublicKey(data, publicKey, defaultEncoder);
    }

    /**
     * @Title: decryptByPublicKey
     * @Description: 		公钥解密
     * @param data			已加密数据
     * @param publicKey	公钥
     * @param encoder		编码方式
     * @return byte[]		解密结果
     * @throws Exception
     */
    public static byte[] decryptByPublicKey(byte[] data, String publicKey, String encoder) throws Exception {

    	if (null == data || data.length == 0) {
    		throw new RuntimeException("data is empty");
    	}
    	if (null == publicKey || "".equals(publicKey.trim())) {
    		throw new RuntimeException("publicKey is empty");
    	}
    	if (null == encoder || "".equals(encoder.trim())) {
    		throw new RuntimeException("encoder is empty");
    	}

    	byte[] keyBytes = EncodeUtils.decode(publicKey, encoder);

    	// 采用X509公钥编码规范生成公钥数据
    	X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        Key publicK = keyFactory.generatePublic(x509KeySpec);

        // 对数据解密
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, publicK);

        int inputLen = data.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        byte[] cache;
        int i = 0;
        // 对数据分段解密
        while (inputLen - offSet > 0) {
            if (inputLen - offSet > MAX_DECRYPT_BLOCK) {
                cache = cipher.doFinal(data, offSet, MAX_DECRYPT_BLOCK);
            } else {
                cache = cipher.doFinal(data, offSet, inputLen - offSet);
            }
            out.write(cache, 0, cache.length);
            i++;
            offSet = i * MAX_DECRYPT_BLOCK;
        }
        byte[] decryptedData = out.toByteArray();
        out.close();

        return decryptedData;
    }

}
