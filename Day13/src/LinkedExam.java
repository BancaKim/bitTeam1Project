import java.util.Scanner;

public class LinkedExam {
	static LinkNode head;
	static LinkNode cur;
	static LinkNode newNode;
	static LinkNode del;

	public static void main(String[] args) {
		head = cur = newNode = new LinkNode();
		newNode.next = null;

		newNode.setData(1);
		newNode.next = new LinkNode();
		newNode.next.setData(2);
		newNode.next.next = null;

		newNode.next.next = new LinkNode();
		newNode.next.next.setData(3);
		newNode.next.next.next = null;

		newNode.next.next.next = new LinkNode();
		newNode.next.next.next.setData(4);
		newNode.next.next.next.next = null;

		newNode = new LinkNode();
		newNode.next = head;
		head = newNode;

		newNode.setData(5);
		cur = head;
//
		Scanner sc = new Scanner(System.in);
		System.out.print("몇번째 추가할거야?:");
		int answer = sc.nextInt();
		System.out.print("얼마 추가할거야?:");
		int response = sc.nextInt();

		// 데이터삽입
		LinkNode linkNode = new LinkNode();
		linkNode.setData(response);

		if (answer == 1) {
			linkNode.next = head;
			head = cur = linkNode;

		} else {
			cur = head;
			for (int i = 0; i < answer - 2; i++) {
				cur = cur.next;
				System.out.println("cur:" + cur.getData());
			}

			linkNode.setData(response);
			linkNode.next = cur.next;
			cur.next = linkNode;
		}

		cur = head;

		while (cur != null) {
			System.out.println(cur.getData());
			cur = cur.next;
		}

		// 입력 => 삽입
		System.out.print("몇번째 삭제?:");
		int input = sc.nextInt();

		// 삭제
		cur = head;
		if (input == 1) {
			del = head;
			head = head.next;
		} else {
			cur = head;
			for (int i = 0; i < input - 2; i++) {
				cur = cur.next;
				System.out.println("cur:" + cur.getData());
			}

			del = cur.next;
			cur.next = del.next;
		}
		del.next = null;
		del = null;

		// 출력
		cur = head;

		while (cur != null) {
			System.out.println(cur.getData());
			cur = cur.next;
		}
	}

}