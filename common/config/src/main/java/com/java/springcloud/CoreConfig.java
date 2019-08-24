package com.java.springcloud;

import com.java.springcloud.properties.ConfigProperties;
import com.java.springcloud.properties.ConfigProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * config
 *
 * @author TONE
 * @date 2019/8/9
 */
@Configuration
@EnableConfigurationProperties(ConfigProperties.class)
public class CoreConfig {
}
