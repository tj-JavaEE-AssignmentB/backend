package com.tj_JavaEE.mapper;

import com.tj_JavaEE.entity.User;
import org.apache.ibatis.annotations.Mapper;

import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserCenterMapper {

    @Select("SELECT * FROM user WHERE user_id = #{userId}")
    User selectUserById(Integer userId);

    void updateUser(User user);
}
