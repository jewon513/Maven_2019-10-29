package com.biz.oracle.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class DBConnection {

	private static SqlSessionFactory sqlSessionFactory =null;
	
	static {
		
		String configFile = "com/biz/oracle/config/mybatis-config.xml";
		
		try {
			InputStream inputStream = Resources.getResourceAsStream(configFile);
			
			String encType = "PBEwithMD5AndDES";
			
			String encUser = "fl2omAkNz7vAB00EpThVJA==";
			String encPassword = "qbXrKiuXO2coAmuBzbu9Xw==";
			
			//암호화된 encUser, encPassword를 복호화 하기 위한 준비
			Map<String,String> systemENV = System.getenv();
			StandardPBEStringEncryptor pbEnc = new StandardPBEStringEncryptor();
			pbEnc.setAlgorithm(encType);
			pbEnc.setPassword(systemENV.get("USERNAME"));
			
			//복호화된 문자열을 mybatis-config.xml에 전달하기 위한 절차
			Properties pros = new Properties();
			pros.put("username", pbEnc.decrypt(encUser));
			pros.put("password", pbEnc.decrypt(encPassword));
			
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			
			if(sqlSessionFactory==null) {
				sqlSessionFactory = builder.build(inputStream,pros);
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
