package com.jjx.ssh.dao.impl;

import com.jjx.ssh.dao.IUserDao;
import com.jjx.ssh.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author jiangjx
 */
@Repository
public class UserDaoImpl extends ModelDaoImpl<User, String> implements IUserDao {

    @SuppressWarnings("unchecked")
    @Override
    public List<User> all() {
        return getCurrentSession().createQuery("FROM user").list();
    }

}
