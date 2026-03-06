package com.ruby.java.ch07.상속;
/*
 * 자바 인터페이스 사용의 주된 용도
 *  1) Polymorphism을 통한 유연성 확보
 *  2) 인터페이스는 클래스가 반드시 구현해야 할 기능들을 명세하는 역할
 *  3) 다중 상속이 필요한 상황에서 여러 인터페이스를 구현하여 상속 처리
 */
interface Messenger {
	int MIN_SIZE = 1;//컴파일러가 public static final int로 자동 변환
	public static final int MAX_SIZE = 999999;
	
	public String getMessage();//컴파일러가 public abstract를 자동 추가
	public abstract void setMessage(String msg);
	
	public default void setLogin(boolean login) {//인터페이스를 상속받는 클래스들에서 공통적으로 사용
		log();
		if (login) {
			System.out.println("로그인");
		} else {
			System.out.println("로그아웃");
		}
	}
	public static void getConnection() {//클래스의 static 메소드와 같다
		System.out.println("네트워크 연결");
	}
	private void log() {//public, abstract, default, static 만 가능
		System.out.println("start job!");
	}
}
class IPhoneMessenger implements Messenger {
	public String getMessage() {
		return "iphone";
	}
	public void setMessage(String msg) {
		System.out.println("iphone 메시지: " + msg);
	}
}
class GalaxyMessenger implements Messenger {
	public String getMessage() {
		return "galaxy";
	}
	public void setMessage(String msg) {
		System.out.println("galaxy 메시지: " + msg);
	}
}
interface WorkFile{
	public void fileUpload();
	public void fileDownload();
}
class Visualize{
	public void draw_test() {
		System.out.println("텍스트 상자");
	}
	public void draw_heattmap() {
		System.out.println("데이터를 색상/농도로 시각화");
	}
}
class GalaxyMessenger2 implements Messenger, WorkFile {
	public String getMessage() {
		return "galaxy";
	}
	public void setMessage(String msg) {
		System.out.println("galaxy 메시지: " + msg);
	}
	public void fileUpload() {
		System.out.println("file을 upload");
	}
	public void fileDownload() {
		System.out.println("file을 download");
	}
}
class GalaxyMessenger3 extends Visualize implements Messenger, WorkFile {
	public String getMessage() {
		return "galaxy";
	}
	public void setMessage(String msg) {
		System.out.println("galaxy 메시지: " + msg);
	}
	public void fileUpload() {
		System.out.println("file을 upload");
	}
	public void fileDownload() {
		System.out.println("file을 download");
	}
}
public class MessengerTest {

	public static void main(String[] args) {
		Messenger.getConnection();//static 메소드 호출
		
		Messenger iphone = new IPhoneMessenger();
		GalaxyMessenger galaxy = new GalaxyMessenger();
		
		System.out.println("메신저 최소 문자 크기" + Messenger.MIN_SIZE);
		System.out.println("메신저 최대 문자 크기" + Messenger.MAX_SIZE);
		
	    iphone.setLogin(true);
	    iphone.getMessage();
	    iphone.setMessage("hello");
	    
	    galaxy.setLogin(true);
	    galaxy.getMessage();
	    galaxy.setMessage("hello");
	    
	    GalaxyMessenger2 g2 = new GalaxyMessenger2();
	    g2.fileDownload();
	    g2.setMessage("삼성");
	    g2.getMessage();
	    
	    GalaxyMessenger3 g3 = new GalaxyMessenger3();
	    g3.fileDownload();
	    g3.setMessage("애플");
	    g3.getMessage();
	    g3.draw_heattmap();

	}

}
