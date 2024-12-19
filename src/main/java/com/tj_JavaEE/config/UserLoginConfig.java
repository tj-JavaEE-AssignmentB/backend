package com.tj_JavaEE.config;

import com.tj_JavaEE.interceptor.UserLoginCheckInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class UserLoginConfig implements WebMvcConfigurer {

    @Autowired
    private UserLoginCheckInterceptor userLoginCheckInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userLoginCheckInterceptor)
                .addPathPatterns("/**")
                //.excludePathPatterns("/**")
                .excludePathPatterns("/user/login")
                .excludePathPatterns(HttpMethod.OPTIONS.name())
                .excludePathPatterns("/user/register");

    }

}
