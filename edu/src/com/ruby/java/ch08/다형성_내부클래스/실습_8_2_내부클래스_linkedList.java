package com.ruby.java.ch08.다형성_내부클래스;
/*
 * 코드을 삭제하고 주석만으로 삭제한 코드를 작성하는 훈련 실습
 */
class LinkedList {

	// 연결 리스트의 시작 노드 선언
	private Node head = null;

	// 연결 노드 정의
	private class Node {
		// 노드에 저장할 데이터
		private String data;
		// 다음 노드를 가리키는 참조 변수
		private Node link;

		// 노드 생성자
		public Node(String data) {
			this.data = data;
		}
	}

	// 새로운 노드를 만들어서 연결 리스트에 추가
	public void add(String data) {

		// 새로운 노드 생성
		Node newNode = new Node(data);
		// 연결 리스트에 데이터가 없으면
		if (head == null) {
			head = newNode;
		}
		else {
			// 연결 리스트에 이미 데이터가 있으면 제일 끝으로 이동해서 새 노드를 추가
			Node next = head;
			while (next.link != null) {
				next = next.link;
			}
			next.link = newNode;
		}
	}

	// 연결 리스트에 저장된 노드 출력
	public void print() {
		// 연결 리스트에 데이터가 없으면 메시지만 출력
		if (head == null) {
			System.out.println("등록된 데이터가 없습니다.");
		} else {
			// 연결 리스트에 이미 데이터가 있으면 처음부터 방문하면서 노드에 저장된 데이터 출력
			System.out.println("등록된 데이터는 다음과 같습니다.");
			Node next = head;
			while (next != null) {
				System.out.println(next.data);
				next = next.link;
			}
		}
	}
	
	public void delete(String data) {
		// 연결 리스트에 데이터가 없으면 메시지만 출력
		if (head == null) {
			System.out.println("삭제할 데이터가 없습니다.");
		}
		else {
			// 연결 리스트에서 삭제할 노드 검색 시작
			Node p = head;
			Node q = p;
			while (p != null) {
				// 삭제할 노드가 발견되면
				if (p.data.equals(data)) {
					// 삭제할 노드가 head면 head의 link를 head로 변경
					if (p == head) {
						head = p.link;
					}
					else {
						// 이전 노드에 설정된 link를 삭제 노드의 link로 변경
						q.link = p.link;
					}
					
					System.out.println("삭제 완료");
					return;
				}
				// 다음 노드로 이동
				q = p;
				p = p.link;
			}
			// 연결 리스트에서 삭제할 노드를 찾지 못하면 메시지 출력
			System.out.println("삭제할 데이터가 없읍니다.");
		}
	}
}

public class 실습_8_2_내부클래스_linkedList {
	public static void main(String[] args) {
		LinkedList myList = new LinkedList();
		myList.print();

		myList.add("11");
		myList.add("55");
		myList.add("77");
		myList.add("177");
		myList.add("33");
		myList.print();
		myList.delete("177");
		System.out.println("삭제후 출력: ");
		myList.print();
		System.out.println("Head 삭제후 출력: ");
		myList.delete("11");
		myList.print();
	}
}
