package com.dadan.study.mybatis.session;

import com.dadan.study.mybatis.executor.SimpleExecutor;
import com.dadan.study.mybatis.reflect.MapperProxy;
/**
 * 存储mapper映射关系
 * @author liguorui
 *
 */
public class SqlSession {
	private SimpleExecutor executor;
	public SqlSession(){
		this.executor = new SimpleExecutor();
	}
	@SuppressWarnings("unchecked")
	public <T> T getMapper(Class<T> cls){
		Class<T> [] clses = (Class<T>[]) new Class<?>[]{cls};
		return MapperProxy.getMapper(this,clses);
	}
	public <T> T query(Class<T> cls,String sql,Object[] args){
		return executor.query(cls, sql, args);
	}
}
