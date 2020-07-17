package A_GameOfLife;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrganismGameOfLife {

	private static int r, c;
	private static int noOfGeneration;
	private static List<String> grid;
	
	// calculate this value from this 2D array position:
	
	//  (0,0)  (0,1)  (0,2)
	
	//  (1,0)  (1,1)  (1,2)
	
	//  (2,0)  (2,1)  (2,2)
	
	// From this array start from middle position and add/subtract value with x,y value 
	// to the corresponding x,y value like if I add 1 to 1 then it would be 2 so from (1,1)
	// to (2,1) we added 1 with x value. then do same thing with anti clock wise until same place. 
	// 
	
	int dx[] = { 1, 1, 0, -1, -1, -1, 0, 1 };
	int dy[] = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static void main(String args[]) {
		// input processing
		
		Scanner sc = new Scanner(System.in);
		String s[] = sc.nextLine().split(" ");
		r = Integer.parseInt(s[0]);
		c = Integer.parseInt(s[1]);
		
		grid = new ArrayList<>();
		for (int i = 0; i < r; i++) {
			String st = sc.nextLine();
			grid.add(st);
		}
		noOfGeneration = sc.nextInt();
		
		OrganismGameOfLife simulatedOrganism = new OrganismGameOfLife();
		System.out.println(simulatedOrganism.findSimulatedOrganism());
		
		sc.close();
	}

	public int findSimulatedOrganism() {

		for (int i = 0; i < noOfGeneration; ++i) {
			next();
		}
		int count = 0;
		for (int i = 0; i < r; ++i) {
			for (int j = 0; j < c; ++j) {
				if (grid.get(i).charAt(j) == '@') {
					++count;
				}
			}
		}
		return count;
	}

	private void next() {
		List<String> nextGen = new ArrayList<>(grid);
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				int cnt = coundNeighbours(i, j);
				if (cnt <= 1)
					nextGen.set(i, replaceChar(nextGen.get(i), '#', j));
				else if (cnt >= 4)
					nextGen.set(i, replaceChar(nextGen.get(i), '#', j));
				else if (cnt == 3)
					nextGen.set(i, replaceChar(nextGen.get(i), '@', j));
			}
			// is used for replacing or modifying the character.
		}

		grid = nextGen;
	}

	public String replaceChar(String str, char ch, int index) {
		StringBuilder myString = new StringBuilder(str);
		myString.setCharAt(index, ch);
		return myString.toString();
	}

	private int coundNeighbours(int x, int y) {
		int count = 0;
		for (int i = 0; i < dx.length; ++i) {

			int xx = x + dx[i];
			int yy = y + dy[i];
			if (xx >= 0 && yy >= 0 && xx < r && yy < c && grid.get(xx).charAt(yy) == '@') {
				++count;
			}

		}
		return count;
	}

}
