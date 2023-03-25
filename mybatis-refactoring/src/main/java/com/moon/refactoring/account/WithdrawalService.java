package com.moon.refactoring.account;

import com.moon.refactoring.legacy.mapper.AccountMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class WithdrawalService {
    private final AccountRepository accountRepository;

    public WithdrawalService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void withdraw(Long accountId, BigDecimal withdrawalAmount) {
        Account account = accountRepository.findAccountWithTransactions(accountId);
        account.withdraw(withdrawalAmount);
    }
}
