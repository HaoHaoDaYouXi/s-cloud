package com.java.springcloud.config;

import com.java.springcloud.interceptor.TokenInterceptor;
import com.java.springcloud.properties.SecurityConstants;
import com.java.springcloud.interceptor.TokenInterceptor;
import com.java.springcloud.properties.SecurityConstants;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.Resource;
import java.util.List;

/**
 * WebMvcConfig
 *
 * @author TONE
 * @date 2019/8/15
 */
@Configuration
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Resource
    private TokenInterceptor vueViewInterceptor;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/META-INF/resources/", "classpath:/resources/", "classpath:/static/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(vueViewInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/swagger-resources/**",
                        "*.js", "/**/*.js",
                        "*.css", "/**/*.css",
                        "*.html", "/**/*.html",
                        SecurityConstants.DEFAULT_SOCIAL_USER_INFO_URL);
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        PcObjectMapper.buidMvcMessageConverter(converters);
    }
}
