//함수에 throw절을 추가하는 경우 - 함수내에서 throw할 수 있고 
//호출하는 코드에서 예외를 반드시 처리해야 한다
package com.ruby.java.ch11.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Test04_실습대상 {
	public static void c() throws Exception {
		System.out.println("c():: 실행");
		throw(new Exception());
	}
	public static void b() throws Exception {
		try {
			c();
			c();

		}catch(Exception e) {
			System.out.println("C():: 예외처리");
		}

	}
	/*
	 * FileInputStream은 클래스 정의시에 throw() 명시됨 - 교재 설명 참조
	 * try catch 블록으로 해결하거나 throw를 함수명에 명시가 필요 
	 */
	//*
	public static void main(String[] args) {
		/*
			FileInputStream fi = new FileInputStream("a.txt");//에러 발생 이유
			int c = fi.read();
			System.out.println((char) c);
		*/
		
			try {
				FileInputStream fi = new FileInputStream("a.txt");//에러 발생 이유
				int c = fi.read();
				System.out.println((char) c);

				b();
			} catch (Exception e) {
				e.printStackTrace();
			}
		 
	}
	//*/
/*
	public static void main(String[] args) throws FileNotFoundException, IOException {
		//해결 방법2
		FileInputStream fi = new FileInputStream("a.txt");
		int c = fi.read();
		System.out.println((char) c);
	}
	*/
}