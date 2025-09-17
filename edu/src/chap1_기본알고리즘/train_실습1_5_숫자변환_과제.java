package chap1_기본알고리즘;

import java.util.Arrays;

public class train_실습1_5_숫자변환_과제 {
/*
 * split(" ")
 * parseInt(stringArray[i])
 */

    public static void main(String[] args) {
        String input = "12 111 911 921 94 23 214 222";
        
        // 문자열 배열 정렬 및 출력
        String[] sortedStringArray = splitSortString(input);
        System.out.println("Sorted String Array:");
        printStringArray(sortedStringArray);
        
        // 문자열 배열을 정수 배열로 변환 및 정렬 후 출력
        int[] sortedIntArray = convertSortToIntArray(sortedStringArray);
        System.out.println("Sorted Integer Array:");
        printIntArray(sortedIntArray);
    }

	private static void printIntArray(int[] sortedIntArray) {
	// TODO 자동 생성된 메소드 스텁
		for (int i = 0; i < sortedIntArray.length; i++) {
			System.out.print(sortedIntArray[i] + " ");
		}
		System.out.println();
}

	private static void printStringArray(String[] sortedStringArray) {
	// TODO 자동 생성된 메소드 스텁
		for (int i = 0; i < sortedStringArray.length; i++) {
			System.out.print(sortedStringArray[i] + " ");
		}
		System.out.println();
	
}

	private static int[] convertSortToIntArray(String[] sortedStringArray) {
		// TODO 자동 생성된 메소드 스텁
		int[] s = new int[sortedStringArray.length];
		for (int i = 0; i < sortedStringArray.length; i++) {
			s[i] = Integer.parseInt(sortedStringArray[i]);
		}
		Arrays.sort(s);
		return s;
	}

	private static String[] splitSortString(String input) {
		// TODO 자동 생성된 메소드 스텁
		String[] a = input.split(" ");
		Arrays.sort(a);
		return a;
	}
}
