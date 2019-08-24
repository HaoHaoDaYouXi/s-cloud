package com.java.springcloud.security;

import com.java.springcloud.properties.OAuth2ClientProperties;
import com.java.springcloud.properties.SecurityProperties;
import com.java.springcloud.properties.OAuth2ClientProperties;
import com.java.springcloud.properties.SecurityProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.config.annotation.builders.InMemoryClientDetailsServiceBuilder;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * RestClientDetailsServiceImpl
 *
 * @author TONE
 * @date 2019/8/15
 */
@Slf4j
@Component("restClientDetailsService")
public class RestClientDetailsServiceImpl implements ClientDetailsService {

    private ClientDetailsService clientDetailsService;

    @Autowired
    private SecurityProperties securityProperties;

    /**
     * Init.
     */
    @PostConstruct
    public void init() {
        InMemoryClientDetailsServiceBuilder builder = new InMemoryClientDetailsServiceBuilder();
        if (ArrayUtils.isNotEmpty(securityProperties.getOauth2().getClients())) {
            for (OAuth2ClientProperties client : securityProperties.getOauth2().getClients()) {
                builder.withClient(client.getClientId())
                        .secret(client.getClientSecret())
                        .authorizedGrantTypes("refresh_token", "password", "client_credentials")
                        .accessTokenValiditySeconds(client.getAccessTokenValidateSeconds())
                        .refreshTokenValiditySeconds(client.getRefreshTokenValiditySeconds())
                        .scopes(client.getScope());
            }
        }
        try {
            clientDetailsService = builder.build();
        } catch (Exception e) {
            log.error("init={}", e.getMessage(), e);
        }
    }

    /**
     * Load client by client id client details.
     *
     * @param clientId the client id
     *
     * @return the client details
     *
     * @throws ClientRegistrationException the client registration exception
     */
    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        return clientDetailsService.loadClientByClientId(clientId);
    }
}
