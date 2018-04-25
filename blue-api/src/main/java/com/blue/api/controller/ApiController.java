package com.blue.api.controller;

import com.blue.dao.entity.User;
import com.blue.dao.mapper.UserMapper;
import com.blue.dao.service.UserService;
import com.blue.utils.controller.BaseController;
import com.blue.utils.tools.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api")
public class ApiController extends BaseController {

    @Autowired
    UserService userService;
    @Autowired
    UserMapper userMapper;

    @GetMapping("/get/{id}")
    public Object test(@PathVariable Integer id){
        log.info("test");
        return userService.findById(id);
    }

    @GetMapping("/getM/{id}")
    public Object getM(@PathVariable Integer id){
        log.info("getM");
        return userMapper.selectById(id);
    }

}
