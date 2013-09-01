package code.graphs;

import java.util.Stack;

/**
 * DFS Graph traversal
 * 
 * @author Dhass
 * 
 */
class Vertex {
	String label;
	boolean visited;

	public Vertex(String lab) {
		label = lab;
		visited = false;
	}
}

public class DFSGraph {
	int vertexCount;
	int maxVertices;
	Vertex vertexList[];
	int adjMatrix[][];
	Stack<Integer> stack;

	public DFSGraph(int maxVerCount) {
		maxVertices = maxVerCount;
		vertexCount = 0;
		vertexList = new Vertex[maxVerCount];
		adjMatrix = new int[maxVerCount][maxVerCount];
		for (int i = 0; i < maxVerCount; i++)
			for (int j = 0; j < maxVerCount; j++)
				adjMatrix[i][j] = 0;
		stack = new Stack<Integer>();
	}

	public void addVertex(String lab) {
		vertexList[vertexCount++] = new Vertex(lab);
	}

	public void addEdge(int source, int destination, int weight) {
		adjMatrix[source][destination] = weight;
		adjMatrix[destination][source] = weight;
	}

	public void displayVertex(int v) {
		System.out.println(vertexList[v].label);
	}

	// get the unvisited adjacent nodes
	public int getUnVisitedAdjNode(int i) {
		for (int j = 0; j < vertexCount; j++)
			if (adjMatrix[i][j] != 0 && !vertexList[j].visited)
				return j;
		return -1;
	}

	// DFS traversal
	public void dfs() {
		vertexList[0].visited = true;
		stack.push(0);
		displayVertex(0);
		while (!stack.isEmpty()) {
			int v = stack.peek();
			int adj = getUnVisitedAdjNode(v);
			if (adj == -1)
				stack.pop();
			else {
				displayVertex(adj);
				vertexList[adj].visited = true;
				stack.push(adj);
			}
		}
		for (int i = 0; i < vertexCount; i++)
			vertexList[i].visited = false;
	}

	public static void main(String[] args) {
		DFSGraph graph = new DFSGraph(5);
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addEdge(0, 1, 5);
		graph.addEdge(1, 2, 5);
		graph.addEdge(1, 4, 5);
		graph.addEdge(2, 0, 5);
		graph.addEdge(2, 3, 5);
		graph.dfs();
	}
}
