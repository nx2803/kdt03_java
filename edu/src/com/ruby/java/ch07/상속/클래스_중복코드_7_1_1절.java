package com.ruby.java.ch07.상속;
/*
 * 7장 7.1.1 상속이란
 * 중복 코딩 문제를 보여줌: 1) 필드의 중복, 2) 메소드의 중복
 * 
 * 271페이지 문단: 중복 제거 필요성 설명
 */
/*
class Employee {
	private String name;
	private int age;
	private String dept;
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
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
}

class Professor {
	private String name;
	private int age;
	private String subject;
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
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
}

class Student {
	private String name;
	private int age;
	private String major;
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
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
}
*/
public class 클래스_중복코드_7_1_1절 {
	public static void main(String[] args) {
	    Employee e = new Employee();
		Professor p = new Professor();
		Student s = new Student();
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
