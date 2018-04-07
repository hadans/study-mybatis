package com.dadan.study.mybatis.reflect;

import java.lang.reflect.Proxy;

import com.dadan.study.mybatis.session.SqlSession;

public class MapperProxy {
	@SuppressWarnings("unchecked")
	public static <T> T  getMapper(SqlSession sqlSession,Class<T>[] interfaces){
		T object = (T) Proxy.newProxyInstance(MapperProxy.class.getClassLoader(), interfaces,new MapperInvocationHandler(sqlSession));
		return object;
	}
}
