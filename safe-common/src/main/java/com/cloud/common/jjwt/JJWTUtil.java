package com.cloud.common.jjwt;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.impl.crypto.RsaProvider;

/**
 * JJWT工具类 JJWTUtil
 * @author wei.yong
 */
public enum JJWTUtil {

	INSTANCE;

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 生成RsaKey
     * @return KeyPair
     */
    public KeyPair generateRsaKey() {
    	KeyPair keyPair = RsaProvider.generateKeyPair(1024);
    	PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();
    	String privateKeyStr = new String(Base64.encodeBase64(privateKey.getEncoded()), StandardCharsets.UTF_8);
        String publicKeyStr = new String(Base64.encodeBase64(publicKey.getEncoded()), StandardCharsets.UTF_8);
        System.out.println("JJWTUtil-generateRsaKey)-生成私钥, privateKeyStr:"+privateKeyStr);
        System.out.println("(JJWTUtil-generateRsaKey)-生成公钥, publicKeyStr:"+publicKeyStr);
        logger.info("(JJWTUtil-generateRsaKey)-生成私钥, privateKeyStr:{}", privateKeyStr);
        logger.info("(JJWTUtil-generateRsaKey)-生成公钥, publicKeyStr:{}", publicKeyStr);
    	return keyPair;
    }

    /**
     * 解密jwt
     * @param publicKey
     * @param jwt
     * @return Claims
     */
	public Claims parseJWT(Key publicKey,String jwt) {
        Claims claims = Jwts.parser()  	//得到DefaultJwtParser
       .setSigningKey(publicKey)	//设置签名的秘钥
       .parseClaimsJws(jwt)
       .getBody();   				//设置需要解析的jwt

    	logger.info("(JJWTUtil-parseJWT)-解密jwt, claims:{}", claims);
        return claims;
    }

}