package calEmpSalary2;

import java.util.Scanner;

import member.RegularMember;

public class RegularSalary {
	RegularMember[] regularMember;
	int tryRgAdd = 0;

	private final int BASIC_PAY = 1_000_000;

	public RegularSalary() {
		this.regularMember = new RegularMember[100];
	}

//	public RegularSalary(RegularMember rm) {
//		this.overTimeAllowance = rm.getOverTimeAllowance();
//		this.lastGrade = rm.getLastGrade();
//		this.cert = rm.getCert();
//		this.jobLevel = rm.getJobLevel();
//	}

	public void input(Scanner sc) {
		regularMember[tryRgAdd] = new RegularMember(); // 동적 바인딩
		System.out.print("사번을 입력해주세요.:");
		regularMember[tryRgAdd].setId(sc.nextInt());
		System.out.print("이름을 입력해주세요.:");
		regularMember[tryRgAdd].setName(sc.next());
		System.out.print("입행년도를 입력해주세요.:");
		regularMember[tryRgAdd].setJoinYear(sc.nextInt());
		System.out.print("직무등급을 입력해주세요.(L0/L1/L2/L3/L4):");
		regularMember[tryRgAdd].setJobLevel(sc.next());
		System.out.print("성과등급을 입력해주세요.(C/B/A/S):");
		regularMember[tryRgAdd].setLastGrade(sc.next());
		System.out.print("자격증 유무를 입력해주세요. 1.여 2.부 : ");
		regularMember[tryRgAdd].setCert(sc.nextInt());
		System.out.print("시간외 근무 시간을 입력해주세요.:");
		regularMember[tryRgAdd].setOverTimeAllowance(sc.nextInt());
		tryRgAdd++;
	}

	public void search(Scanner sc) {
		System.out.print("사번을 입력해주세요(총 7자리):");
		System.out.println(tryRgAdd);
		int inputId = sc.nextInt();
		for (int i = 0; i < tryRgAdd; i++) {
			if (inputId == regularMember[i].getId()) {
				System.out.println("***********급여조회***********");
				System.out.println("사번:" + regularMember[i].getId());
				System.out.println("이름:" + regularMember[i].getName());
				System.out.println("입행년도:" + regularMember[i].getJoinYear());
				System.out.println("직무등급:" + regularMember[i].getJobLevel());
				System.out.println("성과등급:" + regularMember[i].getLastGrade());
				System.out.println("자격증 유무:" + regularMember[i].getCert());
				System.out.println("시간외 근무시간:" + regularMember[i].getOverTimeAllowance());
				System.out.print("기본급:" + getBasicPay()+"\t");
				System.out.print("직무급:" + getOverallPay(i)+"\t");
				System.out.print("성과급:" + getIncentivePay(i)+"\t");
				System.out.print("자격급:" + getCertPay(i)+"\t");
				System.out.println("시간외 수당:" + getOverTimePay(i)+"\t");
				System.out.println("급여총계:" + getTotal(i));
				System.out.println("**************************");
			} else {
				System.out.println("잘못된 사번입니다.");
			}
		}
	}

