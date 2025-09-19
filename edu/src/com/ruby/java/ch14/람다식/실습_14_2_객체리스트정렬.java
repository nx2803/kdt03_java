package com.ruby.java.ch14.람다식;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class 실습_14_2_객체리스트정렬 {

	static void printStudetns(String msg, String rep, List<Student> data) {
		System.out.println(msg);
		for (Student st: data)
			System.out.println(st);
		if (rep.equals("-"))	System.out.println(rep.repeat(20));
		else					System.out.println(rep.repeat(35));
	}	
	
	public static void main(String[] args) {
		List<Student> data = new ArrayList<>();
		data.add(new Student(4, "홍길동", 2003));
		data.add(new Student(12, "김길동", 2000));
		data.add(new Student(22, "남길동", 2001));
		data.add(new Student(7, "정길동", 1999));
		data.add(new Student(33, "박길동", 2004));
		
		printStudetns("초기 입력 데이터", "=", data);

		//==================================================================
		// 오름차순 정렬
		//
		// 정렬 익명 객체
		Comparator<Student> compName = new Comparator<Student>(){
			@Override
			public int compare(Student s1, Student s2) {
				return (s1.sname.compareTo(s2.sname));
			}
		};
		Collections.sort(data, compName);
		printStudetns(">>>익명 객체를 이용해서 이름으로 오름차순 정렬", "-", data);

		// 익명 객체를 이용해서 번호로 오름차순 정렬
		Collections.sort(data, new Comparator<Student>() {
			@Override
			public int compare(Student s1, Student s2) {
				return s1.sno-s2.sno;
			}
		});
		printStudetns(">>>익명 객체를 이용해서 번호로 오름차순 정렬", "-", data);

		// 람다함수를 이용해서 이름으로 오름차순 정렬
		Collections.sort(data, (s1, s2)->s1.sname.compareTo(s2.sname));
		printStudetns("람다함수를 이용해서 이름으로 오름차순 정렬", "-", data);

		// 람다함수를 이용해서 년도로 오름차순 정렬
		Collections.sort(data, (s1, s2)->s1.sbirth-s2.sbirth);
		printStudetns("람다람수를 이용해서 년도로 오름차순 정렬", "=", data);

		//=================================================
		// 내림차순 정렬 구현
		
		// 익명 객체를 이용해서 이름으로 내림차순 정렬
		Comparator<Student> compName2 = new Comparator<Student>(){
			@Override
			public int compare(Student s1, Student s2) {
				return -(s1.sname.compareTo(s2.sname));
			}
		};
		Collections.sort(data, compName2);
		printStudetns("익명 객체를 이용해서 이름으로 내림차순 정렬", "-", data);
		
		// 익명 객체를 이용해서 번호로 내림차순 정렬
		Collections.sort(data, new Comparator<Student>() {
			@Override
			public int compare(Student s1, Student s2) {
				return s2.sno-s1.sno;
			}
		});
		printStudetns("익명 객체를 이용해서 번호로 내림차순 정렬", "-", data);
		
		// 람다함수를 이용해서 이름으로 내림차순 정렬
		
		Collections.sort(data, (s1, s2)->-s1.sname.compareTo(s2.sname));
		printStudetns("람다함수를 이용해서 이름으로 내림차순 정렬", "-", data);
		
		// 람다함수를 이용해서 년도로 내림차순 정렬
		Collections.sort(data, (s1, s2)->s2.sbirth-s1.sbirth);
		printStudetns("람다함수를 이용해서 년도로 내림차순 정렬", "-", data);
	}
}
