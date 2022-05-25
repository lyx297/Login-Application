package com.lyx297.springloginapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {

        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/welcome").setViewName("welcome");
        registry.addViewController("/welcome-manager").setViewName("welcome-manager");
        registry.addViewController("/login").setViewName("login");
    }

}
