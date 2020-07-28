package com.example.demo.mvc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.interceptor.HelloInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public IndexFilter indexFilter() {
        return new IndexFilter();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new IndexInterceptor());
        registry.addInterceptor(new HelloInterceptor());
    }
}
