package Chap9_Tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class SimpleObject4 {

    static final int NO = 1; // 번호를 읽어 들일까요?
    static final int NAME = 2; // 이름을 읽어 들일까요?

    private String no; // 회원번호
    private String name; // 이름

    // --- 문자열 표현을 반환 ---//
    @Override
    public String toString() {
        return "(" + no + ") " + name;
    }

    public SimpleObject4() {
        no = null;
        name = null;
    }

    public SimpleObject4(String no, String name) {
        this.no = no;
        this.name = name;
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
    public static final Comparator<SimpleObject4> NO_ORDER = new NoOrderComparator();

    private static class NoOrderComparator implements Comparator<SimpleObject4> {

        @Override
        public int compare(SimpleObject4 d1, SimpleObject4 d2) {
            return d1.no.compareTo(d2.no);
        }
    }

}

class ObjectStack4 {
    //--- 실행시 예외: 스택이 비어있음 ---//
    // generic class는 Throwable을 상속받을 수 없다 - 지원하지 않는다

    public class EmptyGenericStackException extends Exception {

        public EmptyGenericStackException() {
            super();
        }
    }

    //--- 실행시 예외: 스택이 가득 참 ---//
    public class OverflowGenericStackException extends RuntimeException {

        public OverflowGenericStackException() {
            super();
        }
    }

    private List<TreeNode4> data;  // list를 사용: 배열은 크기를 2배로 늘리는 작업 필요 
    //private List<T> data;
    private int capacity; // 스택의 크기
    private int top; // 스택 포인터

    //--- 생성자(constructor) ---//
    public ObjectStack4(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>(capacity);
        this.top = 0;
    }

    //--- 스택에 x를 푸시 ---//
    public boolean push(TreeNode4 x) throws OverflowGenericStackException {
        if (isFull()) {
            throw new OverflowGenericStackException();
        }
        if (top < data.size()) {
            data.set(top++, x);
        } else {
            data.add(x);
            top++;
        }
        return true;
    }

    //--- 스택에서 데이터를 팝(정상에 있는 데이터를 꺼냄) ---//
    public TreeNode4 pop() throws EmptyGenericStackException {
        if (isEmpty()) {
            throw new EmptyGenericStackException();
        }
        return data.get(--top);
    }

    //--- 스택에서 데이터를 피크(peek, 정상에 있는 데이터를 들여다봄) ---//
    public TreeNode4 peek() throws EmptyGenericStackException {
        if (isEmpty()) {
            throw new EmptyGenericStackException();
        }
        return data.get(top - 1);
    }

    //--- 스택을 비움 ---//
    public void clear() {
        top = 0;
    }

    //--- 스택에서 x를 찾아 인덱스(없으면 –1)를 반환 ---//
    public int indexOf(TreeNode4 x) {
        for (int i = top - 1; i >= 0; i--) {
            if (data.get(i).equals(x)) {
                return i;
            }
        }
        return -1;
    }

    //--- 스택의 크기를 반환 ---//
    public int getCapacity() {
        return capacity;
    }

    //--- 스택에 쌓여있는 데이터 갯수를 반환 ---//
    public int size() {
        return top;
    }

    //--- 스택이 비어있는가? ---//
    public boolean isEmpty() {
        if (top == 0) {
            return true;
        } else {
            return false;
        }
    }

    //--- 스택이 가득 찼는가? ---//
    public boolean isFull() {
        if (top >= capacity) {
            return true;
        } else {
            return false;
        }
    }

    //--- 스택 안의 모든 데이터를 바닥 → 꼭대기 순서로 출력 ---//
    public void dump() {
        for (int i = 0; i < top; i++) {
            System.out.print(data.get(i) + " ");
        }
        System.out.println();
    }
}
//정수를 저정하는 이진트리 만들기 실습

class ObjectQueue4 {

    private TreeNode4[] que;//큐는 배열로 구현
    //private List<Integer> que; // 수정본
    private int capacity; // 큐의 크기
    private int front; // 맨 처음 요소 커서
    private int rear; // 맨 끝 요소 커서
    private int num; // 데이터수

    //--- 실행시 예외: 큐가 비어있음 ---//
    public class EmptyQueueException extends RuntimeException {

        public EmptyQueueException() {
            super();
        }
    }

    //--- 실행시 예외: 큐가 가득 찼음 ---//
    public class OverflowQueueException extends RuntimeException {

        public OverflowQueueException() {
            super();
        }
    }

    //--- 생성자(constructor) ---//
    public ObjectQueue4(int maxlen) {
        this.num = 0;
        this.front = 0;
        this.rear = 0;
        this.capacity = maxlen;
        try {
            que = new TreeNode4[maxlen];
        } catch (OutOfMemoryError e) {
            capacity = 0;
        }
    }

    //--- 큐에 데이터를 인큐 ---//
    public int enque(TreeNode4 x) throws OverflowQueueException {
        if (isFull()) {
            throw new OverflowQueueException();
        }
        que[rear++] = x;
        num++;
        if (rear == capacity) {
            rear = 0;
        }
        return 1;
    }

    //--- 큐에서 데이터를 디큐 ---//
    public TreeNode4 deque() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        TreeNode4 x = que[front++];
        num--;
        if (front == capacity) {
            front = 0;
        }
        return x;
    }

    //--- 큐에서 데이터를 피크(프런트 데이터를 들여다봄) ---//
    public TreeNode4 peek() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        return que[front];
    }

    //--- 큐를 비움 ---//
    public void clear() {
        this.num = 0;
        this.front = 0;
        this.rear = 0;
    }

    //--- 큐에서 x를 검색하여 인덱스(찾지 못하면 –1)를 반환 ---//
    public int indexOf(TreeNode4 x) {
        for (int i = 0; i < num; i++) {
            int idx = (i + front) % capacity;
            if (que[idx].data.toString().equals(x.data.toString())) // 데이터 비교
            {
                return idx;
            }
        }
        return -1;
    }

    //--- 큐의 크기를 반환 ---//
    public int getCapacity() {
        return capacity;
    }

    //--- 큐에 쌓여 있는 데이터 개수를 반환 ---//
    public int size() {
        return num;
    }

    //--- 큐가 비어있는가? ---//
    public boolean isEmpty() {
        if (num == 0) {
            return true;
        }
        return false;
    }

    //--- 큐가 가득 찼는가? ---//
    public boolean isFull() {
        if (num >= capacity) {
            return true;
        }
        return false;
    }

    //--- 큐 안의 모든 데이터를 프런트 → 리어 순으로 출력 ---//
    public void dump() {
        for (int i = 0; i < num; i++) {
            System.out.print(que[(i + front) % capacity] + " ");
        }
        System.out.println();
    }
}
//정수를 저정하는 이진트리 만들기 실습

