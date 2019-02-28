package com.ochain.consumer.wheel.start;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.SSLContext;

import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
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

@SpringBootApplication
@ComponentScan(basePackages={"com.ochain.consumer.wheel"})
//服务发现
@EnableEurekaClient
//熔断器
@EnableHystrix
public class StartBoot {

	/**
	 * 使用fastjson
	 * @return HttpMessageConverters
	 */
	@Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
		SerializerFeature[] serializerFeature = new SerializerFeature[]{
			SerializerFeature.PrettyFormat, SerializerFeature.MapSortField,
			SerializerFeature.WriteNullListAsEmpty,SerializerFeature.WriteNullStringAsEmpty,
			SerializerFeature.WriteDateUseDateFormat
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

	/* 实例化RestTemplate，通过@LoadBalanced注解开启均衡负载能力.
	 * @return restTemplate
	 */
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(HttpComponentsClientHttpRequestFactory clientHttpRequestFactory) {
		RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);
		return restTemplate;
	}

	/**
	 * 实例化RestTemplate，不开启均衡负载
	 * 读写请求超时时间设置为600,000毫秒(600秒,10分钟)
	 * @return RestTemplate
	 */
	@Bean
	public RestTemplate simpleRestTemplate(HttpComponentsClientHttpRequestFactory clientHttpRequestFactory) {
		RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);
		clientHttpRequestFactory.setConnectionRequestTimeout(600000);
		clientHttpRequestFactory.setConnectTimeout(600000);
		clientHttpRequestFactory.setReadTimeout(600000);
        return restTemplate;
	}

	/**
	 * 设置https和http访问
	 * @return HttpComponentsClientHttpRequestFactory
	 * @throws KeyStoreException
	 * @throws NoSuchAlgorithmException
	 * @throws KeyManagementException
	 */
	@Bean
	public HttpComponentsClientHttpRequestFactory clientHttpRequestFactory() throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
        SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
			@Override
			public boolean isTrusted(X509Certificate[] chain, String authType)
				throws CertificateException {
					return true;
			}
        }).build();

        SSLConnectionSocketFactory sslSocketFactory = new SSLConnectionSocketFactory(sslContext, NoopHostnameVerifier.INSTANCE);
        RegistryBuilder<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create();
        socketFactoryRegistry.register("http", PlainConnectionSocketFactory.getSocketFactory());
        socketFactoryRegistry.register("https", sslSocketFactory);

        PoolingHttpClientConnectionManager connMgr = new PoolingHttpClientConnectionManager(socketFactoryRegistry.build());
        connMgr.setMaxTotal(500);
        connMgr.setDefaultMaxPerRoute(200);

        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        httpClientBuilder.setSSLContext(sslContext);
        httpClientBuilder.setConnectionManager(connMgr);

        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(httpClientBuilder.build());
        return clientHttpRequestFactory;
    }

	public static void main(String[] args) {
		SpringApplication.run(StartBoot.class, args);
	}

}