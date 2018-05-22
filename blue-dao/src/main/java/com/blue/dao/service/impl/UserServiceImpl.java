package com.blue.dao.service.impl;

import com.blue.dao.entity.User;
import com.blue.dao.mapper.UserMapper;
import com.blue.dao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 类名
 *
 * @author lblue
 * @date 2018/4/25
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User findById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
