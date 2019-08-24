package com.java.springcloud.server;

import com.java.springcloud.authentication.FormAuthenticationConfig;
import com.java.springcloud.authentication.mobile.SmsCodeAuthenticationSecurityConfig;
import com.java.springcloud.authorize.AuthorizeConfigManager;
import com.java.springcloud.app.authentication.openId.OpenIdAuthenticationSecurityConfig;
import com.java.springcloud.authentication.FormAuthenticationConfig;
import com.java.springcloud.authentication.mobile.SmsCodeAuthenticationSecurityConfig;
import com.java.springcloud.authorize.AuthorizeConfigManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.expression.OAuth2WebSecurityExpressionHandler;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.social.security.SpringSocialConfigurer;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * PcResourceServerConfig
 * 资源服务器配置
 *
 * @author TONE
 * @date 2019/8/12
 */
@Configuration
@EnableResourceServer
public class PcResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private OAuth2WebSecurityExpressionHandler pcSecurityExpressionHandler;

    @Autowired
    private AccessDeniedHandler pcAccessDeniedHandler;

    @Autowired
    protected AuthenticationSuccessHandler pcAuthenticationSuccessHandler;

    @Autowired
    protected AuthenticationFailureHandler pcAuthenticationFailureHandler;

    @Autowired
    private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;

    @Autowired
    private SpringSocialConfigurer pcSocialSecurityConfig;

    @Autowired
    private AuthorizeConfigManager authorizeConfigManager;

    @Autowired
    private FormAuthenticationConfig formAuthenticationConfig;

    @Autowired
    private OpenIdAuthenticationSecurityConfig openIdAuthenticationSecurityConfig;

    @Resource
    private DataSource dataSource;

    /**
     * 记住我功能的token存取器配置
     *
     * @return the persistent token repository
     */
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
//		tokenRepository.setCreateTableOnStartup(true); // 第一次启动创建
        return tokenRepository;
    }

    /**
     * Configure.
     *
     * @param http the http
     *
     * @throws Exception the exception
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        formAuthenticationConfig.configure(http);
        http.headers().frameOptions().disable();
        http.apply(smsCodeAuthenticationSecurityConfig)
                .and()
                .apply(pcSocialSecurityConfig)
                .and()
                .apply(openIdAuthenticationSecurityConfig)
                .and()
                .headers().frameOptions().disable()
                .and()
                .exceptionHandling().accessDeniedHandler(pcAccessDeniedHandler)
                .and()
                .csrf().disable();

        authorizeConfigManager.config(http.authorizeRequests());
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.expressionHandler(pcSecurityExpressionHandler);
    }
}
