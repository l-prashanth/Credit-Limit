package com.prashanth.configuration;

import com.prashanth.preexecution.TraceIdInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.rmi.registry.Registry;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer   {

    @Autowired
    TraceIdInterceptor traceIdInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(traceIdInterceptor);

    }
}
