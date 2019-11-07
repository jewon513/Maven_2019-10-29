package com.biz.sec.exec;

import com.biz.sec.service.MasterService;

public class MasterEx_01 {

	public static void main(String[] args) {

		MasterService ms = new MasterService();
		
		ms.masterAndDetail();
		ms.insertMaster();
	}

}
