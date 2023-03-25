package com.moon.refactoring.legacy.service;

import com.moon.refactoring.legacy.mapper.AccountMapper;
import com.moon.refactoring.legacy.mapper.TransactionMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
public class AccountService {
    private final AccountMapper accountMapper;
    private final TransactionMapper transactionMapper;

    public AccountService(AccountMapper accountMapper, TransactionMapper transactionMapper) {
        this.accountMapper = accountMapper;
        this.transactionMapper = transactionMapper;
    }

    public Map<String, Object> getAccount(Map<String, Object> param) {
        return accountMapper.getAccount(param);
    }

    @Transactional
    public int updateAccount(Map<String, Object> param) {
        int executeAccount = accountMapper.updateAccount(param);
        if (executeAccount > 0) {
            return transactionMapper.saveTransaction(param);
        }
        return executeAccount;
    }


}
