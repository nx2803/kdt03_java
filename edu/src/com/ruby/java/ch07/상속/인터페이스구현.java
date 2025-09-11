package com.ruby.java.ch07.상속;

interface Employee3 {
 void work();//추상메소드
 void attendMeeting();//추상메소드
}

class Manager2 implements Employee3 {
 @Override
 public void work() {
     System.out.println("매니저는 팀원들의 업무를 관리.");
 }
 @Override
 public void attendMeeting() {
     System.out.println("매니저가 전략 회의에 참석.");
 }
}

class Salesperson2 implements Employee3 {
 @Override
 public void work() {
     System.out.println("영업사원은 고객을 만나 상품을 판매.");
 }
 @Override
 public void attendMeeting() {
     System.out.println("영업사원이 주간 판매 실적 회의에 참석.");
 }
}

class Consultant2 implements Employee3 {
 @Override
 public void work() {
     System.out.println("컨설턴트는 고객의 문제 해결.");
 }
 @Override
 public void attendMeeting() {
     System.out.println("컨설턴트가 고객사와의 미팅에 참석.");
 }
}

public class 인터페이스구현 {
 public static void main(String[] args) {
     Employee3 manager = new Manager2(); //인터페이스를 타입으로 간주
     Employee3 salesperson = new Salesperson2();
     Employee3 consultant = new Consultant2();


     System.out.println("--- 직원들의 역할 수행 ---");
     manager.work();
     manager.attendMeeting();
     System.out.println();

     salesperson.work();
     salesperson.attendMeeting();
     System.out.println();

     consultant.work();
     consultant.attendMeeting();
     System.out.println();

}
}