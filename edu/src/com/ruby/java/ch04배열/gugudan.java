package com.ruby.java.ch04배열;

public class gugudan {

	
	public static void printVertical() {
		for (int i = 2; i < 10; i++) {
			System.out.println(i+"단");
			for (int j = 1; j < 10; j++) {
				System.out.println(i+" * "+j+" = "+i*j);
			}
			System.out.println("----------");
		}
	}
	public static void printHorizontal() {
		for (int i = 1; i < 10; i++) {
			for (int j = 2; j < 10; j++) {
				System.out.print(j+" * "+i+" = "+j*i+"\t");
			}
			System.out.println();
		}
		
	}
	public static void printColumn(int col) {
		int a=2;
		do {
			for (int i = 1; i < 10; i++) {	
				for (int j = a; j < a+col; j++) {
					if(j>9)
						break;
					System.out.print(j+" * "+i+" = "+j*i+"\t");
				}
				System.out.println();
			}
			a+=col;
			System.out.println();
		} while (a<10);
		
	}
	
	public static void main(String[] args) {	
		// TODO 자동 생성된 메소드 스텁
		//printVertical();
		//printHorizontal();
		printColumn(3);
	}

}
