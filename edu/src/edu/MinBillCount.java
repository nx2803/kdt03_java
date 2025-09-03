package edu;

import java.util.Scanner;

public class MinBillCount {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		do {
			System.out.print("가격 입력 : ");
			int a = sc.nextInt();
			a = a/1000;
			int oman;
			int ilman;
			int ochun;
			int ilchun;
			oman=a/50;
			ilman=(a-(oman*50))/10;
			ochun=(a-(oman*50)-(ilman*10))/5;
			ilchun=(a-(oman*50)-(ilman*10)-(ochun*5));
			System.out.println("필요지폐장수\n"+"5만원권 = "+oman+"장\n"+"1만원권 = "+ilman+"장\n"+"5천원권"+ochun+"장\n"+"1천원권"+ilchun+"장");
		}while(true);
		
	}
}
