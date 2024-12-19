package com.tj_JavaEE.service.impl;

import cn.hutool.crypto.digest.BCrypt;
import com.tj_JavaEE.entity.User;
import com.tj_JavaEE.mapper.RegisterMapper;
import com.tj_JavaEE.mapper.UserMapper;
import com.tj_JavaEE.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RegisterServiceimpl implements RegisterService {

    @Autowired
    private RegisterMapper registerMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByAccount(String account) {
        User u=registerMapper.findByAccount(account);
        return u;
    }

    @Override
    public void register(User user) {
        //加密
        user.setPassword(BCrypt.hashpw(user.getPassword()));
        //添加


        registerMapper.add(user);


    }
}
