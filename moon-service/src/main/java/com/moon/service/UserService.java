package com.moon.service;


import com.moon.model.User;

import java.util.List;

/**
 * Created by lesline on 15/11/6.
 */
public interface UserService {

    User selectByPrimaryKey(Integer id);

    List<User> getUsers(User user);


}
