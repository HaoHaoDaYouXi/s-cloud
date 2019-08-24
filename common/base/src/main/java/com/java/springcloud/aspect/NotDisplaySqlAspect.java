package com.java.springcloud.aspect;

import com.java.springcloud.util.ThreadLocalMap;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * NotDisplaySqlAspect
 *
 * @author TONE
 * @date 2019/8/16
 */
@Aspect
@Component
public class NotDisplaySqlAspect {
    /**
     * The constant DISPLAY_SQL.
     */
    public static final String DISPLAY_SQL = "DISPLAY_SQL";

    @Pointcut("@annotation(com.java.springcloud.annotation.NotDisplaySql)")
    private void myPointCut() {
    }

    /**
     * Before.
     */
    @Before(value = "myPointCut()")
    public void before() {
        ThreadLocalMap.put(DISPLAY_SQL, Boolean.FALSE);
    }

    /**
     * After.
     */
    @After(value = "myPointCut()")
    public void after() {
        ThreadLocalMap.remove(DISPLAY_SQL);
    }
}
