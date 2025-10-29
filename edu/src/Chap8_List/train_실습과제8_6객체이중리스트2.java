package Chap8_List;

/*
 * 정수 리스트 > 객체 리스트 >
 * * 헤드 노드가 있는 원형 리스트, 헤드 노드가 없는 원형 리스트 구현
 * merge 구현: in-place 구현, 새로운 노드를 생성하여 합병 구현 
 * 원형 이중 리스트로 동일하게 적용
 */
import java.util.Comparator;
import java.util.Scanner;

class SimpleObject {

    static final int NO = 1; // 번호를 읽어 들일까요?
    static final int NAME = 2; // 이름을 읽어 들일까요?
    String no; // 회원번호
    String name; // 이름
    String expire;//  유효기간 필드를 추가

    public SimpleObject(String sno, String sname, String expire) {
        this.no = sno;
        this.name = sname;
        this.expire = expire;
    }

    public SimpleObject() {
        this.no = null;
        this.name = null;
    }
    // --- 문자열 표현을 반환 ---//

    @Override
    public String toString() {
        return "(" + no + ") " + name;
    }
    // --- 데이터를 읽어 들임 ---//

    void scanData(String guide, int sw) {
        Scanner sc = new Scanner(System.in);
        System.out.println(guide + "할 데이터를 입력하세요." + sw);

        if ((sw & NO) == NO) { //& 는 bit 연산자임
            System.out.print("번호: ");
            no = sc.next();
        }
        if ((sw & NAME) == NAME) {
            System.out.print("이름: ");
            name = sc.next();
        }
    }
    // --- 회원번호로 순서를 매기는 comparator ---//
    public static final Comparator<SimpleObject> NO_ORDER = new NoOrderComparator();

    private static class NoOrderComparator implements Comparator<SimpleObject> {

        @Override
        public int compare(SimpleObject d1, SimpleObject d2) {
            int no1 = Integer.parseInt(d1.no.substring(1));
            int no2 = Integer.parseInt(d2.no.substring(1));

            if (no1 > no2) {
                return 1;
            } else if (no1 < no2) {
                return -1;
            } else {
                return 0;
            }
            // return (d1.no.compareTo(d2.no) > 0) ? 1 : ((d1.no.compareTo(d2.no) < 0)) ? -1 : 0;
        }
    }

    // --- 이름으로 순서를 매기는 comparator ---//
    public static final Comparator<SimpleObject> NAME_ORDER = new NameOrderComparator();

    private static class NameOrderComparator implements Comparator<SimpleObject> {

        @Override
        public int compare(SimpleObject d1, SimpleObject d2) {
            return (d1.name.compareTo(d2.name) > 0) ? 1 : ((d1.name.compareTo(d2.name) < 0)) ? -1 : 0;
        }
    }
}

class Node4 {

    SimpleObject data; // 데이터
    Node4 llink; // 좌측포인터(앞쪽 노드에 대한 참조)
    Node4 rlink; // 우측포인터(뒤쪽 노드에 대한 참조)

    public Node4() {
        // this.data = new SimpleObject2();
        this.data = null;
        this.llink = null;
        this.rlink = null;
    }

    public Node4(SimpleObject data) {
        this.data = data;
        this.llink = null;
        this.rlink = null;
    }

    @Override
    public String toString() {
        return this.data.toString();
    }

}

class DoubledLinkedList {

    private Node4 first; // 머리 포인터(참조하는 곳은 더미노드)

    // --- 생성자(constructor) ---//
    public DoubledLinkedList() {
        first = new Node4(); // dummy(first) 노드를 생성
        first.llink = first;
        first.rlink = first;
    }

    // --- 리스트가 비어있는가? ---//
    public boolean isEmpty() {
        return first.rlink == first;
    }

