package com.cloud.consumer.safe.controller;

import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.common.util.IpUtil;
import com.cloud.consumer.safe.base.BaseRestMapResponse;

/**
 * 错误返回 BaseErrorController
 * @author wei.yong
 */
@RestController
public class BaseErrorController implements ErrorController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * http错误返回
	 * @param request
	 * @param response
	 * @return BaseRestMapResponse
	 */
	@RequestMapping(value="/error")
	@ResponseBody
	public BaseRestMapResponse error(HttpServletRequest request, HttpServletResponse response) {
		String ip = IpUtil.getIpAddr(request);
		Map<String, String[]> paramMap = request.getParameterMap();
		logger.info("===step1:【错误返回】(BaseErrorController-error)-请求参数, 请求ip:{}, paramMap:{}", ip, paramMap);
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		String message =  (String) request.getAttribute("javax.servlet.error.message");
		logger.info("===step2:【错误返回】(BaseErrorController-error)-http返回码, statusCode:{}", statusCode);
		//500 Internal Server Error（服务器内部错误）
		if(statusCode.equals(HttpStatus.INTERNAL_SERVER_ERROR.value())) {
			message = "服务器出错了，别着急！请耐心等待哦~";
		//404 Internal Not Found（页面没找到）
		} else if(statusCode.equals(HttpStatus.NOT_FOUND.value())) {
			message = "页面飘走了，别着急！请耐心等待哦~";
		}
		BaseRestMapResponse baseRestMapResponse = new BaseRestMapResponse(Objects.toString(statusCode), message, Objects.toString(statusCode), message);
		logger.info("===step3:【错误返回】(BaseErrorController-error)-返回信息, baseRestMapResponse:{}", baseRestMapResponse);
		return baseRestMapResponse;
	}

//	 /**
//     * 获取错误编码
//     * @param request
//     * @return
//     */
//    private HttpStatus getStatus(HttpServletRequest request) {
//        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
//        if (statusCode == null) {
//            return HttpStatus.INTERNAL_SERVER_ERROR;
//        }
//        try {
//            return HttpStatus.valueOf(statusCode);
//        }
//        catch (Exception ex) {
//            return HttpStatus.INTERNAL_SERVER_ERROR;
//        }
//    }

	@Override
	public String getErrorPath() {
		return null;
	}

}