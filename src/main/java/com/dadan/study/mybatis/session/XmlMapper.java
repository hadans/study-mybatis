package com.dadan.study.mybatis.session;

import java.util.concurrent.ConcurrentHashMap;

import com.dadan.study.use.mapper.UserMapper;

public class XmlMapper {
	public static String namespace;
	public static ConcurrentHashMap<String, String> mapperMethod = new ConcurrentHashMap<String, String>();
	static{
		
		namespace = UserMapper.class.getName();
		mapperMethod.put("findUserById", "select * from t_user where id  = ?");
		mapperMethod.put("findUserByAge","select * from t_user where age = ?");
		
	}
}