class TreeNode4 {

    TreeNode4 LeftChild;
    SimpleObject4 data;
    TreeNode4 RightChild;

    public TreeNode4() {
        LeftChild = RightChild = null;
    }

    TreeNode4(SimpleObject4 so) {
        data = so;
        LeftChild = RightChild = null;
    }
}

class Tree4 {

    TreeNode4 root;

    Tree4() {
        root = null;
    }

    TreeNode4 inorderSucc(TreeNode4 current) {
        //주어진 노드에 대한 inorder traversal 방문시에 다음에 방문할 노드(successor)를 찾는 알고리즘
        TreeNode4 temp = current.RightChild;
        if (current.RightChild != null) {
            while (temp.LeftChild != null) {
                temp = temp.LeftChild;
            }
        }
        return temp;
    }

    TreeNode4 findParent(TreeNode4 current, Comparator<? super SimpleObject4> c) {
        //주어진 노드의 parent node를 찾는 알고리즘
        if (root == null || current == root) {
            return null;
        }
        TreeNode4 p = root;
        TreeNode4 parent = null;
        while (parent != null) {
            int comp = c.compare(current.data, p.data);

            if (comp == 0) {
                return parent;
            } else if (comp < 0) {
                p = parent;
                parent = parent.LeftChild;
            } else {
                p = parent;
                parent = parent.RightChild;
            }

        }
        return null;
    }

