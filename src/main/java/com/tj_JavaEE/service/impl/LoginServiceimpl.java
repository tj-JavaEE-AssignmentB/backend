package com.tj_JavaEE.service.impl;

import com.tj_JavaEE.entity.User;
import com.tj_JavaEE.mapper.LoginMapper;
import com.tj_JavaEE.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceimpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public User userlogin(User user) {
        return loginMapper.getByAccountAndPassword(user);
    }

}
