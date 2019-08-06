package com.ai.rti.report;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by wangting26 on 2017/8/14.
 */
@Configuration
@EnableSwagger2
public class Swagger2 {
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.ai.rti.ic.grp.controller")).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("spring boot hbase swagger2").description("spring boot hbase swagger2")
				.contact(new Contact("Tina", "http://tina437213.com", "tina437213@163.com")).version("0.5").build();
	}
}
