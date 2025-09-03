package com.ruby.java.ch03제어문;

import java.util.Scanner;

public class Test22 {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		int a=12;
		int b=2;
		char op = '+';
		Scanner sc = new Scanner(System.in);
		System.out.println("연산을 입력하시오: ");
		String op2 = sc.next();
		op = op2.charAt(0);
		switch (op) {
		case '+': {
			
			System.out.println(a+b);
			break;
		}
		case '-': {
			
			System.out.println(a-b);
			break;
		}
		case '*': {
			
			System.out.println(a*b);
			break;
		}
		case '/': {
			
			System.out.println(a/b);
			break;
		}
		
		default:
			throw new IllegalArgumentException("Unexpected value: " + op);
		}
		
	}

}
