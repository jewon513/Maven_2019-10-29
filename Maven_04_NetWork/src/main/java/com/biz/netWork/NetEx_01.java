package com.biz.netWork;

import java.io.IOException;
import java.net.InetAddress;

public class NetEx_01 {

	public static void main(String[] args) throws IOException {

		InetAddress naver = InetAddress.getByName("www.daum.net");
		
		System.out.println(naver);
		
		//ip address만 추출하는 method
		System.out.println(naver.getHostAddress());
		System.out.println(naver.getHostName());
		
		//내 컴퓨터 NCC(NetWrok Interface Card, 랜카드)에 설정된 IP
		InetAddress local = InetAddress.getLocalHost();
		
		//내 컴퓨터 내부의 App 들이 서로 통신을 하거나
		//통신Test 용으로 만들어진 특별한 IP
		InetAddress loopback = InetAddress.getLoopbackAddress();
		
		System.out.println("local " + local);
		System.out.println("loopback " + loopback);
		
		
	}

}
