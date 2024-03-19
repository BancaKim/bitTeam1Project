package studentScoreSet;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class AllStudentSet2 {

	private HashSet<StudentScoreHasA> stu;

	public AllStudentSet2() {
		stu = new HashSet<StudentScoreHasA>();
	}

	public AllStudentSet2(int num) {
		stu = new HashSet<StudentScoreHasA>(num);
	}

	public HashSet<StudentScoreHasA> getStu() {
		return stu;
	}

	public static void main(String[] args) {
		/*
		 * 1. 학생정보입력 2. 학생정보수정 3. 학생정보검색 4. 학생전체출력
		 */
		AllStudentSet2 stu = new AllStudentSet2();
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

		Iterator<StudentScoreHasA> iterator = stu.iterator();
		while (iterator.hasNext()) {
			StudentScoreHasA stu2 = (StudentScoreHasA) iterator.next();

			if (name.equals(stu2.getName())) {
				System.out.println("찾았습니다.");

				while (true) {
					System.out.print("1.국어점수 수정" + "\t");
					System.out.print("2.영어점수 수정" + "\t");
					System.out.print("3.수학점수 수정" + "\t");
					System.out.print("4.수정안함" + "\t");

					int n = sc.nextInt();
					switch (n) {
					case 1:
						System.out.println("국어점수를 입력해주세요: ");
						stu2.setKor(sc.nextInt());
						break;
					case 2:
						System.out.println("영어점수를 입력해주세요: ");
						stu2.setEng(sc.nextInt());
						break;
					case 3:
						System.out.println("수학점수를 입력해주세요: ");
						stu2.setMat(sc.nextInt());
						break;

					}
					if (n == 4) {
						break;
					}
				}
				break;
			}
		}
	}

	private void setSearch() {
		Scanner sc = new Scanner(System.in);
		System.out.print("찾으시려는 이름을 입력해주세요: ");
		String name = sc.next();

		Iterator<StudentScoreHasA> iterator = stu.iterator();
		while (iterator.hasNext()) {
			StudentScoreHasA stu2 = (StudentScoreHasA) iterator.next();

			if (name.equals(stu2.getName())) {
				System.out.println("찾았습니다.");
				System.out.print(stu2.getName() + "\t");
				System.out.print(stu2.getKor() + "\t");
				System.out.print(stu2.getEng() + "\t");
				System.out.print(stu2.getMat() + "\t");
				System.out.print(stu2.getTotal() + "\t");
				System.out.println(stu2.getAvg());

				break;

			}

		}

	}

	private void setDisp() {

		for (StudentScoreHasA s : stu) {
			if (s == null)
				break;
			System.out.print(s.getName() + "\t");
			System.out.print(s.getKor() + "\t");
			System.out.print(s.getEng() + "\t");
			System.out.print(s.getMat() + "\t");
			System.out.print(s.getTotal() + "\t");
			System.out.println(s.getAvg());
		}

	}

	private void setStudent() {
		


		StudentScoreHasA student = new StudentScoreHasA(); // 학생객체생성
		Scanner sc = new Scanner(System.in);

		
		Iterator<StudentScoreHasA> it = this.stu.iterator();
		while(it.hasNext())
		{}
			student.getName().equals(sc.next());
		}
		
		System.out.print("이름을 입력해주세요:");
		stu.setName(sc.next());
		System.out.print("국어점수를 입력해주세요:");
		stu.setKor(sc.nextInt());
		System.out.print("영어점수를 입력해주세요:");
		stu.setEng(sc.nextInt());
		System.out.print("수학점수를 입력해주세요:");
		stu.setMat(sc.nextInt());
		stu.getTotal();
		stu.getAvg();

		this.stu.add(stu); // 연결
	}

}