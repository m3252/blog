package com.moon.refactoring.legacy.user.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface UserMapper {
    List<Map<String, Object>> getUsers(Map<String, Object> param);

    Map<String, Object> getUser(Map<String, Object> param);

    int saveUser(Map<String, Object> param);

    int modifyUser(Map<String, Object> param);
}
