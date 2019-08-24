package com.java.springcloud;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Oauth2ClientProperties
 *
 * @author TONE
 * @date 2019/8/12
 */
@Data
@ConfigurationProperties(prefix = "cloud.oauth2.client")
public class Oauth2ClientProperties {
    private String id;
    private String accessTokenUrl;
    private String clientId;
    private String clientSecret;
    private String clientAuthenticationScheme;
}
