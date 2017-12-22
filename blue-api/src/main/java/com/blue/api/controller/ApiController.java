package com.blue.api.controller;

import com.blue.dao.entity.User;
import com.blue.dao.entity.a.A;
import com.blue.dao.mapper.UserMapper;
import com.mysql.jdbc.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    UserMapper userMapper;

    @GetMapping("/get/{id}")
    public Object test(@PathVariable("id") Integer id, HttpSession httpSession){
//        com.blue.utils.tools.StringUtils
//        com.blue.utils.StringUtils.isNull(id);
        System.out.println("id为空");
        User user = userMapper.selectById(id);

        A a = new A();
        if (user != null) {
            a.setName(user.getName());
            a.setId(user.getId());
        }

        return a.toString();
    }

}
