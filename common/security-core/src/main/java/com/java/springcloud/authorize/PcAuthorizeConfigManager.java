package com.java.springcloud.authorize;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * PcAuthorizeConfigManager
 * 默认的授权配置管理器
 *
 * @author TONE
 * @date 2019/8/12
 */
@Component
public class PcAuthorizeConfigManager implements AuthorizeConfigManager {

    private final List<AuthorizeConfigProvider> authorizeConfigProviders;

    /**
     * Instantiates a new Pc authorize config manager.
     *
     * @param authorizeConfigProviders the authorize config providers
     */
    @Autowired
    public PcAuthorizeConfigManager(List<AuthorizeConfigProvider> authorizeConfigProviders) {
        this.authorizeConfigProviders = authorizeConfigProviders;
    }

    /**
     * Config.
     *
     * @param config the config
     */
    @Override
    public void config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config) {
        boolean existAnyRequestConfig = false;
        String existAnyRequestConfigName = null;

        for (AuthorizeConfigProvider authorizeConfigProvider : authorizeConfigProviders) {
            boolean currentIsAnyRequestConfig = authorizeConfigProvider.config(config);
            if (existAnyRequestConfig && currentIsAnyRequestConfig) {
                throw new RuntimeException("重复的anyRequest配置:" + existAnyRequestConfigName + ","
                        + authorizeConfigProvider.getClass().getSimpleName());
            } else if (currentIsAnyRequestConfig) {
                existAnyRequestConfig = true;
                existAnyRequestConfigName = authorizeConfigProvider.getClass().getSimpleName();
            }
        }

        if (!existAnyRequestConfig) {
            config.anyRequest().authenticated();
        }
    }
}
