package memoryExam;

public class MyStack extends Memory {

	@Override
	public int pop() {
		if (top == 0) {
			System.out.println("Stack이 비었습니다.");
			return -1;
		} else {
			return arr[--top];
		}
	}

	@Override
	public void push(int data) {
		if (top == 5) {
			System.out.println("Stack이 가득 찼습니다.");
		} else {
			arr[top++] = data;
		}
	}
	String
}