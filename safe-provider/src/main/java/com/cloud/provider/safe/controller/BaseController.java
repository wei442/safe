package com.cloud.provider.safe.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * 基础控制类BaseController
 * @author wei.yong
 */
@RestController
public class BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	protected HttpServletRequest request;

	@Autowired
	protected HttpServletResponse response;

	/**
	 * 获取请求加点URI参数不能为空，如：user.register.parameter.empty
	 * @return String
	 */
	protected String getRequestMethodName() {
		String requestURI = request.getRequestURI();
		requestURI = StringUtils.substringAfter(requestURI, "/");
		requestURI = StringUtils.replace(requestURI, "/", ".");
		return requestURI;
	}

}