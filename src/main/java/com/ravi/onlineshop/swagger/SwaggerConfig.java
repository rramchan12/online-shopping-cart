package com.ravi.onlineshop.swagger;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {


    //Get the Application Version
    @Value("@project.version@")
    private String version;
}
