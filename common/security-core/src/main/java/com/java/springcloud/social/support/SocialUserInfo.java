package com.java.springcloud.social.support;

import lombok.Data;

/**
 * SocialUserInfo
 *
 * @author TONE
 * @date 2019/8/12
 */
@Data
public class SocialUserInfo {

    private String providerId;

    private String providerUserId;

    private String nickname;

    private String headimg;
}
