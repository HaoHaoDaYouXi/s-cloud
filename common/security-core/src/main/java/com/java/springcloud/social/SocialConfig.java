package com.java.springcloud.social;

import com.java.springcloud.properties.SecurityProperties;
import com.java.springcloud.social.support.PcSpringSocialConfigurer;
import com.java.springcloud.social.support.SocialAuthenticationFilterPostProcessor;
import com.java.springcloud.properties.SecurityProperties;
import com.java.springcloud.social.support.PcSpringSocialConfigurer;
import com.java.springcloud.social.support.SocialAuthenticationFilterPostProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.UserIdSource;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurer;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.social.security.SpringSocialConfigurer;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * SocialConfig
 * 社交登录配置主类
 *
 * @author TONE
 * @date 2019/8/12
 */
@Configuration
@EnableSocial
public class SocialConfig extends SocialConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired(required = false)
    private ConnectionSignUp connectionSignUp;

    @Autowired(required = false)
    private SocialAuthenticationFilterPostProcessor socialAuthenticationFilterPostProcessor;


    /**
     * Gets users connection repository.
     *
     * @param connectionFactoryLocator the connection factory locator
     *
     * @return the users connection repository
     */
    @Override
    public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
        JdbcUsersConnectionRepository repository = new JdbcUsersConnectionRepository(dataSource, connectionFactoryLocator, Encryptors.noOpText());
        repository.setTablePrefix("pc_uac_");
        if (connectionSignUp != null) {
            repository.setConnectionSignUp(connectionSignUp);
        }
        return repository;
    }

    /**
     * 社交登录配置类，供浏览器或app模块引入设计登录配置用。
     *
     * @return spring social configurer
     */
    @Bean
    public SpringSocialConfigurer pcSocialSecurityConfig() {
        String filterProcessesUrl = securityProperties.getSocial().getFilterProcessesUrl();
        PcSpringSocialConfigurer configurer = new PcSpringSocialConfigurer(filterProcessesUrl);
        configurer.signupUrl(securityProperties.getBrowser().getSignUpUrl());
        configurer.setSocialAuthenticationFilterPostProcessor(socialAuthenticationFilterPostProcessor);
        return configurer;
    }

    /**
     * 用来处理注册流程的工具类
     *
     * @param connectionFactoryLocator the connection factory locator
     *
     * @return provider sign in utils
     */
    @Bean
    public ProviderSignInUtils providerSignInUtils(ConnectionFactoryLocator connectionFactoryLocator) {
        return new ProviderSignInUtils(connectionFactoryLocator,
                getUsersConnectionRepository(connectionFactoryLocator)) {
        };
    }


   /* @Bean
    public UserIdSource userIdSource() {
        UserIdSource userIdSource = null;
        for (SocialConfigurer socialConfigurer : socialConfigurers) {
            UserIdSource userIdSourceCandidate = socialConfigurer.getUserIdSource();
            if (userIdSourceCandidate != null) {
                userIdSource = userIdSourceCandidate;
                break;
            }
        }
        Assert.notNull(userIdSource, "One configuration class must implement getUserIdSource from SocialConfigurer.");
        return userIdSource;
    }*/
}
