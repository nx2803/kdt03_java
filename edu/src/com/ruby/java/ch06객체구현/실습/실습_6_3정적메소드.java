package com.ruby.java.ch06객체구현.실습;

class Student_ss {
	// 필드
	/*
	 * name, age, subjects[], scores[], passFail[], count를 private으로 선언 count는 배열의
	 * index로 사용 numberStudents를 정적 필드로 선언
	 */
	private String name;
	private int age;
	private String subjects[];
	private int scores[];
	private int passFail[];
	private int count;
	private static int numberStudents;

	// 생성자
	/*
	 * name, age, subjects[], scores[], passFail[], count를 매개변수로 전달받는 생성자 정의
	 * 
	 */
	public Student_ss(String name, int age, String subjects[], int scores[], int passFail[], int count) {
		this.name = name;
		this.age = age;
		this.subjects = subjects;
		this.scores = scores;
		this.passFail = passFail;
		this.count = count;
		numberStudents++;
	}
	// setter 메소드: setName(String name), setAge(int age), setSubjects(String
	// subjects[]), setScores(int scores[]), setCount(int num)

	// 학생 수를 반환하는 정적 메소드getNumberStudents()
	public static int getNumberStudents() {
		return numberStudents;
	}

	// 학생 정보를 출력하는 메소드 (예시용)
	public void printStudent() {
		/*
		 * 이름 = **, 나이 = ** 과목1 = **, 점수1 = ** 과목2 = **, 점수2 = ** ... 등으로 출력
		 */
		System.out.println("이름 = " + name + ", 나이 = " + age + " ");
		for (int i = 0; i < subjects.length; i++) {
			System.out.println(", 과목" + (i + 1) + " = " + subjects[i] + ", 점수" + (i + 1) + " = " + scores[i]);
		}

	}

	// 학생 정보를 출력하는 메소드 (예시용)
	public void printStudentInfo() {
		/*
		 * 이름 = **, 나이 = ** 과목1 = **, 점수1 = **, 통과여부=pass 과목2 = **, 점수2 = **, 통과여부=fail
		 * ... 등으로 출력
		 */
		System.out.println("이름 = " + name + ", 나이 = " + age + " ");
		for (int i = 0; i < subjects.length; i++) {
			System.out.print(", 과목" + (i + 1) + " = " + subjects[i] + ", 점수" + (i + 1) + " = " + scores[i] + ", 통과여부=");
			if (scores[i] >= passFail[i]) {
				System.out.println("pass");
			} else {
				System.out.println("fail");
			}
		}
	}

	// 통과 여부 (모든 과목을 통과했는지 확인)
	public boolean isPassed() {
		// 주어진 학생이 모든 과목 통여 여부를 반환
		int x = 0;
		for (int i = 0; i < passFail.length; i++) {
			if (scores[i] < passFail[i]) {
				x++;
			}
		}
		if (x > 0) {
			return false;
		}
		else
			return true;
		
	}

	// 6.2.2 각 학생의 성적 테이블을 출력하는 정적 메소드
	public static void printAllStudents(Student_ss[] students) {
		// 학생 이름 + 과목명, 과목 점수 .... + 과목통과여부:pass or fail
		for (int i = 0; i < students.length; i++) {
			System.out.println("이름 = " + students[i].name + ", 나이 = " + students[i].age + " ");
			for (int j = 0; j < students[i].subjects.length; j++) {
				System.out.print("과목" + (j + 1) + " = " + students[i].subjects[j] + ", 점수" + (j + 1) + " = " + students[i].scores[j] + ", 통과여부=");
				if (students[i].scores[j] >= students[i].passFail[j]) {
					System.out.println("pass");
				} else {
					System.out.println("fail");
				}
			}
		}
	}

	// 6.2.2 과목별 최대/최소 점수 및 해당 학생을 출력하는 정적 메소드
	public static void printSubjectStats(Student_ss[] students) {
		int[] max = {students[0].scores[0], students[0].scores[0], students[0].scores[0], students[0].scores[0], students[0].scores[0]};
		String[] maxname = {students[0].name, students[0].name, students[0].name, students[0].name, students[0].name};
		int[] min = {students[0].scores[0], students[0].scores[0], students[0].scores[0], students[0].scores[0], students[0].scores[0]};
		String[] minname = {students[0].name, students[0].name, students[0].name, students[0].name, students[0].name};
		for (int i = 0; i < students.length; i++) {
			for (int j = 0; j < students[0].subjects.length; j++) {
				if (students[i].scores[j] > max[i]) {
					max[i] = students[i].scores[j];
					maxname[i] = students[i].name;
				}
				if (students[i].scores[j] < min[i]) {
					min[i] = students[i].scores[j];
					minname[i] = students[i].name;
				}
			}
		}
		for (int i = 0; i < min.length; i++) {
			System.out.println(students[i].subjects[i]+" 최고점수 : "+max[i]+", 이름 : " +maxname[i]+", 최저점수 : "+min[i]+", 이름 : "+minname[i]);
		}
	}
}

public class 실습_6_3정적메소드 {
	public static void main(String[] args) {
		String[] subjects = {"수학", "국어", "영어", "과학", "역사"};
		int []passFails = {40,70,60,55,80};
		Student_ss[] students = { 
				
				
////				   생성자를 사용하여 객체 생성
				   new Student_ss("홍길동", 21, subjects, new int[]{85, 90, 78, 88, 92},passFails, -1), 
				   new Student_ss("김유신", 22, subjects, new int[]{75, 80, 85, 90, 95}, passFails,-1),
				   new Student_ss("계백", 23, subjects, new int[]{65, 70, 75, 80, 85}, passFails,-1),
				   new Student_ss("강감찬", 24, subjects, new int[]{95, 92, 88, 84, 91}, passFails,-1),
				   new Student_ss("을지문덕", 25, subjects, new int[]{88, 76, 85, 79, 90}, passFails,-1)		 
		};
		// 학생 수를 정적 메소드 호출로 처리
		int ns = Student_ss.getNumberStudents();
		System.out.println(ns);
		// 학생 정보 출력 (예시)
		//showStudents(students);

		// 각 학생의 성적 테이블 출력
		Student_ss.printAllStudents(students);

		// 과목별 최대/최소 점수 및 해당 학생 출력
		Student_ss.printSubjectStats(students);
		}
}
