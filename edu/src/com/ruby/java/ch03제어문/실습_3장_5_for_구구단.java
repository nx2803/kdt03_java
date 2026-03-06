package com.ruby.java.ch03제어문;

import java.util.Scanner;



/*
 * 구구단 출력
 * int dan = sc.nextInt()
 * for(;;) {
 *     //3x1 = 3
 *     //3x2 = 6 등으로 출력
 * }
 * 
 */
public class 실습_3장_5_for_구구단 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자입력:");
		int dan = sc.nextInt();
		for (int i = 1; i < 10; i++) {
			System.out.println(dan+"x"+i+"="+dan*i);
			
		}
		sc.close();
	}
	
	
}
