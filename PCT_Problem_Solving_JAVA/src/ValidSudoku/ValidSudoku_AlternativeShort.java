package ValidSudoku;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ValidSudoku_AlternativeShort {

	

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		String[][] arrInp = new String[9][9];
		

		for (int i = 0; i < arrInp.length; i++) {
			arrInp[i] = sc.nextLine().split(" ");
		}

		System.out.print(isValidSudoku(arrInp));
		sc.close();
	}
	
	public static boolean isValidSudoku(String[][] A) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (A[i][j].contentEquals( ".")) continue;
                if (!set.add("r" + i + A[i][j])) return false;
                if (!set.add("c" + j + A[i][j])) return false;
                if (!set.add("b" + i/3 + j/3 + A[i][j])) return false;
            }
        }
        return true;
    }

	
}

/*
 * 

5 3 . . 7 . . . .
6 . . 1 9 5 . . .
. 9 8 . . . . 6 .
8 . . . 6 . . . 3
4 . . 8 . 3 . . 1
7 . . . 2 . . . 6
. 6 . . . . 2 8 .
. . . 4 1 9 . . 5
. . . . 8 . . 7 9

 * 
 */
