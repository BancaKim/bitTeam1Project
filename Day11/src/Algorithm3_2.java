import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Algorithm3_2 {
	public static int count;
	
	public static void main(String[] args) {

//		ArrayList<Integer> list = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);

		int x;
		int y;


		while (true) {
			System.out.print("Input X Number: ");
			int xinput = sc.nextInt();
			if (xinput < 100 || 9999999 < xinput) {
				System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
			} else {
				x = xinput;
				break;
			}
		}

		System.out.print("Input Y Number: ");
		y = sc.nextInt();

		for (int i = x; i < y; i++) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			String num = "" + i;
			String[] num1 = num.split("");

			for (int j = 0; j < num.length(); j++) {
				int num2 = Integer.parseInt(num1[j]);
				list.add(num2);
			}

			if (!list.contains(0)) {

				HashSet<Integer> set = new HashSet<Integer>();
				set.addAll(list);
				if (set.size() == list.size()) {
					for (int h = 0; h < list.size() - 1; h++) {
						if (list.get(h) < list.get(h + 1)) {
							
							String re = "";
							for (int k = 0; k < list.size(); k++) {
								re += Integer.toString(list.get(k));
							}
							System.out.println(re);
							re = "";
							System.out.println("count:"+count);
							count++;
						}
					}

				}
				list.clear();
			}
			list.clear();
		}
	}
}
