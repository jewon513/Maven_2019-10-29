package com.biz.sec.work;

import java.util.Map;
import java.util.Scanner;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

/*
 *jasypt 도구를 사용하여 문자열을 암호화 하는 TEST를 수행
 *
 * 평문문자열(planText)을 암호화, 그리고 그것을 복호화 할 수 있음
 */
public class SecEX_03 {

	public static void main(String[] args) {
		
		// 환경변수를 사용하여 암호화
		Scanner scan = new Scanner(System.in);
		
		Map<String,String> envList = System.getenv();
		
		StandardPBEStringEncryptor pbEnc = new StandardPBEStringEncryptor();
	
		// 암호화와 복호화를 수행할 때 사용할 Key
		String saltPass = envList.get("BIZ");
		
		pbEnc.setAlgorithm("PBEWithMD5AndDES");
		pbEnc.setPassword(saltPass);
		
		System.out.print("username >> ");
		String planUserName = scan.nextLine();
		System.out.print("password >> ");
		String planPassword = scan.nextLine();
		
		String encUserName = pbEnc.encrypt(planUserName);
		String encPassword = pbEnc.encrypt(planPassword);
		
		System.out.printf("plan : %s, enc : %s \n", planUserName, encUserName);
		System.out.printf("plan : %s, enc : %s \n", planPassword, encPassword);
		
//		username AivRxDRSW+CUbFeHHLqVsA== 
//		password EgmJbb3LIEbjEMyrBQjsQw== 
	}

}
