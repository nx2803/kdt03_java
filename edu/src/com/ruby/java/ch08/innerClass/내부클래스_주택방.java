package com.ruby.java.ch08.innerClass;

//외부 클래스: House
class House {
	private String address; // 집 주소
	private Room[] rooms;
	private int numRooms; //생성자에서 배열의 크기
	private int count; //방2개면 count=2

	// House 클래스의 생성자
	public House(String address, int numRooms) {
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

	// --- 내부 클래스 ---
	class Room {
		private String roomName; // 방 이름

		// Room 클래스의 생성자
		public Room(String roomName) {
			this.roomName = roomName;
		}

		// 방의 정보와 함께, 속해 있는 집의 정보도 출력하는 메소드
		public void show() {
			System.out.println("방 이름: " + roomName);

			// 내부 클래스는 외부 클래스의 변수에 직접 접근할 수 있어요!
			System.out.println(roomName + "방은 '" + address + "' 집에 있어요");
		}
	}
}

public class 내부클래스_주택방 {
	public static void main(String[] args) {

		House myHouse = new House("부산시 부산대학로 63번길의2", 2);
		myHouse.makeRoom("아빠");	myHouse.makeRoom("엄마");
		myHouse.show();
		
//		Room myRoom = new Room("부엌");//오류
//		House.Room myRoom = new House.Room("내방");//오류
		House.Room myRoom = myHouse.new Room("내방");
		myRoom.show();
	}
}