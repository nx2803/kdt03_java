package com.ruby.java.ch08;

//추상 클래스의 생성자 정의

abstract class Employee extends Object {
	String name;
	int salary;

	public Employee() {
		name = null;
		salary = 0;
	}

	public Employee(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}

	public abstract void calcSalary();

	public abstract void calcBonus();

	@Override
	public String toString() {
		return "name=" + name + " salary= " + salary;
	}

}

class Salesman extends Employee {
//	int eno;
	int annual_sales;

	public Salesman() {
		super();
		annual_sales = 0;
	}

	public Salesman(String name, int salary, int eno) {
		super(name, salary);
		this.annual_sales = eno;
	}

	@Override
	public void calcSalary() {
		System.out.println("세일즈맨 급여");
	}

	@Override
	public void calcBonus() {
		System.out.println("세일즈맨 보너스");
	}

	@Override
	public String toString() {
		return super.toString() + ", eno=" + annual_sales;
	}
}

class Consultant extends Employee {
	int consultingFee;

	public Consultant(String name, int salary, int fee) {
		super(name, salary);
		consultingFee = fee;
	}

	@Override
	public void calcSalary() {
		System.out.println("컨설턴트 급여");
	}

	@Override
	public void calcBonus() {
		System.out.println("컨설턴트 보너스");
	}

	@Override
	public String toString() {
		return super.toString() + ", consultingFee =" + consultingFee;
	}
}

abstract class Manager extends Employee {
	int managingNo;

	public Manager() {
		managingNo = 0;
	}

	public Manager(String name, int salary, int mno) {
		super(name, salary);
		this.managingNo = mno;
	}

	@Override
	public void calcSalary() {
		System.out.println("매니저 급여");
	}

	@Override
	public String toString() {
		return super.toString() + ", managingNo =" + managingNo;
	}
}

class Director extends Manager {
	int count;

	public Director() {
	}

	public Director(String name, int salary, int mno, int count) {
		super(name, salary, mno);
		this.count = count;
	}

	@Override
	public void calcBonus() {
		System.out.println("이사 보너스");
	}

	@Override
	public String toString() {
		return super.toString() + ", count =" + count;
	}
}

public class HRSTest {
	// *
	// 다음과 같은 3개의 함수를 만들지 않고 하나의 함수로 구현 가능
	public static void calcTax(Salesman s) {
		s.calcSalary();
		double tax = s.salary * 0.1;
		System.out.println("세금 = " + tax);
	}

	public static void calcTax(Consultant c) {
		c.calcSalary();
		double tax = c.salary * 0.1;
		System.out.println("세금 = " + tax);
	}

	public static void calcTax(Director d) {
		d.calcSalary();
		double tax = d.salary * 0.1;
		System.out.println("세금 = " + tax);
	}
	// */
	/*
	 * 교재 332페이지 8.1.2 다형성의 원리 - 마지막 문단 > 정확하지 않은 표현
	 * 
	 * 자바의 추상 클래스(abstract class)에서 메서드 바디(body)가 없는 추상 메서드(abstract method)를 선언하고,
	 * 이를 상속받는 하위 클래스들이 각자 다르게 구현하는 것을 Polymorphism이라고 한다.
	 */
	// *

	public static void calcTax(Employee e) {
		e.calcSalary();// 동적 바인딩
		double tax = e.salary * 0.1;
		System.out.println("세금 = " + tax);

		if (e instanceof Salesman) {
			System.out.println("Salesman 인스턴스");
			// System.out.println(e.eno);//오류 > 353페이지 - 355페이지 그림 이해
			System.out.println(((Salesman) e).annual_sales);// type casting으로 해결
		} else if (e instanceof Manager) {
			System.out.println("Manager 인스턴스");
			System.out.println(((Manager) e).managingNo);// 오류
		} else if (e instanceof Consultant) {
			System.out.println("Consultant 인스턴스");
			System.out.println(e.name);// 오류가 없는 이유는?
		} else {
			System.out.println("Employee 인스턴스");
		}
	}

	// */
	public static void main(String[] args) {
		Employee s = new Salesman("hong", 10000, 2301);
		Salesman s5;
		// s5=s;
//		s = s5;
//		if (s5.equals(s)) {
//			System.out.println(s5 + "은 " + s + "과 같습니다.");
//		}
		/*
		 * 341페이지 (2) 인스턴스 생성
		 */
		Consultant c = new Consultant("kim", 240, 3333);
		// Employee d = new Director("Lee", 3434, 11, 3);
		Director d = new Director("Lee", 4000, 11, 3);

		s.calcBonus();
		c.calcBonus();
		d.calcBonus();
		calcTax(s); // 파라미터 전달
		calcTax(c);
		calcTax(d);
		/*
		 * 333페이지 (1) Object 클래스 > 첫째, 둘째 문단
		 * 
		 * 구글링: java java.base 검색하여 334-335 페이지 확인
		 * 
		 */
		// s.e //교재 337 그림 확인 - Object 클래스에서 상속받은 메소드 확인
		// Salesman s2 = s;
		if (s.equals(d)) {
			System.out.println("s,d는 동일 객체");
		} else {
			System.out.println("s,d는 다른 객체");
		}
		System.out.println(s.toString());
		/*
		 * Object 클래스의 toString(): 339페이지 첫째, 둘째 문단
		 */
		// Salesman s2 = s;
//		if (s2.equals(s))
//			System.out.println("s,s2 같은 객체");
//		else
//			System.out.println("s,s2 다른 객체");
//		System.out.println(s.toString());
//		System.out.println(s2.toString());
//		System.out.println(d.toString());
		// d = s;
		// s = d;
		/*
		 * 344페이지 (3)클래스 다형성 polymorphisms use the inherited methods to perform
		 * different tasks -> allow to perform a single action in different ways.
		 */
		Salesman s1 = new Salesman();
		Employee s3 = new Salesman();
		Object s4 = new Salesman(); // 교재는 이것을 다형성이라고 잘 못 설명하고 있다

		Object m1 = new Director();
		Employee m2 = new Director();
		Manager m3 = new Director();
		// Director m4 = new Manager();

		Object arr[] = new Object[6];
		arr[0] = s1;
		arr[1] = s3;
		arr[2] = s4;
		arr[3] = m1;
		arr[4] = m2;
		arr[5] = m3;

		for (Object o : arr)
			System.out.println(o.toString());// 동적 바인딩

	}

}
