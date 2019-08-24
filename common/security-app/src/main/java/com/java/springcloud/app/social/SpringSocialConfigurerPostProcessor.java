package com.java.springcloud.app.social;

import com.java.springcloud.properties.SecurityConstants;
import com.java.springcloud.social.support.PcSpringSocialConfigurer;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * SpringSocialConfigurerPostProcessor
 *
 * @author TONE
 * @date 2019/8/12
 */
@Component
public class SpringSocialConfigurerPostProcessor implements BeanPostProcessor {

    /**
     * Post process before initialization object.
     *
     * @param bean     the bean
     * @param beanName the bean name
     *
     * @return the object
     *
     * @throws BeansException the beans exception
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    /**
     * Post process after initialization object.
     *
     * @param bean     the bean
     * @param beanName the bean name
     *
     * @return the object
     *
     * @throws BeansException the beans exception
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        String pcSocialSecurityConfig = "pcSocialSecurityConfig";
        if (StringUtils.equals(beanName, pcSocialSecurityConfig)) {
            PcSpringSocialConfigurer config = (PcSpringSocialConfigurer) bean;
            config.signupUrl(SecurityConstants.DEFAULT_SOCIAL_USER_INFO_URL);
            return config;
        }
        return bean;
    }
}
