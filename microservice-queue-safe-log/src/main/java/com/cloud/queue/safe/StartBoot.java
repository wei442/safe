package com.cloud.queue.safe;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

import redis.clients.jedis.JedisSentinelPool;

@SpringBootApplication
@ComponentScan(basePackages={"com.cloud.queue.safe"})
//服务发现
@EnableEurekaClient
public class StartBoot {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//redis哨兵(sentinel) master名称
	@Value("${jedis.sentinelMasterName}")
	public String sentinelMasterName;

	//redis哨兵(sentinel) ip
	@Value("${jedis.sentinelIp}")
	public String sentinelIp;

	//redis哨兵(sentinel) 密码
	@Value("${jedis.sentinelPassword}")
	public String sentinelPassword;

	//最大连接数, 默认8个
	@Value("${jedis.maxTotal}")
	public Integer maxTotal;

	//最大空闲连接数
	@Value("${jedis.maxIdle}")
	public Integer maxIdle;

	//最小空闲连接数
	@Value("${jedis.minIdle}")
	public Integer minIdle;

	//连接时的最大等待毫秒数
	@Value("${jedis.maxWait}")
	public Integer maxWait;

	//在获取连接的时候检查有效性
	@Value("${jedis.testOnBorrow}")
	public Boolean testOnBorrow;

	//在return给pool时，是否提前进行validate操作
	@Value("${jedis.testOnReturn}")
	public Boolean testOnReturn;

	//空闲时检查有效性
	@Value("${jedis.testWhileIdle}")
	public Boolean testWhileIdle;

	//一个对象至少停留在idle状态的最短时间，大于0
	@Value("${jedis.minEvictableIdleTimeMillis}")
	public Long minEvictableIdleTimeMillis;

	@Value("${jedis.timeBetweenEvictionRunsMillis}")
	//逐出扫描的时间间隔(毫秒) 如果为负数,则不运行逐出线程, 默认-1
	public Long timeBetweenEvictionRunsMillis;

	//表示idle object evitor每次扫描的最多的对象数
	@Value("${jedis.numTestsPerEvictionRun}")
	public Integer numTestsPerEvictionRun;

	//超时时间
	@Value("${jedis.timeout}")
	public Integer timeout;

	/**
	 * 使用fastjson
	 * @return HttpMessageConverters
	 */
	@Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
		SerializerFeature[] serializerFeature = new SerializerFeature[]{
			SerializerFeature.PrettyFormat, SerializerFeature.MapSortField,
			SerializerFeature.WriteNullListAsEmpty,SerializerFeature.WriteNullStringAsEmpty
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
	 * 获取jedis哨兵连接池
	 * @return JedisSentinelPool
	 */
	@Bean
    public JedisSentinelPool getJedisSentinelPool() {
    	GenericObjectPoolConfig<?> config = new GenericObjectPoolConfig<>();
    	if (maxTotal != null) config.setMaxTotal(maxTotal);
    	if (maxIdle != null) config.setMaxIdle(maxIdle);
    	if (minIdle != null) config.setMinIdle(minIdle);
    	if (maxWait != null) config.setMaxWaitMillis(maxWait);
    	if (minEvictableIdleTimeMillis != null) config.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
    	if (timeBetweenEvictionRunsMillis != null) config.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
    	if (numTestsPerEvictionRun != null) config.setNumTestsPerEvictionRun(numTestsPerEvictionRun);

		if (testOnBorrow != null) config.setTestOnBorrow(testOnBorrow);
		if (testOnReturn != null) config.setTestOnReturn(testOnReturn);
		if (testWhileIdle != null) config.setTestWhileIdle(testWhileIdle);

		Set<String> sentinels = new HashSet<String>();
		String[] sentinelIps = StringUtils.split(sentinelIp, ",");
		if(sentinelIps != null && sentinelIps.length >0) {
			for (String str : sentinelIps) {
				sentinels.add(str);
			}
		}

		JedisSentinelPool jedisSentinelPool = null;
		if (timeout != null) {
			jedisSentinelPool = new JedisSentinelPool(sentinelMasterName, sentinels, config, timeout, sentinelPassword);
		} else {
			jedisSentinelPool = new JedisSentinelPool(sentinelMasterName, sentinels, config, sentinelPassword);
		}
		return jedisSentinelPool;
    }


	/* 实例化RestTemplate，通过@LoadBalanced注解开启均衡负载能力.
	* @return restTemplate
	*/
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(HttpComponentsClientHttpRequestFactory clientHttpRequestFactory) {
		RestTemplate template = new RestTemplate(clientHttpRequestFactory);
        return template;
	}

	/**
	 * 实例化RestTemplate，不开启均衡负载
	 * @return RestTemplate
	 */
	@Bean
	public RestTemplate simpleRestTemplate(HttpComponentsClientHttpRequestFactory clientHttpRequestFactory) {
		RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);
        return restTemplate;
	}

	public static void main(String[] args) {
		SpringApplication.run(StartBoot.class, args);
	}

}