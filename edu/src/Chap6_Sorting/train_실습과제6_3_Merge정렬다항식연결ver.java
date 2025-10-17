package Chap6_Sorting;

/*
 * 6장 구현과제3
 

 
 * 6장 구현과제 - 다항식 add, multiply
 */
class Node implements Comparable<Node> {

    double coef;           // 계수
    int exp;            // 지수
    Node next;
    //--- 생성자(constructor) ---//

    public Node(double coef, int exp) {
        this.coef = coef;
        this.exp = exp;
        this.next = null;
    }

    @Override
    public String toString() {
        return coef + "x^" + exp + " ";
    }

    @Override
    public int compareTo(Node d2) { //지수가 같으면 계수로 비교
        if (this.exp != d2.exp) {
            return d2.exp - this.exp;
        }
        return Double.compare(d2.coef, coef);
    }
}

public class train_실습과제6_3_Merge정렬다항식연결ver {

    static Node merge(Node left, Node right) {
        Node s = new Node(0.0, 0);
        Node cu = s;

        while (left != null && right != null) {
            if (left.exp > right.exp) {
                cu.next = left;
                left = left.next;
            } else if (left.exp < right.exp) {
                cu.next = right;
                right = right.next;
            } else {
                if (left.coef > right.coef) {
                    cu.next = left;
                    left = left.next;
                } else {
                    cu.next = right;
                    right = right.next;
                }
            }
            cu = cu.next;
        }
        if (left != null) {
            cu.next = left;
        } else {
            cu.next = right;
        }
        return s.next;
    }

    static Node Middle(Node x) {
        if (x == null || x.next == null) {
            return x;
        }
        Node slow = x;
        Node fast = x.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    static Node MergeSort(Node x) {
        if (x == null || x.next == null) {
            return x;
        }
        Node mid = Middle(x);
        Node midNext = mid.next;
        mid.next = null;

        Node left = x;
        Node right = midNext;

        left = MergeSort(left);
        right = MergeSort(right);

        return merge(left, right);
    }

    static void ShowPolynomial(String msg, Node x) {
        //str 변수는 다항식 이름으로 스트링이다
        //count가 -1이면 다항식 x의 length로 계산하고 -1이면 count가 다항식 항의 숫자이다 
        //정렬후 다항식 x = 2.5x**7  + 3.8x**5  + 3.1x**4  + 1.5x**3  + 3.3x**2  + 4.0x**1  + 2.2x**0 
        //구현코드
        System.out.print(msg);
        Node cu = x;
        boolean fir = true;
        while (cu != null) {
            if (cu.coef == 0.0) {
                cu = cu.next;
                continue;
            }
            if (!fir) {
                System.out.print(" + ");
            }
            System.out.print(cu.toString());
            fir = false;
            cu = cu.next;
        }
        if (fir) {
            System.out.print("0");
        }
        System.out.println();
    }


    static Node AddPolynomial(Node p1, Node p2) {
        //result = p1 + p2, 다항식 덧셈 결과를 result로 주고 result의 항의 수 terms을 리턴한다 
        // int p = 0, q = 0, r = 0;
        // int terms = 0;
        Node s = new Node(0.0, 0);
        Node tp1 = p1;
        Node tp2 = p2;
        Node cu = s;

        while (tp1 != null && tp2 != null) {
            if (tp1.exp > tp2.exp) {
                cu.next = new Node(tp1.coef, tp1.exp);
                tp1 = tp1.next;
                cu = cu.next;

            } else if (tp1.exp < tp2.exp) {
                cu.next = new Node(tp2.coef, tp2.exp);
                tp2 = tp2.next;
                cu = cu.next;

            } else {
                double addcoef = Math.round((tp1.coef + tp2.coef) * 100.0) / 100.0;
                if (addcoef != 0.0) {
                    cu.next = new Node(addcoef, tp1.exp);
                    cu = cu.next;
                }
                tp1 = tp1.next;
                tp2 = tp2.next;
            }

        }
        Node remain = (tp1 != null) ? tp1 : tp2;
        while (remain != null) {
            cu.next = new Node(remain.coef, remain.exp);
            cu = cu.next;
            remain = remain.next;
        }
        return s.next;

    }

    static Node MultiplyPolynomial(Node p1, Node p2) {
        //result = p1 * p2, 다항식 result의 항의 수는 terms으로 리턴한다 
        //terms = addTerm(result, term, terms);사용하여 곱셈항을 추가한다.
        if (p1 == null || p2 == null) {
            return null;
        }

        Node s = null;

        for (Node now1 = p1; now1 != null; now1 = now1.next) {
            Node temp = new Node(0.0, 0);
            Node tempcu = temp;

            for (Node now2 = p2; now2 != null; now2 = now2.next) {
                double mulcoef = now1.coef * now2.coef;
                int resexp = now1.exp + now2.exp;
                if (mulcoef != 0.0) {
                    tempcu.next = new Node(mulcoef, resexp);
                    tempcu = tempcu.next;
                }
            }
            Node templ = temp.next;
            if (temp.next != null) {
                Node sortTemp = MergeSort(templ);

                s = AddPolynomial(s, sortTemp);
            }
        }
        return s;
    }

    static double EvaluatePolynomial(Node p, double value) {
        //다항식 계산 결과를 double로 리턴한다 
        double result = 0.0;
        //구현 코드
        Node cu = p;
        while (cu != null) {
            double jg = 1.0;
            for (int i = 0; i < cu.exp; i++) {
                jg *= value;
            }
            result += cu.coef * jg;
            cu = cu.next;
        }
        return result;
    }

    static Node MakeNodeFromArray(Node[] a) {
        Node s = new Node(0.0, 0);
        Node cu = s;
        for (int i = 0; i < a.length; i++) {
            cu.next = a[i];
            cu = cu.next;
        }
        return s.next;
    }

    public static void main(String[] args) {
        Node[] pp1 = {
            new Node(1.5, 3),
            new Node(2.5, 7),
            new Node(3.3, 2),
            new Node(4.0, 1),
            new Node(2.2, 0),
            new Node(3.1, 4),
            new Node(3.8, 5),};

        Node[] pp2 = {
            new Node(1.5, 1),
            new Node(2.5, 2),
            new Node(3.3, 3),
            new Node(4.0, 0),
            new Node(2.2, 4),
            new Node(3.1, 5),
            new Node(3.8, 6),};

        Node p1 = MakeNodeFromArray(pp1);
        Node p2 = MakeNodeFromArray(pp2);
        //int nx = p1.length;

        ShowPolynomial("다항식 p1 = ", p1);
        ShowPolynomial("다항식 p2 = ", p2);
        p1 = MergeSort(p1);
        p2 = MergeSort(p2);
        ShowPolynomial("정렬후 다항식 p1 = ", p1);
        ShowPolynomial("정렬후 다항식 p2 = ", p2);

        //다항식 덧셈
        ShowPolynomial("덧셈후 다항식 result = ", AddPolynomial(p1, p2));

        //다항식 곱셈
        Node res2 = MultiplyPolynomial(p1, p2);
        ShowPolynomial("곱셈후 다항식 result = ", res2);

        double value = 1.5;
        double resultValue = EvaluatePolynomial(res2, value);//다항식 값 계산 함수 z(10) 값 계산한다 
        System.out.println("x= " + value + " result = " + resultValue);
    }
}
