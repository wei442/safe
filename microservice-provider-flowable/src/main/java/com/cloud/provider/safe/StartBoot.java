package com.cloud.provider.safe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource;
import org.springframework.transaction.interceptor.RollbackRuleAttribute;
import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute;
import org.springframework.transaction.interceptor.TransactionAttribute;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

@SpringBootApplication
@MapperScan(basePackages="com.cloud.provider.safe.dao")
@EnableTransactionManagement
//服务发现
@EnableEurekaClient
public class StartBoot {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 事务管理器
	 */
	@Autowired
	private DataSourceTransactionManager transactionManager;

	/**
	 * 实施事务的业务逻辑层(service)
	 */
	private static final String AOP_POINTCUT_EXPRESSION = "execution(* com.cloud.provider.safe.service..*.*(..))";

	/**
	 * 使用fastjson
	 * @return HttpMessageConverters
	 */
	@Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
		SerializerFeature[] serializerFeature = new SerializerFeature[]{
			SerializerFeature.PrettyFormat, SerializerFeature.MapSortField,
			SerializerFeature.WriteNullListAsEmpty, SerializerFeature.WriteNullStringAsEmpty,
			SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat
		};
		List<MediaType> mediaTypes = new ArrayList<MediaType>();
		mediaTypes.add(MediaType.parseMediaType(MediaType.APPLICATION_JSON_UTF8_VALUE));
		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(serializerFeature);
		fastJsonConfig.setDateFormat(JSON.DEFFAULT_DATE_FORMAT);
		fastConverter.setSupportedMediaTypes(mediaTypes);
		fastConverter.setFastJsonConfig(fastJsonConfig);
		HttpMessageConverter<?> converter = fastConverter;
		return new HttpMessageConverters(converter);
    }

	/**
	 * 启动web安全,允许所有请求,关闭CSRF保护
	 * @author wei.yong
	 */
	@Configuration
    public static class WebSecurityConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests().anyRequest().permitAll().and().csrf().disable();
        }
    }

	/**
	 * 创建事务通知，配置事物相关，配置事务异常封装，声明式容器事务管理
	 * @return TransactionInterceptor
	 */
	@Bean
	public TransactionInterceptor txAdvice() {
		/*当前存在事务就使用当前事务，当前不存在事务就创建一个新的事务*/
		RuleBasedTransactionAttribute requiredTx = new RuleBasedTransactionAttribute();
		requiredTx.setRollbackRules(Collections.singletonList(new RollbackRuleAttribute(Exception.class)));
		requiredTx.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

		/*只读事务，不做更新操作*/
	    RuleBasedTransactionAttribute readOnlyTx = new RuleBasedTransactionAttribute();
	    readOnlyTx.setReadOnly(true);

	    Map<String, TransactionAttribute> txMap = new HashMap<String, TransactionAttribute>();
	    txMap.put("add*", requiredTx);
	    txMap.put("save*", requiredTx);
	    txMap.put("insert*", requiredTx);
	    txMap.put("create*", requiredTx);
	    txMap.put("delete*", requiredTx);
	    txMap.put("remove*", requiredTx);
	    txMap.put("modify*", requiredTx);
	    txMap.put("update*", requiredTx);
	    txMap.put("restore*", requiredTx);
	    txMap.put("reset*", requiredTx);
	    txMap.put("select*", readOnlyTx);
	    txMap.put("get*", readOnlyTx);
	    txMap.put("find*", readOnlyTx);
	    txMap.put("count*", readOnlyTx);

	    NameMatchTransactionAttributeSource transactionAttributeSource = new NameMatchTransactionAttributeSource();
	    transactionAttributeSource.setNameMap(txMap);
	    TransactionInterceptor txAdvice = new TransactionInterceptor(transactionManager, transactionAttributeSource);
	    return txAdvice;
	}

	/**
	 * 只对业务逻辑层实施事务
	 * Advisor定义，切入点和通知分别为txPointcut、txAdvice
	 * @return Advisor
	 */
	@Bean
	public Advisor txAdviceAdvisor() {
		AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
	    pointcut.setExpression(AOP_POINTCUT_EXPRESSION);
	    return new DefaultPointcutAdvisor(pointcut, txAdvice());
	}

	public static void main(String[] args) {
		SpringApplication.run(StartBoot.class, args);
	}

}