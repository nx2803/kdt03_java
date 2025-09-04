package edu;

public class Test36 {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		char letter = 'ㄱ';
		char[] alphabet = new char[26];
		for (int i = 0; i < alphabet.length; i++) {
			alphabet[i] = (char)(letter + i);
		}
		for (char c : alphabet) {
			System.out.println(c);
		}
	}

}
