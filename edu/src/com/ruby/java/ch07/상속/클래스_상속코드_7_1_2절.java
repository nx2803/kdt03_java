package com.ruby.java.ch07.상속;

/*
 * 7.1.2 상속 구현
 */
/*
class Person {
	private String name;
	private int age;
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
		return name + ", ";
	}
}

class Employee extends Person {
	private String dept;
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	} 
}
class Professor extends Person {
	private String subject;
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
}
class Student extends Person {
	private String major;
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
}
*/
public class 클래스_상속코드_7_1_2절 {
	public static void main(String[] args) {
	    Employee e = new Employee();
		Professor p = new Professor();
		Student s = new Student();
		/*
		 * 279페이지 하단 문단: heap에 객체 생성
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
		/*
		 * 280페이지 가운데 문단 이해 > 스택영역의 변수 e > heap영역의 인스턴스 객체 접근 - 클래스 확인후 > 메소드를 조사 - 메소드 영역에서
		 * 
		 * heap 영역에 있는 객체는 클래스 정보만 갖고 있다 - 상속관계는 heap 인스턴스에 표현되지 않는다
		 */

		System.out.println(e.toString());
		System.out.println(p.toString());
		System.out.println(s.toString());
	}
}
