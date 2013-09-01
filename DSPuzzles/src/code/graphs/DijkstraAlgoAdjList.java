package code.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Dijkstra's algo for finding minimum distance in graph
 * 
 * @author Dhass
 * 
 */
public class DijkstraAlgoAdjList {
	ArrayList<Integer> adjList;
	ArrayList<ArrayList<Node>> adjNodesList;

	public DijkstraAlgoAdjList() {
		adjList = new ArrayList<Integer>();
		adjNodesList = new ArrayList<ArrayList<Node>>();
	}

	public void createVertices(int n) {
		for (int i = 0; i < n; i++) {
			adjList.add(i);
			adjNodesList.add(new ArrayList<Node>());
		}
	}

	public void addEdge(int source, int destination, int weight) {
		adjNodesList.get(source).add(new Node(destination, weight));
		adjNodesList.get(destination).add(new Node(source, weight));
	}

	public void removeEdge(int source, int destination) {
		adjNodesList.get(source).remove(destination);
		adjNodesList.get(destination).remove(source);
	}

	// get the unvisited adjacent nodes
	public ArrayList<Node> getUnVisitedAdjNode(int i) {
		return adjNodesList.get(i);
	}

	int getMinDistance(int s, int d) {
		int dist[] = new int[adjList.size()];
		for (int i = 0; i < dist.length; i++)
			dist[i] = -1;
		// source is s and dest is d.
		dist[s] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<Node>(5,
				new DistanceComparator());
		pq.add(new Node(s, 0));
		while (!pq.isEmpty()) {
			Node cur = pq.remove();
			ArrayList<Node> adjNodes = getUnVisitedAdjNode(cur.node);
			for (Node adjNode : adjNodes) {
				int newDistance = dist[cur.node] + adjNode.distance;
				if (dist[adjNode.node] == -1) {
					dist[adjNode.node] = newDistance;
					pq.add(new Node(adjNode.node, newDistance));

				}
				if (dist[adjNode.node] > newDistance) {
					// Update the values in priorityQueue
					pq.remove(new Node(adjNode.node, dist[adjNode.node]));
					dist[adjNode.node] = newDistance;
					pq.add(new Node(adjNode.node, newDistance));

				}
			}
		}
		System.out.println(Arrays.toString(dist));
		return dist[d];
	}

	public static void main(String[] args) {
		DijkstraAlgoAdjList d = new DijkstraAlgoAdjList();
		d.createVertices(5);
		d.addEdge(0, 1, 5);
		d.addEdge(1, 2, 2);
		d.addEdge(0, 2, 2);
		d.addEdge(1, 3, 2);
		d.addEdge(0, 3, 9);
		System.out.println(d.getMinDistance(0, 3));
	}

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
}
