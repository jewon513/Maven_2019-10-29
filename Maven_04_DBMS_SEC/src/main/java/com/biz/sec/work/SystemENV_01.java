package com.biz.sec.work;

import java.util.Map;
import java.util.Set;

public class SystemENV_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// java에서 OS에서 설정할 환경변수를 가져오기
		Map<String, String> envList = System.getenv();
		
		Set<String> keys = envList.keySet();
		
		for (String string : keys) {
			System.out.printf("Key : %-30s \t\tValue : %s\n", string ,envList.get(string));
		}
		
	
		System.out.println(envList.get("BIZ"));
		
	}

}
