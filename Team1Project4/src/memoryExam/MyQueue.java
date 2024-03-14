package memoryExam;

public class MyQueue extends Memory {
	private int front;

	@Override
	public int pop() {
		if (front == 0 && top == 0) {
			System.out.println("Queue가 비었습니다.");
			return -1;
		} else {
			System.out.println("front:" + front);
			System.out.println("top:" + top);
			return arr[front++];
		}
	}

	@Override
	public void push(int data) {
		if (front == 0 && top == 5) {
			System.out.println("Queue가 가득찼습니다.");
		} else if (front != 0 && top == 5) {
			for (int i = front; i < 5; i++) {
				arr[i - front] = arr[i];
			}
			top -= front;
			front = 0;
			arr[top++] = data;
			System.out.println("front:" + front);
			System.out.println("top:" + top);
		} else {
			arr[top++] = data;
			System.out.println("front:" + front);
			System.out.println("top:" + top);
		}
	}
}
