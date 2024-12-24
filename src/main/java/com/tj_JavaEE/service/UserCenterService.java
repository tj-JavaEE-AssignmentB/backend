package com.tj_JavaEE.service;

import com.tj_JavaEE.entity.User;


public interface UserCenterService {
    User getUserById(Integer userId);
    void updateUser(User user);
}
