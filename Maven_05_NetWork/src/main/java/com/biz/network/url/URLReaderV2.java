package com.biz.network.url;

import java.net.MalformedURLException;
import java.net.URL;

public class URLReaderV2 {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub

		URL callor = new URL("https://callor.com:12200/main?name=korea");
		
		System.out.println("Protocol : " + callor.getProtocol());
		System.out.println("Authority : " + callor.getAuthority());
		System.out.println("Host : " + callor.getHost());
		System.out.println("Port : " + callor.getPort());
		System.out.println("Path : " + callor.getPath());
		System.out.println("Query : " + callor.getQuery());
		System.out.println("File : " + callor.getFile());
		System.out.println("ref : " + callor.getRef());
	}

}
