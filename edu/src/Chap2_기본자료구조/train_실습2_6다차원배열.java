package Chap2_기본자료구조;

/*
 * 3번째 실습
 * 교재 83 - 배열 처리 + function parameter 전달 숙달 훈련 
 *  함수에서 배열을 리턴할 때 리턴 타입 정의할 수 있어야 한다
 */

import java.util.Random;

public class train_실습2_6다차원배열 {

	public static void main(String[] args) {
		int[][] A = new int[2][3];
		int[][] B = new int[3][4];
		int[][] C = new int[2][4];

		inputData(A);
		inputData(B);
		int[][] D = A.clone();// 교재83 - 배열 복제
		System.out.println("A[2][3] = ");
		showData("행렬 A", A);
		System.out.println("D[2][3] = ");
		showData("행렬 D", D);
		System.out.println();
		System.out.println("B[3][4] = ");
		showData("행렬 B", B);
		int[][] E = addMatrix(A, D);
		System.out.println("E[2][3] = ");
		showData("행렬 E", E);
		C = multiplyMatrix(A, B);
		System.out.println("C[2][4] = ");
		showData("행렬 C", C);

		int[][] F = transposeMatrix(D);
		System.out.println("F[3][2] = ");
		showData("행렬 F", F);
		C = multiplyMatrixTransposed(A, F);
		showData("행렬 곱셈 결과-전치행렬 사용", C);
		boolean result = equals(A, C);
		if (result)
			System.out.println("행렬 A,C는 equal이다");
		else
			System.out.println("행렬 A,C는 equal 아니다");
	}

	private static boolean equals(int[][] a, int[][] c) {
		// TODO 자동 생성된 메소드 스텁

		if (a[0].length != c[0].length || a.length != c.length) {
			return false;
		}

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				if (a[i][j] != c[i][j]) {
					return false;
				}
			}
		}
		return true;

	}

	private static int[][] multiplyMatrixTransposed(int[][] a, int[][] f) {
		// TODO 자동 생성된 메소드 스텁

		int[][] res = multiplyMatrix(a, f);
		res = transposeMatrix(res);
		return res;
	}

	private static int[][] transposeMatrix(int[][] b) {
		// TODO 자동 생성된 메소드 스텁

		int[][] res = new int[b[0].length][b.length];
		for (int i = 0; i < b[0].length; i++) {
			for (int j = 0; j < b.length; j++) {

				res[i][j] = b[j][i];

			}
		}

		return res;

	}

	private static int[][] multiplyMatrix(int[][] a, int[][] b) {
		// TODO 자동 생성된 메소드 스텁
		int[][] res = new int[a.length][b[0].length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b[0].length; j++) {
				for (int j2 = 0; j2 < a[0].length; j2++) {
					res[i][j] += a[i][j2] * b[j2][j];
				}
			}
		}
		return res;
	}

	private static int[][] addMatrix(int[][] a, int[][] d) {
		// TODO 자동 생성된 메소드 스텁
		int[][] res = new int[a.length][a[0].length];
		for (int i = 0; i < d.length; i++) {
			for (int j = 0; j < d[0].length; j++) {
				res[i][j] = a[i][j] + d[i][j];
			}
		}
		return res;
	}

	private static void showData(String string, int[][] a) {
		// TODO 자동 생성된 메소드 스텁
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				System.out.print(a[i][j] + "\t");
			}
			System.out.println();
		}

	}

	private static void inputData(int[][] a) {
		// TODO 자동 생성된 메소드 스텁
		Random rd = new Random();
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				a[i][j] = rd.nextInt(0, 10);
			}
		}
	}

}
