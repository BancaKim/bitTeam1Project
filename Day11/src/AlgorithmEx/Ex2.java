package AlgorithmEx;

import java.util.ArrayList;
import java.util.Collections;

public class Ex2 {

	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int i = 1000; i < 10000; i++) {

			int num = i;
			for (int j = 0; j < 4; j++) {
				list.add(num % 10);
				num = num / 10;
			}

			Collections.sort(list);
			
			if (list.get(0) == 0) {
			for (int k = 0; k < list.size()-1; k++) {
					if (list.get(k + 1) != 0) {
						list.set(0, list.get(k+1));
						list.set(k+1, 0);
					}
				}
			}
			
			String answer = "";
			for (int k = 0; k < list.size(); k++) {
				answer += list.get(k);
			}
			System.out.print(i+"\t");
			System.out.println(answer);
			list.clear();
		}

	}

}
