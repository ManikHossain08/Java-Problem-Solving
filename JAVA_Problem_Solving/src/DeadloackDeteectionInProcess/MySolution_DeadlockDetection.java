package DeadloackDeteectionInProcess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MySolution_DeadlockDetection {

	public static int edges;
	public static Map<String, List<String>> graph = new HashMap<String, List<String>>();
	public static List<String> allnodes = new ArrayList<String>();
	public static boolean iscycle = false;

	enum STATUS {
		VISITED, NOTVISITED, COMPLETED
	}

	@SuppressWarnings("rawtypes")
	public static Map<String, Enum> isVisted = new HashMap<String, Enum>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		edges = sc.nextInt();

		for (int i = 0; i < edges; i++) {
			String x = sc.nextInt() + "p";
			String ri = sc.nextInt() + "r";
			String rj = sc.nextInt() + "r";
			addEdge(ri, x);
			addEdge(x, rj);
			allnodes.add(x);
			if (!ri.contains("-1")) {
				allnodes.add(ri);
			}
			if (!rj.contains("-1")) {
				allnodes.add(rj);
			}
			isVisted.put(x, STATUS.NOTVISITED);
			isVisted.put(ri, STATUS.NOTVISITED);
			isVisted.put(rj, STATUS.NOTVISITED);
		}

		for (int i = 0; i < allnodes.size(); i++) {
			if (isVisted.get(allnodes.get(i)) == STATUS.NOTVISITED) {
				DFS(allnodes.get(i));
				if (iscycle) {
					break;
				}
			}
		}
		System.out.println(iscycle ? "Yes" : "NO");
		sc.close();
	}

	private static void DFS(String node) {
		isVisted.put(node, STATUS.VISITED);
		if(graph.containsKey(node)) {
			for (String vertex : graph.get(node)) {
				if (isVisted.get(vertex) == STATUS.NOTVISITED) {
					DFS(vertex);
				} else if (isVisted.get(vertex) == STATUS.VISITED) {
					iscycle = true;
				}
			}

		}
	}

	private static void addEdge(String from, String to) {
		if (from.contains("-1") || to.contains("-1")) return;
		if (!graph.containsKey(from)) 
			graph.put(from, new ArrayList<String>());
		graph.get(from).add(to);
		
	}

}
