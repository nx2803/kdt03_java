package com.ruby.java.ch07.상속.실습;

//Discountable 인터페이스 정의 -시즌 할인율 적용
interface Discountable {
	double getDiscountedPrice(double price);
}

//SeasonalDiscount 클래스: Discountable 인터페이스 구현
class SeasonalDiscount implements Discountable {
	private double seasonalDiscountRate;

	// 생성자
	public SeasonalDiscount() {
		super();
		
	}
	
	// Getter
	public double getseasonalDiscountRate() {
		return seasonalDiscountRate;
	}
	
	
	@Override
	public double getDiscountedPrice(double price) {
		return price*(1-getseasonalDiscountRate());
	}
}

//Item 추상 클래스
abstract class Item3 {
	private String name; // 제품명
	private double price; // 제품 가격
	private int stockQuantity; // 재고량

	// 생성자
	public Item3(String name, double price, int stockQuantity) {
		this.name=name;
		this.price=price;
		this.stockQuantity=stockQuantity;
	}
	
	
	// Getter
	public String getname() {
		return name;
	}
	public double getprice() {
		return price;
	}
	public int getstockQuantity() {
		return stockQuantity;
	}
	

	public void reduceStock(int quantity) {
		stockQuantity -= quantity;
	}
}

//Electronics 클래스: Item 클래스 상속
class Electronics3 extends Item3 {
	private int madeYear;

	// 생성자
	public Electronics3(String name, double price, int stockQuantity, int madeYear) {
		super(name, price, stockQuantity);
		this.madeYear=madeYear;
	}
}

//Clothing 클래스: Item 클래스 상속
class Clothing3 extends Item3 {
	private int size;
	


	// 생성자
	public Clothing3(String name, double price, int stockQuantity, int size) {
		super(name, price, stockQuantity);
		this.size=size;
	}
}

//Order 클래스
class Order3 extends SeasonalDiscount {
	private final int N = 20;
	private Customer3 customer; // 고객명
	private Item3[] items; // 주문 제품들
	private int[] quantities; // 주문 제품 수량들
	private String[] orderDates; // 주문일자들
	private int count;
	private double discount;

	

	// 생성자
	public Order3(Customer3 premiumCustomer, double seasonalDiscountRate) {
		// TODO 자동 생성된 생성자 스텁
		customer = premiumCustomer;
		items = new Item3[5];
		quantities=new int[5];
		discount = seasonalDiscountRate;
		count = 0;
	}
	
	public void addItem(Item3 item, int quantity, String date) {
		items[count] = item;
		quantities[count] = quantity;
		count++;
		
	}

	private double calculateTotal() {
		double total = 0.0;
		for (int i = 0; i < count; i++) {
			total += (items[i].getprice() * quantities[i]);
		}
		return total;
	}

	public void printOrderSummary() {
		System.out.println(customer.toString());
		for (int i = 0; i < count; i++) {
			System.out.println("제품명 : " + items[i].getname() + ", 단가: " + items[i].getprice() + ", 수량 : "
					+ quantities[i] + ", 가격 : " + items[i].getprice() * quantities[i]);
		}
		System.out.println("구매총액 : "+calculateTotal());
	}

	// 할인된 내역을 출력하는 메소드
	public void printDiscountDetails() {
		System.out.println("할인율 : " + customer.getDiscountRate());
		System.out.println("할인가격 : "+customer.applyDiscount(calculateTotal()));
		System.out.println("시즌할인율:" + discount);
		System.out.println("시즌할인: "+customer.applyDiscount(calculateTotal())*(1-discount));
		/*
		 * 정가 - 시즌 할인 적용 - 고객 할인 적용 => 할인된 가격 * 수량 > 총 지불 금액
		 */
	}
}

//Customer 추상 클래스 정의
abstract class Customer3 {
	private String name;

	// 생성자
	public Customer3(String name) {
		this.name=name;
	}
	

	@Override
	public String toString() {
		return "고객명:" + name;
	}
	
	abstract double applyDiscount(double totalAmount);
	abstract double getDiscountRate();
}

//RegularCustomer 클래스: Customer 클래스를 상속받음
class RegularCustomer3 extends Customer3 {
	static final double REGULARDISCOUNT_RATE = 0.03;

	// 생성자
	public RegularCustomer3(String name) {
		super(name);
		double discount = REGULARDISCOUNT_RATE;
	}
	

	@Override
	double applyDiscount(double totalAmount) {
		// 일반 고객은 추가 할인 없음
		return totalAmount*(1-getDiscountRate());
	}
	
	@Override
	double getDiscountRate() {
		return REGULARDISCOUNT_RATE;
	}
}

//PremiumCustomer 클래스: Customer 클래스를 상속받음
class PremiumCustomer3 extends Customer3 {
	static final double PREMIUMDISCOUNT_RATE = 0.1;

	// 생성자
	public PremiumCustomer3(String name) {
		super(name);
		double discount = PREMIUMDISCOUNT_RATE;
	}
	
	
	@Override
	double applyDiscount(double totalAmount) {
		return totalAmount*(1-getDiscountRate());
	}
	
	@Override
	double getDiscountRate() {
		return PREMIUMDISCOUNT_RATE;
	}
}

public class 실습_7_3_인터페이스 {
	public static void main(String[] args) {

		// 배열에 전자제품과 의류패션 객체 추가
		Item3 note = new Electronics3("노트북", 1500, 24, 23);
		Item3 clothe = new Clothing3("티셔츠", 50, 50, 95);

		// 고객 생성
		Customer3 regularCustomer = new RegularCustomer3("홍길동");
		Customer3 premiumCustomer = new PremiumCustomer3("강감찬");

		// 주문 생성 및 계산 (RegularCustomer)
		double seasonalDiscountRate = 0.01;
		Order3 regularOrder = new Order3(regularCustomer, seasonalDiscountRate);
		regularOrder.addItem(note, 1, "240901");
		regularOrder.addItem(clothe, 2, "240902");

		regularOrder.printOrderSummary();
		regularOrder.printDiscountDetails(); // 할인된 내역 출력

		// 주문 생성 및 계산 (PremiumCustomer)
		Order3 premiumOrder = new Order3(premiumCustomer, seasonalDiscountRate);
		premiumOrder.addItem(note, 1, "240901");
		premiumOrder.addItem(clothe, 2, "240903");

		premiumOrder.printOrderSummary();
		premiumOrder.printDiscountDetails(); // 할인된 내역 출력

		/*
		 * 출력 결과 예시
		 * 
		고객명:홍길동
		제품명:노트북, 단가:1500.0, 수량:1, 가격:1500.0
		제품명:티셔츠, 단가:50.0, 수량:2, 가격:100.0
		구매총액:1600.0
		---------------------------------------------
		할인율:0.03
		할인가격:1552.0
		시즌할인율:0.01
		시즌할인:1536.48
		=============================================
		고객명:강감찬
		제품명:노트북, 단가:1500.0, 수량:1, 가격:1500.0
		제품명:티셔츠, 단가:50.0, 수량:2, 가격:100.0
		구매총액:1600.0
		---------------------------------------------
		할인율:0.1
		할인가격:1440.0
		시즌할인율:0.01
		시즌할인:1425.6
		=============================================
		 */
	}
}
