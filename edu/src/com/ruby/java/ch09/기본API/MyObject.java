package com.ruby.java.ch09.기본API;

public class MyObject {

	int num;
	
	MyObject(int num){
		this.num=num;
	}
	
	public String toString() {
		return "MyObject";
	}
	
	public boolean equals(Object obj) {
		boolean result = false;
		MyObject arg = (MyObject) obj;
		
		if(this.num==arg.num){
			return true;
		}
		return result;
		
		
	}
}
