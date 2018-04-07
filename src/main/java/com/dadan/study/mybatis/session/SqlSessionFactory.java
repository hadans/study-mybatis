package com.dadan.study.mybatis.session;

public class SqlSessionFactory{
	public SqlSession openSession(){
		return new SqlSession();
	}
}
