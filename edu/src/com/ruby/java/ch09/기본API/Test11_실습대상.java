package com.ruby.java.ch09.기본API;
/*
 * boxing unboxing Wrapper class 실습
 */
public class Test11_실습대상 {

	public static void main(String[] args) {
		boolean bool = true;
		byte b = 12;
		char c = 'A';
		double d = 3.14;//자바는 기본 실수가 double
		d = 1.12f;
		float f = 10.5f;//10.5를 사용하면 double로 인식한다
		int i = 123;
		long l = 123456789;
		short s = 256;

		Boolean obj1 = bool;
		Byte obj2 = b;
		Character obj3 = c;
		Double obj4 = d;
		Float obj5 = f;
		Integer obj6 = i;
		//obj6. > 클래스 메소드를 사용할 필요가 있을 때
	       // 1. Integer 클래스 메서드 사용 예제
        int num = 14;
        
        // 오토 박싱을 통해 int가 Integer 객체로 변환됨
        Integer boxedNum = num;
        System.out.println(Integer.toBinaryString(num));
        // Integer.toBinaryString() 메서드 사용 (정수를 2진수 문자열로 변환)
        String binaryString = Integer.toBinaryString(boxedNum);
        System.out.println("14의 2진수: " + binaryString); // 출력: 1100100
        
        // Integer.max() 메서드 사용 (두 정수 중 큰 값 반환)
        int max = Integer.max(50, 150);
        System.out.println("두 정수 중 큰 값: " + max); // 출력: 150
        
		Long obj7 = l;
		Short obj8 = s;
		System.out.println("Double obj4 = " + obj4);
		//obj4.toString();
		boolean bool2 = obj1;
		byte b2 = obj2;
		char c2 = obj3;
		double d2 = obj4;
		float f2 = obj5;
		int i2 = obj6;
		long l2 = obj7;
		short s2 = obj8;
		System.out.println("d = "+d);
		System.out.println("f = "+f);
	}
}