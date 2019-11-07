package com.biz.sec.work;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

/*
 *jasypt 도구를 사용하여 문자열을 암호화 하는 TEST를 수행
 *
 * 평문문자열(planText)을 암호화, 그리고 그것을 복호화 할 수 있음
 */
public class SecEX_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * java에서 쉽게 사용할 수 있는 암호화, 복호화를 수행하는 클래스
		 * 암호화와 복호화를 동시에 수행할 수 있다.
		 * 
		 *  1.암호화의 종류 : 단방향, 양방향 암호화
		 *  	가.	단방향 암호화 :
		 *  			평문 >> 암호문으로 변경 가능.
		 *  			암호문 >> 평문으로 변경 불가능
		 *  			보안성을 유리하지만, 사용에 제약이 따른다.
		 *  	나. 양방향 암호화
		 *  			평문 >> 암호문,
		 *  			암호문 >> 평문 둘다 변경 가능
		 *  			사용에 편리성
		 *  			만약 salt Key가 노출되면 의미가 없음
		 *  
		 *  jasypt는 양방향 암호화를 수행하고 쉽게 사용할 수 있는 형태
		 *  java에서 DBMS에 접근하기 위해 userID와 password를 사용해야 하는데
		 *  jdbc Connection 코드에 userid와 password가 노출되어 보안에 매우 취약하다.
		 * 
		 *  
		 *  
		 */
		StandardPBEStringEncryptor pbEnc = new StandardPBEStringEncryptor();
	
		// 암호화와 복호화를 수행할 때 사용할 Key
		String saltPass = "com.biz";
		
		String planText1 = "java";
		String planText2 = "Republic of Korea";
		
		String encText1 = "";
		String encText2 = "";
		
		/*
		 * 암호화를 수행하는 코드 
		 */
		
		pbEnc.setAlgorithm("PBEWithMD5AndDES");
		pbEnc.setPassword(saltPass);
		
		encText1 = pbEnc.encrypt(planText1);
		encText2 = pbEnc.encrypt(planText2);
		
		System.out.printf("plan : %s, enc : %s \n", planText1, encText1);
		System.out.printf("plan : %s, enc : %s \n", planText2, encText2);
		
		String decText1 = pbEnc.decrypt(encText1);
		String decText2 = pbEnc.decrypt(encText2);
		
		System.out.println("-----------------------------------------------------------");
		
		System.out.printf("enc : %s, dec : %s \n", encText1, decText1);
		System.out.printf("enc : %s, dec : %s \n", encText2, decText2);
		
	}

}
