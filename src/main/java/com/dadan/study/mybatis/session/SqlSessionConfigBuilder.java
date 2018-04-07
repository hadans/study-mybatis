package com.dadan.study.mybatis.session;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 系统config配置文件
 * @author liguorui
 *
 */
public class SqlSessionConfigBuilder {
	public ConcurrentHashMap<String, String> plugines = new ConcurrentHashMap<String, String>();
	
	public SqlSessionFactory build(){
		return new SqlSessionFactory();
	}
}
