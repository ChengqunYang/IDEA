package com.monster.mapper;

import com.monster.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Bean;

import java.util.List;
@Mapper
public interface UserMapper {
    public List<User> queryUserList();
}
