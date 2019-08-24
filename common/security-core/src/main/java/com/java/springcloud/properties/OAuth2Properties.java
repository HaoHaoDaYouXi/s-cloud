package com.java.springcloud.properties;

import lombok.Data;

/**
 * OAuth2Properties
 *
 * @author TONE
 * @date 2019/8/12
 */
@Data
public class OAuth2Properties {

    /**
     * 使用jwt时为token签名的秘钥
     */
    private String jwtSigningKey = "cloud";
    /**
     * 客户端配置
     */
    private OAuth2ClientProperties[] clients = {};

}
