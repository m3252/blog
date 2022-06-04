package com.moon.blog.legacy.user.service;

import com.moon.blog.legacy.user.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService {

    private UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public List<Map<String, Object>> getUsers(Map<String, Object> param) {
        return userMapper.getUsers(param);
    }

    public Map<String, Object> getUser(Map<String, Object> param) {
        return userMapper.getUser(param);
    }

    public int saveUser(Map<String, Object> param) {
        return userMapper.saveUser(param);
    }

    public int modifyUser(Map<String, Object> param) {
        return userMapper.modifyUser(param);
    }
}
