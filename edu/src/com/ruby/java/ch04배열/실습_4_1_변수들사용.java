package com.ruby.java.ch04배열;
/*
 * 배열 사용없이 변수 5개를 사용하여 5명 점수의 평균 구하기
 * int score1,score2,score3, score4, score5;
 */
public class 실습_4_1_변수들사용 {
	public static void main(String[] args) {
		
		int sc1 = 49;
		int sc2 = 91;
		int sc3 = 87;
		int sc4 = 67;
		int sc5 = 73;
		//5명 점수를 score1 등의 변수로 초기화: 49, 91, 87, 67, 73
		
		int sum = sc1+sc2+sc3+sc4+sc5;
		double avg = (double)sum /5;
		int min = sc1;
		int max = sc1;
		if (sc2 > max) {
			max = sc2;
		}
		else if (sc2 < min)
			min = sc2;
		if(sc3 > max) {
			max = sc3;
		}
		else if(sc3 < min)
			min = sc3;
		if(sc4 > max)
			max = sc4;
		else if(sc4 < min)
			min = sc4;
		if(sc5 > max)
			max = sc5;
		else if(sc5 < min)
			min = sc5;
		
		System.out.println("max = "+max+" min = "+min+" avg = "+avg);	
		
	}
	//최대 점수, 최소 점수, 평균 점수 계산하는 코드 구현
}
