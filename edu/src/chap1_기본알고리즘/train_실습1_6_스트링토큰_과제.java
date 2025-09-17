package chap1_기본알고리즘;

import java.util.Arrays;
import java.util.StringTokenizer;

public class train_실습1_6_스트링토큰_과제 {
/*
 * StringTokenizer(input), countTokens(), hasMoreTokens(), nextToken()
 * parseDouble(stringArray[i])
 */
  

  
    public static void main(String[] args) {
        String msg = "3.24 3.34156 1141.56 214. 0.0314156 54.12f";
        
        // 실수를 문자열로 추출하고 정렬 후 출력
        String[] sortedStringArray = extractSortStrings(msg);
        System.out.println("정렬 스트링 배열:");
        printStringArray(sortedStringArray);
        
        // 문자열 배열을 실수 배열로 변환하고 정렬 후 출력
        double[] sortedDoubleArray = convertSortToDouble(sortedStringArray);
        System.out.println("정렬 실수 배열:");
        printDoubleArray(sortedDoubleArray);
    }

	private static void printDoubleArray(double[] sortedDoubleArray) {
	// TODO 자동 생성된 메소드 스텁
		for (int i = 0; i < sortedDoubleArray.length; i++) {
			System.out.print(sortedDoubleArray[i] + " ");
		}
		System.out.println();
}

	private static double[] convertSortToDouble(String[] sortedStringArray) {
		// TODO 자동 생성된 메소드 스텁
		double[] d = new double[sortedStringArray.length];
		for (int i = 0; i < d.length; i++) {
			d[i] = Double.parseDouble(sortedStringArray[i]);
		}
		Arrays.sort(d);
		return d;
	}

	private static void printStringArray(String[] sortedStringArray) {
		for (int i = 0; i < sortedStringArray.length; i++) {
			System.out.print(sortedStringArray[i] + " ");
		}
		System.out.println();
	
}

	private static String[] extractSortStrings(String msg) {
		// TODO 자동 생성된 메소드 스텁
		StringTokenizer tk = new StringTokenizer(msg, " ");
		String[] a = new String[tk.countTokens()];
		int i=0;
		while(tk.hasMoreTokens()) {
			a[i]=tk.nextToken();
			i++;
		}
		Arrays.sort(a);
		return a;
	}
}
