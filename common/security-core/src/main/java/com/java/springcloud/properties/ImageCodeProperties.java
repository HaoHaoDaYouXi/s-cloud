package com.java.springcloud.properties;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ImageCodeProperties
 * 图片验证码配置项
 *
 * @author TONE
 * @date 2019/8/12
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ImageCodeProperties extends SmsCodeProperties {

    /**
     * Instantiates a new Image code properties.
     */
    ImageCodeProperties() {
        super.setLength(4);
    }

}
