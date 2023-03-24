package com.moon.refactoring.legacy.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Mapper
@Repository
public interface AccountMapper {

    Map<String, Object> getAccount(Map<String, Object> param);

    int updateAccount(Map<String, Object> param);

}