    // --- 노드를 검색 ---//
    public boolean search(SimpleObject obj, Comparator<? super SimpleObject> c) {
        if (isEmpty()) {
            return false;
        }
        Node4 cu = first.rlink;
        while (cu != first) {
            if (c.compare(cu.data, obj) == 0) {
                System.out.println("있다에요.");
                return true;
            }
            cu = cu.rlink;
        }
        System.out.println("없다에요.");
        return false;
    }

    // --- 전체 노드 표시 ---//
    public void show() {
        if (isEmpty()) {
            System.out.println("리스트가 비었다에요");
            return;
        }
        Node4 c = first.rlink;
        while (c != first) {
            System.out.println(c.toString());
            c = c.rlink;
        }
    }
    // --- 올림차순으로 정렬이 되도록 insert ---//

    public void add(SimpleObject obj, Comparator<? super SimpleObject> c) {
        Node4 nn = new Node4(obj);
        Node4 cu = first.rlink;

        while (cu != first && c.compare(cu.data, obj) < 0) {
            cu = cu.rlink;
        }

        nn.rlink = cu;
        nn.llink = cu.llink;

        cu.llink.rlink = nn;
        cu.llink = nn;
    }

    // --- list에 삭제할 데이터가 있으면 해당 노드를 삭제 ---//
    public void delete(SimpleObject obj, Comparator<? super SimpleObject> c) {
        if (isEmpty()) {
            System.out.println("빔.");
            return;
        }
        Node4 cu = first.rlink;

        while (cu != first) {
            if (c.compare(cu.data, obj) == 0) {

                cu.llink.rlink = cu.rlink;
                cu.rlink.llink = cu.llink;
                System.out.println(obj + "삭제");
                return;
            }
            cu = cu.rlink;
        }

        System.out.println(obj + "삭제 실패.");

    }

    public DoubledLinkedList merge_NewList(DoubledLinkedList lst2, Comparator<SimpleObject> cc) {
        //l3 = l1.merge(l2); 실행하도록 리턴 값이 리스트임 
        //l.add(객체)를 사용하여 구현
        //기존 리스트의 노드를 변경하지 않고 새로운 리스트의 노드들을 생성하여 구현 
        DoubledLinkedList lst3 = new DoubledLinkedList();
        Node4 ai = this.first.rlink, bi = lst2.first.rlink;
        while (ai != this.first || bi != lst2.first) {
            if (ai != this.first && (bi == lst2.first || cc.compare(ai.data, bi.data) <= 0)) {

                lst3.add(ai.data, cc);
                ai = ai.rlink;
            } else if (bi != lst2.first) {

                lst3.add(bi.data, cc);
                bi = bi.rlink;
            } else {

                break;
            }
        }
        return lst3;

    }

    void merge_InPlace(DoubledLinkedList b, Comparator<SimpleObject> cc) {
        /*
		 * 연결리스트 a,b에 대하여 a = a + b
		 * merge하는 알고리즘 구현으로 in-place 방식으로 합병/이것은 새로운 노드를 만들지 않고 합병하는 알고리즘 구현
		 * 난이도 등급: 최상급
		 * 회원번호에 대하여 a = (3, 5, 7), b = (2,4,8,9)이면 a = (2,3,4,5,8,9)가 되도록 구현하는 코드
         */
        if (b.isEmpty()) {
            return;
        }
        Node4 p = first.rlink;
        Node4 q = b.first.rlink;
        Node4 p_prev = first;

        while (q != b.first) {
            if (p == first || cc.compare(q.data, p.data) <= 0) {
                Node4 q_next = q.rlink;
                q.llink = p_prev;
                q.rlink = p;
                p_prev.rlink = q;
                p.llink = q;
                q = q_next;
                b.first.rlink = q;
                if (q == b.first) {
                    b.first.llink = b.first;
                    b.first.rlink = b.first;
                } else {
                    q.llink = b.first;
                }
                p_prev = p_prev.rlink;
            } else {
                p_prev = p;
                p = p.rlink;
            }
        }

    }
}

