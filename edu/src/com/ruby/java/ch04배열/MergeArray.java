package com.ruby.java.ch04배열;

import java.util.Random;

public class MergeArray {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		Random rd = new Random();
		int A[] = new int[5];
		int B[] = new int[5];
		int C[] = new int[A.length + B.length];
		for (int i = 0; i < A.length; i++) {
			A[i] = rd.nextInt(100);
			B[i] = rd.nextInt(100);
		}
		for (int i = 0; i < A.length; i++) {
			C[i * 2] = A[i];
			C[i * 2 + 1] = B[i];
		}
		System.out.print("A : ");
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.print("\nB : ");
		for (int i = 0; i < B.length; i++) {
			System.out.print(B[i] + " ");
		}
		System.out.print("\nC : ");
		for (int i = 0; i < C.length; i++) {
			System.out.print(C[i] + " ");
		}

	}

}
