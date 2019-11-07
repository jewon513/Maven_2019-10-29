package com.biz.oracle.exec;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class EncEx_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String user = "iolist2";
		String password = "iolist2";
		
		String salt = "com.biz.oracle";
		
		
		//문자열을 암호화시키기 위한 클래스
		StandardPBEStringEncryptor pbEnc = new StandardPBEStringEncryptor();
		
		//암호화 타입
		//MD5 또는 DE5 형식의 암호화 타입
		//가장 쉽게 접근할 수 있는 암호화타입
		//jasypt만으로 암호화 시키는 방법
		String encType = "PBEwithMD5AndDES";
		
		pbEnc.setAlgorithm(encType);
		pbEnc.setPassword(salt);
		String encUser = pbEnc.encrypt(user);
		String encPassword = pbEnc.encrypt(password);
		
		System.out.printf("%s -> %s\n", user, encUser);
		System.out.printf("%s -> %s\n", password, encPassword);
		/*
		 * iolist2 -> GpauUQFtSO7dcmnBCkjIOQ==
		 * iolist2 -> H58E5fmID/iOMVsYFmeB+w==
		 * 
		 */
		
	}

}
