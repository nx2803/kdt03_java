package com.ruby.java.ch06객체구현;


public class Member_3 {
	private String name;
	private int age;
	
	
	public Member_3() {
		this("guest");
	}
	
	public Member_3(String name) {
		this(name, 0);
	}
	
	public Member_3(String name, int age) {
		this.name=name;
		this.age = age;
	}
	public String toString() {
		return name + " : " + age;
		
	}
	
	public void setName(String name) {
		
	}
	public static void main(String[] args) {
		Member_3 m1 = new Member_3();
		Member_3 m2 = new Member_3("Amy");
		Member_3 m3 = new Member_3("Amy",23);
		System.out.println(m1.toString());
		System.out.println(m2.toString());
		System.out.println(m3.toString());
		}
	}

