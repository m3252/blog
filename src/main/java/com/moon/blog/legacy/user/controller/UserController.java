package com.moon.blog.legacy.user.controller;

import com.moon.blog.legacy.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<Map<String, Object>> getUsers(Map<String, Object> param) {
        Map<String, Object> result = new HashMap<>();
        List<Map<String, Object>> users = userService.getUsers(param);
        if (users != null) {
            result.put("info", users);
            result.put("message", "success");
            result.put("code", "1");
        } else {
            result.put("message", "fail");
            result.put("code", "2");
        }

        return userService.getUsers(param);
    }

    @GetMapping("{accountId}")
    public Map<String, Object> getUser(Map<String, Object> param) {
        Map<String, Object> result = new HashMap<>();
        Map<String, Object> user = userService.getUser(param);
        if (user != null) {
            result.put("info", user);
            result.put("message", "success");
            result.put("code", "1");
        } else {
            result.put("message", "fail");
            result.put("code", "2");
        }
        return userService.getUser(param);
    }

    @PostMapping
    public Map<String, Object> saveUser(Map<String, Object> param) {
        Map<String, Object> result = new HashMap<>();
        if (userService.saveUser(param) == 1) {
            result.put("message", "success");
            result.put("code", "1");
        } else {
            result.put("message", "fail");
            result.put("code", "2");
        }
        return result;
    }

    @PutMapping
    public Map<String, Object> modifyUser(Map<String, Object> param) {
        Map<String, Object> result = new HashMap<>();
        if (userService.modifyUser(param) == 1) {
            result.put("message", "success");
            result.put("code", "1");
        } else {
            result.put("message", "fail");
            result.put("code", "2");
        }
        return result;
    }

}
