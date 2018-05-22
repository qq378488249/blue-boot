package com.blue.consumer;

import com.blue.dao.entity.User;
import com.blue.dao.model.ResultModel;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 类名
 *
 * @author lblue
 * @date 2018/5/8
 */

@FeignClient("eureka-client")
public interface DcClient {
    @GetMapping("/get")
    String get();

//    @PostMapping("/add")
//    ResultModel add(@RequestBody User user);
//
    @PostMapping("/add")
//    ResultModel add(@RequestParam("id") Long id,
//                    @RequestParam("mobile") String mobile,
//                    @RequestParam("name") String name);
    ResultModel add(User user);
}
