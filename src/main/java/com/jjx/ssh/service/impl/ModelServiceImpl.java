package com.jjx.ssh.service.impl;

import com.jjx.ssh.dao.ModelDao;
import com.jjx.ssh.dao.impl.ModelDaoImpl;
import com.jjx.ssh.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * @author jiangjx
 */
public class ModelServiceImpl<T, K extends Serializable, D extends ModelDao<T, K>> implements ModelService<T, K> {

    @Autowired
    protected D dao;

    @Override
    public T get(K id) {
        return dao.get(id);
    }

    @Override
    public K save(T entity) {
        return dao.save(entity);
    }

    @Override
    public void update(T entity) {
        dao.update(entity);
    }

    @Override
    public void delete(K id) {
        dao.delete(id);
    }

}
