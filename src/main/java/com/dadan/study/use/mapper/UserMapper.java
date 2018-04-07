package com.dadan.study.use.mapper;

import com.dadan.study.use.bean.User;

public interface UserMapper {
	User findUserById(String id);
	User findUserByAge(int age);
}
