package com.tj_JavaEE.service;

import com.tj_JavaEE.entity.User;

public interface RegisterService {

    //依据账号查询用户
    User findByAccount(String account);

    //注册
    void register(User user);

}
