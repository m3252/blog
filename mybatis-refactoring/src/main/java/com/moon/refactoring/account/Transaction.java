package com.moon.refactoring.account;

import java.math.BigDecimal;

public class Transaction {
    private Long id;
    private Long accountId;
    private BigDecimal amount;
    private Type type;

    public Transaction() {
    }

    public Transaction(Long accountId, BigDecimal amount, Type type) {
        this.accountId = accountId;
        this.amount = amount;
        this.type = type;
    }

    public Transaction(Long id, Long accountId, BigDecimal amount, Type type) {
        this.id = id;
        this.accountId = accountId;
        this.amount = amount;
        this.type = type;
    }
}
