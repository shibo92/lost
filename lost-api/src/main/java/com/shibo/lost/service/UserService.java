package com.shibo.lost.service;

import com.shibo.lost.entity.User;
import com.shibo.lost.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author by shibo on 2020/9/1.
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User getUserById(Long userId) {
        return userMapper.selectById(userId);
    }

    public Long save(User u) {
        return userMapper.save(u);
    }
}
