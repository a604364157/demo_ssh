package com.jjx.ssh.service;

import java.io.Serializable;

/**
 * @author jiangjx
 */
public interface ModelService<T, K extends Serializable> {

    /**
     * 主键查询
     *
     * @param id 主键
     * @return T
     */
    T get(K id);

    /**
     * 保存
     *
     * @param entity e
     * @return id
     */
    K save(T entity);

    /**
     * 修改
     *
     * @param entity e
     */
    void update(T entity);

    /**
     * 删除
     *
     * @param id 主键
     */
    void delete(K id);

}
