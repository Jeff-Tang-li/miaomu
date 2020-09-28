package com.miaomu.manager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Jack
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    /**
     * @return
     * @Description
     * @Date 2020/06/19
     */
    @Bean
    public Docket controllerApi() {

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title("标题:Manager管理")
                        .description("Manager管理")
                        .contact(new Contact("", "www.miaomu.com", "@miaomu.net"))
                        .version("1.0.0")
                        .build())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.miaomu.manager"))
                .paths(PathSelectors.any())
                .build();

    }

}