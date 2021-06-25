package com.shibo.lost.mapper;

import com.shibo.lost.entity.User;

/**
 * @author by shibo on 2020/9/1.
 */
public interface UserMapper {
    User selectById(Long userId);
    Long save(User u);
}
