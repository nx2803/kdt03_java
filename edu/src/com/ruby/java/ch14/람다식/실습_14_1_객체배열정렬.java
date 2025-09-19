package com.ruby.java.ch14.람다식;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Student {
	Integer sno;
	String sname;
	Integer sbirth;
	
	public Student(Integer sno, String sname, Integer sbirth) {
		this.sno = sno;
		this.sname = sname;
		this.sbirth = sbirth;
	}
	
	public String toString() {
		return "[" + String.format("%3d", sno) + ", " + sname + ", " + sbirth + "]";
	}
}

public class 실습_14_1_객체배열정렬 {

	static void printStudetns(String msg, String rep, Student[] data) {
		System.out.println(msg);
		for (Student st: data)
			System.out.println(st);
		if (rep.equals("-"))
			System.out.println(rep.repeat(20));
		else
			System.out.println(rep.repeat(35));
	}
	
	public static void main(String[] args) {
		Student [] data = {
			new Student(12, "홍길동", 2003),
			new Student(121, "김길순", 2000),
			new Student(213, "최길춘", 2001),
			new Student(9, "나길홍", 1999)
		};
		
		printStudetns("초기 입력 데이터", "=", data);

		//==================================================================
		// 익명 객체를 이용해서 이름으로 오름차순 정렬
		//
		// 정렬 익명 객체
		Comparator<Student> compName = new Comparator<Student>(){
			@Override
			public int compare(Student s1, Student s2) {
				return (s1.sname.compareTo(s2.sname));
			}
		};
		Arrays.sort(data, compName);
		printStudetns(">>>익명 객체를 이용해서 이름으로 오름차순 정렬", "-", data);

		// 람다함수를 이용해서 이름으로 내림차순 정렬
		Arrays.sort(data, (s1, s2)->s2.sname.compareTo(s1.sname));
		printStudetns(">>>람다함수를 이용해서 이름으로 내림차순 정렬", "=", data);
		//==================================================================
		// 익명 객체를 이용해서 번호로 오름차순 정렬
		Arrays.sort(data, new Comparator<Student>() {
			@Override
			public int compare(Student s1, Student s2) {
				return s1.sno-s2.sno;
			}
		});
		printStudetns(">>>익명 객체를 이용해서 번호로 오름차순 정렬", "-", data);

		// 람다함수를 이용해서 번호로 내림차순 정렬
		Arrays.sort(data, (s1, s2)->s2.sno-s1.sno);
		printStudetns(">>>람다함수를 이용해서 번호로 내림차순 정렬", "=", data);
		//==================================================================
		// 익명 객체를 이용해서 생년으로 오름차순 정렬
		Arrays.sort(data, new Comparator<Student>() {
			@Override
			public int compare(Student s1, Student s2) {
				return s1.sbirth-s2.sbirth;
			}
		});
		printStudetns(">>>익명 객체를 이용해서 생년으로 오름차순 정렬", "=", data);

		// 앞 코드를 참고해서 구현
		
		// 람다함수를 이용해서 생년으로 내림차순 정렬
		

		// 앞 코드를 참고해서 구현
		Arrays.sort(data, (s1, s2)->s2.sbirth-s1.sbirth);
		printStudetns("람다함수를 이용해서 생년으로 내림차순 정렬", "-", data);
	}
}
