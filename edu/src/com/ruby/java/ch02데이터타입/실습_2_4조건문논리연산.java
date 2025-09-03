package com.ruby.java.ch02데이터타입;

import java.util.Scanner;

public class 실습_2_4조건문논리연산 {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		Scanner sc = new Scanner(System.in);
		System.out.print("나이 : ");
		int n = sc.nextInt();
		System.out.print("도시 : ");
		String st = sc.next();
		Boolean byf = false;
		byf = (20<n&&n<30)&&(st.equals("부산"));
		String r = byf?"참":"거짓";
		System.out.println("나이="+n+", 도시="+st+", 부산청년여부="+r);
	}

}
