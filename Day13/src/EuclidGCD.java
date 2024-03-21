import java.util.Scanner;

public class EuclidGCD {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("숫자1입력: ");
		int num1 = sc.nextInt();
		System.out.print("숫자2입력: ");
		int num2 = sc.nextInt();

		int result = EuclidGCD.gcd(num1, num2);
		System.out.println("result=" + result);
	}

	public static int gcd(int num1, int num2) {
		if (num2 == 0) {
			return num1;
		} else {
			return gcd(num2, num1%num2);
		}
	}

}
