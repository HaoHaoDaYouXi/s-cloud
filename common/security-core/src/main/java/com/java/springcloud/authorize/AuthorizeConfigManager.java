package com.java.springcloud.authorize;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;

/**
 * AuthorizeConfigManager
 * 授权信息管理器
 * 用于收集系统中所有 AuthorizeConfigProvider 并加载其配置
 *
 * @author TONE
 * @date 2019/8/12
 */
public interface AuthorizeConfigManager {

    /**
     * Config.
     *
     * @param config the config
     */
    void config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config);
}
