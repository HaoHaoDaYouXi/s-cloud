package com.java.springcloud.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * KvDto
 *
 * @author TONE
 * @date 2019/8/9
 */
@Data
public class KvDto<K, V> implements Serializable {

    private static final long serialVersionUID = -7712636075929650779L;

    /**
     * Instantiates a new Kv dto.
     */
    public KvDto() {
    }

    /**
     * Instantiates a new Kv dto.
     *
     * @param key   the key
     * @param value the value
     */
    public KvDto(K key, V value) {
        this.key = key;
        this.value = value;
    }

    /**
     * key
     */
    private K key;
    /**
     * value
     */
    private V value;
}
