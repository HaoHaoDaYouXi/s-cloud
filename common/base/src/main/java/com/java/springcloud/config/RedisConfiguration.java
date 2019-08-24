package com.java.springcloud.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * RedisConfiguration
 *
 * @author TONE
 * @date 2019/8/16
 */
@Configuration
@EnableCaching
public class RedisConfiguration {
    /**
     * generator key generator.
     *
     * @return the key generator
     */
    @Bean
    public KeyGenerator keyGenerator() {
        return (target, method, params) -> {
            StringBuilder sb = new StringBuilder();
            sb.append(target.getClass().getName());
            sb.append(method.getName());
            for (Object obj : params) {
                sb.append(obj.toString());
            }
            return sb.toString();
        };

    }

    /**
     * Cache manager cache manager.
     *
     * @param connectionFactory the redis template
     *
     * @return the cache manager
     */
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory connectionFactory) {
        RedisCacheManager manager=RedisCacheManager.create(connectionFactory);
        return manager;
    }

    @Bean
    public StringRedisSerializer stringRedisSerializer() {
        return new StringRedisSerializer();
    }

    @Bean("redisTemplate")
    public RedisTemplate redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate template = new RedisTemplate<>();
        template.setConnectionFactory(factory);
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        template.setValueSerializer(jackson2JsonRedisSerializer);
        template.setKeySerializer(stringRedisSerializer());
        template.afterPropertiesSet();
        return template;
    }
}
