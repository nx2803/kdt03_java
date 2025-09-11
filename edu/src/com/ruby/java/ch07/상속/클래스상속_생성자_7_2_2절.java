package com.ruby.java.ch07.상속;

class Person {
	private String name;
	private int age;

	public Person() {// default 생성자
		System.out.println("Person 생성자 실행!");
	}

	/*
	 * 297페이지 (5) 생성자 오류
	 */
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
		System.out.println("Person(name, age) 생성자 실행!");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String toString() {
		return name + ", " + age;
	}
}

class Employee extends Person {
	private String dept;

	public Employee() {

		System.out.println("Employee 생성자 실행!");

	}

	public Employee(String name, int age, String dept) {

		// name = name;
		// this.name = name;
		// super.setName(name);
		// super.setAge(age);
		super(name, age);// 생성자의 첫번째 라인에 있어야 한다
		this.dept = dept;
		System.out.println("Employee(name, age, dept) 생성자 실행!");
	}

//
//	/*
//	 * 생성자의 코드 중복 문제가 있다 > 293페이지 (4) 부모 생성자 활용 문단
//	 */
	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
	// method overriding

	public String toString() {
		return super.toString() + ", " + dept;
	}
}

class Professor extends Person {
	private String subject;

	public Professor() {
		System.out.println("Professor 생성자 실행!");
	}

	public Professor(String name, int age, String subject) {
		// name = name;
		// this.name = name;
		// super.setName(name);
		// super.setAge(age);
		super(name, age);
		this.subject = subject;
		System.out.println("Professor(name, age, subject) 생성자 실행!");
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	// method overriding

	public String toString() {
		return super.toString() + ", " + subject;
	}
}

class Student extends Person {
	private String major;

	public Student() {
		System.out.println("Student 생성자 실행!");
	}

	public Student(String name, int age, String major) {
		// name = name;
		// this.name = name;
		// super.setName(name);
		// super.setAge(age);
		super(name, age);
		this.major = major;
		System.out.println("Student(name, age, major) 생성자 실행!");
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	// method overriding - 285페이지 중간: 1,,2,3,4 설명 암기
	public String toString() {
		return super.toString() + ", " + major;
	}
}

public class 클래스상속_생성자_7_2_2절 {
	public static void main(String[] args) {
		Employee e = new Employee();
		/*
		 * 자바에서 하위 클래스 생성자 실행 전에는 반드시 상위 클래스 생성자가 먼저 호출
		 * 
		 * Employee() 생성자 안에는 컴파일러가 자동으로 super(); 를 삽입 > 289페이지 첫째, 둘째 문단 > 290페이지 상단의
		 * 1,2,3항 암기
		 * 
		 * public Employee() { super(); // Person() 호출 ← 컴파일러가 자동 추가
		 * System.out.println("Employee 생성자 실행!"); }
		 */
		Professor p = new Professor();
		Student s = new Student();
		/*
		 * Employee e1 = new Employee("오정임",47, "입학처");//에러 발생 Professor p1 = new
		 * Professor("김푸름",52,"빅데이터"); Student s1 = new Student("김유빈",20,"컴퓨터");
		 */
		e.setName("오정임");
		e.setAge(47);
		e.setDept("입학처");

		p.setName("김푸름");
		p.setAge(52);
		p.setSubject("빅데이터");

		s.setName("김유빈");
		s.setAge(20);
		s.setMajor("컴퓨터과학");

		System.out.println(e.toString());
		System.out.println(p.toString());
		System.out.println(s.toString());
	}
}
