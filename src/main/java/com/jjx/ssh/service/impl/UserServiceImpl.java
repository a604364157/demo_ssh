package com.jjx.ssh.service.impl;

import com.jjx.ssh.dao.IUserDao;
import com.jjx.ssh.entity.User;
import com.jjx.ssh.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jiangjx
 */
@Service
public class UserServiceImpl extends ModelServiceImpl<User, String, IUserDao> implements IUserService {
    @Override
    public List<User> all() {
        return dao.all();
    }
}
