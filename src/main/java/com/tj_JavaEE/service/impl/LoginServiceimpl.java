package com.tj_JavaEE.service.impl;

import cn.hutool.crypto.digest.BCrypt;
import com.tj_JavaEE.entity.User;
import com.tj_JavaEE.mapper.LoginMapper;
import com.tj_JavaEE.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LoginServiceimpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public User userlogin(User user) {

        User u =loginMapper.findByAccount(user);
        log.info("用户登录u:{}",u);
        if(u!=null&&BCrypt.checkpw(user.getPassword(),u.getPassword())){
            return u;
        }
        return null;
    }

}
