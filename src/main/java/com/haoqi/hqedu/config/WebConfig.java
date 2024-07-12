package com.haoqi.hqedu.config;

import com.haoqi.hqedu.interceptor.LoginCheckInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private LoginCheckInterceptor loginCheckInterceptor;

    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(loginCheckInterceptor).addPathPatterns("/**").excludePathPatterns("/login");
    }


}
