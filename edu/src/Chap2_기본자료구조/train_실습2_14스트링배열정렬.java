package Chap2_기본자료구조;

import java.util.Arrays;

/*
 * 2장 실습과제4 - 스트링 배열 정렬
 * 정렬된 배열에 insert하면 중간에 끼워 넣으면 큰 값들은 이동해야 하고 크기를 1 증가 처리가 필요 
 */
public class train_실습2_14스트링배열정렬 {

	public static void main(String[] args) {
		String[] data = { "apple", "grape", "persimmon", "pear", "blueberry", "strawberry", "melon", "oriental melon" };

		showData("정렬전", data);
		// Arrays.sort(data); // Internally uses String.compareTo()
		Arrays.sort(data, (s1, s2) -> s1.compareTo(s2));
		sortData(data);
		showData("정렬후", data);
		String[] newData = insertString(data, "banana");
		showData("삽입후 크기가 증가된 정렬 배열", newData);

	}

	public static void showData(String string, String[] data) {
		// TODO 자동 생성된 메소드 스텁
		System.out.print(string + ": [ ");
		for (int j = 0; j < data.length; j++) {
			System.out.print("\"" + data[j] + "\" ");
		}
		System.out.print("]");
		System.out.println("");
	}

	public static String[] insertString(String[] data, String string) {
		// TODO 자동 생성된 메소드 스텁
		String newData[] = new String[data.length + 1];
		int i = 0;
		boolean m = false;
		for (i = 0; i < data.length; i++) {

			if (string.compareTo(data[i]) < 0) {
				newData[i] = string;
				m = true;
				break;
			}
			newData[i] = data[i];
		}
		if (!m) {
			newData[newData.length - 1] = string;
		}
		for (int j = i; j < data.length; j++) {
			newData[j + 1] = data[j];
		}
		return newData;
	}

	public static void sortData(String[] data) {
		// TODO 자동 생성된 메소드 스텁
		Arrays.sort(data);

	}
}
