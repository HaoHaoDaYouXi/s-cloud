package com.java.springcloud.app.social;

import com.java.springcloud.social.support.SocialAuthenticationFilterPostProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.social.security.SocialAuthenticationFilter;
import org.springframework.stereotype.Component;

/**
 * AppSocialAuthenticationFilterPostProcessor
 *
 * @author TONE
 * @date 2019/8/12
 */
@Component
public class AppSocialAuthenticationFilterPostProcessor implements SocialAuthenticationFilterPostProcessor {

    private final AuthenticationSuccessHandler pcAuthenticationSuccessHandler;

    @Autowired
    public AppSocialAuthenticationFilterPostProcessor(AuthenticationSuccessHandler pcAuthenticationSuccessHandler) {
        this.pcAuthenticationSuccessHandler = pcAuthenticationSuccessHandler;
    }

    @Override
    public void process(final SocialAuthenticationFilter socialAuthenticationFilter) {
        socialAuthenticationFilter.setAuthenticationSuccessHandler(pcAuthenticationSuccessHandler);
    }
}
