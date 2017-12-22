package com.blue.dao.mapper;

import com.blue.dao.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper {
    User selectById(Integer id);
}