    boolean isLeafNode(TreeNode4 current) {
        //주어진 노드가 leaf node인지 검사
        return current != null && current.LeftChild == null && current.RightChild == null;
    }

    void inorder() {
        inorder(root);
    }

    void preorder() {
        preorder(root);
    }

    void postorder() {
        postorder(root);
    }

    void inorder(TreeNode4 CurrentNode) {
        if (CurrentNode != null) {
            inorder(CurrentNode.LeftChild);
            System.out.print(" " + CurrentNode.data);
            inorder(CurrentNode.RightChild);
        }
    }

    void preorder(TreeNode4 CurrentNode) {
        if (CurrentNode != null) {
            System.out.print(CurrentNode.data + " ");
            preorder(CurrentNode.LeftChild);
            preorder(CurrentNode.RightChild);
        }
    }

    void postorder(TreeNode4 CurrentNode) {
        if (CurrentNode != null) {
            postorder(CurrentNode.LeftChild);
            postorder(CurrentNode.RightChild);
            System.out.print(CurrentNode.data + " ");
        }
    }

    public boolean add(SimpleObject4 obj, Comparator<? super SimpleObject4> c) {
        //inorder로 출력시에 정렬이 되도록 입력: binary search tree를 구현
        // left subtree < x < right subtree
        TreeNode4 p = root;
        TreeNode4 q = null;
        TreeNode4 n = new TreeNode4(obj);
        if (root == null) {
            root = n;
            return true;
        }

        while (p != null) {
            q = p;
            int comp = c.compare(obj, p.data);
            if (comp == 0) {

                return false;
            } else if (comp < 0) {
                p = p.LeftChild;
            } else {
                p = p.RightChild;
            }
        }

        int comp = c.compare(obj, q.data);
        if (comp < 0) {
            q.LeftChild = n;
        } else {
            q.RightChild = n;
        }
        return true;
    }

    public boolean delete(SimpleObject4 obj, Comparator<? super SimpleObject4> c) {
        //주어진 객체 obj를 포함한 노드를 찾아 삭제하는 알고리즘
        //난이도: 최상급 중에서 최상급
        if (root == null) {
            return false;
        }

        TreeNode4 p = root, q = null;
        while (p != null) {
            int comp = c.compare(obj, p.data);
            if (comp == 0) {
                break;
            } else if (comp < 0) {
                q = p;
                p = p.LeftChild;
            } else {
                q = p;
                p = p.RightChild;
            }
            if (p == null) {
                return false;
            }
        }

        if (p.LeftChild != null && p.RightChild != null) {
            TreeNode4 t = p.RightChild;
            TreeNode4 tp = p;
            while (t.LeftChild != null) {
                tp = t;
                t = t.LeftChild;
            }
            p.data = t.data;

            p = t;
            q = tp;
        } else {
            TreeNode4 t = (p.LeftChild == null) ? p.LeftChild : p.RightChild;
            if (p == root) {
                root = t;
            } else if (q.LeftChild == p) {
                q.LeftChild = t;
            } else {
                q.RightChild = t;
            }
        }
        return true;

    }

    boolean search(SimpleObject4 obj, Comparator<? super SimpleObject4> c) {
        //주어진 객체 obj를 갖는 노드를 찾는 문제
        TreeNode4 p = root;
        while (p != null) {
            int comp = c.compare(obj, p.data);

            if (comp == 0) {
                System.out.println("찾았어요");
                return true;
            } else if (comp < 0) {
                p = p.LeftChild;
            } else {
                p = p.RightChild;
            }

        }
        System.out.println("없어요");
        return false;

    }

