package com.java.springcloud.properties;

import lombok.Data;

/**
 * AsyncTaskProperties
 *
 * @author TONE
 * @date 2019/8/9
 */
@Data
public class AsyncTaskProperties {

    private int corePoolSize = 50;

    private int maxPoolSize = 100;

    private int queueCapacity = 10000;

    private int keepAliveSeconds = 3000;

    private String threadNamePrefix = "root-task-executor-";
}
