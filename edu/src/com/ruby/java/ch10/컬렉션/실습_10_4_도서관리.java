package com.ruby.java.ch10.컬렉션;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

//Book 클래스
class Book implements Comparable<Book> {
	private String title;
	private String author;
	private int publicationYear;
	private String isbn;

	public Book() {
	}

	public Book(String title, String author, int publicationYear, String isbn) {
		this.title = title;
		this.author = author;
		this.publicationYear = publicationYear;
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public String getIsbn() {
		return isbn;
	}

	@Override
	public String toString() {
		return String.format("도서명:\t%s\t저자:\t%s\t출판연도:\t%d\tISBN:\t%s", title, author, publicationYear, isbn);
	}

	@Override
	public int compareTo(Book o) {
		// 구현
		return 0;
	}
}

class Library {
	static final int CAPACITY = 5; // 기본 용량을 5로 설정
	private ArrayList<Book> books = new ArrayList<>();;

	// 책 추가 (용량 초과 시 에러메시지 출력)
	public void addBook(Book book) {
		// 구현
		books.containsAll((Collection<?>) book);

		if (books.size() > 5) {
			System.err.println("용량 초과");
		}
	}

	// 책 삭제 (빈 목록에서 삭제 시 에러메시지 출력)
	public Book removeBook() {
		// 구현
		if (books.size()==0) {
			System.err.println("빈 목록");
		}
		else {
			books.remove(books.getLast());
		}
		

		return null;
	}

	// 메시지와 함께 library에 저장된 도서 출력
	public void printBooks(String msg) {
		// 구현

		
		System.out.println("-".repeat(60));
	}

	// 제목으로 정렬
	public void sortBooksByTitle() {
		// 구현
	}

	// ISBN으로 정렬
	public void sortBooksByISBN() {
		// 구현
	}

	// books에서 title을 검색해서 리턴, 없으면 null 리턴
	public Book searchBookByTitle(String title) {
		// 구현
		return null;
	}
}

public class 실습_10_4_도서관리 {
	public static void main(String[] args) {

		Library library = new Library();

		// 5개의 Book 객체 초기화
		Book book1 = new Book("자바", "강감찬", 1995, "12");
		Book book2 = new Book("파이썬", "이순신", 2008, "9");
		Book book3 = new Book("C#", "을지문덕", 2008, "8");
		Book book4 = new Book("자료구조", "연개소문", 1994, "45");
		Book book5 = new Book("리액트", "김춘추", 1999, "7");

		library.addBook(book1);
		library.addBook(book2);
		library.addBook(book3);
		library.addBook(book4);
		library.addBook(book5);

		// 도서 목록 출력
		library.printBooks("현재 도서 목록:");

		library.sortBooksByTitle(); // 제목으로 도서 목록 정렬
		library.printBooks("정렬후 최종 도서 목록:");

		// 특정 제목으로 도서 검색 후 출력
		String searchTitle = "자바";
		Book foundBook = library.searchBookByTitle(searchTitle);
		if (foundBook != null)
			System.out.println(searchTitle + " 검색결과\n[" + foundBook + "]");
		else
			System.out.println(searchTitle + " 검색결과가 없습니다.");
		System.out.println("-".repeat(60));

		library.removeBook(); // 정상 삭제
		library.removeBook(); // 정상 삭제
		library.removeBook(); // 정상 삭제
		library.removeBook(); // 정상 삭제
		library.removeBook(); // 정상 삭제

		// 도서 목록 출력
		library.printBooks("현재 도서 목록:");

		library.removeBook();
	}
}