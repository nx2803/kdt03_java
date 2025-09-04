package com.ruby.java.ch04배열;

import java.util.Random;

/*
 * 배열 사용, 난수로 입력된 10명의 성적 평균 구하기
 * Random rd =new Random();
 * score[i] = rd. nextInt(100);//0 ~ 99 정수 생성
 * 
 * 10명 학생의 학점 출력:
 *    ~90 A, ~80 B, ~70 C, ~60 D, 59~ F
 *    출력은 "99점 - A 학점" 등으로 출력한다.
 */
public class 실습_4_3_배열_점수평균 {
	public static void main(String[] args) {
		int score[] = new int[10];
		Random rd = new Random();
		for (int i = 0; i < score.length; i++) {
			score[i] = rd. nextInt(100);
		}
		int sum=0;
		double avg;
		String grade[] = new String[10];
		for (int i = 0; i < grade.length; i++) {
			if (score[i]>=90) {
				grade[i] = "A";
			}
			else if (score[i] >= 80) {
				grade[i] = "B";
			}
			else if (score[i] >= 70) {
				grade[i] = "C";
			}
			else if (score[i] >= 60) {
				grade[i] = "D";
			}
			else if (score[i] < 59) {
				grade[i] = "F";
			}
			sum += score[i];
		}
		for (int i = 0; i < score.length; i++) {
			System.out.println(score[i]+"점 - "+grade[i]+" 학점");
		}
		avg = (double)sum/10;
		System.out.println("평균 : "+avg+"점");
	}


}
