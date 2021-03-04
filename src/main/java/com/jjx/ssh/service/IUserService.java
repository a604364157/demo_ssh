package com.jjx.ssh.service;

import com.jjx.ssh.entity.User;

import java.util.List;

/**
 * @author jiangjx
 */
public interface IUserService extends ModelService<User, String> {

    /**
     * 查询全部用户
     *
     * @return users
     */
    List<User> all();

}
