package com.java.springcloud.properties;

import lombok.Data;

/**
 * SessionProperties
 * session管理相关配置项
 *
 * @author TONE
 * @date 2019/8/12
 */
@Data
public class SessionProperties {

    /**
     * 同一个用户在系统中的最大session数，默认1
     */
    private int maximumSessions = 1;
    /**
     * 达到最大session时是否阻止新的登录请求，默认为false，不阻止，新的登录会将老的登录失效掉
     */
    private boolean maxSessionsPreventsLogin;
}
