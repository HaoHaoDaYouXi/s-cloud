package com.java.springcloud.config;

import com.java.springcloud.TMAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * Description:
 * Date: 19-2-15 下午5:25
 *
 * @author ujued
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(value = {TMAutoConfiguration.class})
public @interface EnableTransactionManagerServer {
}
