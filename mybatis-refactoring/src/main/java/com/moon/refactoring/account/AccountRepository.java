package com.moon.refactoring.account;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AccountRepository {
    Account findAccountWithTransactions(Long accountId);
}
