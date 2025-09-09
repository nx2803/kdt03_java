package com.ruby.java.ch06객체구현;
class Student2 {
	//public class Student2 {
		int a;
		int b;
	}
public class ArmorTest_3회차 {
	public static int sum(int data1, int data2) {
		int result = data1 + data2;
		return result;
	}
	public static void main(String[] args) {
		String st;
		st = "hello";//스트링 리터럴은 메소드 영역의 constant pool에 
		
		int result = sum(10, 20);
		Armor_3회차 am;
		am = new Armor_3회차();
		Armor_3회차 am2 = new Armor_3회차();
		Armor_3회차 am3 = new Armor_3회차();
		Armor_3회차 am4 = new Armor_3회차();		
		
		am2.getHeight();
		
		int n = 10;
		Armor_3회차 a = new Armor_3회차();//클래스로 변수 선언시 초기화가 필요하다.
		a.height = 0;//not visible
		a.setHeight(n);
		a = new Armor_3회차();
		/*
		 * new 키워드는 힙(Heap) 영역에 객체를 저장할 공간을 동적으로 할당
		 * 필드는 힙에 저장되고, 힙 메모리를 동적으로 할당하는 것은 new 키워드의 역할
		 * 
		 * 생성자는 할당된 메모리 공간에 있는 인스턴스 변수들을 사용자가 정의한 초기값으로 초기화하는 역할
		 */
		//System.out.println(a.name + " : " + a.getHeight());//220페이지 표 참조

		Armor_3회차 suit1 = new Armor_3회차();
		Armor_3회차 suit2 = new Armor_3회차();
		Armor_3회차 suit3 = new Armor_3회차();
		/*
		 *  JVM이 .java 파일을 컴파일한 .class 파일을 로드할 때, 클래스 정보, 필드, 
		 *  그리고 메소드에 대한 정의는 **메소드 영역(Method Area)**에 저장
		 *  
		 *  JVM 내에서 클래스당 하나만 존재하며, 모든 인스턴스가 공유하는 공간
		 *  
		 *  heap의 객체 인스턴스에는 메소드 코드가 포함되지 않는다(215페이지 그림)
		 *  
		 */
//		suit1 = null;
		suit1.setName("mark611");
		suit1.setHeight(180);

		suit2.setName("mark16");
		suit2.setHeight(220);

		suit3.setName("mark38");
		suit3.setHeight(200);

		System.out.println(suit1.getName() + " : " + suit1.getHeight());
		System.out.println(suit2.getName() + " : " + suit2.getHeight());
		System.out.println(suit3.getName() + " : " + suit3.getHeight());
	}
}
