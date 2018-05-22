package com.blue.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;
import java.util.Date;

/**
 * 类名
 *
 * @author lblue
 * @date 2018/5/2
 */
@Configuration
//@EnableWebMvc
@EnableSwagger2
//@ComponentScan(basePackages = { "" })
public class SwaggerConfig {
    /**
     *
     * Description: <br>
     *
     * @author luoluocaihong<br>
     * @taskId <br>
     * @return <br>
     */
    ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("liblue Web SelfService APIs")
                .description("description")
                .license("license")
                .licenseUrl("licenseUrl")
                .termsOfServiceUrl("termsOfServiceUrl")
                .version("1.0.0")
                .build();
    }

    /**
     *
     * Description: <br>
     *
     * @author luoluocaihong<br>
     * @taskId <br>
     * @return <br>
     */
    @Bean
    public Docket customImplementation() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.blue.api.controller"))
                .build()
                .directModelSubstitute(LocalDate.class, Date.class)
//                .directModelSubstitute(DateTime.class, Date.class)
                .apiInfo(apiInfo());
    }

}
