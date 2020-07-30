package BasicProblemSolving;

import java.util.LinkedList;
import java.util.Scanner;

public class addTwoNumbers {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String l1 = ""; String l2 = ""; int sum = 0;
		
		LinkedList<Integer> list1 = new LinkedList<Integer>();
		LinkedList<Integer> list2 = new LinkedList<Integer>();
		LinkedList<Integer> result = new LinkedList<Integer>();
		
		String[] inp1 = sc.nextLine().split(" ");
		String[] inp2 = sc.nextLine().split(" ");
		
		for (int i = 0; i < inp1.length; i++) {
			list1.add(Integer.parseInt(inp1[i]));
		}
		
		for (int i = 0; i < inp2.length; i++) {
			list2.add(Integer.parseInt(inp2[i]));
		}
		
		for (Integer integer : list1) {
			l1 = l1 + integer.toString();
		}
		for (Integer integer : list2) {
			l2 = l2 + integer.toString();
		}
		
		sum = Integer.parseInt(l1) + Integer.parseInt(l2); 
		String sumStr = sum+"";
		
		for (int i = sumStr.length()-1; i >= 0  ; i--) {
			String ch = sumStr.charAt(i)+"";
			int abc = Integer.parseInt(ch);
			result.add(abc);
		}
		
		System.out.print(result);
		sc.close();
	}
	
	
}
