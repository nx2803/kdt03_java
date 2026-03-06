
package com.ruby.java.ch09.기본API;

import java.util.Random;

public class Test15_실습대상 {
	public static void main(String[] args) {
		long seed = 11;
		Random r1 = new Random(11);//seed 사용의 의미를 이해해야 
		//Random r1 = new Random();
		for (int i = 0; i < 5; i++) {
			System.out.print(r1.nextInt() + "\t");
			System.out.print(r1.nextInt(10) + "\t");
			System.out.print(r1.nextBoolean() + "\t");
			System.out.print(r1.nextDouble() + "\t");
			System.out.println();
		}

		Random r2 = new Random(123);
		for (int i = 0; i < 5; i++) {
			System.out.println(r2.nextInt(10));
		}
	}
}