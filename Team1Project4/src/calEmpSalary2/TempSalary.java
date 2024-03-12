package calEmpSalary2;

import java.util.Scanner;

import member.TempMember;

public class TempSalary implements Salary {

	TempMember[] tempMember;
	int tryTpAdd = 0;

	public TempSalary() {
		tempMember = new TempMember[100];
	}

	@Override
	public void input(Scanner sc) {
		tempMember[tryTpAdd] = new TempMember();
		System.out.print("사번을 입력해주세요.:");
		tempMember[tryTpAdd].setId(sc.nextInt());
		System.out.print("이름을 입력해주세요.:");
		tempMember[tryTpAdd].setName(sc.next());
		System.out.print("입행년도를 입력해주세요.:");
		tempMember[tryTpAdd].setJoinYear(sc.nextInt());
		System.out.print("근무일수를 입력해주세요.:");
		tempMember[tryTpAdd].setWorkingDate(sc.nextInt());
		tryTpAdd++;
	}

	@Override
	public void search(Scanner sc) {
		System.out.print("사번을 입력해주세요(총 7자리):");
		int inputId = sc.nextInt();
		for (int i = 0; i < tryTpAdd; i++) {
			if (inputId == tempMember[i].getId()) {
				System.out.println("***********급여조회***********");
				System.out.println("사번:" + tempMember[i].getId());
				System.out.println("이름:" + tempMember[i].getName());
				System.out.println("입행년도:" + tempMember[i].getJoinYear());
				System.out.println("근무일수:" + tempMember[i].getWorkingDate());
				System.out.print("기본급:" + BASIC_PAY + "\t");
				System.out.println("근무수당:" + getWorkingDatePay(i));
				System.out.println("급여총계:" + getTotal(i));
				System.out.println("**************************");
			}
		}
	}

	@Override
	public void modify(Scanner sc) {
		System.out.print("사번을 입력해주세요(총 7자리):");
		int inputId = sc.nextInt();
		for (int i = 0; i < tryTpAdd; i++) {
			if (inputId == tempMember[i].getId()) {
				String subQuest = "Y";
				do {
					System.out.print("수정하려는 항목을 선택하세요.: 1.이름 2.입행년도 3.근무일수"); // 추가
					int modifiedMember = sc.nextInt();
					switch (modifiedMember) {
					case 1:
						System.out.print("이름을 입력하세요.:");
						tempMember[i].setName(sc.next());
						System.out.println("이름이 수정되었습니다. Y:추가수정 N: 메인이동:");
						subQuest = sc.next();
						break;
					case 2:
						System.out.print("입행년도를 입력하세요.:");
						tempMember[i].setJoinYear(sc.nextInt());
						System.out.println("입행년도가 수정되었습니다. Y:추가수정 N: 메인이동:");
						subQuest = sc.next();
						break;
					case 3:
						System.out.print("근무일수를 입력하세요.:");
						tempMember[i].setWorkingDate(sc.nextInt());
						System.out.println("근무일수가 수정되었습니다. Y:추가수정 N: 메인이동:");
						subQuest = sc.next();
					}
				} while (subQuest.equalsIgnoreCase("Y"));
			} else {
				System.out.println("잘못된 사번입니다.");
			}
		}
	}

	@Override
	public void print() {
		for (int i = 0; i < tryTpAdd; i++) {
			System.out.println("***********급여조회***********");
			System.out.println("사번:" + tempMember[i].getId());
			System.out.println("이름:" + tempMember[i].getName());
			System.out.println("입행년도:" + tempMember[i].getJoinYear());
			System.out.println("근무일수:" + tempMember[i].getWorkingDate());
			System.out.print("기본급:" + BASIC_PAY + "\t");
			System.out.println("근무수당:" + getWorkingDatePay(i));
			System.out.println("급여총계:" + getTotal(i));
			System.out.println("**************************");
		}
	}

	public int getWorkingDatePay(int i) {
		return tempMember[i].getWorkingDate() * MINIMUM_WAGE * DAY_WORKING_TIME;
	}

	public int getTotal(int i) {
		return BASIC_PAY + getWorkingDatePay(i);
	}
}