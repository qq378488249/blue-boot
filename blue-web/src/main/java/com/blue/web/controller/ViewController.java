package com.blue.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类名
 *
 * @author lblue
 * @date 2018/4/25
 */
@Controller
@RequestMapping("/view")
public class ViewController {

    @GetMapping("/index")
    public ModelAndView index(){
        List<Map> map = new ArrayList<>();
        Map<String,Object> m;
        for (int i = 0; i < 3; i++) {
            m = new HashMap<>();
            m.put("userName", "姓名"+i);
            m.put("id", ""+i);

            map.add(m);
        }
        return new ModelAndView("index").addObject("users",map);
    }
}
