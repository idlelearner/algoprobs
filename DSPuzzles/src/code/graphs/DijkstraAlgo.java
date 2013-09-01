package code.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Node {
	int node;
	int distance;

	public Node(int n, int d) {
		node = n;
		distance = d;
	}

	@Override
	public boolean equals(Object obj) {
		Node n = (Node) obj;
		return (node == n.node) && (distance == n.distance);
	}
}

// Comparator for priority queue
class DistanceComparator implements Comparator<Node> {
	public int compare(Node n1, Node n2) {
		return n2.distance > n1.distance ? n1.distance : n2.distance;
	}
}

/**
 * Dijkstra's algo for finding minimum distance in graph
 * 
 * @author Dhass
 * 
 */
public class DijkstraAlgo {

	public void addEdge(int adjMatrix[][], int source, int destination,
			int weight) {
		adjMatrix[source][destination] = weight;
		adjMatrix[destination][source] = weight;
	}

	// get the unvisited adjacent nodes
	public ArrayList<Node> getUnVisitedAdjNode(int adjMatrix[][], int i) {
		ArrayList<Node> adjNodes = new ArrayList<Node>();
		for (int j = 0; j < adjMatrix.length; j++)
			if (adjMatrix[i][j] != 0)
				adjNodes.add(new Node(j, adjMatrix[i][j]));
		return adjNodes;
	}

	int getMinDistance(int a[][]) {
		int path[] = new int[a.length];
		int dist[] = new int[a.length];
		for (int i = 0; i < a.length; i++)
			dist[i] = -1;
		// source is 0 and dest is n.
		dist[0] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<Node>(5,
				new DistanceComparator());
		pq.add(new Node(0, 0));
		path[0] = 0;
		while (!pq.isEmpty()) {
			Node cur = pq.remove();
			ArrayList<Node> adjNodes = getUnVisitedAdjNode(a, cur.node);
			for (Node adjNode : adjNodes) {
				int newDistance = dist[cur.node] + adjNode.distance;
				if (dist[adjNode.node] == -1) {
					dist[adjNode.node] = newDistance;
					pq.add(new Node(adjNode.node, newDistance));
					path[adjNode.node] = cur.node;
				}
				if (dist[adjNode.node] > newDistance) {
					// Update the values in priorityQueue
					pq.remove(new Node(adjNode.node, dist[adjNode.node]));
					dist[adjNode.node] = newDistance;
					pq.add(new Node(adjNode.node, newDistance));
					path[adjNode.node] = cur.node;
				}
			}
		}
		System.out.println(Arrays.toString(dist));
		System.out.println(Arrays.toString(path));
		return dist[a.length - 1];
	}

	public static void main(String[] args) {
		DijkstraAlgo d = new DijkstraAlgo();
		int a[][] = { { 0, 5, 2, 4, 1 }, { 5, 0, 0, 0, 0 }, { 2, 0, 0, 1, 0 },
				{ 4, 0, 1, 0, 0 }, { 1, 0, 0, 0, 0 } };
		System.out.println(d.getMinDistance(a));
	}
}
