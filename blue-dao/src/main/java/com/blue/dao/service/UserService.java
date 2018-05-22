package com.blue.dao.service;

import com.blue.dao.entity.User;
import org.springframework.stereotype.Service;

/**
 * Created by light blue on 2017/12/19
 */
public interface UserService {
    User findById(Long id);
}
