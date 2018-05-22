//package com.blue.api;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
///**
// * @author dingyuan
// * @version 1.0.0
// * @date 17/4/18 下午12:02.
// */
//@Configuration
//@EnableSwagger2
//public class Swagger2 {
//
//    @Bean
//    public Docket createRestApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.blue.api.controller"))
//                .paths(PathSelectors.any())
//                .build();
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("金贝猫中使用Swagger2构建RESTful APIs")
//                .description("官方网站：http://www.jinbeicat.com/")
//                .termsOfServiceUrl("http://www.jinbeicat.com/")
//                .contact("金贝猫")
//                .version("1.0")
//                .build();
//    }
//
//}
