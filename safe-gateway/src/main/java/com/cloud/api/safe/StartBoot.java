package com.cloud.api.safe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.cloud.api.safe.filter.ResponseZuulFilter;
import com.cloud.api.safe.filter.TokenZuulFilter;

@SpringBootApplication
//服务网关
@EnableZuulProxy
public class StartBoot {

	/**
	 * 跨域
	 * @return CorsFilter
	 */
	@Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);	//允许cookies跨域
        config.addAllowedOrigin("*");	//允许向该服务器提交请求的URI，*表示全部允许，在SpringMVC中，如果设成*，会自动转成当前请求头中的Origin
        config.addAllowedHeader("*");	//允许访问的头信息,*表示全部
        config.addAllowedMethod("*");	//允许提交请求的方法，*表示全部允许
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

	/**
	 * TokenZuulFilter过滤器
	 * @return TokenZuulFilter
	 */
	@Bean
	public TokenZuulFilter tokenZuulFilter() {
		return new TokenZuulFilter();
	}

	/**
	 * ResponseZuulFilter过滤器
	 * @return ResponseZuulFilter
	 */
	@Bean
	public ResponseZuulFilter responseZuulFilter() {
		return new ResponseZuulFilter();
	}

	public static void main(String[] args) {
		SpringApplication.run(StartBoot.class, args);
	}

}