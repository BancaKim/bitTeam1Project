
public class SortExam3 {

	public static void main(String[] args) {
		int data[] = { 90, 78, 100, 30, 55 };

		bubbleSort(data);

		for (int i : data) {
			System.out.println(i + "\t");
		}
	}

	public static void bubbleSort(int[] data) {
		int revolving = 1;
		int change = 1;
		for (int i = 0; i < data.length - 1; i++) {
			//각 패스의 시작 지점부터 마지막 원소 직전까지의 비교
			for (int k = 0; k < data.length -i- 1; k++) {
				if (data[k] > data[k + 1]) {
					int tmp = data[k];
					data[k] = data[k + 1];
					data[k + 1] = tmp;
					System.out.println("교체횟수:" + change++);
				}
				System.out.println("반복횟수:" + revolving++);
			}
		}
	}
}
