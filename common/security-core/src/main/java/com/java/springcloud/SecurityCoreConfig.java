package com.java.springcloud;

import com.java.springcloud.properties.SecurityProperties;
import com.java.springcloud.properties.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * SecurityCoreConfig
 *
 * @author TONE
 * @date 2019/8/12
 */
@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityCoreConfig {

}

