package com.moon.refactoring.account;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransferService {
    private final AccountRepository accountRepository;

    public TransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void transfer(Long from, Long to, BigDecimal amount) {
        Account sender = accountRepository.findAccountWithTransactions(from);
        Account recipient = accountRepository.findAccountWithTransactions(to);
        if (recipient == null) {
            throw new RuntimeException("Invalid recipient account");
        }

        sender.transfer(amount);
        recipient.receive(amount);

        accountRepository.updateBalance(sender);
        accountRepository.updateBalance(recipient);

    }
}
