package com.ruby.java.ch07.상속;

abstract class Employee2 {// 추상 클래스
	String name;
	int salary;
	public Employee2() {}//default 생성자

	public Employee2(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}

	public abstract void calcSalary();// 추상 메소드

	public abstract void calcBonus();
}

abstract class Salesman extends Employee2 {// 307페이지 하단 밑에서 두번째 문단
	int salesQty;

//	public Salesman() {
//		super("",0);
//	}

	public Salesman(String name, int salary, int qty)
	{
		super();
		salesQty = qty;
	}
	public void calcSalary() {
		System.out.println("Salesman 급여 = 기본급+판매수당*판매량");
	}
}

class DomesticSalesman extends Salesman {//concrete class
	

	int domesticSalesQty;

	public DomesticSalesman(String name, int salary, int qty, int dqty) {
		super(name, salary, qty);
		this.salesQty = qty;
		this.domesticSalesQty = dqty;
	}

	public void calcBonus() {
		System.out.println("DomesticSalesman 보너스 = 기본급* 0.01");
	}
}

class Consultant extends Employee2 {// concrete class
	int consultingHours;
	public Consultant() {
		super();
	}//자바 컴파일러가 자동 생성 > 

	public void calcSalary() {
		System.out.println("Consultant 급여 = 기본급+컨설팅단가 * 컨설팅 시간");
	}

	public void calcBonus() {
		System.out.println("Consultant 보너스 = 기본급* 0.02");
	}
}

class Manager extends Employee2 {// concrete class
	int teamNumbers;

	public void calcSalary() {
		System.out.println("Manager 급여 = 기본급+관리자단가 * 팀수");
	}

	public void calcBonus() {
		System.out.println("Manager 보너스 = 기본급* 0.03");
	}
}

public class HRSTest {

	public static void main(String[] args) {
		// Salesman s = new Salesman();//추상 클래스
		//Salesman s = new DomesticSalesman("홍길동",10,20,30);
		//DomesticSalesman s = new DomesticSalesman("홍길동",10,20,30);
		Employee2 s = new DomesticSalesman("홍길동",10,20,30);
		Employee2 c = new Consultant();
		Employee2 m = new Manager();
		s.calcBonus();
		c.calcBonus();
		m.calcBonus();

	}

}
