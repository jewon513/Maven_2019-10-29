package com.biz.sec.exec;

import com.biz.sec.service.IolistServiceV2;

public class IolistEx_02 {

	public static void main(String[] args) {

		// mybatis-config.xml, DboConnection 클래스, mapper 확인
		IolistServiceV2 is = new IolistServiceV2();
		
		is.viewIolist2();
	}

}
