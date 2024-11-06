package com.my.mybatisTest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    // http://localhost:8080/upload/test.img
    private String resourcePath = "/upload/**";
    // C:/upload_files/test.img
    private String savePath = "file:///C:/upload_files/";
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(resourcePath)
                .addResourceLocations(savePath);
    }
}
