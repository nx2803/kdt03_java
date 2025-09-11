package com.ruby.java.ch08.다형성_내부클래스;



//동적바인딩
//Item 추상 클래스
abstract class Item {
	private String name; // 제품명
	private double price; // 제품 가격
	private int stockQuantity; // 재고량

	// 생성자
	public Item(String name, double price, int stockQuantity) {
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
	
	
	@Override
	public String toString() {
		return "name = " + name + ", price = " + price + ", stockQuantity = " + stockQuantity;
	}
	
	// 재고 감소 메소드
	public void reduceStock(int quantity) {
		stockQuantity -= quantity;
	}

	public abstract void show();
}

//Electronics 클래스: Item 클래스 상속
class Electronics extends Item {
	int madeYear;

	// 생성자
	public Electronics(String name, double price, int stockQuantity, int madeYear) {
		super(name, price, stockQuantity);
		this.madeYear=madeYear;
	}
	
	@Override
	public void show() {
		System.out.println("Electronics : " + super.toString() + ", madeYear = " + madeYear);
	}
}

//Clothing 클래스: Item 클래스 상속
class Clothing extends Item {
	int size;

	// 생성자
	public Clothing(String name, double price, int stockQuantity, int size) {
		super(name, price, stockQuantity);
		this.size=size;
	}
	
	
	@Override
	public void show() {
		System.out.println("Clothing : " + super.toString() + ", size = " + size);
	}
}

//Discountable 인터페이스 정의
interface Discountable {
	double getDiscountedPrice(double price);
}

//SeasonalDiscount 클래스: Discountable 인터페이스 구현
class SeasonalDiscount implements Discountable {
	private double seasonalDiscount;

	// 생성자
	public SeasonalDiscount() {
		seasonalDiscount = 0.0;
	}
	
	public SeasonalDiscount(double seasonalDiscount) {
		this.seasonalDiscount = seasonalDiscount;
	}
	
	@Override
	public double getDiscountedPrice(double price) {
		return price * seasonalDiscount;
	}
}

//Order 클래스
class Order extends SeasonalDiscount {
	private final int N = 20;
	private Customer customer; // 고객명
	private Item[] items; // 주문 제품들
	private int[] quantities; // 주문 제품 수량들
	private String[] orderDates; // 주문일자들
	private int count = 0;
	private double seasonalDiscount;

	// 생성자
	public Order(Customer customer, double seasonalDiscount) {
		this.customer = customer;
		items = new Item[5];
		quantities=new int[5];
		orderDates = new String[5];
		this.seasonalDiscount = seasonalDiscount;
		
	}
	
	
	public void addItem(Item item, int quantity, String date) {
		// 최대 주문 item 개수를 넘어서는지 확인
		
		// item에 재고가 있는지 확인
		
		// 재고가 있으면 아이템 추가
		if(quantity < item.getstockQuantity())
		{
			items[count] = item;
			quantities[count] = quantity;
			orderDates[count] = date;
			count++;
			item.reduceStock(quantity);
		}
	}

	private double calculateTotal() {
		/*
		 * 할인없이 수량 단가로 비용 계산
		 */
		double total = 0.0;
		for (int i = 0; i < count; i++) {
			total += (items[i].getprice() * quantities[i]);
		}
		return total;
	}

	private double calculateDiscountTotal() {
		/*
		 * 할인을 적용한 비용 계산
		 */
		return 0.0;
	}
	
	// 주문 내역을 출력하는 메소드
	public void printOrderSummary() {
		//System.out.println(customer.toString());
		System.out.println(customer.toString());
		for (int i = 0; i < count; i++) {
			System.out.println("제품명 : " + items[i].getname() + ", 단가: " + items[i].getprice() + ", 개수 : "
					+ quantities[i] + " ==> 가격 : " + items[i].getprice() * quantities[i] + ", 주문일 : "+ orderDates[i]);
		}
		System.out.println("총액 : " + calculateTotal());
	}

	// 할인된 내역을 출력하는 메소드
	public void printDiscountDetails() {
		/*
		 * 할인가격 = 정가 - (정가*시즌할인율) - (정가*고객할인율)
		 */
		
	}
}

//Customer 추상 클래스 정의
abstract class Customer {
	private String name;

	// 생성자
	public Customer(String name) {
		this.name = name;
	}
	
	
	// Getter
	public String getname() {
		return name;
	}
		
	public String toString() {
		return "고객명:" + name;
	}
	
	abstract double getDiscountedPrice(double price);
}

//RegularCustomer 클래스: Customer 클래스를 상속받음
class RegularCustomer extends Customer {
	static final double REGULARDISCOUNT_RATE = 0.03;

	// 생성자
	public RegularCustomer(String name)
	{
		super(name);
		
	}
	
	
	@Override
	double getDiscountedPrice(double price) {
		return REGULARDISCOUNT_RATE;
	}
}

//PremiumCustomer 클래스: Customer 클래스를 상속받음
class PremiumCustomer extends Customer {
	static final double PREMIUMDISCOUNT_RATE = 0.1;

