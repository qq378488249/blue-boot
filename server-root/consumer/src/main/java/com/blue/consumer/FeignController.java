package com.blue.consumer;

import com.blue.dao.entity.User;
import com.blue.dao.model.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * 类名
 *
 * @author lblue
 * @date 2018/5/8
 */
@RestController
public class FeignController {
    @Autowired
    DcClient dcClient;

    @GetMapping("/fegin/get")
    public String dc() {
        return dcClient.get();
    }
//
    @PostMapping("/fegin/add")
    public ResultModel add(User user) {
//        return dcClient.add(user.getId(),user.getMobile(),user.getName());
        return dcClient.add(user);
    }
//
//    @PostMapping("/fegin/add")
//    public ResultModel add1(User user) {
//        return dcClient.add1(user.getId(),user.getMobile(),user.getName());
//    }
//    @PostMapping("/fegin/add")
//    public ResultModel add(User user) {
//        return dcClient.add(user.getId(),user.getMobile(),user.getName());
//    }
}
