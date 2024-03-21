import java.util.Scanner;

public class Factorial2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("number: ");
		int input = sc.nextInt();
		System.out.println(input);
		
		int inputNext = input-1;
		
		while (inputNext > 0) {
			System.out.println(inputNext);
			input *= inputNext;
			inputNext --;
		}
		System.out.println("total="+input);
	}
}
