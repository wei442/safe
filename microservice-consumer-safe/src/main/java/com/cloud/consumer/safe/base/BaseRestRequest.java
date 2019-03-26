package com.cloud.consumer.safe.base;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.CommConstants;

import io.swagger.annotations.ApiModelProperty;

/**
 * 基础分页请求
 * @author wei.yong
 */
public class BaseRestRequest implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "当前页默认值：1")
	//当前页
	private int pageNum = 1;

	@ApiModelProperty(value = "每页显示条数默认值：10")
	//每页的数量
	private int pageSize = 10;


	private Integer enterpriseId;

	public int getPageNum() {
		return this.pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return this.pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getEnterpriseId() {
		return this.enterpriseId;
	}

	public void setEnterpriseId(Integer enterpriseId) {
		this.enterpriseId = this.getEnterpriseId();
	}

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	protected HttpServletRequest request;

	@Autowired
	protected HttpServletResponse response;

	/**
	 * 获取token(payload)
	 * @return JSONObject
	 */
	protected JSONObject getTokenPayload() {
		String token = request.getHeader(CommConstants.TOKEN);
		logger.info("(BaseController-getTokenPayload)-获取token, token:{}", token);
		if(StringUtils.isBlank(token)) {
			return null;
		}

		String[] datas = StringUtils.split(token, ".");
//		String header = null;
		String payload = null;
//		String signature = null;
		try {
//			header = datas[0];
			payload = datas[1];
//			signature = datas[2];
			logger.info("(BaseController-getTokenPayload)-获取payload, payload:{}", payload);
		} catch (Exception e) {
			logger.error("(BaseController-getTokenPayload)-jwt(token)数组转换异常, Exception = {}, message = {}", e, e.getMessage());
		}
		String payloadStr = new String(Base64.decodeBase64(payload), StandardCharsets.UTF_8);
		JSONObject payloadJSON = JSONObject.parseObject(payloadStr);
		return payloadJSON;
	}

	/**
	 * 获取token(enterpriseId)
	 * @return Integer
	 */
	protected Integer getTokenEnterpriseId() {
		JSONObject payloadJSON = this.getTokenPayload();
		Integer enterpriseId = new Integer(Objects.toString(payloadJSON.get(CommConstants.ENTERPRISE_ID)));
		logger.info("(BaseController-getTokenEnterpriseId)-返回信息, enterpriseId:{}", enterpriseId);
		return enterpriseId;
	}

}