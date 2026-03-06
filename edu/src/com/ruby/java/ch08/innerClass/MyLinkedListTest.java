package com.ruby.java.ch08.innerClass;
/*
 *  inner class: 359페이지 밑에서 두번째, 마지막 문단 이해
 */
class MyLinkedList {
	private Node head=null;
	public MyLinkedList() {
		
	}
	
	static class Node {
		private String data;
		private Node link;

		public Node(String data) {
			this.setData(data);
		}

		public String getData() {
			return data;
		}

		public void setData(String data) {
			this.data = data;
		}
	}

	public void add(String data) {
		//코드 이해해야 한다 - 자료구조 수업에 도움이 됨
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
		} else {
			Node next = head;
			while (next.link != null) {
				next = next.link;
			}
			next.link = newNode;

		}
	}

	public void print() {
		if (head == null) {
			System.out.println("등록된 데이터가 없습니다.");
		} else {
			System.out.println("등록된 데이터는 다음과 같습니다.");
			Node next = head;
			while (next != null) {
				System.out.println(next.getData());
				next = next.link;
			}
		}
	}
	
	public void delete(String data) {
		if (head == null) {
			System.out.println("삭제할 데이터가 없습니다.");
		} else {
			Node p = head;
			Node q = p;
			while (p != null) {
				if (p.getData().compareTo(data) == 0) {
					q.link = p.link;
					//삭제할 데이터
					System.out.println("삭제 완료");
					return;
				}
				q = p;
				p = p.link;
			}
			System.out.println("삭제할 데이터가 없읍니다.");
			return;
		}
		
	}
}
public class MyLinkedListTest {
	public static void main(String[] args) {
		MyLinkedList myList = new MyLinkedList();
		

		
		myList.add("11");
		myList.add("55");
		myList.print();
		
		myList.add("77");
		myList.add("177");
		myList.add("33");
		myList.print();
		myList.delete("177");
		System.out.println("삭제후 출력: ");
		myList.print();
		MyLinkedList.Node nd = myList.new Node("Hong");//not visible
		nd.setData("hello");
	}
}