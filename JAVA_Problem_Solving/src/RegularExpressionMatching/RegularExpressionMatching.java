package RegularExpressionMatching;

import java.util.Scanner;

public class RegularExpressionMatching {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();

		System.out.print(findRegexPattern(str1, str2));
		sc.close();
	}

	// https://www.youtube.com/watch?time_continue=1109&v=l3hda49XcDE&feature=emb_logo
	private static boolean findRegexPattern(String s1, String s2) {

		int row = s1.length() + 1;
		int col = s2.length() + 1;

		boolean[][] table2d = new boolean[row][col];
		table2d[0][0] = true;

		for (int i = 1; i < table2d[0].length; i++) {
			if (s2.charAt(i - 1) == '*') {
				table2d[0][i] = table2d[0][i - 2];
			}
		}

		for (int i = 1; i < table2d.length; i++) {
			for (int j = 1; j < table2d[0].length; j++) {

				char rowChar = s1.charAt(i - 1);
				char colChar = s2.charAt(j - 1);

				if (colChar == '.' || rowChar == colChar) {
					table2d[i][j] = table2d[i - 1][j - 1];
				} else if (colChar == '*') {
					char colPrevChar = s2.charAt(j - 2);
					table2d[i][j] = table2d[i][j - 2];
					if (rowChar == colPrevChar || colPrevChar == '.') {
						table2d[i][j] = table2d[i - 1][j] | table2d[i][j - 2];
					}
				} else {
					table2d[i][j] = false;
				}
			}
		}

		return table2d[s1.length()][s2.length()];
	}
}
