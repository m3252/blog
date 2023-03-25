package com.moon.refactoring.account;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.moon.refactoring.account.Type.*;

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

    public Long getId() {
        return id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void withdraw(BigDecimal amount) {
        changeAmount(amount);
        Transaction transaction = new Transaction(this.id, amount, WITHDRAW);
        this.transactions.add(transaction);
    }

    public void deposit(BigDecimal amount) {
        changeAmount(amount);
        Transaction transaction = new Transaction(this.id, amount, DEPOSIT);
        this.transactions.add(transaction);
    }

    public void transfer(BigDecimal amount) {
        changeAmount(amount);
        Transaction transaction = new Transaction(this.id, amount, TRANSFER);
        this.transactions.add(transaction);
    }

    private void changeAmount(BigDecimal amount) {
        if (balance.add(amount).compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalStateException("Remaining amount must be greater than 0");
        }
        this.balance = this.balance.add(amount);
    }
}
