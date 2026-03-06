package com.ruby.java.ch03제어문;

import java.util.Scanner;

/*
 * 출력 형태를 다음과 같이 만들기 실습
 * 실습1:
 * $$$$$
 * $$$$
 * $$$
 * $$
 * $
 * 
 * 실습2: 정삼각형 형태로 출력하기
 * $$$$$$
 *  $$$
 *   $
 */
public class 실습_3장_9_forfor문 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 입력: ");
		int a = sc.nextInt();
		int b = a;
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < b; j++) {
				System.out.print("$");
			}
			b--;
			System.out.println();
		}
		System.out.println();
		int c = a;
		int d = 0;
		for (int i = 0; i < a; i++) {
			for (int k = 0; k < d; k++) {
				System.out.print(" ");
			}
			for (int j = 0; j < c; j++) {
				System.out.print("$");
			}
			d++;
			c -= 2;
			System.out.println();
		}
		sc.close();
	}
}