	public void modify(Scanner sc) {
		System.out.print("사번을 입력해주세요(총 7자리):");
		int inputId = sc.nextInt();
		for (int i = 0; i < tryRgAdd; i++) {
			if (inputId == regularMember[i].getId()) {
				String subQuest = "Y";
				do {
					System.out.print("수정하려는 항목을 선택하세요.: 1.이름 2.입행년도 3.직무등급 4.성과등급 5.자격증 유무 6.시간외 근무시간"); // 추가
					int modifiedMember = sc.nextInt();
					switch (modifiedMember) {
					case 1:
						System.out.print("이름을 입력하세요.:");
						regularMember[i].setName(sc.next());
						System.out.println("이름이 수정되었습니다. Y:추가수정 N: 메인이동:");
						subQuest = sc.next();
						break;
					case 2:
						System.out.print("입행년도를 입력하세요.:");
						regularMember[i].setJoinYear(sc.nextInt());
						System.out.println("입행년도가 수정되었습니다. Y:추가수정 N: 메인이동:");
						subQuest = sc.next();
						break;
					case 3:
						System.out.print("직무등급을 입력하세요.:");
						regularMember[i].setJobLevel(sc.next());
						System.out.println("직무등급이 수정되었습니다. Y:추가수정 N: 메인이동:");
						subQuest = sc.next();
						break;
					case 4:
						System.out.print("성과등급을 입력하세요.:");
						regularMember[i].setLastGrade(sc.next());
						System.out.println("성과등급이 수정되었습니다. Y:추가수정 N: 메인이동:");
						subQuest = sc.next();
						break;
					case 5:
						System.out.print("자격증 유무를 입력하세요.:");
						regularMember[i].setCert(sc.nextInt());
						System.out.println("자격증 유무가 수정되었습니다. Y:추가수정 N: 메인이동:");
						subQuest = sc.next();
						break;
					case 6:
						System.out.print("시간외 근무 시간을 입력하세요.:");
						regularMember[i].setOverTimeAllowance(sc.nextInt());
						System.out.println("시간외 근무 시간이 수정되었습니다. Y:추가수정 N: 메인이동:");
						subQuest = sc.next();
						break;
					}
				} while (subQuest.equalsIgnoreCase("Y"));
			}
		}
	}

	public void print() {
		for (int i = 0; i < tryRgAdd; i++) {
			System.out.println("***********급여조회***********");
			System.out.println("사번:" + regularMember[i].getId());
			System.out.println("이름:" + regularMember[i].getName());
			System.out.println("입행년도:" + regularMember[i].getJoinYear());
			System.out.println("직무등급:" + regularMember[i].getJobLevel());
			System.out.println("성과등급:" + regularMember[i].getLastGrade());
			System.out.println("자격증 유무:" + regularMember[i].getCert());
			System.out.println("시간외 근무시간:" + regularMember[i].getOverTimeAllowance());
			System.out.print("기본급:" + getBasicPay()+"\t");
			System.out.print("직무급:" + getOverallPay(i)+"\t");
			System.out.print("성과급:" + getIncentivePay(i)+"\t");
			System.out.print("자격급:" + getCertPay(i)+"\t");
			System.out.println("시간외 수당:" + getOverTimePay(i));
			System.out.println("급여총계:" + getTotal(i)+"\t");
			System.out.println("**************************");
		}
	}

	public int getBasicPay() {
		return BASIC_PAY;
	}

	public int getOverallPay(int i) {
		if (regularMember[i].getJobLevel().equalsIgnoreCase("L0")) {
			return 200_000;
		} else if (regularMember[i].getJobLevel().equalsIgnoreCase("L1")) {
			return 400_000;
		} else if (regularMember[i].getJobLevel().equalsIgnoreCase("L2")) {
			return 600_000;
		} else if (regularMember[i].getJobLevel().equalsIgnoreCase("L3")) {
			return 800_000;
		} else if (regularMember[i].getJobLevel().equalsIgnoreCase("L4")) {
			return 1_000_000;
		} else {
			return 0;
		}	
	}

	public int getIncentivePay(int i) {
		if (regularMember[i].getLastGrade().equalsIgnoreCase("C")) {
			return 300_000;
		} else if (regularMember[i].getLastGrade().equalsIgnoreCase("B")) {
			return 600_000;
		} else if (regularMember[i].getLastGrade().equalsIgnoreCase("A")) {
			return 900_000;
		} else if (regularMember[i].getLastGrade().equalsIgnoreCase("S")) {
			return 1_200_000;
		} else {
			return 0;
		}
	}

	public int getCertPay(int i) {
		if (regularMember[i].getCert() == 1) {
			return 100_000;
		} else {
			return 0;
		}
	}

	public int getOverTimePay(int i) {
		return regularMember[i].getOverTimeAllowance()*(10000);
	}

	public int getTotal(int i) {
		return getBasicPay() + getOverallPay(i) + getIncentivePay(i) + getCertPay(i) + getOverTimePay(i);
	}
}
