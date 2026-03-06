/*
package com.ruby.java.ch08.innerClass;

class Room {
	private String roomName; // 방 이름

	// Room 클래스의 생성자
	public Room(String roomName) {
		this.roomName = roomName;
	}

	// 방의 정보와 함께, 속해 있는 집의 정보도 출력하는 메소드
	public void show() {
		System.out.println("방 이름: " + roomName);
	}
}

class House2 {
	private String address; // 집 주소
	private Room[] rooms;
	private int numRooms;
	private int count;

	// House 클래스의 생성자
	public House2(String address, int numRooms) {
		this.address = address;
		this.numRooms = numRooms;
		rooms = new Room[this.numRooms];
		count = 0;
	}

	// 집의 정보를 출력하는 메소드
	public void show() {
		System.out.println("집 주소: " + address);
		System.out.println("집 방수: " + numRooms);
		for (Room rm: rooms) {
			rm.show();
		}
	}
	void makeRoom(String name) {
		if (count > numRooms) {
			System.out.println("방 없어요");
			 return;
		}
		rooms[count++] = new Room(name);
	}


}
public class 외부클래스_주택방 {
	public static void main(String[] args) {

		House2 myHouse = new House2("부산시 부산대학로 63번길의2", 2);
		myHouse.makeRoom("아빠");	myHouse.makeRoom("엄마");
		myHouse.show();
		
		Room myRoom = new Room("부엌");
		//House.Room myRoom = new House.Room("내방");//해당없음

		myRoom.show();
	}
}
*/