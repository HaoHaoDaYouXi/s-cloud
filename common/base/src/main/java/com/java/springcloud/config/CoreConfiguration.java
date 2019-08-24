package com.java.springcloud.config;

import com.java.springcloud.interceptor.SqlLogInterceptor;
import com.java.springcloud.interceptor.TokenInterceptor;
import com.java.springcloud.interceptor.SqlLogInterceptor;
import com.java.springcloud.interceptor.TokenInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * CoreConfiguration
 * 加载LWR规则.
 *
 * @author TONE
 * @date 2019/8/16
 */
@Configuration
public class CoreConfiguration {
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public SqlLogInterceptor sqlLogInterceptor() {
        return new SqlLogInterceptor();
    }


    @Bean
    @ConditionalOnMissingBean(HandlerInterceptor.class)
    @ConditionalOnProperty(prefix = "cloud.token.interceptor", name = "enable", havingValue = "true")
    public TokenInterceptor tokenInterceptor() {
        return new TokenInterceptor();
    }
}
