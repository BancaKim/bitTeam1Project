
import java.util.Scanner;

import Member.RegularMember;
import Member.TempMember;

public class ManagingSalaryMain {
	int BASE_PAY = 100;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ManagingSalaryMain msm = new ManagingSalaryMain();
		RegularMember[] regularMember = new RegularMember[100];
		TempMember[] tempMember = new TempMember[100];
		int tryRgAdd = 0;
		int tryTpAdd = 0;
		String managerPwd = "1234";
		String pcdSalary = "Y";

		do {
			System.out.print("급여 관리 프로그램에 접속하였습니다. 권한을 선택하세요. 1.관리자 2.사용자 3.종료 : ");
			int mainChoice = sc.nextInt();

			switch (mainChoice) {
			case 1: // 관리자 선택
				System.out.print("비밀번호를 입력하세요 : ");
				String inputPwd = sc.next();
				if (managerPwd.equalsIgnoreCase(inputPwd)) {
					System.out.print("1.직원정보 입력 2.직원정보 및 급여조회 3.직원정보 수정 4.전체출력 : "); // 관리자 화면
					int managerChoice = sc.nextInt();
					switch (managerChoice) {
					case 1: // 직원정보 입력
						System.out.print("고용조건을 선택하세요. 1.정규직 2.비정규직");
						int empCondition = sc.nextInt();
						if (empCondition == 1) {
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
						} else if (empCondition == 2) {
							tempMember[tryTpAdd] = new TempMember();
							System.out.print("사번을 입력해주세요.:");
							tempMember[tryTpAdd].setId(sc.nextInt());
							System.out.print("이름을 입력해주세요.:");
							tempMember[tryTpAdd].setName(sc.next());
							System.out.print("입행년도를 입력해주세요.:");
							tempMember[tryTpAdd].setJoinYear(sc.nextInt());
							tryTpAdd++;
						}
						break;
					case 2: // 직원정보 및 급여 조회
						System.out.print("직원정보 및 급여조회 화면입니다. 1.정규직 2.비정규직:");
						int main2Choice = sc.nextInt();
						if (main2Choice == 1) {
							System.out.print("사번을 입력해주세요(총 7자리):");
							int inputId = sc.nextInt();
							for (int i = 0; i < tryRgAdd; i++) {
								if (inputId == regularMember[i].getId()) {
									System.out.println("사번:" + regularMember[i].getId());
									System.out.println("이름:" + regularMember[i].getName());
									System.out.println("입행년도:" + regularMember[i].getJoinYear());
									System.out.println("직무등급:" + regularMember[i].getJobLevel());
									System.out.println("성과등급:" + regularMember[i].getLastGrade());
									System.out.println("자격증 유무:" + regularMember[i].getCert());
									System.out.println("시간외 근무시간:" + regularMember[i].getOverTimeAllowance());
									System.out.println("기본급:" + msm.BASE_PAY);
									System.out.println("직무급:" + msm.overallPay(regularMember[i].getJobLevel()));
									System.out.println("성과급:" + msm.incentivePay(regularMember[i].getLastGrade()));
									System.out.println("자격급:" + msm.certPay(regularMember[i].getCert()));
									System.out.println("시간외 수당:"+ msm.overTimePay(regularMember[i].getOverTimeAllowance()));
									System.out.println(
											"급여총계:" + (msm.BASE_PAY + msm.overallPay(regularMember[i].getJobLevel())
													+ msm.incentivePay(regularMember[i].getLastGrade())
													+ msm.certPay(regularMember[i].getCert())
													+ msm.overTimePay(regularMember[i].getOverTimeAllowance())));
								} else {
									System.out.println("잘못된 사번입니다.");
								}
							}
						} else if (main2Choice == 2) {
							System.out.print("사번을 입력해주세요(총 7자리):");
							int inputId = sc.nextInt();
							for (int i = 0; i < tryTpAdd; i++) {
								if (inputId == tempMember[i].getId()) {
									System.out.println("사번:" + tempMember[i].getId());
									System.out.println("이름:" + tempMember[i].getName());
									System.out.println("입행년도:" + tempMember[i].getJoinYear());
									System.out.println("기본급:" + msm.BASE_PAY);
									System.out.println("급여총계:" + msm.BASE_PAY);
								}
							}
						}
						break;
					case 3: // 직원정보 수정
						System.out.print("직원정보 수정 화면입니다. 1.정규직 2.비정규직:");
						int main3Choice = sc.nextInt();
						if (main3Choice == 1) {
							System.out.print("사번을 입력해주세요(총 7자리):");
							int inputId = sc.nextInt();
							for (int i = 0; i < tryRgAdd; i++) {
								if (inputId == regularMember[i].getId()) {
									String subQuest = "Y";
									do {
										System.out.print(
												"수정하려는 항목을 선택하세요.: 1.이름 2.입행년도 3.직무등급 4.성과등급 5.자격증 유무 6.시간외 근무시간"); // 추가
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
								} else {
									System.out.println("잘못된 사번입니다.");
								}
							}
						} else if (main3Choice == 2) {
							System.out.print("사번을 입력해주세요(총 7자리):");
							int inputId = sc.nextInt();
							for (int i = 0; i < tryTpAdd; i++) {
								if (inputId == regularMember[i].getId()) {
									String subQuest = "Y";
									do {
										System.out.print(
												"수정하려는 항목을 선택하세요.: 1.이름 2.입행년도 3.직무등급 4.성과등급 5.자격증 유무 6.시간외 근무시간"); // 추가
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
										}
									} while (subQuest.equalsIgnoreCase("Y"));
								} else {
									System.out.println("잘못된 사번입니다.");
								}
							}
						}
						break;

					case 4: // 전체 출력
						System.out.print("직원정보 출력 화면입니다. 1.정규직 2.비정규직:");
						int main4Choice = sc.nextInt();
						if (main4Choice == 1) {
							for (int i = 0; i < tryRgAdd; i++) {
								System.out.println("사번:" + regularMember[i].getId());
								System.out.println("이름:" + regularMember[i].getName());
								System.out.println("입행년도:" + regularMember[i].getJoinYear());
								System.out.println("직무등급:" + regularMember[i].getJobLevel());
								System.out.println("성과등급:" + regularMember[i].getLastGrade());
								System.out.println("자격증 유무:" + regularMember[i].getCert());
								System.out.println("시간외 근무시간:" + regularMember[i].getOverTimeAllowance());
								System.out.println("기본급:" + msm.BASE_PAY);
								System.out.println("직무급:" + msm.overallPay(regularMember[i].getJobLevel()));
								System.out.println("성과급:" + msm.incentivePay(regularMember[i].getLastGrade()));
								System.out.println("자격급:" + msm.certPay(regularMember[i].getCert()));
								System.out.println("시간외 수당:"+ msm.overTimePay(regularMember[i].getOverTimeAllowance()));
								System.out.println("급여총계" + (msm.BASE_PAY + msm.overallPay(regularMember[i].getJobLevel())
												+ msm.incentivePay(regularMember[i].getLastGrade())
												+ msm.certPay(regularMember[i].getCert())
												+ msm.overTimePay(regularMember[i].getOverTimeAllowance())));
											
							}
						} else if (main4Choice == 2) {
							for (int i = 0; i < tryTpAdd; i++) {
								System.out.println("사번:" + tempMember[i].getId());
								System.out.println("이름:" + tempMember[i].getName());
								System.out.println("입행년도:" + tempMember[i].getJoinYear());
								System.out.println("기본급:" + msm.BASE_PAY);
								System.out.println("급여총계:" + msm.BASE_PAY);
							}
						}
						break;
					}
				} else {
					System.out.println("잘못된 비밀번호입니다");
				}
				break;
			case 2: // 사용자 권한
				System.out.print("직원정보 및 급여 조회 화면입니다 고용조건을 선택하세요. 1. 정규직 2.비정규직 : "); // 관리자 화면
				int emplChoice = sc.nextInt();
				if (emplChoice == 1) {
					System.out.print("사번을 입력해주세요(총 7자리):");
					int inputId = sc.nextInt();
					for (int i = 0; i < tryRgAdd; i++) {
						if (inputId == regularMember[i].getId()) {
							System.out.println("사번:" + regularMember[i].getId());
							System.out.println("이름:" + regularMember[i].getName());
							System.out.println("입행년도:" + regularMember[i].getJoinYear());
							System.out.println("직무등급:" + regularMember[i].getJobLevel());
							System.out.println("성과등급:" + regularMember[i].getLastGrade());
							System.out.println("자격증 유무:" + regularMember[i].getCert());
							System.out.println("시간외 근무시간:" + regularMember[i].getOverTimeAllowance());
							System.out.println("기본급:" + msm.BASE_PAY);
							System.out.println("직무급:" + msm.overallPay(regularMember[i].getJobLevel()));
							System.out.println("성과급:" + msm.incentivePay(regularMember[i].getLastGrade()));
							System.out.println("자격급:" + msm.certPay(regularMember[i].getCert()));
							System.out.println("시간외 수당:"+ msm.overTimePay(regularMember[i].getOverTimeAllowance()));
							System.out.println("급여총계:" + (msm.BASE_PAY + msm.overallPay(regularMember[i].getJobLevel())
									+ msm.incentivePay(regularMember[i].getLastGrade())
									+ msm.certPay(regularMember[i].getCert())
									+ msm.overTimePay(regularMember[i].getOverTimeAllowance())));
						}
					}
				} else if (emplChoice == 2) {
					System.out.print("사번을 입력해주세요(총 7자리):");
					int inputId = sc.nextInt();
					for (int i = 0; i < tryTpAdd; i++) {
						System.out.println("사번:" + tempMember[i].getId());
						System.out.println("이름:" + tempMember[i].getName());
						System.out.println("입행년도:" + tempMember[i].getJoinYear());
						System.out.println("기본급:" + msm.BASE_PAY);
						System.out.println("급여총계:" + msm.BASE_PAY);
					}
				}
				break;
			case 3:
				pcdSalary = "N"; // 종료
				break;
			} // 사용자 선택(main 화면 종료)
		} while (pcdSalary.equalsIgnoreCase("Y"));
	}

	/* main 끝 */
	private int overallPay(String jobLevel) {
		if (jobLevel.equalsIgnoreCase("L0")) {
			return 20;
		} else if (jobLevel.equalsIgnoreCase("L1")) {
			return 40;
		} else if (jobLevel.equalsIgnoreCase("L2")) {
			return 60;
		} else if (jobLevel.equalsIgnoreCase("L3")) {
			return 80;
		} else if (jobLevel.equalsIgnoreCase("L4")) {
			return 100;
		} else {
			return 0;
		}
	}

	private int incentivePay(String lastGrade) {
		if (lastGrade.equalsIgnoreCase("C")) {
			return 30;
		} else if (lastGrade.equalsIgnoreCase("B")) {
			return 60;
		} else if (lastGrade.equalsIgnoreCase("A")) {
			return 90;
		} else if (lastGrade.equalsIgnoreCase("S")) {
			return 120;
		} else {
			return 0;
		}
	}

	private int certPay(int cert) {
		if (cert == 1) {
			return 10;
		} else {
			return 0;
		}
	}
	
	private int overTimePay(int overTimeAllowance) {
		return overTimeAllowance;
	}
}
