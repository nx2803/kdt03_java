package com.ruby.java.ch02데이터타입;

import java.util.Scanner;

public class 실습_2_5타입변환 {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		Scanner sc = new Scanner(System.in);
		System.out.print("정수입력:");
		int a= sc.nextInt();
		double b = (double)a;
		System.out.println("정수변수값="+a+", 실수변수값="+b);
		
		System.out.print("실수입력:");
		double c= sc.nextDouble();
		int d = (int)c;
		System.out.println("실수변수값="+c+", 정수변수값="+d);
	}

}
