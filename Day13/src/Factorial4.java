import java.util.Scanner;

public class Factorial4 {

	int result = 1;

	public static void main(String[] args) {

		Factorial4 fct = new Factorial4();

		Scanner sc = new Scanner(System.in);
		System.out.print("number: ");
		int input = sc.nextInt();

		int resultFct = fct.factorial(input);

		System.out.println("total=" + resultFct);
	}

	public int factorial(int n) {
		if (n > 0) {
			result *= n;
			factorial(--n);
		}
		return result;
	}
}