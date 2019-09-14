package com.java.springcloud.service;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

/**
 * PermissionService
 *
 * @author TONE
 * @date 2019/9/14
 */
public interface PermissionService {

    /**
     * Has permission boolean.
     *
     * @param authentication the authentication
     * @param request        the request
     *
     * @return the boolean
     */
    boolean hasPermission(Authentication authentication, HttpServletRequest request);
}
