import java.util.ArrayList;
import java.util.Scanner;

public class BaseBall1 {
	
	
	
	
	public static void main(String[] args) {

		ArrayList<Integer> answer = new ArrayList<Integer>(3);
		ArrayList<Integer> myAns = new ArrayList<Integer>(3);

		int index =0;
		
		while (index!=3) {
			int rnd = (int) (Math.random() * 10);
			if(answer.contains(rnd)){
				continue;				
			}else {
				answer.add(rnd);
				index ++;
			}
		}

		int count = 1;
		int strike = 0;
		int ball = 0;
		Scanner sc = new Scanner(System.in);

		do {
//			System.out.println(answer);
			System.out.print("input three number : ");
			String myAnssc = sc.next();

			for (int i = 0; i < 3; i++) {
				myAns.add((int) myAnssc.charAt(i)-48);
			}
			
//			System.out.println(myAns);

			for (int i = 0; i < 3; i++) {
				if (answer.contains(myAns.get(i))) {
					if (answer.get(i).equals(myAns.get(i))) {
						strike++;
					} else {
						ball++;
					}
				}
			}

			System.out.println(strike + " strike, " + ball + "ball");

			
			if(strike==3) {
				System.out.println("success!! count: "+ count);
			} else {
				myAns.clear();
				strike = 0;
				ball = 0;
				count++;
			}
		} while (strike != 3);

	}
}
