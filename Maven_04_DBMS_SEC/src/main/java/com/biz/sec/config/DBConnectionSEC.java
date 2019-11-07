package com.biz.sec.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class DBConnectionSEC {

	private static SqlSessionFactory sqlSessionFactory = null;
	
	static {
		
		String saltPass = System.getenv().get("BIZ");
		StandardPBEStringEncryptor pbEnc = new StandardPBEStringEncryptor();
		
		pbEnc.setAlgorithm("PBEWithMD5AndDES");
		pbEnc.setPassword(saltPass);
		
		String userName = "AivRxDRSW+CUbFeHHLqVsA==";
		String password = "EgmJbb3LIEbjEMyrBQjsQw==";
		
		String configFile = "com/biz/sec/config/mybatis-config.xml";
		
		Properties pros = new Properties();
		/*
		 * java에서 어떤 setting 값들을 모아서 어떤 설정을 하는 용도로 사용됨
		 */
		
		/*
		 * DBMS에 접근할 username과 password를 실제 값으로 적용하고 프로젝트 실행할 것
		 */
		pros.put("username", pbEnc.decrypt(userName));
		pros.put("password", pbEnc.decrypt(password));
		
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
