package com.biz.sec.service;

import java.util.List;
import java.util.Scanner;

import com.biz.sec.config.DBConnectionSEC;
import com.biz.sec.mapper.MDDao;
import com.biz.sec.persistence.DetailDTO;
import com.biz.sec.persistence.MasterDTO;
import com.biz.sec.persistence.MasterDetailVO;

public class MasterService {

	protected MDDao mdDao = null;
	protected Scanner scan = null;
	
	{
		mdDao = DBConnectionSEC.getSqlSessionFactory().openSession(true).getMapper(MDDao.class);
		scan = new Scanner(System.in);
	}
	
	public void insertMaster() {
		System.out.println("문제입력(-q:quit)");
		System.out.print(">>");
		String strQ = scan.nextLine();
		if(strQ.equals("-Q")) return;
		
		MasterDTO mDTO = MasterDTO.builder().m_subject(strQ).build();
		
		int ret = mdDao.insertMaster(mDTO);
		if(ret > 0) {
			System.out.println("등록 성공");
		}else {
			System.out.println("등록 실패");
		}
	}
	
	public void masterAndDetail() {
		
		List<MasterDetailVO> mdList = mdDao.selectAll();
		
		for (MasterDetailVO masterDetailVO : mdList) {
			System.out.print(masterDetailVO.getM_seq() +" : ");
			System.out.println(masterDetailVO.getM_subject());
			
			List<DetailDTO> deList = masterDetailVO.getDeList();
			if(deList !=null) {
				int nNum = 1;
				for (DetailDTO dDTO : deList) {
					System.out.print(nNum++ + ". " +dDTO.getD_subject() + "\t");
					System.out.println(dDTO.getD_ok());
				}
			}
		}
		
		
	}
}
