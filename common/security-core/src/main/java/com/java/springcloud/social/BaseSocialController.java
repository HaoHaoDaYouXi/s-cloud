package com.java.springcloud.social;

import com.java.springcloud.social.support.SocialUserInfo;
import com.java.springcloud.social.support.SocialUserInfo;
import org.springframework.social.connect.Connection;

/**
 * BaseSocialController
 *
 * @author TONE
 * @date 2019/8/12
 */
public abstract class BaseSocialController {

    /**
     * 根据Connection信息构建SocialUserInfo
     *
     * @param connection the connection
     *
     * @return social user info
     */
    protected SocialUserInfo buildSocialUserInfo(Connection<?> connection) {
        SocialUserInfo userInfo = new SocialUserInfo();
        userInfo.setProviderId(connection.getKey().getProviderId());
        userInfo.setProviderUserId(connection.getKey().getProviderUserId());
        userInfo.setNickname(connection.getDisplayName());
        userInfo.setHeadimg(connection.getImageUrl());
        return userInfo;
    }

}
