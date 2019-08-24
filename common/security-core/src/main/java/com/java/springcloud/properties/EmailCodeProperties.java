package com.java.springcloud.properties;

import lombok.Data;

/**
 * EmailCodeProperties
 *
 * @author TONE
 * @date 2019/8/12
 */
@Data
public class EmailCodeProperties {

    /**
     * 过期时间
     */
    private int expireIn = 60 * 60 * 24;
    /**
     * 要拦截的url，多个url用逗号隔开，ant pattern
     */
    private String url;
}
