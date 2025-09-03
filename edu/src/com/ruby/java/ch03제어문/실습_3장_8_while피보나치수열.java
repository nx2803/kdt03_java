package com.ruby.java.ch03제어문;

import java.util.Scanner;

/*
 * 피보나치 수열: 0 1 1 2 3 5 8 ...
 * int n = sc.nextInt(); //항의 수
 * int first = 0;
 * int second = 1;
 * sysout(first);
 * while() {
 *    sysout(second)
 *    int next = first + second;
 *    first = second;
 *    second = next;
 * }
 * 
 */
public class 실습_3장_8_while피보나치수열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자입력:");
		int n = sc.nextInt(); //항의 수
		int a=0;
		int first = 0;
		int second = 1;
		while(a<n) {
			     System.out.println(second);
			     int next = first + second;
			     first = second;
			     second = next;
			     a++;
			  } ;
		sc.close();
	}
}
