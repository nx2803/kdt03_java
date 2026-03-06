package com.ruby.java.ch10.컬렉션;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/*
 * 로또 당첨 규칙:
 * 5등: 번호 3개 - 5000원
 * 4등: 번호 4개 - 5만원
 * 3등: 번호 5개 - 150만원 - 판매금액에 변동(판매금액의 12.5%)
 * 2등: 3등번호 + 보너스번호 - 3000만원 - 판매 금액에 변동, 당첨 확률: 1,300,000분의1
 * 1등: 6개 숫자 - 당첨 확률 8,000,000 분의 1, 10억 ~ 30억
 */

class Lotto1 {
	private Set<Integer> lotto;
	private Integer bonus;
	
	// 생성자에서 1~45 사이의 정수를 임의로 선택해서 lotto에 중복되지 않게 저장
	// 마지막 보너스 번호도 1개 lotto에 저장된 숫자들과 중복되지 않게 저장
	public Lotto1() {
		
		Random random = new Random();
		lotto = new HashSet<Integer>();
		for (int j2 = 0; lotto.size() < 7; j2++) {
			lotto.add(random.nextInt(45) + 1);
	}
		List<Integer> L = new ArrayList<Integer>(lotto);
		bonus = L.getLast();
		L.remove(L.getLast());
		lotto.clear();
		lotto.addAll(L);
	}
	
	

	// Getter
	public Set<Integer> getLotto() {
		return lotto;
	}
	
	public Integer getBonun() {
		return bonus;
	}

	// Lotto 번호를 ArrayList로 변환해서 Collections.sort()를 이용해서 정렬하고 출력 
	// [ 2,  7, 24, 25, 37, 42 + 40]
	@Override
	public String toString() {
		List<Integer> list = new ArrayList<>(lotto);
		Collections.sort(list);
		StringBuilder sb = new StringBuilder("[");
		for(int i = 0 ; i < list.size(); i++) {
			if (0 < i) sb.append(", ");
			sb.append(String.format("%2d", list.get(i)));
		}
		sb.append(" + " + String.format("%2d", bonus) + "]");
		
		return sb.toString();
	}
}

public class 실습_10_2_lotto당첨 {

	// Lotto 구매 횟수
	private static final int NUMBEROFLOTTO = 100000;
	
	// 구매한 Lotto 화면에 출력 여부
	private static final boolean PRINTLOTTO = true;

	// lottWin과 lotto를 비교해서 당첨여부를 확인
	// 맞춘 번호 개수를 리턴하면 된다.
	private static int hitTest(Lotto1 lottoWin, Lotto1 lotto) {
		Set<Integer> w = lottoWin.getLotto();
		Set<Integer> b = lotto.getLotto();
		int count = 0;
		for (Integer number : b) {
			if(w.contains(number)){
				count++;
			}
		}
		
		return count;
	}
	
	// 숫자를 ","가 있는 문자열로 변환
	public static String formatString(int number) {
		NumberFormat nf = NumberFormat.getInstance();
		return nf.format(number);
	}

	public static void main(String[] args) {

		// Lotto 당첨번호 생성
		Lotto1 lottoWin = new Lotto1();
		if (!PRINTLOTTO)	System.out.println(lottoWin.toString());

		int[] win = new int[5];
		int[] money = { 1000000000, 30000000, 1500000, 50000, 5000 };
		
		// NUMBEROFLOTTO 개수 만큼 Lotto를 생성해서 lottoWin과 같은지 검사
		for(int i = 1 ; i <= NUMBEROFLOTTO ; i++ ) {
			if (PRINTLOTTO)	System.out.print(i + lottoWin.toString() + " : ");
			Lotto1 lotto = new Lotto1();
			if (PRINTLOTTO)	System.out.print(lotto.toString() + " => ");

			int hitCount = hitTest(lottoWin, lotto);
			switch(hitCount) {
			case 6:
				win[0]++;
				if (PRINTLOTTO)	System.out.print("축! 1등 당첨~~~~");
				break;
			case 5:
				if (lottoWin.getBonun() == lotto.getBonun()) {
					win[1]++;
					if (PRINTLOTTO)	System.out.print("축! 2등 당첨~~~~");
				}
				else {
					win[2]++;
					if (PRINTLOTTO)	System.out.print("축! 3등 당첨~~~~");
				}
				break;
			case 4:
				win[3]++;
				if (PRINTLOTTO)	System.out.print("축! 4등 당첨~~~~");
				break;
			case 3:
				win[4]++;
				if (PRINTLOTTO)	System.out.print("축! 5등 당첨~~~~");
				break;
			default:
				if (PRINTLOTTO)	System.out.print("꽝! 다음 기회에~");
				break;
			}
			if (PRINTLOTTO)	System.out.println();
		}
		System.out.println("-".repeat(80));
		System.out.println("시도횟수 : " + NUMBEROFLOTTO + " ==> 투자금 : " + formatString(NUMBEROFLOTTO*1000) + "원");
		System.out.println("-".repeat(80));
		int total = 0;
		for (int j = 0 ; j < 5 ; j++) {
			System.out.print((j+1)+ "등 당첨 횟수 : " + win[j]);
			System.out.println(" ==> 당첨금 : " + formatString(win[j] * money[j]) + "원");
			total += win[j] * money[j];
		}
		System.out.println("-".repeat(80));
		System.out.println(" ==> 당첨금 총액 : " + formatString(total));
		System.out.println(" ==> 총 수익 : " + formatString(total-(NUMBEROFLOTTO*1000)));
		
	}
}