package com.loger.service.impl;

import com.loger.dao.UserDao;
import com.loger.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Map;

/**
 * Created by 王睿 on 2018/5/7.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public int addUser(User user) {
        return userDao.addUser(user);
    }

    public int delUserById(Integer id) {
        return userDao.delUserById(id);
    }

    public List<User> getUser(Map<String, Object> map) {
        return userDao.getUser(map);
    }

    public int updateUser(User user) {
        return userDao.updateUser(user);
    }
}
