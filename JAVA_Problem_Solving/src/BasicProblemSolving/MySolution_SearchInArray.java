package BasicProblemSolving;

import java.util.Scanner;

public class MySolution_SearchInArray {
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		String[] arrinp = sc.nextLine().split(",");
		
		int[] elements = new int[arrinp.length];
		for (int i = 0; i < arrinp.length; i++) {
			elements[i] = Integer.parseInt(arrinp[i]);
		}

		int searchInp = sc.nextInt();
		System.out.print(searchelement(elements, searchInp));
		sc.close();

	}

	private static int searchelement(int[] elements, int searchInp) {
		if (elements.length == 0)
			return -1;

		for (int i = 0; i < elements.length; i++) {
			if (searchInp == elements[i])
				return i;
		}
		return -1;
	}
}
