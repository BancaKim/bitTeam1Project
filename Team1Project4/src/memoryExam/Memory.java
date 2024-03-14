package memoryExam;

public abstract class Memory {
	protected int[] arr;
	protected int top; // 마지막 위치

	public Memory() {
		arr = new int[5];
		top = 0;
	}

	public void push(int data) {
		arr[top++] = data;
	}

	public abstract int pop();
}
