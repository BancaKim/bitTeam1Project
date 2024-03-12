package calEmpSalary2;

import java.util.Scanner;

public interface Salary {
	int BASIC_PAY = 1_000_000;
	int MINIMUM_WAGE = 9860;
	int DAY_WORKING_TIME = 8;
	
	void input(Scanner sc);
	void search(Scanner sc);
	void modify(Scanner sc);
	void print();

}
