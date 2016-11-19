package com.briup.estore.dao;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BaseDao<M extends Serializable, PK extends Serializable > {
	public static SqlSessionFactory getSqlSessionFactory()
	{
		String resource="mybatis-config.xml";
		try {
			InputStream stream = Resources.getResourceAsStream(resource);
			return new SqlSessionFactoryBuilder().build(stream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	public SqlSession openSession()
	{
		return openSession(false);
	}
	public SqlSession openSession(boolean b)
	{
		return getSqlSessionFactory().openSession(b);
	}
	
}
