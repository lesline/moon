package com.moon.service.impl;

import com.moon.dao.UserMapper;
import com.moon.model.User;
import com.moon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public User selectByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<User> getUsers(User user) {
        return userMapper.queryByPage(user);
    }
}
