package com.ruby.java.ch06객체구현;

public class StaticBlockTest_3회차 {
	/*
	 * main() 실행되기 전에 1번 실행된다
	 */
	static {
		System.out.println("hello");
		System.out.println("java");
	}

	public static void main(String[] args) {
		System.out.println("world!!");
	}

	/*
	 * 데이터베이스 연결 설정을 위한 static block의 사용
	 * 
	 * 프로그램이 시작될 때 단 한 번만 데이터베이스 연결 드라이버를 로드해야 할 때 사용
	 * 인스턴스를 생성할 때마다 드라이버를 로드하는 불필요한 작업을 피할 수 있다.
	 */
	static {
		try {
			// JDBC 드라이버 로드
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("데이터베이스 드라이버가 성공적으로 로드되었습니다.");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
