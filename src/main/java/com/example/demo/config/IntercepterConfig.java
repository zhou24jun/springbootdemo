package com.example.demo.config;

import com.example.demo.intercepter.AuthenticatoinIntercepter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @className: IntercepterConfig
 * @description: TODO 类描述
 * @author: junZhou
 * @date: 2020/7/10
 **/
@Configuration
public class IntercepterConfig implements WebMvcConfigurer {
    @Bean
    public AuthenticatoinIntercepter authenticationInterceptor() {
        return new AuthenticatoinIntercepter();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticationInterceptor())
                .addPathPatterns("/**");
    }

}
