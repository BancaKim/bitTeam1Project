package memoryExam;

import java.util.Arrays;
import java.util.Scanner;

public class MemoryMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MyStack ms = new MyStack();
		MyQueue mq = new MyQueue();
		Memory m = ms;

		do {
			System.out.print("1.Stack 2.Queue 3.exit: ");
			int num = sc.nextInt();

			if (num == 1) {
				m = ms;
			} else if (num == 2) {
				m = mq;
			} else {
				System.exit(0);
			}

			while (true) {
				System.out.print("1.push 2.pop 3.back: ");

				int n = sc.nextInt();

				if (n == 1) {
					System.out.print("숫자입력:");
					m.push(sc.nextInt());
					System.out.println(Arrays.toString(m.arr));

				} else if (n == 2) {
					System.out.println(m.pop());
					System.out.println(Arrays.toString(m.arr));
				} else
					break;
			}

		} while (true);
	}
}
