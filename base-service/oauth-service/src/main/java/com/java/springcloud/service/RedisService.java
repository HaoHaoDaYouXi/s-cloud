package com.java.springcloud.service;

import java.util.concurrent.TimeUnit;

/**
 * RedisService
 *
 * @author TONE
 * @date 2019/8/15
 */
public interface RedisService {

    /**
     * Gets key.
     *
     * @param key the key
     *
     * @return the key
     */
    String getKey(String key);

    /**
     * Delete key.
     *
     * @param key the key
     */
    void deleteKey(String key);

    /**
     * Sets key.
     *
     * @param key   the key
     * @param value the value
     */
    void setKey(String key, String value);

    /**
     * Sets key.
     *
     * @param key     the key
     * @param value   the value
     * @param timeout the timeout
     * @param unit    the unit
     */
    void setKey(String key, String value, final long timeout, final TimeUnit unit);
}
