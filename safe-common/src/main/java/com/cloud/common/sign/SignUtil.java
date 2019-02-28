package com.cloud.common.sign;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.HmacUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cloud.common.constants.SignConstants;
import com.cloud.common.sign.security.AESUtils;
import com.cloud.common.sign.security.RSAUtils;

/**
 *
 * @ClassName: SignUtil
 * @Description: 签名工具类
 * @author S.J.
 * @date 2016年7月13日 下午3:00:44
 *
 */
public class SignUtil {

	protected static final Logger logger = LoggerFactory.getLogger(SignUtil.class);

    /**
     * @Title: verifySign
     * @Description: 签名校验
     * @param sign		商户签名数据
     * @param params	签名校验参数
     * @return boolean	校验结果
     * @throws Exception
     */
	public static boolean verifySign(String sign, SignParams params) throws Exception {
		if (null == sign || "".equals(sign.trim())) {
			throw new RuntimeException("sign is empty");
		}
		if (null == params) {
			throw new RuntimeException("SignParams is null");
		}

		String result = "";
		StringBuffer buf = new StringBuffer();
		// MD5
		if (SignConstants.MD5.equalsIgnoreCase(params.getSignType())) {
			//参数后追加key
			buf.append(params.getData());

			result = DigestUtils.md5Hex(buf.toString());
		}

		// SHA1
		else if (SignConstants.SHA1.equalsIgnoreCase(params.getSignType())) {
			//参数后追加key
			buf.append(params.getData());

			result = DigestUtils.sha1Hex(buf.toString());
		}

		// SHA256
		else if (SignConstants.SHA256.equalsIgnoreCase(params.getSignType())) {
			//参数后追加key
			buf.append(params.getData());

			result = DigestUtils.sha256Hex(buf.toString());
		}

		// HmacMD5
		else if (SignConstants.HMACMD5.equalsIgnoreCase(params.getSignType())) {
			result = HmacUtils.hmacMd5Hex(params.getKey(), params.getData());
		}

		// HmacSHA1
		else if (SignConstants.HMACSHA1.equalsIgnoreCase(params.getSignType())) {
			result = HmacUtils.hmacSha1Hex(params.getKey(), params.getData());
		}

		// HmacSHA256
		else if (SignConstants.HMACSHA256.equalsIgnoreCase(params.getSignType())) {
			result = HmacUtils.hmacSha256Hex(params.getKey(), params.getData());
		}

		// AES
		else if (SignConstants.AES.equalsIgnoreCase(params.getSignType())) {
			//获取参数摘要
			String paramsDigest = DigestUtils.sha256Hex(params.getData());

			if(logger.isInfoEnabled())logger.info("[签名工具-签名校验-AES-参数摘要] 参数摘要paramsDigest={}", paramsDigest);

			result = AESUtils.encrypt(paramsDigest, params.getKey(), params.getIv());
		}

		// RSA
		else if (SignConstants.RSA.equalsIgnoreCase(params.getSignType())) {
			//对已加密数据解密
			result = RSAUtils.decryptByPrivateKey(sign, params.getPrivateKey());

			if(logger.isInfoEnabled())logger.info("[签名工具-签名校验-RSA-私钥解密] 原sign={}, 解密结果decrypt={}", sign, result);

			//获取参数摘要
			String paramsDigest = DigestUtils.sha256Hex(params.getData());

			if(logger.isInfoEnabled())logger.info("[签名工具-签名校验-RSA-参数摘要-{}] 参数paramsData={}, 参数摘要paramsDigest={}", params.getData(), paramsDigest);

			//将解密出来的摘要数据与实际传参摘要数据对比
			return result.equals(paramsDigest);
		}

		if(logger.isInfoEnabled())logger.info("[签名工具-签名校验-{}] paramsData={}, 原sign={}, 加密结果encrypt={}", params.getSignType(), params.getData(), sign, result);

		return sign.equals(result);
	}

	/**
	 * @Title: sign
	 * @Description: 	数据签名
	 * @param params	数据签名参数
	 * @return String	签名结果
	 * @throws Exception
	 */
	public static String sign(SignParams params) throws Exception {
		if (null == params) {
			throw new RuntimeException("SignParams is null");
		}

		String result = "";
		StringBuffer buf = new StringBuffer();
		// MD5
		if (SignConstants.MD5.equalsIgnoreCase(params.getSignType())) {
			//参数后追加key
			buf.append(params.getData());
			result = DigestUtils.md5Hex(buf.toString());
		}

		// SHA1
		else if (SignConstants.SHA1.equalsIgnoreCase(params.getSignType())) {
			//参数后追加key
			buf.append(params.getData());
			result = DigestUtils.sha1Hex(buf.toString());
		}

		// SHA256
		else if (SignConstants.SHA256.equalsIgnoreCase(params.getSignType())) {
			//参数后追加key
			buf.append(params.getData());

			result = DigestUtils.sha256Hex(buf.toString());
		}

		// HmacMD5
		else if (SignConstants.HMACMD5.equalsIgnoreCase(params.getSignType())) {
			result = HmacUtils.hmacMd5Hex(params.getKey(), params.getData());
		}

		// HmacSHA1
		else if (SignConstants.HMACSHA1.equalsIgnoreCase(params.getSignType())) {
			result = HmacUtils.hmacSha1Hex(params.getKey(), params.getData());
		}

		// HmacSHA256
		else if (SignConstants.HMACSHA256.equalsIgnoreCase(params.getSignType())) {
			result = HmacUtils.hmacSha256Hex(params.getKey(), params.getData());
		}

		// AES
		else if (SignConstants.AES.equalsIgnoreCase(params.getSignType())) {
			//获取参数摘要
			String paramsDigest = DigestUtils.sha256Hex(params.getData());

			result = AESUtils.encrypt(paramsDigest, params.getKey(), params.getIv());
		}

		// RSA
		else if (SignConstants.RSA.equalsIgnoreCase(params.getSignType())) {
			//获取参数摘要
			String paramsDigest = DigestUtils.sha256Hex(params.getData());
			//使用私钥加密数据
			result = RSAUtils.encryptByPrivateKey(paramsDigest, params.getPrivateKey());
		}

		if(logger.isInfoEnabled())logger.info("[签名工具-签名-{}] signResult={}, paramsData={}", params.getSignType(), result, params.getData());
		return result;
	}

}