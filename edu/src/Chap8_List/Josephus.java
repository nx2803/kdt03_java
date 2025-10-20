package Chap8_List;
// 문제1) 조세푸스 문제(Josephus Problem)

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

// 고전적인 수학 퍼즐로, 원형으로 앉아 있는 사람들 중에서 특정 규칙에 따라 사람들을 제거하면서 마지막으로 남는 사람을 찾는 문제2이다. 이 문제는 다음과 같은 이야기에서 유래되었다.
// 1.	문제 배경:
// 고대 유대의 역사가 요세푸스(Josephus)와 그의 동료들이 로마군에게 포위당한 상황에서 자살을 결심하게 된다. 그들은 자살할 순서를 정하기 위해 원을 만들고, 특정 간격마다 사람을 제거하는 방식으로 마지막 사람을 남기는 방법을 선택한다.   요세푸스는 이 방법을 통해 마지막에 살아남을 위치를 계산해 자신은 자살을 피했다.
// 문제 설명:
// N명의 사람이 원형으로 앉아 있다.
// K번째 사람을 반복적으로 제거한다.
// 이 과정을 N-1명이 제거될 때까지 반복한다. 3번째가 제거 대상이면 2명(A> B)이면 A가 자살 대상이다
// 마지막으로 남는 사람의 위치를 구하는 문제이다.
// 입력:
// N: 사람의 수(각 사람의 id는 정수 난수로 생성- 생성 순서로 원형 singly linked list에 id의 올림차순으로 정렬되게 삽입)
// K: 제거할 사람의 순서
// 출력:
// 1.	올림차순으로 정렬된 사람 id 순서를 출력
// 2.	제거되는 k 번째 id 순서대로 출력
// 3.	마지막으로 남는 사람의 id를 출력
class Node {

    int id;
    Node next;

    public Node(int id) {
        this.id = id;
        this.next = null;
    }

}

public class Josephus {

    static Node MakeNode(int mn) {
        Random rd = new Random();
        HashSet<Integer> set = new HashSet<>();
        Node s = new Node(0);
        Node n = s.next;
        Node c = s;
        int count = 0;
        while (count < mn) {
            int id = rd.nextInt(50) + 1;
            if (!set.contains(id)) {
                set.add(id);
                Node newNode = new Node(id);
                Node p = s;
                while (p.next != null && p.next.id < id) {
                    p = p.next;
                }
                newNode.next = p.next;
                p.next = newNode;
                if (p == c) {
                    c = newNode;
                }
                count++;
            }

        }
        c.next = s.next;
        return s.next;
    }

    static void showList(Node a) {
        Node c = a;
        do {
            System.out.print("\t" + c.id);
            c = c.next;

        } while (c != a);

        System.out.println();
    }

    static void kill(int mn, Node a, int k) {
        Node kd = new Node(0);
        Node kd2 = kd;
        Node p = a;
        while (p.next != a) {
            p = p.next;
        }
        while (a.next != a) {

            for (int i = 1; i < k; i++) {
                p = p.next;
            }

            Node killed = p.next;
            kd2.next = killed;
            kd2 = killed;
            if (killed == a) {
                a = killed.next;
            }

            p.next = killed.next;
            killed.next = null;
        }
        System.out.print("사망자 : ");
        Node kd3 = kd.next;
        while (kd3 != null) {
            System.out.print("\t" + kd3.id);
            kd3 = kd3.next;
        }
        System.out.println();
        System.out.println("생존자 : \t" + a.id);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("인원 수 입력 : ");
        int mn = sc.nextInt();
        System.out.print("제거 순서 입력 : ");
        int k = sc.nextInt();
        Node jo = MakeNode(mn);
        System.out.print("사람들 목록 : ");
        showList(jo);
        kill(mn, jo, k);
    }
}
