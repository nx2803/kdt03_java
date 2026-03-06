package chap1_기본알고리즘;

import java.util.ArrayList;


/*
 * 주어진 긴 문자열 text에서 패턴 문자열 pattern이 등장하는 모든 시작 인덱스를 찾으세요.
 *
 * 입력: text = "abxabcabcabyabcaby", pattern = "abcaby"
 * 출력: [6,12]
 * 
 * 패턴이 나타나는 인덱스를 반환
 */
public class train_실습1장_과제3부분문자열검색 {

	public static void main(String[] args) {
		String text = "ababcabcabababd";
		String pattern = "ababd";
		searchSubstring(text, pattern);
		text = "abxabcabcabyabcaby";
		pattern = "abcaby";
		searchSubstring(text, pattern);
	}

	private static void searchSubstring(String text, String pattern) {
		// TODO 자동 생성된 메소드 스텁
		ArrayList<Integer> res = new ArrayList<Integer>();
		boolean ox = false;
		int j = 0;
		for (int i = 0; i <= text.length() - pattern.length(); i++) {
			for (j = 0; j < pattern.length(); j++) {
				if (text.charAt(i+j)!=pattern.charAt(j)) {
					break;
				}
			}
			if (j == pattern.length()) {
				res.add(i);
				ox = true;
			}
		}
		System.out.println("Text : " + text);
		System.out.println("Pattern : " + pattern);
		if (!ox) {
			System.out.println("패턴 발견 안됨");
		} else {
			System.out.println("패턴이 나타난 인덱스 : " + res);
		}
	}
}
