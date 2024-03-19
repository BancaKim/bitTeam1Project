package studentScoreMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import StudentScore.StudentScoreHasA;

public class AllStudentMap {

	private int index;
	private HashMap<Integer, StudentScoreHasA> stu;

	public AllStudentMap() {
		stu = new HashMap<Integer, StudentScoreHasA>();
	}

	public AllStudentMap(int num) {
		stu = new HashMap<Integer, StudentScoreHasA>(num);
	}

	public int getIndex() {
		return index;
	}

	public HashMap<Integer, StudentScoreHasA> getStu() {
		return stu;
	}

	public static void main(String[] args) {
		/*
		 * 1. 학생정보입력 2. 학생정보수정 3. 학생정보검색 4. 학생전체출력
		 */
		AllStudentMap stu = new AllStudentMap();
		Scanner sc = new Scanner(System.in);
		do {
			System.out.print("1. 학생정보입력" + "\t");
			System.out.print("2. 학생정보수정" + "\t");
			System.out.print("3. 학생정보검색" + "\t");
			System.out.print("4. 학생전체출력" + "\t");
			System.out.print("5.  종료");

			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				stu.setStudent();
				break;
			case 2:
				stu.setModify();
				break;
			case 3:
				stu.setSearch();
				break;
			case 4:
				stu.setDisp();
				break;
			case 5:
				System.exit(0);
				;
				break;
			}

		} while (true);

	}

	private void setModify() {
		Scanner sc = new Scanner(System.in);
		System.out.print("수정하려는 학생의 이름을 검색해주세요: ");
		String name = sc.next();

		int i = 0;
		while (true) {
			if (name.equals(stu.get(i).getName())) {
				System.out.println("찾았습니다. ");

				while (true) {
					System.out.println("1.국어점수수정");
					System.out.println("2.영어점수수정");
					System.out.println("3.수학점수수정");
					System.out.println("4.수정안함");

					int n = sc.nextInt();
					switch (n) {
					case 1:
						System.out.println("국어점수를 입력해주세요: ");
						stu.get(i).setKor(sc.nextInt());
						break;
					case 2:
						System.out.println("영어점수를 입력해주세요: ");
						stu.get(i).setEng(sc.nextInt());
						break;
					case 3:
						System.out.println("수학점수를 입력해주세요: ");
						stu.get(i).setMat(sc.nextInt());
						break;

					}
					if (n == 4)
						break;
				}
				break;
			}
			i++;
		}

	}

	private void setSearch() {
		Scanner sc = new Scanner(System.in);
		System.out.print("찾으려는 학생의 이름을 검색해주세요: ");
		String name = sc.next();

		int i = 0;
		while (true) {
			if (name.equals(stu.get(i).getName())) {
				System.out.println("찾았습니다. ");

				System.out.print(stu.get(i).getName() + "\t");
				System.out.print(stu.get(i).getKor() + "\t");
				System.out.print(stu.get(i).getEng() + "\t");
				System.out.print(stu.get(i).getMat() + "\t");
				System.out.print(stu.get(i).getTotal() + "\t");
				System.out.println(stu.get(i).getAvg());

				break;
			}
			i++;
		}
	}

	private void setDisp() {

		for (int i = 0; i < index; i++) {
			System.out.print(stu.get(i).getName() + "\t");
			System.out.print(stu.get(i).getKor() + "\t");
			System.out.print(stu.get(i).getEng() + "\t");
			System.out.print(stu.get(i).getMat() + "\t");
			System.out.print(stu.get(i).getTotal() + "\t");
			System.out.println(stu.get(i).getAvg());
		}

	}

	private void setStudent() {

		StudentScoreHasA stu = new StudentScoreHasA(); // 학생객체생성
		Scanner sc = new Scanner(System.in);

		stu.setName(sc.next());
		stu.setKor(sc.nextInt());
		stu.setEng(sc.nextInt());
		stu.setMat(sc.nextInt());
		stu.getTotal();
		stu.getAvg();

		this.stu.put(index, stu); // 연결
		index++;

	}

}