package datastructures;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GraphsTest {

	private Graph graph;

	@BeforeMethod
	public void Setup() {
		graph = new Graph(8);
	}

	@Test
	public void BFS() {
		graph.addEdge(0, 1);
		graph.addEdge(6, 0);
		graph.addEdge(1, 4);
		graph.addEdge(4, 1);
		graph.addEdge(4, 6);
		graph.addEdge(6, 4);
		graph.addEdge(1, 0);
		graph.addEdge(0, 3);
		graph.addEdge(1, 5);
		graph.addEdge(5, 1);
		graph.addEdge(5, 3);
		graph.addEdge(3, 5);
		graph.addEdge(3, 0);
		graph.addEdge(0, 6);
		graph.addEdge(5, 2);
		graph.addEdge(2, 5);
		graph.addEdge(7, 2);
		graph.addEdge(2, 7);

		System.out.println("Traversing Graph BFS starting with vertex " + 0);

		graph.BFS(0);
	}

	@Test
	public void DFS() {
		graph.addEdge(0, 3);
		graph.addEdge(3, 0);
		graph.addEdge(1, 5);
		graph.addEdge(5, 1);
		graph.addEdge(4, 6);
		graph.addEdge(6, 4);
		graph.addEdge(6, 0);
		graph.addEdge(0, 6);
		graph.addEdge(1, 4);
		graph.addEdge(4, 1);
		graph.addEdge(5, 3);
		graph.addEdge(3, 5);
		graph.addEdge(1, 0);
		graph.addEdge(0, 1);
		graph.addEdge(5, 2);
		graph.addEdge(2, 5);
		graph.addEdge(7, 2);
		graph.addEdge(2, 7);

		System.out.println("Traversing Graph DFS starting with vertex " + 0);

		graph.DFS(0);
	}
}
