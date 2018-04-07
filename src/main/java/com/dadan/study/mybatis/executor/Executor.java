package com.dadan.study.mybatis.executor;

public interface Executor {
	<T> T query(Class<T> cls,String sql, Object[] args);
}
