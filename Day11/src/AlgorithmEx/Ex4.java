package AlgorithmEx;

import java.util.Scanner;

public class Ex4 {

	public static void main(String[] args) {
		int[] arr;
		int[] counts;
		int run;
		int triplete;
		int qna = 1;

		Scanner sc = new Scanner(System.in);

		do {
			System.out.print("Input 6 numbers: ");
			arr = new int[6];
			counts = new int[10];
			run = 0;
			triplete = 0;

			int answer = sc.nextInt();

			for (int i = 0; i < 6; i++) {
				arr[i] = answer % 10;
				answer = answer / 10;
			}

			for (int i = 0; i < 6; i++) {
				counts[arr[i]]++;
			}

			int i = 0;
			while (i < counts.length) {
				if (counts[i] >= 3) {
					triplete++;
					counts[i] -= 3;
					continue;
				}

				if (i <= 7 && counts[i] >= 1 && counts[i + 1] >= 1 && counts[i + 2] >= 1) {
					run++;
					counts[i] -= 1;
					counts[i + 1] -= 1;
					counts[i + 2] -= 1;
					continue;
				}
				 i++;
			}

			if (run + triplete >= 2) {
				System.out.println("baby-gin !!!");
			} else {
				System.out.println("Lose");
			}

			System.out.print("Play this game again? <1-yes/2-no>: ");
			qna = sc.nextInt();
		} while (qna == 1);
	}

}
