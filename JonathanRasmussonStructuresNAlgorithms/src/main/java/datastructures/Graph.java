package datastructures;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class Graph {

	private int Size;
	private LinkedList<Integer> adj[];

	@SuppressWarnings("unchecked")
	public Graph(int size) {
		Size = size;
		adj = new LinkedList[Size];
		for (int i = 0; i < Size; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}

	public void addEdge(int source, int dest) {
		adj[source].add(dest);
	}

	// Breadth First Search traversal
	public void BFS(int s) {
		boolean[] visited = new boolean[Size];// mark all vertices as unvisited
		LinkedList<Integer> queue = new LinkedList<Integer>();// create a queue for BFS
		visited[s] = true;
		System.out.println("Starting at " + s);
		queue.add(s);
		while (!queue.isEmpty()) {
			s = queue.poll();
			System.out.print(" " + s);
			Iterator<Integer> it = adj[s].iterator();
			while (it.hasNext()) {
				int n = it.next();
				if (!visited[n]) {
					visited[n] = true;
					// System.out.println("Queueing " + n);
					queue.add(n);
				}
			}
		}
		System.out.println();
	}

	// Depth First Search
	public void DFS(int s) {
		boolean[] visited = new boolean[Size];// mark all vertices as unvisited
		Stack<Integer> stack = new Stack<Integer>();// create a queue for BFS
		visited[s] = true;
		System.out.println("Starting at " + s);
		stack.add(s);
		while (!stack.isEmpty()) {
			s = stack.pop();
			System.out.print(" " + s);
			Iterator<Integer> it = adj[s].iterator();
			while (it.hasNext()) {
				int n = it.next();
				if (!visited[n]) {
					visited[n] = true;
					stack.push(n);
				}
			}
		}
		System.out.println();
	}
}
