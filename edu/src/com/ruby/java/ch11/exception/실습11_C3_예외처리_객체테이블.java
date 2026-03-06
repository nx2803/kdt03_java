package com.ruby.java.ch11.exception;

import java.util.Arrays;

/*
 * 1. public class Exception extends Throwable {}
 * 2. public class Throwable implements java.io.Serializable {
 *      // 예외의 원인을 설명하는 메시지
 *      private String detailMessage;
 *    }
 * 3. 자바의 예외 객체는 제네릭(Generic)이 지원되지 않는다.
 *   -> 제네릭이 컴파일 시점에 타입 안정성을 보장하기 위해 설계
 *   -> 예외 객체는 런타임에 발생하고, 
 *      런타임 시점에 제네릭 타입 정보가 소실되기 때문이다.

 */
class TableOverflowException extends Exception {
	public TableOverflowException(String message) {
		super(message);
	}
}

class TableUnderflowException extends Exception {
	public TableUnderflowException(String message) {
		super(message);
	}
}

class TableManager {
	private Object[] table;
	private int size;
	private int capacity;

	public TableManager(int capacity) {
		this.capacity = capacity;
		this.table = new Object[capacity];
		this.size = 0;
	}

	public void add(Object item) throws TableOverflowException {
		if (size >= capacity) {
			throw new TableOverflowException("테이블이 꽉 찼습니다. 더 이상 추가할 수 없습니다.");
		}
		table[size++] = item;
		System.out.println("객체 추가 성공: " + item.toString());
	}

	public Object remove() throws TableUnderflowException {
		if (size <= 0) {
			throw new TableUnderflowException("테이블이 비어 있습니다. 제거할 객체가 없습니다.");
		}
		Object removedItem = table[--size];
		table[size] = null; // 객체 참조 해제
		System.out.println("객체 제거 성공: " + removedItem.toString());
		return removedItem;
	}

	public int getSize() {
		return size;
	}
}

public class 실습11_C3_예외처리_객체테이블 {
	public static void main(String[] args) {
		Arrays.sort(args);
		TableManager manager = new TableManager(3);

		// 1. 오버플로우 예제
		System.out.println("--- 오버플로우 테스트 ---");
		try {
			manager.add("객체1");
			manager.add("객체2");
			manager.add("객체3");
			manager.add("객체4"); // 여기서 TableOverflowException 발생
		} catch (TableOverflowException e) {
			System.err.println("에러 발생: " + e.getMessage());
		}

		System.out.println("\n현재 테이블 크기: " + manager.getSize());

		// 2. 언더플로우 예제
		System.out.println("\n--- 언더플로우 테스트 ---");
		try {
			manager.remove();
			manager.remove();
			manager.remove();
			manager.remove(); // 여기서 TableUnderflowException 발생
		} catch (TableUnderflowException e) {
			System.err.println("에러 발생: " + e.getMessage());
		}

		System.out.println("\n현재 테이블 크기: " + manager.getSize());
	}
}
