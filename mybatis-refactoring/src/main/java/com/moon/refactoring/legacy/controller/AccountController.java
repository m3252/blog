package com.moon.refactoring.legacy.controller;

import com.moon.refactoring.legacy.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/api/accounts")
    public Map<String, Object> getAccount(Map<String, Object> param) {
        return accountService.getAccount(param);
    }

    @PutMapping("/api/accounts/deposit")
    public Map<String, Object> deposit(Map<String, Object> param) {
        Map<String, Object> result = new HashMap<>();
        int execute = accountService.deposit(param);
        if (execute > 0) {
            result.put("resultCode", "200");
        } else {
            result.put("resultCode", "500");
        }
        return result;
    }
}
