package com.ruby.java.ch03제어문;
// Annotation: 주석처럼 보이지만 주석이 아니라 컴파일러/JVM에게 전달되는 메타 데이터

// @Override > 클래스 상속시 코드 재사용 정의
/**
 * @author 윤치형
 * 
 */
public class Test18 {
	
	/**
	 * @param a 합의 첫번째 변수
	 * @param b 합의 두번째 변수
	 * @return a+b 결과를 반환
	 */
	public int sum(int a, int b) {

		int salary = 0;
		salary += 10;
		System.out.println();
		//
		return a+b;
	}
}
