package com.biz.sec.exec;

import com.biz.sec.config.DBConnectionSEC;

public class IolistEx_01 {

	public static void main(String[] args) {

		// mybatis-config.xml, DboConnection 클래스, mapper 확인
		DBConnectionSEC.getSqlSessionFactory().openSession(true);
		
	}

}
