package com.biz.oracle.exec;

import java.util.List;

import com.biz.oracle.config.DBConnection;
import com.biz.oracle.mapper.IolistDao;
import com.biz.oracle.persistence.IolistDTO;
import com.biz.oracle.service.IolistServiceV1;

public class IolistEx_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		IolistServiceV1 is = new IolistServiceV1();
		
		is.selectMapListView();
		
	}

}
