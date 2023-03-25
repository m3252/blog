package com.moon.refactoring.account;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class AccountTest {

    @Test
    void addTest() {
        BigDecimal bigDecimal1 = BigDecimal.TEN;
        BigDecimal bigDecimal2 = BigDecimal.ONE;
        bigDecimal1.add(bigDecimal2);
        assertThat(bigDecimal1).isEqualTo(BigDecimal.TEN);
    }
}