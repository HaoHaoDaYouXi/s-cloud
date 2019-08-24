package com.java.springcloud.properties;

import com.java.springcloud.constant.GlobalConstant;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * ConfigProperties
 *
 * @author TONE
 * @date 2019/8/9
 */
@Data
@ConfigurationProperties(prefix = GlobalConstant.ROOT_PREFIX)
public class ConfigProperties {
    private AsyncTaskProperties task = new AsyncTaskProperties();
    private SwaggerProperties swagger = new SwaggerProperties();
    private JobProperties job = new JobProperties();
    private ZookeeperProperties zk = new ZookeeperProperties();
}
