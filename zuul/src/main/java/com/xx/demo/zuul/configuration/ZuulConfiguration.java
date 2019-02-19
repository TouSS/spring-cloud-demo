package com.xx.demo.zuul.configuration;

import com.xx.demo.zuul.filter.AccessFilter;
import com.xx.demo.zuul.filter.LogFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZuulConfiguration {

    /**
     * 注入自定义过滤器, 也可以使用@Component注解自动注入
     */
    @Bean
    public AccessFilter accessFilter() {
        return new AccessFilter();
    }

    @Bean
    public LogFilter logFilter() {
        return new LogFilter();
    }
}
