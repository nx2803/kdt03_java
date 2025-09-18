package Chap2_기본자료구조;
/*
 * 2장 - 정수 배열 정렬
 */

//교재 67 - 실습 2-5
//2번 실습
import java.util.Random;
import java.util.Arrays;

public class train_실습2_5정수배열정렬 {

	public static void main(String[] args) {
		int[] data = new int[10];
		inputData(data); // 난수를 10 ~ 60 사이에 생성
		showData("난수 입력", data);
		/*
		 * sortData(data); showData("정렬후", data);
		 */
		reverse(data);// 역순으로 재배치 - 정렬 아님
		showData("역순 재배치", data);

		reverseSort(data);// 역순으로 재배치 - 정렬
		showData("역순 정렬후", data);
		sortData(data);
		int realData[] = { 5, 15, 99 };
		for (int newData : realData) {
			int[] result = insertData(data, newData);// 입력 실수보다 큰 숫자를 우측으로 이동
			System.out.print("\n\n" + newData + " : ");
			showData("실수 삽입후", result);
		}
	}

	private static void sortData(int[] data) {
		// TODO 자동 생성된 메소드 스텁
		Arrays.sort(data);
	}

	private static void reverseSort(int[] data) {
		// TODO 자동 생성된 메소드 스텁
		Arrays.sort(data);
		reverse(data);

	}

	private static void reverse(int[] data) {
		// TODO 자동 생성된 메소드 스텁
		int[] r = new int[data.length];
		for (int j = 0; j < data.length; j++) {

			r[j] = data[r.length - j - 1];
		}
		for (int j = 0; j < data.length; j++) {
			data[j] = r[j];
		}
	}

	private static void showData(String string, int[] data) {
		// TODO 자동 생성된 메소드 스텁
		System.out.print(string + ": ");
		for (int j = 0; j < data.length; j++) {
			System.out.print(data[j] + " ");
		}
	}

	static void inputData(int[] data) {
		// TODO 자동 생성된 메소드 스텁
		Random rnd = new Random(11);
		for (int i = 0; i < data.length; i++) {
			data[i] = rnd.nextInt(10, 61);
		}

	}

	/*
	 * 난이도가 매우 높은 알고리즘 구현 정렬된 기존 배열에 임의 값을 추가하는 알고리즘 > 새 배열의 크기는 기존 배열보다 +1로 만들고 기존
	 * 배열을 copy할 때 삽입된 값이 중간에 들어가는 알고리즘 구현하기 O(n) 알고리즘으로 구현
	 */
	static int[] insertData(int[] data, int value) {// insert되는 실수 값이 insert될 위치를 찾아 보다 큰 값은 우측으로 이동
		int newData[] = new int[data.length + 1];
		int i = 0;
		boolean m = false;
		for (i = 0; i < data.length; i++) {

			if (data[i] > value) {
				newData[i] = value;
				m=true;
				break;
			}
			newData[i] = data[i];
		}
		if (!m) {
			newData[newData.length - 1] = value;
		}
		for (int j = i; j < data.length; j++) {
			newData[j + 1] = data[j];
		}
		return newData;
	}

}
