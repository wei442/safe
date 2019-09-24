package com.cloud.provider.safe.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.common.exception.SafeException;

/**
 * Boot的BootBaseController
 * @author wang.tongmeng
 * @date 2017-11-16
 */
@RestController
public class BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	protected HttpServletRequest request;

	@Autowired
	protected HttpServletResponse response;

	/**
	 * 校验参数
	 * @param bindingResult
	 */
	protected void bindingResult(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
        	logger.info(">>>>>> {}.{}() valid params is error msg = {}", this.getClass().getSimpleName(), this.getRequestMethodName(), bindingResult.getFieldError().getDefaultMessage());
            throw new SafeException("1050000", bindingResult.getFieldError().getDefaultMessage());
        }
    }

	/**
	 * 获取请求加点URI参数为空，如：user.register.parameter.empty
	 * @return String
	 */
	protected String getRequestMethodName() {
		String requestURI = request.getRequestURI();
		requestURI = StringUtils.substringAfter(requestURI, "/");
		requestURI = StringUtils.replace(requestURI, "/", ".");
//		requestURI = Objects.toString(requestURI, "");
		return requestURI;
	}

//	/**
//	 * 获取请求加点URI参数错误，如：user.register.parameter.error
//	 * @return String
//	 */
//	protected String getRequestParameterError() {
//		String requestURI = request.getRequestURI();
//		requestURI = StringUtils.substringAfter(requestURI, "/");
//		requestURI = StringUtils.replace(requestURI, "/", ".");
//		requestURI = Objects.toString(requestURI, "") + ".parameter.error";
//		return requestURI;
//	}

}