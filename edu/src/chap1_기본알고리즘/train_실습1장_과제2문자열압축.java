package chap1_기본알고리즘;

import java.util.StringTokenizer;

/*
* 문자열에서 연속해서 반복되는 문자를 해당 문자와 반복 횟수로 압축요. 
* 단, 압축한 문자열이 원래 문자열보다 작아야 한다.
* 
* 입력: "aabcccccaaa"
* 압축 결과: "a2b1c5a3" (단, 길이 비교 후 결정)
*
* StringBuilder:
* 내부 버퍼를 사용하여 문자열을 직접 수정할 수 있다.
* 객체 자체를 변경하기 때문에 반복적인 문자열 조작에 효율적
*/
public class train_실습1장_과제2문자열압축 {

	public static void main(String[] args) {
		String input = "aabcccccaaa";
		System.out.println("압축 결과: " + compress(input));
	}

	private static String compress(String input) {
		// TODO 자동 생성된 메소드 스텁
		StringBuilder b = new StringBuilder();
		int count = 1;
		for (int i = 1; i < input.length(); i++) {
			if (input.charAt(i) == input.charAt(i - 1)) {
				count++;
			} else {
				b.append(input.charAt(i - 1));
				b.append(count);
				count = 1;
			}
		}
		b.append(input.charAt(input.length() - 1));
		if (count > 1) {
			b.append(count);
		}
		String r = new String(b);
		return r;
	}
}
