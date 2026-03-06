package com.ruby.java.ch11.exception;
/* 1. Throwable은 일반 클래스 : public class Throwable implements Serializable
 * java.lang.Object
   └── java.lang.Throwable
          ├── java.lang.Error
          └── java.lang.Exception

 * 2. throw와 catch는 자바의 **키워드(Keywords)**
 *    -> 예외 처리라는 특정 기능을 수행하기 위한 언어의 구조
 *
 */

public class Test01_실습대상 {

	public static void main(String[] args) {
		int arr2[] = new int[3];
		//arr2[3] = 0;//java.lang.ArrayIndexOutOfBoundsException:

		String st = "hello";
		st = null;
		//System.out.println(st.length());//NullPointerException:

		try {
			String s = new String("java");
			int len = s.length();
			s = null;
			s.length(); // new NullPointerException()
			int arr[] = new int[3];
			arr[3] = 30; // new ArrayIndexOutOfBoundsException()
			System.out.println("OK");
		}
		/*
		 * catch(Exception e) { //unreachable - 상위 클래스로서 모두 여기서 capture하기 때문이다
		 * e2 = e; //downcasting은 에러로 안됨
		 * System.out.println("Exception 처리"); }
		 */
		catch (ArrayIndexOutOfBoundsException e1) {
			e1.printStackTrace();// 교재 542
			System.out.println("배열 인덱스 범위 밖");
			System.out.println(e1.getMessage());// 교재 542
		} catch (NullPointerException e2) {
			e2.printStackTrace();
			System.out.println("널 포인터 예외 발생: ");
			System.out.println(e2.getMessage());
		} catch (Exception e) {// 순서상 마지막에 와야 -> 538페이지 
			System.out.println("오류 발생 : " + e);// e.toString()
			//e = e1; 또는 e = e2; 은 가능하다 upcasting 이므로 
		} finally {// try block에서 할당된 자원의 해제 처리
			//finally 블록은 try 블록에서 예외가 발생하든 안 하든 항상 실행
			// 파일 입출력(File I/O)과 같이 자원(resource)을 사용하는 작업에 사용
			System.out.println("GOOD");
		}
	}
}