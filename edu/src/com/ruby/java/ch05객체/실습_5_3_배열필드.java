package com.ruby.java.ch05객체;

class Person {
	// 필드 (private)
	/*
	 * name은 String, age는 int, weight는 float로 필드들을 private 선언 subjects을 교육과목 private
	 * 배열[10] years을 수강 연도 private 배열[10] count 필드를 사용하여 수강 과목 증가시마다 ++count
	 */
	private String name;
	private int age;
	private float weight;
	private String[] subjects = new String[10];
	private int[] years = new int[10];
	int count = 0;
	// 필드

	// 메소드
	void show() {
		// 기본 정보 출력::name=**, age=**, weight=**로 출력
		System.out.println("name= " + getName() + " age= " + getAge() + " weight= " + getWeight());
		// 교육과목 및 수강 연도 출력
		/*
		 * while 문을 사용하여 교육과목과 수강연도를 출력
		 */
		int a = 0;
		while (a < count) {
			System.out.println("subject= " + subjects[a] + "\t year= " + years[a]);
			a++;
		}
	}

	void addSubjectYear(String subject, int year) {
		// 과목, 수강연도를 매개변수로 전달받아 배열에 추가
		subjects[count] = subject;
		years[count] = year;
		++count;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}
}

public class 실습_5_3_배열필드 {

	public static void main(String[] args) {
		// 첫 번째 객체 생성 및 초기화
		Person p1 = new Person();
		// 다음 코드를 setter, addSubjectYear를 사용하여 수정
		p1.setName("홍길동");
		p1.setAge(25);
		p1.setWeight(60.56f);
//        p1.subjects = new String[] {"Mathematics", "Science", "History"};
//        p1.years = new int[] {2020, 2021, 2022};
		p1.addSubjectYear("Mathematics", 2020);
		p1.addSubjectYear("Science", 2021);
		p1.addSubjectYear("History", 2022);

		// 메소드 호출
		p1.show();

		// 두 번째 객체 생성 및 초기화
		Person p2 = new Person();
		p2.setName("강감찬");
		p2.setAge(55);
		p2.setWeight(62.34f);
//        p2.subjects = new String[] {"Literature", "Philosophy", "Physics"};
//        p2.years = new int[] {2018, 2019, 2020};
		p2.addSubjectYear("Literature", 2018);
		p2.addSubjectYear("Philosophy", 2019);
		p2.addSubjectYear("Physics", 2020);

		// 메소드 호출
		p2.show();
	}
}
