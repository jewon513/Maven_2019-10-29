package com.biz.network.url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class URLConnectionReader02 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		// 일부 홈페이지(Site)는 주소를 직접 URL로 요청을 하면
		// 주소변환과정등의 문제로 접속이 불가능 하다.
		// 이때는 주소를 UTF-8로 encoding을 수행해주어야 한다.
		String naverURL = "https://naver.com/";
		String encNaverURL = URLEncoder.encode(naverURL,"UTF-8"); 
		
		URL naver = new URL(naverURL);
		URLConnection naverOpen = naver.openConnection();
		
		naverOpen.setDoOutput(true);
		
		//실제로 사용하지 않아도 **Stream이 작동될때마다 내부적으로 실행이됨
		naverOpen.connect();
		
		
		OutputStreamWriter out = new OutputStreamWriter(naverOpen.getOutputStream());
		out.write(encNaverURL);
		out.close();

		BufferedReader buffer = new BufferedReader(new InputStreamReader(naverOpen.getInputStream()));
		
		String reader = "";
		while(true) {
			reader = buffer.readLine();
			if(reader==null) break;
			System.out.println(reader);
		}
		buffer.close();
	}

}
