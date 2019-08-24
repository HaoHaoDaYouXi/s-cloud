package com.java.springcloud.authorize;

import com.java.springcloud.properties.SecurityConstants;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

/**
 * PcAuthorizeConfigProvider
 *
 * @author TONE
 * @date 2019/8/12
 */
@Component
@Order(Integer.MIN_VALUE)
public class PcAuthorizeConfigProvider implements AuthorizeConfigProvider {

    /**
     * Config boolean.
     *
     * @param config the config
     *
     * @return the boolean
     */
    @Override
    public boolean config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config) {
        config.antMatchers(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL,
                SecurityConstants.DEFAULT_SIGN_IN_PROCESSING_URL_MOBILE,
                SecurityConstants.DEFAULT_SIGN_IN_PROCESSING_URL_OPENID,
                SecurityConstants.DEFAULT_SOCIAL_USER_INFO_URL,
                SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX + "/*", "/pay/alipayCallback",
                "/druid/**", "/auth/**", "/swagger-ui.html", "/swagger-resources/**", "/v2/api-docs").permitAll();
        return false;
    }

}
