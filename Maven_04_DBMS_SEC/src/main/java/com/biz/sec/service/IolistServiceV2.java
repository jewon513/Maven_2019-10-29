package com.biz.sec.service;

import java.util.List;

import com.biz.sec.persistence.IolistDTO;

public class IolistServiceV2 extends IolistServiceV1 {

	public void viewIolist2() {
		
		List<IolistDTO> list = ioDao.selectAllDTO();
		for (IolistDTO iolistDTO : list) {
			System.out.println(iolistDTO);
		}
		
	}
	
}
