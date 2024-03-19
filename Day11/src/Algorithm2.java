import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Algorithm2 {
	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int j = 1000; j < 10000; j++) {
			String num = "" + j;
			System.out.print(num + "\t");
			String[] num1 = num.split("");

			for (int i = 0; i < num.length(); i++) {
				int num2 = Integer.parseInt(num1[i]);
				list.add(num2);
			}
			Collections.sort(list);

			if (list.get(0) == 0) { // 첫째자리 0일 경우
				if (list.get(1) != 0) { // 둘째자리 0이 아닌 경우
					int tmp = list.get(0);
					list.set(0, list.get(1));
					list.set(1, tmp);
				} else { // 둘째 자리 0인 경우
					if (list.get(2) != 0) { // 셋째 자리가 0이 아닌 경우
						int tmp = list.get(0);
						list.set(0, list.get(2));
						list.set(2, tmp);
					} else { // 셋째 자리가 0인 경우
						int tmp = list.get(0);
						list.set(0, list.get(3));
						list.set(1, tmp);
					}
				}}
				
				String re = "";
				for(int i = 0; i < list.size(); i++) {
					re+=Integer.toString(list.get(i));
				}
				
				System.out.println("str: "+re);
				re = "";
				list.clear();
			}

		}
	}
