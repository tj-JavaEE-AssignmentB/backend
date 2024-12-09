package com.tj_JavaEE;

import com.tj_JavaEE.controller.UserController;
import com.tj_JavaEE.entity.User;
import com.tj_JavaEE.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AssignmentBApplicationTests {

	@Autowired
	private UserController userController;

	@Autowired
	private UserMapper userMapper;

	@Test
	void controllerTest() {
		System.out.println(userController.list());
	}

	@Test
	void mapperTest() {
		System.out.println(userMapper.list());
	}
}
