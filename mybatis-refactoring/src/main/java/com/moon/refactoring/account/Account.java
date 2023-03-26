package com.moon.refactoring.account;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private Long id;
    private BigDecimal balance;
    private List<Transaction> transactions = new ArrayList<>();

    public Account() {
    }

    public Account(Long id, BigDecimal balance, List<Transaction> transactions) {
        this.id = id;
        this.balance = balance;
        this.transactions = transactions;
    }

    public void withdraw(BigDecimal amount) {
        changeAmount(amount);
        Transaction transaction = Transaction.createWithdrawalTransaction(this.id, amount);
        this.transactions.add(transaction);
    }

    public void deposit(BigDecimal amount) {
        changeAmount(amount);
        Transaction transaction = Transaction.createWithdrawalTransaction(this.id, amount);
        this.transactions.add(transaction);
    }

    public void transfer(BigDecimal amount) {
        changeAmount(amount);
        Transaction transaction = Transaction.createOutgoingTransferTransaction(this.id, amount);
        this.transactions.add(transaction);
    }

    public void receive(BigDecimal amount) {
        changeAmount(amount);
        Transaction transaction = Transaction.createIncomingTransferTransaction(this.id, amount);
        this.transactions.add(transaction);
    }

    private void changeAmount(BigDecimal amount) {
        if (balance.add(amount).compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Remaining amount must be greater than 0");
        }
        this.balance = this.balance.add(amount);
    }
}
