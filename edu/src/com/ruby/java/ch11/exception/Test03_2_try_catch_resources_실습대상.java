package com.ruby.java.ch11.exception;
/*
 *  1. try - catch - resources: 
 *   -> 파일, 소켓, 데이터베이스 연결 등과 같은 자원을 자동으로 해제하기 위해 사용
 *  
 *  2. finally 블록에서 자원을 수동으로 닫아주는 코드를 작성할 필요가 없어 코드가 간결
 *   -> try 괄호 안에 자원 객체 선언
 */

import java.io.FileInputStream;
import java.io.IOException;


public class Test03_2_try_catch_resources_실습대상 {
	public static void main(String[] args) {
		//try-catch-resources문
		try(FileInputStream fi = new FileInputStream("a.txt"))//547페이지 하단의 파일처리 
		{
			int c = fi.read();
			fi.read(null);//null을 참조하는 바이트 배열에 데이터를 쓰려고 시도
			//fi.read(byte[] b);
			System.out.println((char) c);
		} catch (IOException e) {
			
			e.printStackTrace();
			System.out.println(e.getMessage());
		
		}
	}
}
