package com.cloud.consumer.safe.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.common.exception.SafeException;
import com.cloud.consumer.safe.base.BaseRestMapResponse;

/**
 * @author S.J.
 * @date 2018/06/28
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 异常处理
	 * @param e
	 * @return BootRestMapResponse
	 */
	@ResponseBody
	@ExceptionHandler(value = Exception.class)
	public BaseRestMapResponse exceptionHandler(Exception e) {
		if (e instanceof SafeException) {
			SafeException ex = (SafeException) e;
			logger.error("【全局异常处理】(GlobalExceptionHandler-exceptionHandler)-自定义异常, Exception = {}, message = {}", ex, ex.getMessage());
			return new BaseRestMapResponse(ex.getErrorCode(), ex.getMessage());
		}

		logger.error("【全局异常处理】(GlobalExceptionHandler-exceptionHandler)-未知异常, Exception = {}, message = {}", e, e.getMessage());
		String message = e.getMessage();
        String exceptionName = e.getClass() == null ? null : e.getClass().getSimpleName();
        String resultMessage = exceptionName == null ? "[" + message+ "]" : exceptionName + "[" + message + "]";
        return new BaseRestMapResponse(SafeResultEnum.UNKNOWN_ERROR.getCode(), resultMessage);
	}

}