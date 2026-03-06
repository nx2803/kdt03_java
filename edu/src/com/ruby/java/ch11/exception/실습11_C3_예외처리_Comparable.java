package com.ruby.java.ch11.exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Employee implements Comparable<Employee> {
	private String name;
	private int salary;

	public Employee(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public int getSalary() {
		return salary;
	}

	@Override
	public String toString() {
		return "Employee{" + "name='" + name + '\'' + ", salary=" + salary + '}';
	}

	@Override
	public int compareTo(Employee other) {
		// 급여를 기준으로 비교 (오름차순 정렬)
		// 이 객체의 급여가 다른 객체보다 작으면 음수, 같으면 0, 크면 양수 반환
		return Integer.compare(this.salary, other.salary);
	}
}

public class 실습11_C3_예외처리_Comparable {
	public static void main(String[] args) {
		
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee("Alice", 50000));
		employees.add(new Employee("Bob", 75000));
		employees.add(new Employee("Charlie", 45000));
		employees.add(new Employee("David", 60000));
		

		System.out.println("정렬 전: " + employees);

		// Employee 클래스가 Comparable을 구현했기 때문에 자연스럽게 정렬 가능
		//Collections.sort() 메서드의 signature는
		//public static <T extends Comparable<? super T>> void sort(List<T> list) 
		Collections.sort(employees);
		//Collections.sort(null);

		System.out.println("급여 오름차순 정렬 후: " + employees);
		
		
		Employee [] arr = new Employee[4];
		arr[0] = new Employee("을지문덕", 50000);
		arr[1] = new Employee("홍길동", 750000);
		arr[2] = new Employee("강감찬", 450000);
		arr[3] = new Employee("계백", 650000);
		for (Employee e: arr)
			System.out.println(e + " ");
		Arrays.sort(arr);
		for (Employee e: arr)
			System.out.println(e + " ");
		/*
		 * Arrays.sort(Object[] a)는 Employee[] 배열을 Object[]로 받는다
		 * 내부적으로는 실제 객체의 타입(Employee)에 따라 compareTo() 메서드를
		 * 호출하는 동적바인딩이 적용(polymorphism)
		 */
	}
}
