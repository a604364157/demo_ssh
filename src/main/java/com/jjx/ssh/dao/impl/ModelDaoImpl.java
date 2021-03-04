package com.jjx.ssh.dao.impl;

import com.jjx.ssh.dao.ModelDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;

/**
 * @author jiangjx
 */
@SuppressWarnings("unchecked")
public class ModelDaoImpl<T, K extends Serializable> implements ModelDao<T, K> {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    private T newT() {
        try {
            return getT().getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("model type is null");
        }
    }


    private T[] newTs(int length) {
        return (T[]) Array.newInstance(getT(), length);
    }

    private Class<T> getT() {
        Type superClass = getClass().getGenericSuperclass();
        Type type = ((ParameterizedType) superClass).getActualTypeArguments()[0];
        return (Class<T>) getRawType(type);
    }

    private Class<?> getRawType(Type type) {
        if (type instanceof Class) {
            return (Class<?>) type;
        } else if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type rawType = parameterizedType.getRawType();
            return (Class<?>) rawType;
        } else if (type instanceof GenericArrayType) {
            Type componentType = ((GenericArrayType) type).getGenericComponentType();
            return Array.newInstance(getRawType(componentType), 0).getClass();
        } else if (type instanceof TypeVariable) {
            return Object.class;
        } else if (type instanceof WildcardType) {
            return getRawType(((WildcardType) type).getUpperBounds()[0]);
        } else {
            String className = type == null ? "null" : type.getClass().getName();
            throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + className);
        }
    }

    @Override
    public T get(K id) {
        return (T) getCurrentSession().get(getT(), id);
    }

    @Override
    public K save(T entity) {
        return (K) getCurrentSession().save(entity);
    }

    @Override
    public void update(T entity) {
        getCurrentSession().update(entity);
    }

    @Override
    public void delete(K id) {
        getCurrentSession().delete(id);
    }

}
