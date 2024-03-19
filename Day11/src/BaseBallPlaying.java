import java.util.Scanner;

public class BaseBallPlaying {
	
	public BaseBallPlaying() {
		BaseBallRule rule = new BaseBallRule();
		Scanner sc = new Scanner(System.in);
	}
	
	public void input(BaseBallRule rule, Scanner sc) {

		System.out.print("input three number : ");
		String myAnssc = sc.next();

		for (int i = 0; i < 3; i++) {
			rule.getMyAns().add((int) myAnssc.charAt(i)-48);
		}
	}
	
	public void playBall(BaseBallRule rule) {
		for (int i = 0; i < 3; i++) {
			if (rule.getAnswer().contains(rule.getMyAns().get(i))) {
				if (rule.getAnswer().get(i).equals(rule.getMyAns().get(i))) {
					int strike = rule.getStrike()+1;
					rule.setStrike(strike);
				} else {
					int ball = rule.getBall()+1;
					rule.setBall(ball);
				}
			}
		}
		System.out.println(rule.getStrike() + " strike, " + rule.getBall() + "ball");
	}
	
	public void playStop(BaseBallRule rule) {
		if(rule.getStrike()==3) {
			System.out.println("success!! count: "+ rule.getCount());
		} else {
			rule.getMyAns().clear();
			rule.setStrike(0);
			rule.setBall(0);
			int count = rule.getCount()+1;
			rule.setCount(count);
		}
	}
	
}
