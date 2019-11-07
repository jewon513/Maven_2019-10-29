package com.biz.sec.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBConnection {

	private static SqlSessionFactory sqlSessionFactory = null;
	
	static {
		
		String configFile = "com/biz/sec/config/mybatis-config.xml";
		
		Properties pros = new Properties();
		/*
		 * java에서 어떤 setting 값들을 모아서 어떤 설정을 하는 용도로 사용됨
		 */
		pros.put("username", "iolist2");
		pros.put("password", "iolist2");
		
		try {
			InputStream inputStream = Resources.getResourceAsStream(configFile);
			SqlSessionFactoryBuilder bulider = new SqlSessionFactoryBuilder();
			
			if(sqlSessionFactory == null) {
				sqlSessionFactory = bulider.build(inputStream, pros);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
}
