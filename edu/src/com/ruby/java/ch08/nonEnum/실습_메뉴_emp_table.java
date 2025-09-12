package com.ruby.java.ch08.nonEnum;

import java.util.Scanner;

/**
 * Employee 테이블(배열 기반) - 메뉴 구동 
 * 메뉴: ADD_ALL, ADD_NEW, DELETE, UPDATE, FIND, SHOWTABLE, EXIT
 */

// 직원 클래스
class Employee {
	private String name;
	private int age;

}

// 직원 테이블: 고정 길이 배열 + top(현재 개수)
class EmpTable {
	Employee[] arr;
	int top; // 현재 저장된 개수 (0..top-1 유효)

	public EmpTable(int capacity) {

	}

	public boolean isFull() {

	}

	public boolean isEmpty() {

	}

	public int size() {

	}

	public int capacity() {

	}

	// 이름으로 인덱스 찾기(대소문자 구분 없이 비교)
	public int indexOfName(String name) {

	}

	// 추가
	public boolean add(Employee e) {

	}

	// 삭제(이름으로) : 뒤 요소들을 앞으로 한 칸씩 당김
	public boolean deleteByName(String name) {

	}

	// 갱신(이름으로 찾은 뒤 이름/나이 변경)
	public boolean updateByName(String name, int newAge) {

	}

	public Employee findByName(String name) {

	}

	public void showTable() {
		if (isEmpty()) {
			System.out.println("[테이블 비어 있음]");
			return;
		}
		System.out.println("\n[직원 테이블]");
		System.out.println("--------------------------------");
		System.out.printf("%-4s %-10s %-4s%n", "번호", "이름", "나이");//%-4s는 문자열을 4칸 왼쪽 정렬
		System.out.println("--------------------------------");
		for (int i = 0; i < top; i++) {
			System.out.printf("%-4d %-10s %-4d%n", i, arr[i].getName(), arr[i].getAge());
		}
		System.out.println("--------------------------------");
		System.out.printf("Size: %d / Capacity: %d%n%n", size(), capacity());
	}
}

enum Menu {
	ADD_ALL, ADD_NEW, DELETE, UPDATE, FIND, SHOWTABLE, EXIT;

	// 숫자 -> Menu 매핑
	public static Menu fromInt(int n) {
		//Menu.values();//리턴 값을 확인하는것이 필요 
		if (n < 0 || n >= values().length)
			return null;
		return values()[n];
	}

	public static void printMenu() {
		System.out.println("==== 메뉴 ====");
		for (int i = 0; i < values().length; i++) {
			System.out.printf("%d) %s%n", i, values()[i]);//%n은 printf에서 사용하는 줄바꿈
		}
		System.out.print("선택: ");
	}
}
public class 실습_메뉴_emp_table {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		EmpTable table = new EmpTable(100);
		Employee arr[] = { new Employee("홍길동", 30), new Employee("강감찬", 45), 
				new Employee("김유신", 40),new Employee("이순신", 47), 
				new Employee("계백", 42) };
		while (true) {
			Menu.printMenu();
			int choice = sc.nextInt();
			Menu menu = Menu.fromInt(choice);
		
			/*
			if (choice == menu)
				System.out.println(choice + " == " +  menu);
				*/
			//Menu menu = choice;
			System.out.println("choice = " + choice);
			System.out.println("menu = " + menu);
			if (menu == null) {
				System.out.println("잘못된 선택입니다.\n");
				continue;
			}

			switch (menu) {
			case ADD_ALL:
				if (table.isFull()) {
					System.out.println("테이블이 가득 찼습니다.");
					break;
				}
				for (Employee e : arr)
					table.add(e);
				break;

			case ADD_NEW: {
				if (table.isFull()) {
					System.out.println("테이블이 가득 찼습니다.");
					break;
				}
				System.out.print("이름: ");
				String name = sc.next();
				System.out.print("나이: ");
				int age = sc.nextInt();
				boolean ok = table.add(new Employee(name, age));
				System.out.println(ok ? "추가 완료." : "추가 실패.");
				break;
			}
			case DELETE: {
				System.out.print("삭제할 이름: ");
				String name = sc.next();
				boolean ok = table.deleteByName(name);
				System.out.println(ok ? "삭제 완료." : "해당 이름이 없습니다.");
				break;
			}
			case UPDATE: {
				System.out.print("수정할 대상 이름: ");
				String target = sc.next();
				Employee found = table.findByName(target);
				if (found == null) {
					System.out.println("해당 이름이 없습니다.");
					break;
				}
				System.out.print("나이 변경값: ");
				int newAge= sc.nextInt();
				boolean ok = table.updateByName(target, newAge);
				System.out.println(ok ? "수정 완료." : "수정 실패.");
				break;
			}
			case FIND: {
				System.out.print("찾을 이름: ");
				String name = sc.next();
				Employee e = table.findByName(name);
				if (e == null)
					System.out.println("해당 이름이 없습니다.");
				else
					System.out.println("검색 결과: " + e);
				break;
			}
			case SHOWTABLE: {
				table.showTable();
				break;
			}
			case EXIT: {
				System.out.println("프로그램 종료");
				sc.close();
				return;
			}
			}

		}

	}
}
