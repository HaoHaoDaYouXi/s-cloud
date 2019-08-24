package com.java.springcloud.annotation;

import java.lang.annotation.*;

/**
 * NotDisplaySql
 * 配合 SqlLogInterceptor 对指定方法 禁止打印SQL到控制台
 *
 * @author TONE
 * @date 2019/8/16
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface NotDisplaySql {
}
