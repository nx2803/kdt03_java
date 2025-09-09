package com.ruby.java.ch06객체구현;

public class Member {
	private String name;
	private int age;
	/*
	 * 247 페이지 6.3.2 생성자 오버로딩 - 메소드 오버로딩
	 * 
	 * 250페이지 그림에서 오류: stack이 아니고 Code 
	 */
	public Member() {//default 생성자 - 기본 생성자
		//public member() { //생성자는 클래스 이름과 같아야 한다 - 244페이지 6.3절
		// 생성자의 목적은 메모리 할당이 아니고 초기화 목적이다 - 245페이지 6.3.1 생성자 개요
		this("guest");//중복 코딩 제거
		/*
		 * this.name = "guest";
		 * this.age = 0;
		 */
		System.out.println("Member() 생성자 실행");
		//this("good");//생성자 함수 내에서도 첫줄에 기재해야 한다.
	}

	public Member(String name) {
		this(name, 0);// 생성자 body에서 첫번째 와야 한다. > 264페이지 하단 문단 
		//refactoring > 중복 코딩 제거 : 262페이지 2,3번째 문단 이해
		/*
		 * this.name = name;
		 * this.age = 0;
		 */
		
		System.out.print("Member(String) 생성자 실행 : ");
		System.out.println("name = " + name);
		System.out.println("this.name = " + this.name);
	}

	public Member(String name, int age) {
		this.name = name;
		this.age = age;
		System.out.print("Member(String, int) 생성자 실행 : ");
		System.out.println(name + " : " + age);
	}

	public void setName(String name) {
		//this("guest");//생성자내에서만 사용 가능하다
	}
	//많이 사용하는 코딩 방식 - 숙달 필요
	@Override
	public String toString() {
		return name + ":" + age;
	}
	public static void main(String[] args) {
		System.out.println("main() 메서드 실행");
		Member m;//생성자 호출 안됨 - C++ 차이가 있는 점이다, 참조 변수이다
		/*
		 * 생성자 실행: 246페이지 (2) 생성자 실행
		 * 
		 * new 문이 2가지 실행: 1) heap에 메모리 할당, 2) 생성자 호출, 3) 할당된 메모리의 주소를 반환 
		 */
		m = new Member();
		System.out.println(m.toString());//숙달 필요
		m = new Member("Amy");
		System.out.println(m.toString());
		m = new Member("Amy", 23);
		System.out.println(m.toString());
		new Member("Hong", 20);
		/*
		 *  힙(heap)에 객체는 생성되지만, 곧바로 가비지 컬렉션(GC) 대상
		 *  
		 *  자바의 가비지 컬렉션은 **도달 가능성(Reachability)**을 기준으로 메모리를 관리
		 *  1) 도달 가능한 객체: main 메서드와 같이 프로그램의 시작점에서부터 변수 참조를 통해 접근할 수 있는 모든 객체
		 *  2) 도달 불가능한 객체: 어떤 변수도 참조하지 않아 접근할 수 없는 객체
		 *  3) 자바의 가비지 컬렉터(Garbage Collector, GC)는 JVM이 메모리가 부족하다고 판단할 때 등 필요한 시점에 비동기적으로 실행
		 */
	}
}