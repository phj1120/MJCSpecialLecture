package com.wams.api.mapper;

import com.wams.api.model.User;
import org.apache.ibatis.annotations.*;

import java.util.stream.DoubleStream;

@Mapper
public interface UserMapper {
    @Results(id = "UserMap", value = {
            @Result(property = "userId", column = "user_id"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "userPassword", column = "user_password"),
            @Result(property = "userRole", column = "user_role")
    })

    @Select("select * " +
            "from user " +
            "where user_id = #{user_id};")
    User findByUserId(@Param("user_id") String userId);




}
