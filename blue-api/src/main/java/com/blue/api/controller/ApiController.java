package com.blue.api.controller;

import com.blue.api.exception.BlueException;
import com.blue.dao.entity.User;
import com.blue.dao.mapper.UserMapper;
import com.blue.dao.service.UserService;
import com.blue.utils.controller.BaseController;
import com.blue.utils.tools.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api")
@Api(value = "value11243")
public class ApiController extends BaseController {

    @Autowired
    UserService userService;
    @Autowired
    UserMapper userMapper;

    @ApiOperation("获取用户信息")
    @PostMapping("/get")
    public User test(@ModelAttribute User user){
        log.info("test");
        return userService.findById(user.getId());
    }

    @GetMapping("/getM/{id}")
    public User getM(@PathVariable @ApiParam(value = "id备注",required = true) Integer id){
        log.info("getM");
        throw new RuntimeException("235u8");
//        return userMapper.selectById(id);
    }
    @GetMapping("/getE/{id}")
    public User getE(@PathVariable @ApiParam(value = "id备注",required = true) Integer id){
        throw new BlueException(1,"blue");
//        return userMapper.selectById(id);
    }

}
