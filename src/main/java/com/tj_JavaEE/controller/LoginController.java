package com.tj_JavaEE.controller;


import com.tj_JavaEE.entity.Result;
import com.tj_JavaEE.entity.User;
import com.tj_JavaEE.service.LoginService;
import com.tj_JavaEE.util.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/user/login")
    public Result userlogin(@RequestBody User user){
        log.info("用户登录:{}",user);
        User e =loginService.userlogin(user);

        //登录成功，生成并下发令牌
        if(e!=null){
            Map<String,Object> claims = new HashMap<>();
            claims.put("account",e.getAccount());
            claims.put("nickname",e.getNickname());
            claims.put("userId",e.getUserId());

            String jwt=JwtUtils.generateJwt(claims);
            return Result.success(1,jwt);
        }

        //登陆失败，返回错误信息


        return Result.error(0,"账号或密码错误");


    }


}
