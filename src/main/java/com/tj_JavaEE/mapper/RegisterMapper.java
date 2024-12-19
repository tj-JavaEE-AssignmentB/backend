package com.tj_JavaEE.mapper;

import com.tj_JavaEE.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface RegisterMapper {

    //依据账号查询用户
    @Select("select * from user where account=#{account}")
    User findByAccount(String account);

    @Insert("insert into user(nickname,avatar_url,account,password_hash,email) values(#{nickname},#{avatarUrl},#{account},#{password},#{email})")
    void add(User user);
}
