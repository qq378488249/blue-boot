package com.blue.client1;

import com.blue.dao.entity.User;
import com.blue.dao.mapper.UserMapper;
import com.blue.dao.model.ResultModel;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

/**
 * 类名
 *
 * @author lblue
 * @date 2018/5/8
 */
@RestController
public class Client1Controller {
    @Autowired
    DiscoveryClient discoveryClient;
    @Autowired
    UserMapper userMapper;

    @GetMapping("/get")
    public String get() {
        String services = "Services: " + discoveryClient.getServices();
        System.out.println(services);
        return "get";
    }

    @PostMapping("/get1")
    public User get1(Long id) {
        String services = "Services: " + discoveryClient.getServices();
        System.out.println(services);
        return userMapper.selectByPrimaryKey(id);
    }

    @PostMapping("/add")
    public ResultModel add(@RequestBody User user) {
        ResultModel resultModel = new ResultModel();
        String msg = "新增";

        if (user == null) {
            resultModel.setErrMsg("user不能为空");
        }

        System.out.println(new Gson().toJson(user));
        int i = userMapper.insertSelective(user);
        if (i != 1) {
            resultModel.setErrMsg(msg + "失败");
        } else {
            resultModel.setSucMsg(msg + "成功");
        }
        return resultModel;
    }

    @PostMapping("/del")
    public ResultModel del(Long id) {
        ResultModel resultModel = new ResultModel();
        String msg = "删除";

        int i = userMapper.deleteByPrimaryKey(id);
        if (i != 1) {
            resultModel.setErrMsg(msg + "失败");
        } else {
            resultModel.setSucMsg(msg + "成功");
        }
        return resultModel;
    }
}
