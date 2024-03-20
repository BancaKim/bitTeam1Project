import java.util.Arrays;
import java.util.Scanner;

public class Queue {
	int[] queue;
	int front;
	int rear;

	public Queue() {
		this.queue = new int[5];
	}

	public static void main(String[] args) {

		Queue queueClass = new Queue();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("1.Enqueue 2.Dequeue 3.Stop: ");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.print("숫자를 입력하여 주세요.: ");
				int input = sc.nextInt();

				queueClass.enQueue(input);
				System.out.println(Arrays.toString(queueClass.queue));// 확인용
				break;

			case 2:
				queueClass.deQueue();
				System.out.println(Arrays.toString(queueClass.queue));// 확인용
				break;
			case 3:
				System.exit(0);
			}
		}
	} // main 끝

	public void shift() {
		int size = rear - front;
		for (int i = 0; i < queue.length; i++) {
			if (i < size) {
				queue[i] = queue[i + front];
			} else {
				queue[i] = 0;
			}
		}
		rear -= front;
		front = 0;
	}

	public void enQueue(int input) {
		if (front == 0 && rear == queue.length) {
			System.out.println("Queue가 full 상태입니다.");
		} else if (front != 0 && rear == 5) {
			shift();
			this.queue[rear++] = input;
		} else {
			this.queue[rear++] = input;
		}
	}

	public void deQueue() {
		if (front == rear) {
			System.out.println("Queue가 비었습니다.");
		} else {
			System.out.println(this.queue[front]);
			this.queue[front++] = 0;
		}
	}
}
