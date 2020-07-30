package PathWithMinimumCost;

import java.util.Scanner;

public class FindingPathWIthMinimumCost {
	public static void main(String args[]) {
		FindingPathWIthMinimumCost obj = new FindingPathWIthMinimumCost();

		Scanner scan = new Scanner(System.in);
		int numStations = Integer.parseInt(scan.nextLine());

		int cost[][] = new int[numStations][numStations];
		String costa[][] = new String[numStations][numStations];
		for (int i = 0; i < numStations; i++) {
			costa[i] = scan.nextLine().split(" ");
		}
		

		for (int i = 0; i < numStations; i++) {
			for (int j = 0; j < numStations; j++) {
				cost[i][j] = Integer.parseInt(costa[i][j]);
				// Another way, take direct scanner input and store in array.
				//cost[i][j] = scan.nextInt();
			}
			//scan.nextLine(); // add this line too for this alternative option.
		}
		System.out.print(obj.minCost(cost, numStations));
		scan.close();
	}

	public int minCost(int cost[][], int n) {
		return minCostRec(cost, 0, n - 1);
	}

	static int minCostRec(int cost[][], int s, int d) {
		if (s == d || s + 1 == d)
			return cost[s][d];
		int min = cost[s][d];
		for (int i = s + 1; i < d; i++) {
			int c = minCostRec(cost, s, i) + minCostRec(cost, i, d);
			if (c < min)
				min = c;
		}
		return min;
	}

}
