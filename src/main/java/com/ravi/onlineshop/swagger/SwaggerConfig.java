package com.ravi.onlineshop.swagger;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {


    //Get the Application Version
    @Value("@project.version@")
    private String version;

    /**
     * The API Info to be displayed on the Swagger UI
     *
     * @return
     */
    private ApiInfo apiInfo() {
        Contact contact = new Contact("Ravi Skill Build Team",
                "https://gecgithub01.walmart.com/riyenga/skillbite-shopping-cart",
                null);
        return new ApiInfoBuilder()
                .title("Shopping Cart with Configurable Discount Engine")
                .description(
                        "An API to simulate a shopping cart application")
                .version(version)
                .license(null)
                .licenseUrl(null).contact(contact).build();
    }
}
