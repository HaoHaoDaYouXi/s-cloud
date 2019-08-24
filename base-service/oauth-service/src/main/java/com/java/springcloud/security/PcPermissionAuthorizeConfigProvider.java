package com.java.springcloud.security;

import com.java.springcloud.authorize.AuthorizeConfigProvider;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

/**
 * PcPermissionAuthorizeConfigProvider
 *
 * @author TONE
 * @date 2019/8/15
 */
@Order
@Component
public class PcPermissionAuthorizeConfigProvider implements AuthorizeConfigProvider {

    /**
     * Config boolean.
     *
     * @param config the config
     *
     * @return the boolean
     */
    @Override
    public boolean config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config) {
        config
                .anyRequest()
                .access("@permissionService.hasPermission(authentication,request)");
        return true;
    }
}
