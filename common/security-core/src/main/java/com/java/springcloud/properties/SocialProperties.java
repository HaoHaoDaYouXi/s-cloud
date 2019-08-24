package com.java.springcloud.properties;

import lombok.Data;

/**
 * SocialProperties
 * 社交登录配置项
 *
 * @author TONE
 * @date 2019/8/12
 */
@Data
public class SocialProperties {

    /**
     * 社交登录功能拦截的url
     */
    private String filterProcessesUrl = "/auth";

    private QQProperties qq = new QQProperties();

//    private WeixinProperties weixin = new WeixinProperties();

}
