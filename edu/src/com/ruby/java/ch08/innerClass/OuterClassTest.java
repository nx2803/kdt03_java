package com.ruby.java.ch08.innerClass;
/*
 * 368페이지 8.2.2 내부 클래스 종류 > 마지막 문단 설명
 */
class OuterClass {
	class InstanceClass {
		int a;

		void method2() {
			System.out.println("Instance Class : " + a);
		}
	}

	static class StaticClass {
		int b;
		static int c;
		void method3() {
			System.out.println("Static Class : "+ b);
		}

		static void method4() {
			System.out.println("Static Class: " + c);
		}
	}

	public void method1() {
		class LocalClass { //method에서 사용하는 클래스
			int d;
			void method5() {
				InstanceClass ic = new InstanceClass();
				ic.a = 55;
				System.out.println("method1():Local Class : d = " + d);
				System.out.println("method1():Local Class : ic.a = "+ ic.a);
			}
		}
		LocalClass inner = new LocalClass();
		InstanceClass ic = new InstanceClass();
		inner.d = 1004;
		inner.method5();
		System.out.println("method1():" + ic.a);
	}

}
public class OuterClassTest {

	public static void main(String[] args) {

		OuterClass outer = new OuterClass();
		//InstanceClass ic = outer.new InstanceClass();
		//outer.InstanceClass ic = outer.new InstanceClass();//outer는 참조 변수
		OuterClass.InstanceClass inner01 = outer.new InstanceClass();
		inner01.a = 123;
		inner01.method2();
		
		//Outerclass의 인스턴스 생성없이 사용할 수 있다 - static 클래스
		OuterClass.StaticClass inner02 = new OuterClass.StaticClass();
		//outer.StaticClass os = outer.new StaticClass();
		inner02.b = 456;
		inner02.method3();
		OuterClass.StaticClass.c = 789;
		OuterClass.StaticClass.method4();
		//outer.StaticClass.c = 111;
		outer.method1();
	}

}
