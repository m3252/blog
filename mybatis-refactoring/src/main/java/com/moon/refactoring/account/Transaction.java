package com.moon.refactoring.account;

import java.math.BigDecimal;

import static com.moon.refactoring.account.Type.*;

public class Transaction {
    private Long id;
    private Long accountId;
    private BigDecimal amount;
    private Type type;

    public Transaction() {
    }

    private Transaction(Long accountId, BigDecimal amount, Type type) {
        validateAmount(amount);

        this.accountId = accountId;
        this.amount = amount;
        this.type = type;
    }

    private Transaction(Long id, Long accountId, BigDecimal amount, Type type) {
        validateAmount(amount);

        this.id = id;
        this.accountId = accountId;
        this.amount = amount;
        this.type = type;
    }

    public static Transaction createWithdrawalTransaction(Long accountId, BigDecimal amount) {
        return new Transaction(accountId, amount, WITHDRAW);
    }

    public static Transaction createDepositTransaction(Long accountId, BigDecimal amount) {
        return new Transaction(accountId, amount, DEPOSIT);
    }

    public static Transaction createOutgoingTransferTransaction(Long from, BigDecimal amount) {
        return new Transaction(from, amount, DEPOSIT);
    }

    public static Transaction createIncomingTransferTransaction(Long to, BigDecimal amount) {
        return new Transaction(to, amount, DEPOSIT);
    }

    private void validateAmount(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.TEN) <= 0) {
            throw new IllegalArgumentException("Amount should be greater than 10");
        }
    }


}
