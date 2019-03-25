package com.cloud.provider.safe.core.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import com.cloud.common.enums.safe.RetSafeAdminResultEnum;
import com.cloud.common.exception.SafeException;

@Component
@Aspect
@Order(1)
public class BindResultAspect {

	//取得日志记录器
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 参数校验
	 * @param point
	 * @throws Throwable
	 */
	@Before("execution(* com.cloud.provider.safe.controller.*.*(..))")
	public void bindResultBeforeAdvice(JoinPoint point) throws Throwable {
		// 获取类名
		String clazzName = point.getTarget().getClass().getName();
		// 获取方法名
		String methodName = point.getSignature().getName();
		// 获取参数
		Object[] args = point.getArgs();
		for (Object arg : args) {
			if (arg instanceof BindingResult) {
				BindingResult result = (BindingResult) arg;
				if (result.hasErrors()) {
					logger.error(">>>>>> {}.{}() valid params is error msg = {}", clazzName, methodName, result.getFieldError().getDefaultMessage());
					throw new SafeException(RetSafeAdminResultEnum.PARAMETER_NULL.getCode(), result.getFieldError().getDefaultMessage());
				}
			}
		}
	}
}
