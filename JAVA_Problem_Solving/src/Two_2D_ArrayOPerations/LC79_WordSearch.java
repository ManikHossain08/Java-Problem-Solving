package Two_2D_ArrayOPerations;

import java.util.Scanner;

public class LC79_WordSearch {
	
	private static int[] dx = { -1, 0, 1, 0 };
	private static int[] dy = { 0, -1, 0, 1 };
	private static boolean[][] isvisited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		int col = sc.nextInt();

		char[][] matrix = new char[row][col];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				matrix[i][j] = sc.next().charAt(0);
			}
		}
		String word = sc.next();
		System.out.print(exists(matrix, word));

		sc.close();

	}

	private static boolean exists(char[][] matrix, String word) {

		isvisited = new boolean[matrix.length][matrix[0].length];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {

				char ch = matrix[i][j];
				if (word.charAt(0) == ch && searchWord(matrix, word, i, j, 0)) {
					return true;
				}
			}
		}

		return false;
	}

	private static boolean searchWord(char[][] matrix, String word, int i, int j, int index) {

		if (index == word.length())
			return true;
		if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length)
			return false;
		if (matrix[i][j] != word.charAt(index) || isvisited[i][j] == true)
			return false;

		isvisited[i][j] = true;

		for (int nighbour = 0; nighbour < dx.length; nighbour++) {
			int row = i + dx[nighbour];
			int col = j + dy[nighbour];
			if (searchWord(matrix, word, row, col, index + 1))
				return true;

		}
		isvisited[i][j] = false;
		return false;
	}

}

/*

4
3
A B C E
S F C S
A D E E

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.

same problem another questions; LC_212

4
4
o a a n
e t a e
i h k r
i f l v
pea


*/