    void levelOrder() //root 부터 level별로 출력 : root는 level 1, level 2는 다음줄에 => 같은 level이면 같은 줄에 출력하게 한다 
    {
        if (root == null) {
            System.out.println("트리가 없어요");
            return;
        }
        ObjectQueue4 q = new ObjectQueue4(20);
        TreeNode4 CurrentNode = root;

        q.enque(CurrentNode);
        int count = 1;
        int nlevcount = 0;

        while (!q.isEmpty()) {
            CurrentNode = q.deque();
            count--;
            System.out.print(CurrentNode.data + "\t");

            if (CurrentNode.LeftChild != null) {
                q.enque(CurrentNode.LeftChild);
                nlevcount++;
            }
            if (CurrentNode.RightChild != null) {
                q.enque(CurrentNode.RightChild);
                nlevcount++;
            }

            if (count == 0) {
                System.out.println();
                count = nlevcount;
                nlevcount = 0;
            }
        }
        System.out.println();

    }

    void NonrecInorder()//void Tree::inorder(TreeNode4 *CurrentNode)와 비교
    //stack을 이용하여 inorder traversal하는 알고리즘 구현
    {
        ObjectStack4 s = new ObjectStack4(20);
        TreeNode4 CurrentNode = root;
        while (true) {
            while (CurrentNode != null) {
                s.push(CurrentNode);
                CurrentNode = CurrentNode.LeftChild;
            }
            if (!s.isEmpty()) {
                try {
                    CurrentNode = s.pop();
                } catch (Chap9_Tree.ObjectStack4.EmptyGenericStackException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println(" " + CurrentNode.data);
                CurrentNode = CurrentNode.RightChild;
            } else {
                break;
            }
        }
    }
}

public class train_실습과제9_2_객체이진트리 {

    enum Menu {
        Add("삽입"), Delete("삭제"), Search("검색"), InorderPrint("정렬출력"),
        LevelorderPrint("레벨별출력"), StackInorderPrint("스택정렬출력"),
        PreorderPrint("prefix출력"), PostorderPrint("postfix출력"), Exit("종료");

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
        Scanner stdIn = new Scanner(System.in);
        int key;
        do {
            for (Menu m : Menu.values()) {
                System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
            }
            System.out.print(" : ");
            key = stdIn.nextInt();
        } while (key < Menu.Add.ordinal() || key > Menu.Exit.ordinal());

        return Menu.MenuAt(key);
    }

    public static void main(String[] args) {
        Scanner sc2 = new Scanner(System.in);
        Tree4 t = new Tree4();
        Menu menu; // 메뉴
        String sno1, sname1;
        SimpleObject4 so;
        int count = 0;
        int num;
        boolean result;
        do {
            switch (menu = SelectMenu()) {
                case Add: // 
                    SimpleObject4[] sox = {new SimpleObject4("33", "ee"),
                        new SimpleObject4("55", "tt"),
                        new SimpleObject4("22", "ww"),
                        new SimpleObject4("66", "yy"),
                        new SimpleObject4("21", "wq")};
                    for (SimpleObject4 soz : sox) {
                        t.add(soz, SimpleObject4.NO_ORDER);
                    }
                    break;

                case Delete: //임의 정수 삭제
                    so = new SimpleObject4();
                    so.scanData("삭제", SimpleObject4.NO);
                    t.delete(so, SimpleObject4.NO_ORDER);

                    break;

                case Search: // 노드 검색
                    so = new SimpleObject4();
                    so.scanData("검색", SimpleObject4.NO);
                    result = t.search(so, SimpleObject4.NO_ORDER);
                    if (!result) {
                        System.out.println("검색 값 = " + so + "데이터가 없습니다.");
                    } else {
                        System.out.println("검색 값 = " + so + "데이터가 존재합니다.");
                    }
                    break;

                case InorderPrint: // 전체 노드를 키값의 오름차순으로 표시
                    t.inorder();
                    System.out.println();
                    //t.NonrecInorder();
                    break;
                case LevelorderPrint: // 전체 노드를 키값의 오름차순으로 표시
                    t.levelOrder();
                    System.out.println();
                    //t.NonrecInorder();
                    break;
                case StackInorderPrint: // 전체 노드를 키값의 오름차순으로 표시
                    t.NonrecInorder();
                    break;
                case PreorderPrint://prefix 출력
                    t.preorder();
                    System.out.println();
                    break;
                case PostorderPrint://postfix로 출력
                    t.postorder();
                    System.out.println();
                    break;
            }
        } while (menu != Menu.Exit);
    }
}
