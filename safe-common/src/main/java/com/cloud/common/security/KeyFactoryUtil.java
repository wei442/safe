package com.cloud.common.security;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * key工厂工具类 KeyFactoryUtil
 * @author wei.yong
 */
public enum KeyFactoryUtil {

	INSTANCE;

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
     * 加密算法-RSA
     */
    private static final String ALGORITHM_RSA = "RSA";

	/**
	 * 生成RSA私钥
	 * @param privateKeyStr
	 * @return PrivateKey
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 */
    public PrivateKey generateRSAPrivateKey(String privateKeyStr) {
    	byte[] keyBytes = Base64.decodeBase64(privateKeyStr);
    	// 采用PKCS8私钥编码规范生成私钥数据
    	PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(keyBytes);
    	KeyFactory keyFactory = null;
		try {
			keyFactory = KeyFactory.getInstance(ALGORITHM_RSA);
		} catch (NoSuchAlgorithmException e) {
			logger.error("(KeyUtil-generateRSAPrivateKey)-通过算法获取KeyFactory失败, Exception = {}, message = {}", e, e.getMessage());
		}
        PrivateKey privateKey = null;
		try {
			privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
		} catch (InvalidKeySpecException e) {
			logger.error("(KeyUtil-generateRSAPrivateKey)-生成私钥失败, Exception = {}, message = {}", e, e.getMessage());
		}
        return privateKey;
    }

    /**
     * 生成RSA公钥
     * @param publicKeyStr
     * @return PublicKey
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     */
    public PublicKey generateRSAPublicKey(String publicKeyStr) {
    	byte[] keyBytes = Base64.decodeBase64(publicKeyStr);
    	// 采用X509公钥编码规范生成公钥数据
    	X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(keyBytes);
    	KeyFactory keyFactory = null;
		try {
			keyFactory = KeyFactory.getInstance(ALGORITHM_RSA);
		} catch (NoSuchAlgorithmException e) {
        	logger.error("(KeyUtil-generateRSAPublicKey)-通过算法获取KeyFactory失败, Exception = {}, message = {}", e, e.getMessage());
			e.printStackTrace();
		}
    	PublicKey publicKey = null;
		try {
			publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
		} catch (InvalidKeySpecException e) {
			logger.error("(KeyUtil-generateRSAPublicKey)-生成公钥失败, Exception = {}, message = {}", e, e.getMessage());
		}
    	return publicKey;
    }

}