
package com.ruby.java.ch09.기본API;
/*
 * mutable 객체 - StringBuilder
 * immutable 객체를 구분해야 한다 
 */
public class Test09_실습대상 {
	public static void main(String[] args) {
		String st = "hello";
		String st2 = st + "good";
		
		System.out.println("st2 = " + st2);
		StringBuilder sb = new StringBuilder("날이 좋아서 ");

		System.out.println(sb);
		//String s2 = sb.append("날이 적당해서");
		StringBuilder sb2 = sb.append("날이 적당해서");		
		System.out.println(sb2);
		System.out.println(sb2.insert(8, "날이 좋지 않아서 "));
		System.out.println(sb2.append(" 모든 날이 좋았다 "));
		//System.out.println(sb2.insert(0," 모든 날이 좋았다 "));//포함시에 결과가 달라지는 이유는?
		System.out.println("sb2 = " + sb2);
		System.out.println("sb = " + sb);
		int start = sb2.indexOf("모든 날이 좋았다 ");
		int end = sb2.length();
		System.out.println("start = " + start + ", end = " + end);
		System.out.println(sb.replace(start, end, "너와 함께 한 시간 모두 눈부셨다"));
	}
}