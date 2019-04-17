package com.cloud.provider.safe.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.common.exception.SafeException;
import com.cloud.provider.safe.base.BaseRestMapResponse;

/**
 * @author S.J.
 * @date 2018/06/28
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@InitBinder
    public void initBinder(WebDataBinder binder) {
//        System.out.println("============应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器");
    }

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
			logger.error("【全局异常处理】(GlobalExceptionHandler-exceptionHandler)-自定义异常, Exception = {}, message = {}", e, e.getMessage());
			return new BaseRestMapResponse(ex.getErrorCode(), ex.getMessage());
		}
//		if (e instanceof SQLException) {
//			SQLException ex = (SQLException) e;
//			logger.error("【全局异常处理】(GlobalExceptionHandler-exceptionHandler)-sql异常, Exception = {}, message = {}", ex, ex.getMessage());
//			return new BaseRestMapResponse(SafeResultEnum.SYSTEM_ERROR);
//		}
		if (e instanceof DataAccessException) {
			DataAccessException ex = (DataAccessException) e;
			logger.error("【全局异常处理】(GlobalExceptionHandler-exceptionHandler)-数据访问异常, Exception = {}, message = {}", ex, ex.getMessage());
			return new BaseRestMapResponse(SafeResultEnum.SYSTEM_ERROR);
		}

		logger.error("【全局异常处理】(GlobalExceptionHandler-exceptionHandler)-未知异常, Exception = {}, message = {}", e, e.getMessage());
		String message = e.getMessage();
        String exceptionName = e.getClass() == null ? null : e.getClass().getSimpleName();
        String resultMessage = exceptionName == null ? "[" + message+ "]" : exceptionName + "[" + message + "]";
        return new BaseRestMapResponse(SafeResultEnum.UNKNOWN_ERROR.getCode(), resultMessage);
	}

}
