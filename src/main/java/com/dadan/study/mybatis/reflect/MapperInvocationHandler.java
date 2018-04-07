package com.dadan.study.mybatis.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import com.dadan.study.mybatis.session.SqlSession;
import com.dadan.study.mybatis.session.XmlMapper;
import com.dadan.study.use.bean.User;

public class MapperInvocationHandler implements InvocationHandler{
	private SqlSession sqlSession;
	public MapperInvocationHandler(SqlSession sqlSession){
		this.sqlSession = sqlSession;
	}
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		String spaceName = method.getDeclaringClass().getName();
		if(spaceName.equals(XmlMapper.namespace)){
			if(XmlMapper.mapperMethod.containsKey(method.getName())){
				String sql = XmlMapper.mapperMethod.get(method.getName());
				return sqlSession.query(User.class, sql, args);
			}
		}
		return null;
	}

}
