
import java.util.Arrays;

public class Algorithm2_1 {
	public static void main(String[] args) {

		String[] answer = new String[4];

		for (int j = 1000; j < 10000; j++) {
			String num = "" + j;

			answer = num.split("");

			Arrays.sort(answer);

			for (int i = 0; i < answer.length-1; i++) {
				if (answer[i].equals("0")) { // 첫째자리 0일 경우
					if (!answer[i + 1].equals("0")) { // 둘째자리 0이 아닌 경우
						answer[i] = answer[i + 1];
						answer[i + 1] = "0";
					}
				}
				System.out.print(j + "\t");
				System.out.println(String.join("", answer));
			}
		}
	}
}
