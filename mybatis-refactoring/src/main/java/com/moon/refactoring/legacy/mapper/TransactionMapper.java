package com.moon.refactoring.legacy.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Mapper
@Repository
public interface TransactionMapper {
    int saveTransaction(Map<String, Object> param);
}
