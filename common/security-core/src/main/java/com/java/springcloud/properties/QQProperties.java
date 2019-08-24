package com.java.springcloud.properties;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * QQProperties
 *
 * @author TONE
 * @date 2019/8/12
 */
@Data
public class QQProperties {
    /**
     * Application id.
     */
    private String appId;

    /**
     * Application secret.
     */
    private String appSecret;

    /**
     * 第三方id，用来决定发起第三方登录的url，默认是 qq。
     */
    private String providerId = "qq";

}
