package com.cloud.common.sign;

import java.io.Serializable;

/**
 *
 * @ClassName: SignParams
 * @Description: 签名密钥参数类
 * @author S.J.
 * @date 2016年7月21日 下午2:53:34
 *
 */
public class SignParams implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private String data;		//待签名数据
	private String signType;	//签名类型
	private String key;			//通用密钥
	private String iv;			//密钥向量
	private String privateKey;	//私钥(非对称加密)
	private String publicKey;	//公钥(非对称加密)

	public SignParams(){}

	public SignParams(String data, String signType) {
		this.data = data;
		this.signType = signType;
	}

	public SignParams(String data, String signType, String key){
		this.data = data;
		this.signType = signType;
		this.key = key;
	}

	public SignParams(String data, String signType, String key, String iv){
		this.data = data;
		this.signType = signType;
		this.key = key;
		this.iv = iv;
	}

	public SignParams(String data, String signType, String key, String iv, String privateKey, String publicKey){
		this.data = data;
		this.signType = signType;
		this.key = key;
		this.iv = iv;
		this.privateKey = privateKey;
		this.publicKey = publicKey;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getSignType() {
		return signType;
	}

	public void setSignType(String signType) {
		this.signType = signType;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getIv() {
		return iv;
	}

	public void setIv(String iv) {
		this.iv = iv;
	}

	public String getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}

	public String getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}

	@Override
	public String toString() {
		return "SignParams [data=" + data + ", signType=" + signType + ", key=" + key + ", iv=" + iv + ", privateKey="
				+ privateKey + ", publicKey=" + publicKey + "]";
	}

}