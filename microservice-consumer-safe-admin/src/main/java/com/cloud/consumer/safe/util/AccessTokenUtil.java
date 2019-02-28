package com.ochain.consumer.wheel.util;

import java.security.Key;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * accessToken工具类 AccessTokenUtil
 * @author wei.yong
 */
public enum AccessTokenUtil {

	INSTANCE;

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 创建jwt
     * @param privateKey
     * @param signatureAlgorithm
     * @param claims
     * @param issuer
     * @param audience
     * @return String
     */
	public String createJWT(Key privateKey,SignatureAlgorithm signatureAlgorithm,Map<String,Object> claims,String issuer,String audience) {
    	logger.info("(AccessTokenUtil-createJWT)-创建jwt-传入参数, privateKey:{}, signatureAlgorithm:{}, claims:{}, issuer:{}, audience:{}", privateKey, signatureAlgorithm, claims, issuer, audience);
		//下面就是在为payload添加各种标准声明和私有声明了
    	JwtBuilder builder = Jwts.builder() 			//这里其实就是new一个JwtBuilder，设置jwt的body
    		.setClaims(claims)          				//如果有私有声明，一定要先设置这个自己创建的私有的声明，这个是给builder的claim赋值，一旦写在标准的声明赋值之后，就是覆盖了那些标准的声明的
    		.setIssuer(issuer)
            .setAudience(audience)
            .signWith(signatureAlgorithm, privateKey);	//设置签名使用的签名算法和签名使用的秘钥
        String jwt = builder.compact();
        logger.info("(AccessTokenUtil-createJWT)-创建jwt, jwt:{}", jwt);
        return builder.compact();						//就开始压缩为xxxxxxxxxxxxxx.xxxxxxxxxxxxxxx.xxxxxxxxxxxxx这样的jwt
    }

}