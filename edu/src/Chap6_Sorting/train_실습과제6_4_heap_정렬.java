package Chap6_Sorting;
//heap의 full, empty에 대한 예외처리 구현 권장 
import java.util.Random;
import java.util.Scanner;

interface MaxHeap {
	public void Insert(int x);
	public int DeleteMax();
}

class Heap implements MaxHeap {
	final int heapSize = 100;
	private int[] heap;
	private int n; // MaxHeap의 현재 입력된 element 개수
	private int MaxSize; // Maximum allowable size of MaxHeap
	
	public Heap(int sz) {
		MaxSize = sz;
		heap= new int[MaxSize+1];
		n = 0;
	}

	public void display() {//heap 배열을 출력한다. 배열 인덱스와 heap[]의 값을 출력한다.
		
		for (int i = 1; i <= n; i++) {
			System.out.print(heap[i]+"\t");
		}
		System.out.println();
	}
	public void change(int i, int j){
		int imsi = heap[i];
			heap[i] = heap[j];
			heap[j] = imsi;
	}
	@Override
	public void Insert(int x) {//max heap이 되도록 insert한다. 삽입후 complete binary tree가 유지되어야 한다.
		int i;
		if (n == MaxSize) {
			HeapFull();
			return;
		}

		n++;
		i = n;
		heap[i] = x;
		while(i > 1 && heap[i / 2] < heap[i]){
			change(i, i/2);
			i = i/2;
		}
	}
	@Override
	public int DeleteMax() {//heap에서 가장 큰 값을 삭제하여 리턴한다. 
		int x= heap[1];
		int i = 1;
		int j;
		if (n == 0) {
			HeapEmpty();
			int elm = 0;
			return elm;
		}
	
		heap[1]=heap[n];
		heap[n]=0;
		n--;
		while (i * 2 <= n) { 
			j = i * 2;
			if (j + 1 <= n && heap[j] < heap[j+1]) {
				j++;
			}
			if (heap[i] >= heap[j]) {
				break;
			}
			change(i, j);
			i=j;
		}
		
		return x;
	} 

	private void HeapEmpty() {
		System.out.println("Heap Empty");
	}

	private void HeapFull() {
		System.out.println("Heap Full");
	}

    public int getN() {
        return n;
    }
}
public class train_실습과제6_4_heap_정렬 {
	 static void showData(int[] d) {
		for (int i = 1; i < d.length; i++) {
			System.out.print(d[i]+"\t");
		}
		System.out.println();
	 }
	public static void main(String[] args) {
		Random rnd = new Random();
		int select = 0;
		Scanner stdIn = new Scanner(System.in);
		Heap heap = new Heap(20);
	    final int count = 10;//난수 생성 갯수
	    int[] x = new int[count+1];//x[0]은 사용하지 않으므로 11개 정수 배열을 생성한다 
	    //heap을 사용하여 deleted 정수를 배열 sorted[]에 보관후 출력한다

		do {
			System.out.println("Max Tree. Select: 1 insert, 2 display, 3 sort, 4 exit => ");
			select = stdIn.nextInt();
			switch (select) {
			case 1://난수를 생성하여 배열 x에 넣는다 > heap에 insert한다.
				for (int i = 1; i < count+1; i++) {
					x[i] = rnd.nextInt(99)+1;
					heap.Insert(x[i]);
				}
			     showData(x);
				break;
			case 2:	//heap 트리구조를 배열 인덱스를 사용하여 출력한다.
				
				heap.display();
				break;
			case 3://heap에서 delete를 사용하여 삭제된 값을 배열 sorted에 넣는다 > 배열 sorted[]를 출력하면 정렬 결과를 얻는다 
			int s = heap.getN();
			int []sorted = new int[s];
				for (int i = 0; i < s; i++) {
					sorted[i] = heap.DeleteMax();
				}

				for (int i = sorted.length-1; i >= 0; i--) {
					System.out.print(sorted[i]+"\t");
				}
				System.out.println();
				break;

			case 4:
				return;

			}
		} while (select < 5);

		return;
	}
}

