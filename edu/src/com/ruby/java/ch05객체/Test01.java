package com.ruby.java.ch05객체;

public class Test01 {
	
	static void test(int... v) {
		System.out.print(v.length+" : ");
		for (int x : v) {
			System.out.print(x + " ");
		}
		System.out.println();
	}
	

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		test(1);
		test(1,2);
		test(1,2,3);
	}

}
