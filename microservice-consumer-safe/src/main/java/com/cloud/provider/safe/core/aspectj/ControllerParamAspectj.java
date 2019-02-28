package com.ochain.provider.wheel.core.aspectj;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.ochain.common.exception.BootServiceException;

@Component
@Aspect
public class ControllerParamAspectj {

	//取得日志记录器
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

//	@Autowired
//	private ObjectMapper objectMapper;

	@Around("execution(* com.ochain.provider.wheel.controllers.*.*(..))")
	public Object myAroundAdvice(ProceedingJoinPoint pjp) throws Throwable {

		long begintime = System.currentTimeMillis();

		//body参数验证
		Object[] objs = pjp.getArgs();
		Signature signature = pjp.getSignature();
		MethodSignature methodSignature = (MethodSignature) signature;
		Method method = methodSignature.getMethod();

		String classFullName = methodSignature.getDeclaringType().getName();
		String className = classFullName.substring(classFullName.lastIndexOf("."));
		String methodName = method.getName();

		long endValtime = System.currentTimeMillis();
		Object result = null;
		try {
			result = pjp.proceed(objs);
		} catch(BootServiceException e) {
			logger.error("Exception ErrorCode :" + e.getErrorCode());
			logger.error("Exception Message :" + e.getMessage());
		}

//		objectMapper.setDateFormat(new SimpleDateFormat(JSON.DEFFAULT_DATE_FORMAT));
		long endtime = System.currentTimeMillis();
		StringBuffer sb = new StringBuffer();
		sb.append("\n\n");
		sb.append("环绕通知：");
		sb.append(className);
		sb.append("-->");
		sb.append(methodName);
		sb.append(" 方法执行结束，验证耗时：");
		sb.append(endValtime - begintime);
		sb.append("ms，方法总耗时:");
		sb.append(endtime-endValtime);
		sb.append("ms！");
//		sb.append("return msg=");
//		sb.append(objectMapper.writeValueAsString(result));
//		sb.append("\n\n");
		if(logger.isInfoEnabled())logger.info(sb.toString());
		return result;
	}

}