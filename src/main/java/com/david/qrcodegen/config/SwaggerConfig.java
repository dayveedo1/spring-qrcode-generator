//package com.david.qrcodegen.config;
//
//import org.springframework.context.annotation.Bean;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//
//public class SwaggerConfig {
//
//    //The select() method called on Docket bean returns an "ApiSelectorBuilder". This provides "apis()" and "paths()" methods to filter the controllers and methods being documented using string predicates.
//    @Bean
//    public Docket postsApi() {
//        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any()).paths(PathSelectors.any()).build();
//    }
//
//    @SuppressWarnings("deprecation")
//    private ApiInfo metadata() {
//        return new ApiInfoBuilder().title("QR-Code").description("API reference guide for developers").termsOfServiceUrl("https://www.google.com/").contact("David").version("1.0").build();
//    }
//}
//
//
