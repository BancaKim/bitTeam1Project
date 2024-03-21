import java.util.Scanner;

public class FactorialCond {

	public static void main(String[] args) {

		FactorialCond fct = new FactorialCond();

		Scanner sc = new Scanner(System.in);
		System.out.print("number: ");
		int input = sc.nextInt();

		int resultFct = fct.factorial(input);

		System.out.println("total=" + resultFct);
	}

	public int factorial(int n) {
		int result = 1;
		for (int i = n; i > 0; i--) {
			result *= i;
		}
		return result;
	}
}