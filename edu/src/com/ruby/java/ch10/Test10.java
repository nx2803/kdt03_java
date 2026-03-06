package com.ruby.java.ch10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class Test10 {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		lotto_generator(5);
	}

	private static void lotto_generator(int i) {
		// TODO 자동 생성된 메소드 스텁
		Random number = new Random();
		HashSet<Integer> lotto = null;
		for (int j = 0; j < i; j++) {
			
			lotto = new HashSet<Integer>();
			
			for (int j2 = 0; lotto.size()<6; j2++) {
				lotto.add(number.nextInt(45)+1);
			}
			
			List<Integer> L = new ArrayList<Integer>(lotto);
			Collections.sort(L);
			System.out.println(L);
		}
	}

}
