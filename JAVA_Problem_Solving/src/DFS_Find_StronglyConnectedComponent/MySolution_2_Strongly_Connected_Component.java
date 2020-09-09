package DFS_Find_StronglyConnectedComponent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class MySolution_2_Strongly_Connected_Component {
	// https://www.youtube.com/watch?v=HJnWmL_oODQ&t=1183s

	public static int vertex, edges;
	public static Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
	public static Map<Integer, Integer> visited = new HashMap<Integer, Integer>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		vertex = sc.nextInt();
		edges = sc.nextInt();

		for (int i = 0; i < edges; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			if (!graph.containsKey(x))
				graph.put(x, new ArrayList<Integer>());
			if (!graph.containsKey(y))
				graph.put(y, new ArrayList<Integer>());

			graph.get(x).add(y);
			visited.put(x, 0);
			visited.put(y, 0);
		}

		List<List<Integer>> scc = getSCComponents(graph, visited);
		for (List<Integer> l : scc) {
			Collections.sort(l);
			System.out.println(l);
		}

		sc.close();
	}

	private static List<List<Integer>> getSCComponents(Map<Integer, List<Integer>> orgGraph,
			Map<Integer, Integer> visited) {

		List<Integer> stack = fillOrder(orgGraph, visited);
		Map<Integer, List<Integer>> transposeGraph = transposeGraph(orgGraph);
		Collections.reverse(stack);

		visited = reFillVisited(visited);

		List<List<Integer>> result = new ArrayList<List<Integer>>();

		for (int i = 0; i < stack.size(); i++) {
			if (visited.get(stack.get(i)) == 0) {
				List<Integer> comp = new ArrayList<>();
				DFS(transposeGraph, stack.get(i), visited, comp);
				result.add(comp);
			}
		}

		return result;
	}

	private static Map<Integer, Integer> reFillVisited(Map<Integer, Integer> nodes) {

		for (Entry<Integer, Integer> node : nodes.entrySet()) {
			visited.put(node.getKey(), 0);
		}
		return visited;
	}

	private static Map<Integer, List<Integer>> transposeGraph(Map<Integer, List<Integer>> orgGraph) {

		Map<Integer, List<Integer>> tGraph = new HashMap<Integer, List<Integer>>();

		for (Entry<Integer, List<Integer>> nodes : orgGraph.entrySet()) {
			for (Integer node : nodes.getValue()) {
				if (!tGraph.containsKey(node))
					tGraph.put(node, new ArrayList<Integer>());
				tGraph.get(node).add(nodes.getKey());
			}
		}
		return tGraph;
	}

	private static List<Integer> fillOrder(Map<Integer, List<Integer>> orgGraph, Map<Integer, Integer> visited) {
		List<Integer> order = new ArrayList<Integer>();

		for (Entry<Integer, List<Integer>> node : orgGraph.entrySet()) {
			int nodeVal = node.getKey();
			if (visited.get(nodeVal) == 0) {
				DFS(orgGraph, nodeVal, visited, order);
			}
		}
		return order;
	}

	private static void DFS(Map<Integer, List<Integer>> orgGraph, int singleNode, Map<Integer, Integer> visited,
			List<Integer> order) {
		visited.put(singleNode, 1);
		if (orgGraph.containsKey(singleNode)) { // confirming key value in map
			for (Integer node : orgGraph.get(singleNode)) { // list value of the key object
				if (visited.get(node) == 0) {
					DFS(orgGraph, node, visited, order);
				}
			}
		}
		order.add(singleNode);
	}

}
