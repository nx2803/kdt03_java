package com.ruby.java.ch12;

import java.io.FileOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class Test15 {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		UserBean user = new UserBean("purum", "오정임", "010-123-4567", "서울");
		
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("user.txt"))) {
			out.writeObject(user);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
