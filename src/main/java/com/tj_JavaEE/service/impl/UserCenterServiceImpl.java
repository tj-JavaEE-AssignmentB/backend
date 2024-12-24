package com.tj_JavaEE.service.impl;

import com.tj_JavaEE.entity.User;
import com.tj_JavaEE.mapper.UserCenterMapper;
import com.tj_JavaEE.service.UserCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserCenterServiceImpl implements UserCenterService {

    @Autowired
    private UserCenterMapper userCenterMapper;

    @Override
    public User getUserById(Integer userId) {
        return userCenterMapper.selectUserById(userId);
    }

    @Override
    public void updateUser(User user) {
        // 进行业务逻辑处理，如验证用户身份，数据校验
        userCenterMapper.updateUser(user);
    }

}
