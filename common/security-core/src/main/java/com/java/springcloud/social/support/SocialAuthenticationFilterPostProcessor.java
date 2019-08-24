package com.java.springcloud.social.support;

import org.springframework.social.security.SocialAuthenticationFilter;

/**
 * SocialAuthenticationFilterPostProcessor
 * SocialAuthenticationFilter后处理器，用于在不同环境下个性化社交登录的配置
 *
 * @author TONE
 * @date 2019/8/12
 */
public interface SocialAuthenticationFilterPostProcessor {

    /**
     * Process.
     *
     * @param socialAuthenticationFilter the social authentication filter
     */
    void process(SocialAuthenticationFilter socialAuthenticationFilter);
}
