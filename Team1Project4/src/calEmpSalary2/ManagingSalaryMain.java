package calEmpSalary2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ManagingSalaryMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		TempSalary temp = new TempSalary();
		RegularSalary reg = new RegularSalary();
		Map<String, String> loginMap = new HashMap<>();
		loginMap.put("admin", "1234");
		String pcdSalary = "Y";

		do {
			System.out.print("급여 관리 프로그램에 접속하였습니다. 권한을 선택하세요! 1.관리자 2.사용자 3.종료 : ");
			int mainChoice = sc.nextInt();
			switch (mainChoice) {
			case 1: // 관리자 선택
				System.out.print("ID를 입력하세요 : ");
				String checkId = sc.next();
				System.out.print("비밀번호를 입력하세요 : ");
				String pwd = sc.next();
				if (loginMap.get(checkId).equals(pwd)) {
					System.out.println("로그인되었습니다!");
					System.out.print("1.직원정보 입력 2.직원정보 및 급여조회 3.직원정보 수정 4.전체출력 : "); // 관리자 화면
					int managerChoice = sc.nextInt();
					switch (managerChoice) {
					case 1: // 직원정보 입력
						System.out.print("고용조건을 선택하세요. 1.정규직 2.비정규직 :");
						int empCondition = sc.nextInt();
						if (empCondition == 1) {
							reg.input(sc);
						} else if (empCondition == 2) {
							temp.input(sc);
						}
						break;
					case 2: // 직원정보 및 급여 조회
						System.out.print("직원정보 및 급여조회 화면입니다. 1.정규직 2.비정규직 :");
						int main2Choice = sc.nextInt();
						if (main2Choice == 1) {
							reg.search(sc);
						} else if (main2Choice == 2) {
							temp.search(sc);
						}
						break;
					case 3: // 직원정보 수정
						System.out.print("직원정보 수정 화면입니다. 1.정규직 2.비정규직 :");
						int main3Choice = sc.nextInt();
						if (main3Choice == 1) {
							reg.modify(sc);
						} else if (main3Choice == 2) {
							temp.modify(sc);
						}
						break;
					case 4: // 전체 출력
						System.out.print("직원정보 출력 화면입니다. 1.정규직 2.비정규직 :");
						int main4Choice = sc.nextInt();
						if (main4Choice == 1) {
							reg.print();
						} else if (main4Choice == 2) {
							temp.print();
						}
						break;
					}
				} else {
					System.out.println("잘못된 비밀번호입니다.");
				}
				break;
			case 2: // 사용자 권한
				System.out.print("직원정보 및 급여조회 화면입니다. 고용조건을 구분하세요 1.정규직 2.비정규직:");
				int main2Choice = sc.nextInt();
				if (main2Choice == 1) {
					reg.search(sc);
				} else if (main2Choice == 2) {
					temp.search(sc);
				}
				break;
			case 3:
				pcdSalary = "N"; // 종료
				System.out.println("안녕히 가세요!");
				break;
			} // 사용자 선택(main 화면 종료)
		} while (pcdSalary.equalsIgnoreCase("Y"));
	}
	/* main 끝 */
}
