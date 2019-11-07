package com.biz.sec.service;

import java.util.List;
import java.util.Map;

import com.biz.sec.config.DBConnectionSEC;
import com.biz.sec.mapper.IolistDao;

public class IolistServiceV1 {
	
	IolistDao ioDao;
	// 인스턴스 생성자
	// IolistService의 생성자 보다 먼저 실행되고
	// 생성자 method에 관계없이 자동으로 실행되는 코드들의 묶음
	{
		ioDao = DBConnectionSEC.getSqlSessionFactory().openSession(true).getMapper(IolistDao.class);
	}
	
	public void viewIoList() {
		
		List<Map<String,Object>> iolist = ioDao.selectAllMap();
		
		for (Map<String, Object> map : iolist) {
			System.out.print(map.get("IO_SEQ") + "\t");
			System.out.print(map.get("IO_DATE") + "\t");
			System.out.print(map.get("IO_INOUT") + "\t");
			System.out.print(map.get("IO_QTY") + "\t");
			System.out.print(map.get("IO_TOTAL") + "\t");
			System.out.print(map.get("IO_PRICE") + "\t");
			System.out.print(map.get("IO_PCODE") + "\t");
			System.out.print(map.get("IO_DCODE") + "\n");
		}
		
	}
}
