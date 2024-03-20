
public class SortExam {

	public static void main(String[] args) {
		int data[] = { 90, 78, 100, 30, 55 };

		bubbleSort(data);

		for (int i : data) {
			System.out.println(i + "\t");
		}
	}

	public static void bubbleSort(int[] data) {
		int k = 1;
		int j = 1;
		do {
			for (int i = 0; i < data.length - 1; i++) {
				if (data[i] > data[i + 1]) {
					int tmp = data[i];
					data[i] = data[i + 1];
					data[i + 1] = tmp;
					System.out.println("교체횟수:" + j++);
				}
				System.out.println("반복횟수:"+k++);
			}
		} while (isSorted(data));
	}

	public static boolean isSorted(int[] data) {
		for (int i = 0; i < data.length - 1; i++) {
			if (data[i] > data[i + 1]) {
				return true;
			}
		}
		return false;
	}
}
