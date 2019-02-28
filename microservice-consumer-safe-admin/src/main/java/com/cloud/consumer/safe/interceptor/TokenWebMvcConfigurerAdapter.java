package com.ochain.consumer.wheel.interceptor;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class TokenWebMvcConfigurerAdapter implements WebMvcConfigurer {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//Token 拦截器
	@Autowired
	private TokenInterceptor tokenInterceptor;

	//全局错误返回
	private static final String GLOBAL_ERROR = "/error";

	//token 忽视url
	@Value("${token.ignore.uri}")
	private String tokenIgnoreUri;

	private String[] excludePaths = null;

	//第三方URI资源
	@Value("${third.uri}")
	private String thirdUri;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		logger.info("【Token适配器】(TokenWebMvcConfigurerAdapter-InterceptorRegistry)-增加拦截器-启动开始");
		init();
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
		//token拦截器
		InterceptorRegistration tokenInterceptorRegistration = registry.addInterceptor(tokenInterceptor);
		tokenInterceptorRegistration.addPathPatterns("/**");
		tokenInterceptorRegistration.excludePathPatterns(excludePaths);
		tokenInterceptorRegistration.excludePathPatterns(thirdUri);
		tokenInterceptorRegistration.excludePathPatterns(GLOBAL_ERROR);
		logger.info("【Token适配器】(TokenWebMvcConfigurerAdapter-InterceptorRegistry)-增加拦截器-启动结束");
    }

	/**
	 *初始化
	 */
	public void init() {
		if(excludePaths == null || excludePaths.length == 0) {
			this.excludePaths = StringUtils.split(tokenIgnoreUri, ",");
		}
		logger.info("【Token适配器】(TokenWebMvcConfigurerAdapter-init)-初始化, excludePaths:{}", Arrays.toString(excludePaths));
	}

}