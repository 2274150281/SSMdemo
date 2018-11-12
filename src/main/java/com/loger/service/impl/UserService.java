package com.loger.service.impl;

import com.loger.entity.User;

import java.util.List;
import java.util.Map;

/**
 * Created by 王睿 on 2018/5/7.
 */
public interface UserService {
    public int addUser(User user);
    public int delUserById(Integer id);
    public List<User> getUser(Map<String,Object> map);
    public int updateUser(User user);
}
