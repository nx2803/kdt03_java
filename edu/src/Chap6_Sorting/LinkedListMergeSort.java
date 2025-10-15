package Chap6_Sorting;

public class LinkedListMergeSort {

    // (1) 노드 클래스 정의
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * 핵심 1: 분할 (Divide)과 재귀 호출
     * @param head 정렬할 연결 리스트의 시작 노드
     * @return 정렬된 연결 리스트의 head 노드
     */
    public Node mergeSort(Node head) {
        // 기저 사례(종료 조건): 노드가 없거나, 노드가 하나일 때 (이미 정렬됨)
        if (head == null || head.next == null) {
            return head;
        }

        // 1. 중간 지점을 찾아 리스트를 두 부분으로 나눈다.
        Node middle = getMiddle(head);
        Node nextOfMiddle = middle.next;
        middle.next = null; // 리스트를 두 개로 분리 (중요!)

        // 2. 왼쪽과 오른쪽 리스트를 재귀적으로 정렬 (정복)
        Node left = mergeSort(head);
        Node right = mergeSort(nextOfMiddle);

        // 3. 정렬된 두 리스트를 합병(Merge)한다.
        return merge(left, right);
    }

    /**
     * 보조 함수: 연결 리스트를 반으로 나누기 위해 중간 노드를 찾는다 (Fast/Slow Pointer 기법)
     */
    private Node getMiddle(Node head) {
        if (head == null) return head;

        Node slow = head; // 1칸씩 이동
        Node fast = head; // 2칸씩 이동

        // fast가 끝에 도달하면, slow는 중간에 와 있다.
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 핵심 2: 합병 (Merge)
     * @param left 이미 정렬된 왼쪽 리스트
     * @param right 이미 정렬된 오른쪽 리스트
     * @return 합병된 정렬 리스트의 head
     */
    private Node merge(Node left, Node right) {
        // 합병된 리스트의 시작을 위한 '가짜' 노드 (Dummy Node)를 생성한다.
        Node dummyHead = new Node(0); 
        Node current = dummyHead;

        // 두 리스트 중 하나라도 끝날 때까지 반복
        while (left != null && right != null) {
            if (left.data <= right.data) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }
            current = current.next; // current를 한 칸 앞으로 이동
        }

        // 남은 노드들을 처리 (둘 중 하나는 null임)
        if (left != null) {
            current.next = left;
        }
        if (right != null) {
            current.next = right;
        }

        return dummyHead.next; // 가짜 노드의 다음 노드부터가 진짜 정렬된 리스트의 시작이다.
    }
    
    // --- 실행 및 테스트 함수 ---
    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        LinkedListMergeSort sorter = new LinkedListMergeSort();

        // 8 -> 3 -> 7 -> 4 -> 2 -> 6 -> 1 -> 5 -> NULL
        Node head = new Node(8);
        head.next = new Node(3);
        head.next.next = new Node(7);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(2);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(1);
        head.next.next.next.next.next.next.next = new Node(5);

        System.out.print("정렬 전: ");
        printList(head);

        Node sortedHead = sorter.mergeSort(head);

        System.out.print("정렬 후: ");
        printList(sortedHead);
        // 예상 출력: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> NULL
    }
}