public class train_실습과제8_6객체이중리스트2 {

    enum Menu {
        Add("삽입"), Delete("삭제"), Show("인쇄"), Search("검색"), Merge_NewList("병합-새리스트"), Merge_InPlace("병합-제자리"), Exit("종료");

        private final String message; // 표시할 문자열

        static Menu MenuAt(int idx) { // 순서가 idx번째인 열거를 반환
            for (Menu m : Menu.values()) {
                if (m.ordinal() == idx) {
                    return m;
                }
            }
            return null;
        }

        Menu(String string) { // 생성자(constructor)
            message = string;
        }

        String getMessage() { // 표시할 문자열을 반환
            return message;
        }
    }

    // --- 메뉴 선택 ---//
    static Menu SelectMenu() {
        Scanner sc1 = new Scanner(System.in);
        int key;
        do {
            for (Menu m : Menu.values()) {
                System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
                if ((m.ordinal() % 3) == 2 && m.ordinal() != Menu.Exit.ordinal()) {
                    System.out.println();
                }
            }
            System.out.print(" : ");
            key = sc1.nextInt();
        } while (key < Menu.Add.ordinal() || key > Menu.Exit.ordinal());
        return Menu.MenuAt(key);
    }

    public static void main(String[] args) {
        Menu menu; // 메뉴
        Scanner sc2 = new Scanner(System.in);
        DoubledLinkedList lst1 = new DoubledLinkedList(), lst2 = new DoubledLinkedList();
        DoubledLinkedList lst3 = new DoubledLinkedList(), lst4 = new DoubledLinkedList();
        String sno1 = null, sname1 = null;
        SimpleObject so;
        boolean result = false;
        int count = 3;
        do {
            switch (menu = SelectMenu()) {
                case Add: // 객체들의 올림차순으로 정렬되도록 구현
                    so = new SimpleObject();
                    so.scanData("입력", 3);
                    lst1.add(so, SimpleObject.NO_ORDER);
                    SimpleObject[] simpleobjects = new SimpleObject[10];
                    makeSimpleObjects(simpleobjects);
                    for (int i = 0; i < simpleobjects.length; i++) {
                        lst1.add(simpleobjects[i], SimpleObject.NO_ORDER);
                    }
                    break;
                case Delete: // 임의 객체를 삭제
                    so = new SimpleObject();
                    so.scanData("삭제", SimpleObject.NO);
                    lst1.delete(so, SimpleObject.NO_ORDER);
                    break;
                case Show: // 리스트 전체를 출력
                    lst1.show();
                    break;
                case Search: // 회원 번호 검색
                    so = new SimpleObject();
                    so.scanData("탐색", SimpleObject.NO);
                    result = lst1.search(so, SimpleObject.NO_ORDER);
                    if (!result) {
                        System.out.println("검색 값 = " + so.no + "데이터가 없습니다.");
                    } else {
                        System.out.println("검색 값 = " + so.no + "데이터가 존재합니다.");
                    }
                    break;
                case Merge_NewList://기존 2개의 리스트를 합병하여 새로운 리스트를 생성(새로운 노드를 생성하여 추가)
                    for (int i = 0; i < count; i++) {//3개의 객체를 연속으로 입력받아 l2 객체를 만든다 
                        so = new SimpleObject();
                        so.scanData("병합", 3);
                        lst2.add(so, SimpleObject.NO_ORDER);
                    }
                    SimpleObject[] simpleobjects2 = new SimpleObject[10];
                    makeSimpleObjects2(simpleobjects2);
                    for (int i = 0; i < simpleobjects2.length; i++) {
                        lst2.add(simpleobjects2[i], SimpleObject.NO_ORDER);
                    }
                    System.out.println("리스트 lst1::");
                    lst1.show();
                    System.out.println("리스트 lst2::");
                    lst2.show();
                    lst3 = lst1.merge_NewList(lst2, SimpleObject.NO_ORDER);
                    //merge 실행후 show로 결과 확인 - 새로운 노드를 만들지 않고 합병 - 난이도 상
                    System.out.println("병합 리스트 lst3::");
                    lst3.show();
                    break;
                case Merge_InPlace:
                    for (int i = 0; i < count; i++) {//3개의 객체를 연속으로 입력받아 l2 객체를 만든다 
                        so = new SimpleObject();
                        so.scanData("병합", 3);
                        lst4.add(so, SimpleObject.NO_ORDER);
                    }
                    SimpleObject[] simpleobjects3 = new SimpleObject[10];
                    makeSimpleObjects3(simpleobjects3);
                    for (int i = 0; i < simpleobjects3.length; i++) {
                        lst4.add(simpleobjects3[i], SimpleObject.NO_ORDER);
                    }
                    System.out.println("리스트 lst2::");
                    lst2.show();
                    System.out.println("리스트 lst4::");
                    lst4.show();
                    lst4.merge_InPlace(lst2, SimpleObject.NO_ORDER);
                    //merge 실행후 show로 결과 확인 - 새로운 노드를 만들지 않고 합병 - 난이도 상
                    System.out.println("병합 리스트 lst4::");
                    lst4.show();
                case Exit: // 
                    break;
            }
        } while (menu != Menu.Exit);
    }

