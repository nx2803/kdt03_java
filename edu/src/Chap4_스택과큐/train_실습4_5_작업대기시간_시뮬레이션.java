package Chap4_스택과큐;

import java.util.Random;
import java.util.Scanner;

import Chap4_스택과큐.IntQueue3.EmptyIntQueue3Exception;

public class train_실습4_5_작업대기시간_시뮬레이션 {
	/*
	 * 문제 예시: timeslot 기반의 작업 scheduling 시스템 문제 설명: 어느 회사에서는 여러 작업이 동시에 들어오며, 각 작업의
	 * 처리 시간은 난수로 배정된다. 각 작업은 주어진 time slot 단위로 나눠서 처리되며, 처리 중인 작업은 완료되지 않았더라도 타임슬롯이
	 * 끝나면 큐의 마지막에 다시 대기해야 한다. 순서대로 돌아가며 타임슬롯을 할당하여 작업을 처리하는 이 시스템에서, 작업이 끝나면 큐에서
	 * 제거되고 완료된 시간을 출력한다, 그렇지 않으면 다음 타임슬롯에 다시 처리될 때까지 대기열의 끝으로 이동합니다.
	 * 
	 * 조건: 각 작업에는 고유의 이름과 남은 작업 시간이 주어집니다. 타임슬롯(T)의 크기가 주어집니다. 각 작업은 타임슬롯 단위로 처리되며,
	 * 만약 작업이 완료되지 않으면 남은 시간이 줄어들고 큐의 끝으로 이동합니다. 작업이 완료되면 큐에서 제거됩니다. 모든 작업이 완료될 때까지
	 * 반복적으로 처리합니다.
	 * 
	 * 입력 형식: 첫 번째 줄에 타임슬롯 크기 T가 주어집니다. 두 번째 줄에는 각 작업의 이름과 남은 시간이 (작업 이름, 시간)의 형식으로
	 * 주어집니다.
	 * 
	 * 출력 형식: 각 타임슬롯에서 처리된 작업의 이름과 남은 시간을 출력합니다. 작업이 완료된 경우 "작업 완료"를 출력합니다.
	 * 
	 * 제약 조건: 1 ≤ T ≤ 10 1 ≤ 작업의 개수 ≤ 100 각 작업의 남은 시간은 1 이상 100 이하입니다.
	 */

	public static void main(String[] args) {
		int timeslot;
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();

		System.out.print("타임슬롯 크기를 입력해주세요.(1~10) :");
		int timeSlot = sc.nextInt();
		sc.nextLine();
		System.out.print("작업을 입력해주세요.(쉼표로 구분, 1~100) :");
		String[] jName = sc.nextLine().split(",");
		JQueue jq = new JQueue(100);

		for (int i = 0; i < jName.length; i++) {
			Job j = new Job(jName[i], rd.nextInt(100) + 1);
			jq.enque(j);
		}
		jq.dump();
		System.out.println("=========작업시작=========");
		while (!jq.isEmpty()) {
			jq.work(timeSlot);
		}

	}
}

class Job {
	String jobName;
	int time;

	public Job(String jobName, int time) {
		this.jobName = jobName;
		this.time = time;
	}

	public String getJobName() {
		return this.jobName;
	}

	public int getTime() {
		return this.time;
	}

	@Override
	public String toString() {
		return "(" + jobName + ", " + time + ")";
	}
}

class JQueue {
	private Job[] que; // 큐용 배열
	private int capacity; // 큐의 크기
	private int front; // 맨 처음 요소 커서
	private int rear; // 맨 끝 요소 커서
	boolean isEmptyTag;

	public JQueue(int cap) {
		que = new Job[cap];
		front = rear = 0;
		capacity = cap;
		isEmptyTag = true;
	}

	public class EmptyQueueException extends RuntimeException {
		public EmptyQueueException(String msg) {
			super(msg);
		}
	}

	public class OverflowIntQueue3Exception extends RuntimeException {
		public OverflowIntQueue3Exception(String string) {
			super(string);
		}
	}

	public boolean enque(Job x) throws OverflowIntQueue3Exception {

		if (front == rear && isEmptyTag == false)
			throw new OverflowIntQueue3Exception("큐 enque오버플로우");
		que[rear] = x;
		isEmptyTag = false;
		rear = (rear + 1) % capacity;
		return true;
	}

	public Job deque() throws EmptyIntQueue3Exception {
		if (front == rear && isEmptyTag == false)
			throw new EmptyQueueException("큐 deque언더플로우");
		Job result = que[front];
		front = (front + 1) % capacity;
		if (front == rear)
			isEmptyTag = true;
		return result;
	}

	public boolean isEmpty() {
		return isEmptyTag && front == rear;
	}

	public int size() {
		if (front == rear) {
			if (isEmptyTag) {
				return 0;
			}
			return capacity;
		} else if (front < rear) {
			return rear - front;
		} else
			return capacity - front + rear;

	}

	public void dump() {
		System.out.println("=========작업목록=========");
		for (int i = 0; i < this.size(); i++) {
			System.out.println("작업이름 : " + que[(front + i) % capacity].getJobName() + ", 작업 시간: "
					+ que[(front + i) % capacity].getTime());
		}
		System.out.println("========================");
		System.out.println();
	}

	public void work(int t) {
		if (!isEmpty()) {
			que[front].time = que[front].time - t;
			if (que[front].time <= 0) {
				System.out.println(que[front].jobName + " 작업 완료!");
				deque();
			} else {
				System.out.println(que[front].jobName + " 처리, 남은 시간:  " + que[front].time);
				enque(deque());

			}
		}
	}

}
