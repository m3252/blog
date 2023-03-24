package com.moon.refactoring.legacy.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Mapper
@Repository
public interface TransactionMapper {
    int saveDeposit(Map<String, Object> param);

    int saveWithdrawal(Map<String, Object> param);

    int saveTransferFrom(Map<String, Object> param);

    int saveTransferTo(Map<String, Object> param);

}