	// 생성자
	public PremiumCustomer(String name)
	{
		super(name);
	}
	

	@Override
	double getDiscountedPrice(double price) {
		return PREMIUMDISCOUNT_RATE;
	}
	
}
public class 실습_8_3_동적바인딩 {
	static void showItemsStock(Item[] items) {
		// 모든 아이템의 이름과 재고량, 가격 출력
		for (Item item : items) {
			item.show(); // 동적 바인딩에 의해 각 클래스의 show() 메서드가 호출됨
		}
	}

	public static void main(String[] args) {
	
		// Item 타입의 배열 생성
		Item[] items = new Item[4];

		// 배열에 전자제품과 의류패션 객체 추가
		items[0] = new Electronics("노트북", 150, 100, 23);
		items[1] = new Clothing("티셔츠", 10, 100, 95);
		items[2] = new Electronics("휴대폰", 80, 100, 24);
		items[3] = new Clothing("청바지", 20, 100, 90);

		// 모든 아이템의 이름과 재고량, 가격 출력
		System.out.println(">>모든 아이템의 이름과 재고량, 가격 출력");
		showItemsStock(items);
		System.out.println("-".repeat(80));

		// 고객 생성
		Customer regularCustomer = new RegularCustomer("홍길동");
		Customer premiumCustomer = new PremiumCustomer("강감찬");

		// 주문 생성 및 계산 (RegularCustomer)
		Order regularOrder = new Order(regularCustomer, 0.01);
		regularOrder.addItem(items[0], 1, "240901");
		regularOrder.addItem(items[1], 2, "240902");

		System.out.println(">>RegularCustomer 주문 내역 출력");
		regularOrder.printOrderSummary();

		System.out.println(">>RegularCustomer 할인된 주문 내역 출력");
		regularOrder.printDiscountDetails(); // 할인된 내역 출력
		System.out.println("-".repeat(80));

		// 주문 생성 및 계산 (PremiumCustomer)
		Order premiumOrder = new Order(premiumCustomer, 0.01);
		premiumOrder.addItem(items[1], 1, "240901");
		premiumOrder.addItem(items[3], 2, "240903");

		System.out.println(">>PremiumCustomer 주문 내역 출력");
		premiumOrder.printOrderSummary();
		
		System.out.println(">>PremiumCustomer 할인된 주문 내역 출력");
		premiumOrder.printDiscountDetails(); // 할인된 내역 출력
		System.out.println("-".repeat(80));

		// 모든 아이템의 이름과 재고량, 가격 출력
		System.out.println(">>모든 아이템의 이름과 재고량, 가격 출력");
		showItemsStock(items);
	
	}
}
/*
 * 출력 결과 예시
 * 
>>모든 아이템의 이름과 재고량, 가격 출력
Electronics : name = 노트북, price = 150.0, stockQuantity = 100, madeYear = 23
Clothing : name = 티셔츠, price = 10.0, stockQuantity = 100, size = 95
Electronics : name = 휴대폰, price = 80.0, stockQuantity = 100, madeYear = 24
Clothing : name = 청바지, price = 20.0, stockQuantity = 100, size = 90
--------------------------------------------------------------------------------
>>RegularCustomer 주문 내역 출력
고객정보 : 홍길동
제품명 : 노트북, 단가 : 150.0, 개수 : 1 ==> 가격 : 150.0, 주문일 : 240901
제품명 : 티셔츠, 단가 : 10.0, 개수 : 2 ==> 가격 : 20.0, 주문일 : 240902
총액 : 170.0
>>RegularCustomer 할인된 주문 내역 출력
제품명 : 노트북, 할인 : 144.0, 개수 : 1 ==> 가격 : 144.0, 주문일 : 240901
제품명 : 티셔츠, 할인 : 9.6, 개수 : 2 ==> 가격 : 19.2, 주문일 : 240902
총액 : 163.2
--------------------------------------------------------------------------------
>>PremiumCustomer 주문 내역 출력
고객정보 : 강감찬
제품명 : 티셔츠, 단가 : 10.0, 개수 : 1 ==> 가격 : 10.0, 주문일 : 240901
제품명 : 청바지, 단가 : 20.0, 개수 : 2 ==> 가격 : 40.0, 주문일 : 240903
총액 : 50.0
>>PremiumCustomer 할인된 주문 내역 출력
제품명 : 티셔츠, 할인 : 8.9, 개수 : 1 ==> 가격 : 8.9, 주문일 : 240901
제품명 : 청바지, 할인 : 17.8, 개수 : 2 ==> 가격 : 35.6, 주문일 : 240903
총액 : 44.5
--------------------------------------------------------------------------------
>>모든 아이템의 이름과 재고량, 가격 출력
Electronics : name = 노트북, price = 150.0, stockQuantity = 99, madeYear = 23
Clothing : name = 티셔츠, price = 10.0, stockQuantity = 97, size = 95
Electronics : name = 휴대폰, price = 80.0, stockQuantity = 100, madeYear = 24
Clothing : name = 청바지, price = 20.0, stockQuantity = 98, size = 90
 */
