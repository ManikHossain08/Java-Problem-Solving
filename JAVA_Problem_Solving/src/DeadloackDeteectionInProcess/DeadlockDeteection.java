package DeadloackDeteectionInProcess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class DeadlockDeteection {

	enum STATUS {
		VISITED, NOTVISITED, COMPLETED
		// WHITE means not visited
		// BLACK AND RED means already visited
	}

	private static HashMap<String, List<String>> buildGraph = new HashMap<>();
	@SuppressWarnings("rawtypes")
	private static HashMap<String, Enum> nodeeStatus = new HashMap<>();
	private static TreeSet<String> nodes = new TreeSet<>();
	private static boolean cycle = false;

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		int process = sc.nextInt();
		for (int i = 0; i < process; ++i) {
			String x = sc.nextInt() + "p";
			String ri = sc.nextInt() + "r";
			String rj = sc.nextInt() + "r";
			addEdge(ri, x);
			addEdge(x, rj);
			nodes.add(x);
			if (!ri.contains("-1") || !rj.contains("-1")) {
				nodes.add(ri);
				nodes.add(rj);
			}
			nodeeStatus.put(x, STATUS.NOTVISITED);
			nodeeStatus.put(ri, STATUS.NOTVISITED);
			nodeeStatus.put(rj, STATUS.NOTVISITED);
		}

		for (String node : nodes) {
			if (nodeeStatus.get(node).equals(STATUS.NOTVISITED)) {
				dfs(node);
			}
		}

		System.out.println(cycle ? "YES" : "NO");
		sc.close();
	}

	private static void dfs(String u) {
		nodeeStatus.put(u, STATUS.VISITED);
		if (buildGraph.containsKey(u)) {
			// get direct value using integer hashmap
			for (String v : buildGraph.get(u)) {
				if (nodeeStatus.get(v).equals(STATUS.NOTVISITED))
					dfs(v);
				else if (nodeeStatus.get(v).equals(STATUS.VISITED)) {
					cycle = true;
				}
			}
		}
		nodeeStatus.put(u, STATUS.COMPLETED);
	}

	private static void addEdge(String u, String v) {
		if (u.contains("-1") || v.contains("-1"))
			return;
		if (!buildGraph.containsKey(u))
			buildGraph.put(u, new ArrayList<>());
		buildGraph.get(u).add(v);
		// we can also use integer instead of the arrayList in the HashMap
	}

}
