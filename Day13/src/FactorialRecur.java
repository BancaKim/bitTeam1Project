import java.util.Scanner;

public class FactorialRecur {

	public static void main(String[] args) {

		FactorialRecur fct = new FactorialRecur();

		Scanner sc = new Scanner(System.in);
		System.out.print("number: ");
		int input = sc.nextInt();

		int resultFct = fct.factorial(input);

		System.out.println("total=" + resultFct);
	}

	public int factorial(int n) {
		if (n > 0) {
			return n * factorial(n - 1);
		} else {
			return 1;
		}
	}
}