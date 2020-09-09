package DFS_Find_StronglyConnectedComponent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MySolution_1_Strongly_Connected_Component {
	// https://www.youtube.com/watch?v=HJnWmL_oODQ&t=1183s

	public static int vertex, edges;
	public static List<Integer>[] graph;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		vertex = sc.nextInt();
		edges = sc.nextInt();

		graph = new List[vertex];

		for (int i = 0; i < vertex; i++) {
			graph[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < edges; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			graph[x].add(y);
		}

		List<List<Integer>> scc = getSCComponents(graph);
		for (List<Integer> l : scc) {
			Collections.sort(l);
			System.out.println(l);
		}

		sc.close();
	}

	private static List<List<Integer>> getSCComponents(List<Integer>[] orgGraph) {
		boolean[] visited = new boolean[vertex];
		
		List<Integer> stack = fillOrder(orgGraph, visited);
		List<Integer>[] transposeGraph = transposeGraph(orgGraph);
		Collections.reverse(stack);
		
		visited = new boolean[vertex];
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		
		for (int i = 0; i < stack.size(); i++) {
			if (visited[stack.get(i)] == false) {
				List<Integer> comp = new ArrayList<>();
				DFS(transposeGraph, stack.get(i), visited, comp);
				result.add(comp);
			}
		}

		return result;
	}

	private static List<Integer>[] transposeGraph(List<Integer>[] orgGraph) {
		@SuppressWarnings("unchecked")
		List<Integer>[] tGraph = new List[vertex];
		for (int i = 0; i < vertex; i++) {
			tGraph[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < orgGraph.length; i++) {
			for (int j = 0; j < orgGraph[i].size(); j++) {
				tGraph[orgGraph[i].get(j)].add(i);
			}
		}
		return tGraph;
	}

	private static List<Integer> fillOrder(List<Integer>[] orgGraph, boolean[] visited) {
		List<Integer> order = new ArrayList<Integer>();
		for (int i = 0; i < vertex; i++) {
			if (visited[i] == false) {
				DFS(orgGraph, i, visited, order);
			}
		}
		return order;
	}

	private static void DFS(List<Integer>[] orgGraph, int singleNode, boolean[] visited, List<Integer> order) {
		visited[singleNode] = true;
		for (int j = 0; j < orgGraph[singleNode].size(); j++) {
			int node = orgGraph[singleNode].get(j);
			if (visited[node] == false) {
				DFS(orgGraph, node, visited, order);
			}
		}
		order.add(singleNode);
	}

}
