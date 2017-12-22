package com.blue.api.blueapi;

import com.blue.dao.entity.User;
import com.blue.dao.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlueApiApplicationTests {

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
