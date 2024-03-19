
import java.util.Arrays;

public class Algorithm3 {
	public static void main(String[] args) {

		String[] answer = new String[4];

		for (int j = 1000; j < 10000; j++) {
			String num = "" + j;
			System.out.print(num + "\t");
			answer = num.split("");

			Arrays.sort(answer);

			if (answer[0].equals("0")) { // 첫째자리 0일 경우
				if (!answer[1].equals("0")) { // 둘째자리 0이 아닌 경우
					String tmp = answer[0];
					answer[0] = answer[1];
					answer[1] = tmp;
				} else { // 둘째 자리 0인 경우
					if (!answer[2].equals("0")) { // 셋째 자리가 0이 아닌 경우
						String tmp = answer[0];
						answer[0] = answer[2];
						answer[2] = tmp;
					} else { // 셋째 자리가 0인 경우
						String tmp = answer[0];
						answer[0] = answer[3];
						answer[3] = tmp;
					}
				}

			}
			System.out.println(String.join("", answer));

			System.out.println();

		}
	}
}
