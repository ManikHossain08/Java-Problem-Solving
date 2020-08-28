package ValidSudoku;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MySolution_ValidSoduku {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String[][] arrInp = new String[9][9];

		for (int i = 0; i < arrInp.length; i++) {
			arrInp[i] = sc.nextLine().split(" ");
		}

		System.out.print(isValidSudoku(arrInp));
		sc.close();
	}

	private static boolean isValidSudoku(String[][] arrInp) {
		Set<String> records = new HashSet<String>();
		for (int i = 0; i < arrInp.length; i++) {
			for (int j = 0; j < arrInp[i].length; j++) {
				
				String value = arrInp[i][j];
				if (value.contentEquals("."))  continue;
				if (!records.add("r" + i + value)) return false;
				if (!records.add("c" + j + value)) return false;
				if (!records.add("b" + i / 3 + j / 3 + value)) return false;
			}
		}
		return true;
	}
}
