package CountIntersection;

import java.util.Scanner;

public class IntersectionCountInGraph {

	private static int V = 0, H = 0, countIntersection = 0;
	private static String[][] verticalInp = null;
	private static String[][] horizontalInp = null;

	public static void main(String args[]) {
		Scanner sc_in = new Scanner(System.in);
		String[] input = new String[2];

		input = sc_in.nextLine().split(" ");
		V = Integer.parseInt(input[0]);
		H = Integer.parseInt(input[1]);

		verticalInp = new String[V][3];
		horizontalInp = new String[H][3];

		for (int i = 0; i < V; i++) {
			verticalInp[i] = sc_in.nextLine().split(" ");
		}
		for (int i = 0; i < H; i++) {
			horizontalInp[i] = sc_in.nextLine().split(" ");
		}

		for (int i = 0; i < V; i++) {
			for (int j = 0; j < H; j++) {
				if (countIntersectioninVHLines(verticalInp[i], horizontalInp[j])) {
					countIntersection++;
				}
			}

		}

		System.out.print(countIntersection);
		
		sc_in.close();
	}

	private static boolean countIntersectioninVHLines(String[] verticalInp, String[] horizontalInp) {
		boolean isIntersect = false;
		if (STIC(verticalInp[0]) >= STIC(horizontalInp[1])
				&& STIC(verticalInp[0]) <= STIC(horizontalInp[2])) {
			if (STIC(horizontalInp[0]) >= STIC(verticalInp[1])
					&& STIC(horizontalInp[0]) <= STIC(verticalInp[2])) {
				isIntersect = true;
			}
		}
		return isIntersect;
	}

	private static int STIC(String value) {

		return Integer.parseInt(value);
	}

}
