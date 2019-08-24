package com.java.springcloud.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * BaseTree
 *
 * @author TONE
 * @date 2019/8/9
 */
@Data
public class BaseTree<E, ID> implements Serializable {
    private static final long serialVersionUID = -5703964834600572016L;

    /**
     * ID
     */
    private ID id;

    /**
     * 父ID
     */
    private ID pid;

    /**
     * 是否含有子节点
     */
    private boolean hasChild = false;

    /**
     * 子节点集合
     */
    private List<E> children;
}
