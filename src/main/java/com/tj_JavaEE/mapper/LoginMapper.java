package com.tj_JavaEE.mapper;

import com.tj_JavaEE.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginMapper {

    @Select("select * from user where account = #{account} and password_hash = #{passwordHash}")
    User getByAccountAndPassword(User user);

}
