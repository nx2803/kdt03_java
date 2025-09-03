package com.ruby.java.ch03제어문;
// Annotation: 주석처럼 보이지만 주석이 아니라 컴파일러/JVM에게 전달되는 메타 데이터

// @Override > 클래스 상속시 코드 재사용 정의
/**
 * @author 홍봉희
 */
public class Test18 {
	public static void main(String[] args) {
		System.out.println();
	}
	/**
	 * @param a 합의 첫째 요소
	 * 
	 * @param b 합의 둘째 요소
	 * 
	 * @return a와 b를 합한 결과
	 */
	public int sum(int a, int b) {

		int salary = 0;
		salary += 10;
		System.out.println();
		//
		return a + b;
	}
}
