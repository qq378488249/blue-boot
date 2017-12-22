package com.blue.api.controller;

import com.blue.dao.entity.User;
import com.blue.dao.mapper.UserMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by light blue on 2017/12/22
 */
public class ApiControllerTest {
    @Autowired
    UserMapper userMapper;
    @Test
    public void test1() {
        User user = new User();
        user.setName("gg");
        User user1 = userMapper.selectById(1);
        System.out.println(user1.toString());
    }
}