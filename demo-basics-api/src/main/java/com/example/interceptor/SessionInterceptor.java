package com.example.interceptor;

/**
 * @Author ： leo
 * @Date :2019/11/6 16:25
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:wjup
 * @Date: 2018/9/28 0028 10:28
 */
@Configuration
public class SessionInterceptor implements WebMvcConfigurer {

    @Resource
    private UserInterceptor userInterceptor;

    /**
     * 自定义拦截器，添加拦截路径和排除拦截路径
     * addPathPatterns():添加需要拦截的路径
     * excludePathPatterns():添加不需要拦截的路径
     */
    //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(userInterceptor).addPathPatterns("/**").excludePathPatterns("/user/toIndex",
        "/user/loginUser",
        "/user/toRegister",
        "/user/register",
        "/test/hello",
        "/test/get/{id}",
        "/demo/hi",
        "/swagger-ui.html",
        "/v2/**",
        "/swagger-resources/**",
        "/webjars/**");
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //支持所有的请求跨域
        registry.addMapping("/**")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE")
                .allowedOrigins("*")//此处设置所有跨域请求，防止生产上漏配配错
                .maxAge(300)
                .allowedHeaders("X-PINGOTHER", "Content-Type");
    }


}