    static void makeSimpleObjects(SimpleObject[] simpleobjects) {
        simpleobjects[0] = new SimpleObject("s8", "hong", "240618");
        simpleobjects[1] = new SimpleObject("s2", "kim", "240619");
        simpleobjects[2] = new SimpleObject("s3", "lee", "240601");
        simpleobjects[3] = new SimpleObject("s1", "park", "240621");
        simpleobjects[4] = new SimpleObject("s4", "choi", "240622");
        simpleobjects[5] = new SimpleObject("s6", "jung", "240611");
        simpleobjects[6] = new SimpleObject("s7", "kang", "240624");
        simpleobjects[7] = new SimpleObject("s5", "jo", "240615");
        simpleobjects[8] = new SimpleObject("s19", "oh", "240606");
        simpleobjects[9] = new SimpleObject("s10", "jang", "240607");

    }

    static void makeSimpleObjects2(SimpleObject[] simpleobjects) {
        simpleobjects[0] = new SimpleObject("s5", "song", "240608");
        simpleobjects[1] = new SimpleObject("s2", "Lim", "240609");
        simpleobjects[2] = new SimpleObject("s3", "kee", "240601");
        simpleobjects[3] = new SimpleObject("s1", "park", "240611");
        simpleobjects[4] = new SimpleObject("s8", "choo", "240612");
        simpleobjects[5] = new SimpleObject("s9", "jong", "240618");
        simpleobjects[6] = new SimpleObject("s4", "jang", "240614");
        simpleobjects[7] = new SimpleObject("s7", "go", "240605");
        simpleobjects[8] = new SimpleObject("s11", "na", "240616");
        simpleobjects[9] = new SimpleObject("s10", "you", "240617");

    }

    static void makeSimpleObjects3(SimpleObject[] simpleobjects) {
        simpleobjects[0] = new SimpleObject("s5", "song", "240608");
        simpleobjects[1] = new SimpleObject("s2", "Lim", "240609");
        simpleobjects[2] = new SimpleObject("s3", "kee", "240601");
        simpleobjects[3] = new SimpleObject("s1", "park", "240611");
        simpleobjects[4] = new SimpleObject("s8", "choo", "240612");
        simpleobjects[5] = new SimpleObject("s9", "jong", "240618");
        simpleobjects[6] = new SimpleObject("s4", "jang", "240614");
        simpleobjects[7] = new SimpleObject("s7", "go", "240605");
        simpleobjects[8] = new SimpleObject("s11", "na", "240616");
        simpleobjects[9] = new SimpleObject("s10", "you", "240617");

    }
}
