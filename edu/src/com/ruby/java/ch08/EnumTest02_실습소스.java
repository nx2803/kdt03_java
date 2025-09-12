package com.ruby.java.ch08;
/*
 * enum 클래스에 대하여 아래 코드를 학습하는 것이 중요하다
 * 자료구조 코딩을 위해 사전 학습으로 꼭 필요
 * enum 클래스의 생성자는 언제 호출되는가? 이해가 필요 
 */
import java.util.Scanner;

//자료구조시에 사용
enum Mandarin {
	금귤(600), 한라봉(500), 레드향(300), 천혜향(400), 황금향(800);//Mandarin 클래스의 객체들
	//enum의 각 상수(예: 금귤, 한라봉)는 사실 해당 enum 클래스의 public static final 객체 인스턴스
/*
 *     // enum 상수 → 정적(static) 상수(final 객체) > 싱글턴/singleton 객체라 한다 
 *     싱글턴 패턴은 소프트웨어 디자인 패턴 중 하나로, 특정 클래스의 인스턴스가 단 하나만 존재하도록 보장하고, 
 *     그 유일한 인스턴스에 대한 전역적인 접근점을 제공하는 것을 목표
 *     싱글턴 사용: 데이터베이스연결
 *     
 *     소프트웨어 디자인 패턴 > 생성패턴 > 싱글턴 + 팩토리 메소드 + 추상 팩토리 등
 *           "           > 구조패턴 > 어댑터 + 데코레이터 + facade
 *           "           > 행동패턴 > observer + strategy + template method
 *           
    public static final Mandarin 금귤 = new Mandarin("금귤", 0, 600);
    public static final Mandarin 한라봉 = new Mandarin("한라봉", 1, 500);
    public static final Mandarin 레드향 = new Mandarin("레드향", 2, 300);

 */
	private int price;
	//enum의 생성자: enum 상수마다 생성자를 호출하여 초기화한다 - enum 객체가 처음 만들어질 때 호출된다
	/*
	 * enum의 각 상수(예: 금귤, 한라봉 등)는 static final 객체처럼 동작
	 * enum이 처음 로드될 때, 내부적으로 모든 enum 상수가 인스턴스로 생성
	 * 클래스가 로드되면 enum 내부의 상수(즉, 금귤, 한라봉, 레드향, 천혜향, 황금향)들이 한 번만 생성자(Mandarin(int p))를 호출하여 초기화
	 */
	Mandarin(int p) {
		price = p;
		System.out.println("enum 생성자 실행:: price = " + price);
	}

	int getPrice() {
		return price;
	}
	
	static Mandarin MandarinAt(int idx) {
		for (Mandarin m : Mandarin.values())
			if (m.ordinal() == idx)
				return m;
		return null;
	}
}

public class EnumTest02_실습소스 {
	static Scanner stdIn = new Scanner(System.in);
	

	static Mandarin selectMenu() {//자료구조에서 자주 사용이므로 학습 필요 
		int key;
		do {
		for (Mandarin m : Mandarin.values()) {//Mandarin m[] = Mandarin.values();와 의미가 같다 
			System.out.print(m.ordinal()+ ".");
			System.out.println(" " + m + "(" + m.getPrice()+ ")");
		}
		System.out.println("선택: ");
		key = stdIn.nextInt();
		} while(key < Mandarin.금귤.ordinal() || key > Mandarin.황금향.ordinal());
		
		return Mandarin.MandarinAt(key);
	}

	public static void main(String[] args) {
		Mandarin m[] = Mandarin.values();//Mandarin의 생성자를 호출하고 각 값을 생성자 함수에 전달한다.
		//values()는 static 함수로 열거된 모든 원소를 배열로 리턴
		System.out.println("시작::");
		//Mandarin m;//생성자를 호출하지 않는다
		//Mandarin m2 = new Mandarin(100);//생성자를 호출할 수 없다 - 주의점 
		//enum은 미리 정의된, 고정된 개수의 인스턴스만을 가지도록 설계되었기 때문이다 
		//*
		/*
		 * main() 메서드에서 enum 상수에 최초로 접근하는 시점에 생성자들이 호출.
		 * Mandarin.values() 또는 Mandarin.한라봉 등이 처음 호출되는 그 순간에 
		 * 모든 enum 상수들의 생성자가 한꺼번에 호출.
		 */
		Mandarin ma = Mandarin.한라봉;//enum 클래스 생성자가 호출된다 
		System.out.println(ma.toString());
		System.out.println("===enum 객체 생성전===");
		System.out.println("황금향과 비교: "+ ma.compareTo(Mandarin.레드향));
		Mandarin m2	= Mandarin.금귤;
		Mandarin ma2 = Mandarin.valueOf("레드향");
		System.out.println(ma2);

		Mandarin list[] = Mandarin.values();
		System.out.println("== 귤의 종류 ==");
		for (Mandarin m3 : list)
			System.out.println(m3 + ":" + m3.getPrice());
			
			//*/
		Mandarin mSelected = selectMenu();
		System.out.println(mSelected + ":selectedMenu:" + mSelected.getPrice());
	}
}