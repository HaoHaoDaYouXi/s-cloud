package com.java.springcloud.social.qq.connet;

import com.java.springcloud.social.qq.api.QQ;
import com.java.springcloud.social.qq.api.impl.QQImpl;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;

/**
 * QQServiceProvider
 *
 * @author TONE
 * @date 2019/8/12
 */
public class QQServiceProvider extends AbstractOAuth2ServiceProvider<QQ> {

    private String appId;

    private static final String URL_AUTHORIZE = "https://graph.qq.com/oauth2.0/authorize";

    private static final String URL_ACCESS_TOKEN = "https://graph.qq.com/oauth2.0/token";

    /**
     * Instantiates a new Qq service provider.
     *
     * @param appId     the app id
     * @param appSecret the app secret
     */
    QQServiceProvider(String appId, String appSecret) {
        super(new QQOAuth2Template(appId, appSecret, URL_AUTHORIZE, URL_ACCESS_TOKEN));
        this.appId = appId;
    }

    /**
     * Gets api.
     *
     * @param accessToken the access token
     *
     * @return the api
     */
    @Override
    public QQ getApi(String accessToken) {
        return new QQImpl(accessToken, appId);
    }

}
