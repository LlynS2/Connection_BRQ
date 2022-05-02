package com.smarttech.ConnectionBRQ.Setting;

import javax.servlet.ServletContext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/* 𝐋𝐈𝐍𝐊 𝐓𝐎 𝐒𝐖𝐀𝐆𝐆𝐄𝐑 : http://localhost:8080/swagger-ui.html#/ */

@Configuration
@EnableSwagger2
public class SwaggerSetting {
	
    @Bean
    public Docket api(ServletContext servletContext) {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build()
                .tags(new Tag("Applicant", 
                	          "These endpoints are used to register and search for candidates", 1));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Applicant API Control ")
                .description("This service deals with the control of registration and search for candidates")
                .version("1.0.0")
                .build();
    }

    @Bean
    UiConfiguration uiConfig() {
        return UiConfigurationBuilder.builder()
                .defaultModelsExpandDepth(-1)
                .build();
    }

}

/* 𝐏𝐑𝐎𝐉𝐄𝐂𝐓'𝐒 𝐑𝐄𝐏𝐎𝐒𝐈𝐓𝐎𝐑𝐘 : https://github.com/LlynS2/Connection_BRQ */
