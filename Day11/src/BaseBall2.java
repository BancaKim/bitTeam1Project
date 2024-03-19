import java.util.ArrayList;
import java.util.Scanner;

public class BaseBall2 {
	

	ArrayList<Integer> answer; 
	ArrayList<Integer> myAns; 
	int index;
	int count;
	int strike;
	int ball;
	Scanner sc;
	
	public BaseBall2() {
		this.answer = new ArrayList<Integer>(3);
		this.myAns = new ArrayList<Integer>(3); 
		this.index = 0;
		this.count = 1;
		this.strike = 0;
		this.ball = 0;
		sc = new Scanner(System.in);
	}
	
	public void input() {

		System.out.print("input three number : ");
		String myAnssc = sc.next();

		for (int i = 0; i < 3; i++) {
			myAns.add((int) myAnssc.charAt(i)-48);
		}
	}
	
	public void playBall() {
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
	}
	
	public void playStop() {
		if(strike==3) {
			System.out.println("success!! count: "+ count);
		} else {
			myAns.clear();
			strike = 0;
			ball = 0;
			count++;
		}
	}
	
	public static void main(String[] args) {
		BaseBall2 game = new BaseBall2();
		
		while (game.index!=3) {
			int rnd = (int) (Math.random() * 10);
			if(game.answer.contains(rnd)){
				continue;				
			}else {
				game.answer.add(rnd);
				game.index ++;
			}
		}

		do {
			
			game.input(); // 플레이어 숫자 입력
			
			game.playBall(); // Strike&Ball 판정

			game.playStop(); // 게임 지속여부

		} while (game.strike != 3);

	}
}
