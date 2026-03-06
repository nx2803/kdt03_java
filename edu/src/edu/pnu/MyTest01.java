package edu.pnu;

import java.util.Scanner;

class Phone {
	String number; //010-4949-8989
	private String name; //김김동
	private String alias; //김사장
	
	private void print() {
		System.out.println(number);
	}
}

public class MyTest01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Phone phone = new Phone();
		phone.number ="010-4949-8989";
		
	}
	
}
