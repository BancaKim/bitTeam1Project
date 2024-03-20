package AlgorithmEx;

import java.util.Scanner;

public class Ex3 {
	
	public static int count;

	public static void main(String[] args) {
	       Scanner sc = new Scanner(System.in);
	        int x, y;
	        
	        System.out.print("Input X Number: ");
	        x = sc.nextInt();
	        
	        while (x < 100 || x > 9999999) {
	            System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
	            System.out.print("Input X Number: ");
	            x = sc.nextInt();
	        }

	        System.out.print("Input Y Number: ");
	        y = sc.nextInt();
	        
	        while (y < x || y > 9999999) {
	            System.out.println("잘못 입력하였습니다. Y는 X보다 크거나 같아야 합니다.");
	            System.out.print("Input Y Number: ");
	            y = sc.nextInt();
	        }
	        
	        for (int i=x; i<y;i++) {
	        	if(Ex3.isSorted(i)) {
	        		System.out.print(i+"\t");
	        		count++;
	        	}
	        }
	        System.out.println();
	        System.out.println("count :" + count);
	}
	public static boolean isSorted(int num) {
		String numStr = num+"";  //123 -> "123"
		for(int i=0;i<numStr.length()-1;i++) {    //i=0    charAt(0)< charAt(1) true  &&
			if(numStr.charAt(i) < numStr.charAt(i+1)) {  //i=1 charAt(1)<charAt(2) false
				return false;							
			};
		}
		return true;  
	}
}
