package chap1_기본알고리즘;

public class train_실습1_2문자열교체_과제 {

    // 서브스트링을 추가하는 함수
	/*
	 * concat(substring)
	 * replaceAll(target, replacement)
	 */
    

    public static void main(String[] args) {
        String s = "자바 코딩, 파이썬 코딩, C 코딩, C# 코딩";
        
        // 서브스트링 추가
        String newString = addSubstring(s, " PCCP 시험: 11월 23일");
        
        // 문자열 교체
        String finalString = replaceString(newString, "코딩", "프로그래밍 스킬");
        
        // 결과 출력
        System.out.println(finalString);
    }

	private static String replaceString(String newString, String string, String string2) {
		// TODO 자동 생성된 메소드 스텁
		return newString.replaceAll(string, string2);
	}

	private static String addSubstring(String s, String string) {
		// TODO 자동 생성된 메소드 스텁
		return s.concat(string);
		
	}
}
