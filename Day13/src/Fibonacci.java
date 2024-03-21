import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {

		Fibonacci fib = new Fibonacci();

		Scanner sc = new Scanner(System.in);
		System.out.print("number: ");
		int input = sc.nextInt();

		int result = fib.fibonacci(input);

//		System.out.println("result=" + result);
		
		for(int i=1;i<input+1;i++) {
			System.out.println(fib.fibonacci(i));
		}
	}

	public int fibonacci(int n) {
		if (n == 1) {
			return 0;
		} else if (n == 2) {
			return 1;
		} else {
			return fibonacci(n - 2) + fibonacci(n - 1);
		}
	}
}