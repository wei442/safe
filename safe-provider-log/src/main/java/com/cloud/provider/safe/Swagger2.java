package com.cloud.provider.safe;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2 {

	//swagger2是否开启
	@Value("${swagger2.enable}")
    private boolean swagger2Enable;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
        		.enable(swagger2Enable)
                .apiInfo(apiInfo())
                .select()
                 //限制只有在方法上加@Api才添加到swagger，默认是都添加的
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Safe provider service RESTful APIs")
                .description("安全活动提供者接口")
                .contact(new Contact("weiyong", "http://www.ochain.fun/", "weiyong@ochain.fun"))
                .version("1.0.0")
                .build();
    }

}