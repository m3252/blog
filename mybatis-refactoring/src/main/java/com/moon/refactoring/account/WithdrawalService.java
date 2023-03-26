package com.moon.refactoring.account;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class WithdrawalService {
    private final AccountRepository accountRepository;

    public WithdrawalService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void withdraw(Long accountId, BigDecimal withdrawalAmount) {
        Account account = accountRepository.findAccountWithTransactions(accountId);
        account.withdraw(withdrawalAmount);
        accountRepository.updateBalance(account);
    }
}
