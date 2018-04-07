package com.dadan.study.test;

import com.dadan.study.mybatis.session.SqlSession;
import com.dadan.study.mybatis.session.SqlSessionConfigBuilder;
import com.dadan.study.mybatis.session.SqlSessionFactory;
import com.dadan.study.use.bean.User;
import com.dadan.study.use.mapper.UserMapper;

public class TestMybatis {
	public static void main(String[] args) {
		SqlSessionFactory sqlSessionFactory = new SqlSessionConfigBuilder().build();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = (UserMapper)sqlSession.getMapper(UserMapper.class);
		User user = userMapper.findUserByAge(32);
		System.out.println(user);
		user = userMapper.findUserById("5");
		System.out.println(user);
	}
}
