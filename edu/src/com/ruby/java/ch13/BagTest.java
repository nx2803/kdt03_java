package com.ruby.java.ch13;

class Bag<T>{
	private T thing;
	
	public Bag(T thing) {
		this.thing=thing;
	}
	
	public T getThing() {
		return thing;
	}
	
	public void setThing(T thing) {
		this.thing=thing;
	}
	void showType() {
		System.out.println("T의 타입은 "+thing.getClass().getName());
	}
}


class Book{}
class PencilCase{}
class Notebook{}


public class BagTest {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		Bag<Book> bag = new Bag<>(new Book());
		Bag<PencilCase> bag2 = new Bag<>(new PencilCase());
		Bag<Notebook> bag3 = new Bag<>(new Notebook());
		bag.showType();
		bag2.showType();
		bag3.showType();
		
		Book book = (Book)bag.getThing();
		PencilCase pc = (PencilCase)bag2.getThing();
		Notebook nb = (Notebook)bag3.getThing();
		
		//bag=bag2;
	}	

}
