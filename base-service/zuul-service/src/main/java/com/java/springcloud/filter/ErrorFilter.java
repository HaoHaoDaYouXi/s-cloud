package com.java.springcloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;

/**
 * ErrorFilter
 *
 * @author TONE
 * @date 2019/4/9
 */
@Slf4j
public class ErrorFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "err";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        return null;
    }
}
