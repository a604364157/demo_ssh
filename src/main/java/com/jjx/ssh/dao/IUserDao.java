package com.jjx.ssh.dao;

import com.jjx.ssh.entity.User;

import java.util.List;

/**
 * @author jiangjx
 */
public interface IUserDao extends ModelDao<User, String> {

    /**
     * 查询全部用户
     *
     * @return users
     */
    List<User> all();

}
