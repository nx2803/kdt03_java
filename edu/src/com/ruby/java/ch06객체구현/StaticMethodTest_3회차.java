package com.ruby.java.ch06객체구현;
/*
 * class method를 가장 확실히 공부할 수 있는 코드이다 , 교재 243페이지
 */
public class StaticMethodTest_3회차 {
	int num = 123;
	public static void main(String[] args) {
		StaticMethodTest_3회차.print1();
		//StaticMethodTest_3회차.print2();//오류
		print1();
		//print2();//에러가 나는 이유를 알아야 한다
		StaticMethodTest_3회차 smt = new StaticMethodTest_3회차();
		smt.print2();
		//print2();//이유는?
		//System.out.println(num);//객체 생성 없이 사용하므로 안된다 - 난이도 높은 설명이다
	}

	public static void print1() {
		//클래스 메소드는 클래스 변수만 접근해야 한다
		//int num2 = num;//실행하기 전에 값이 있어여 하는데 num 값은 없다
		System.out.println("hello ");
		//System.out.println("hello " + num);//num 변수는 객체가 있어야 사용 가능하다
	}

	public void print2() {
		int num3 = this.num;//instance가 있으므로 오류가 아니다ㅏ
		System.out.println("java " + num);//객체가 만들어질 때 사용하므로 허용
	}
}
//243페이지 (3) 정적 코드 블럭 앞 문단의 마지막 두줄: 명심 기억해야 할 내용