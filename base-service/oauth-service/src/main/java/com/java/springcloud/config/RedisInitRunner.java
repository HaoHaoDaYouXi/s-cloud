package com.java.springcloud.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * RedisInitRunner
 *
 * @author TONE
 * @date 2019/8/15
 */
@Component
@Order(value = 1)
@Slf4j
public class RedisInitRunner implements CommandLineRunner {

    /**
     * Run.
     *
     * @param args the args
     */
    @Override
    public void run(String... args) {
        log.info(">>>>>>>>>>>>>>>服务启动执行，执行加载数据等操作 11111111 <<<<<<<<<<<<<");
    }

}
