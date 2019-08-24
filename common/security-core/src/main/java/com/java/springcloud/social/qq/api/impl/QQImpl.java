package com.java.springcloud.social.qq.api.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.springcloud.social.qq.api.QQ;
import com.java.springcloud.social.qq.api.QQUserInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.TokenStrategy;

/**
 * QQImpl
 *
 * @author TONE
 * @date 2019/8/12
 */
@Slf4j
public class QQImpl extends AbstractOAuth2ApiBinding implements QQ {

    private static final String URL_GET_OPENID = "https://graph.qq.com/oauth2.0/me?access_token=%s";

    private static final String URL_GET_USERINFO = "https://graph.qq.com/user/get_user_info?oauth_consumer_key=%s&openid=%s";

    private String appId;

    private String openId;

    private ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Instantiates a new Qq.
     *
     * @param accessToken the access token
     * @param appId       the app id
     */
    public QQImpl(String accessToken, String appId) {
        super(accessToken, TokenStrategy.ACCESS_TOKEN_PARAMETER);

        this.appId = appId;

        String url = String.format(URL_GET_OPENID, accessToken);
        String result = getRestTemplate().getForObject(url, String.class);

        log.info("result={}", result);

        this.openId = StringUtils.substringBetween(result, "\"openid\":\"", "\"}");
    }
    @Override
    public QQUserInfo getUserInfo() {
        String url = String.format(URL_GET_USERINFO, appId, openId);
        String result = getRestTemplate().getForObject(url, String.class);
        log.info("result={}", result);
        QQUserInfo userInfo;
        try {
            userInfo = objectMapper.readValue(result, QQUserInfo.class);
            userInfo.setOpenId(openId);
            return userInfo;
        } catch (Exception e) {
            throw new RuntimeException("获取用户信息失败", e);
        }
    }
}
