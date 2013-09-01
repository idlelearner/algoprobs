package code;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class GoingOffice {
	// change to adjacency list
	ArrayList<Integer> adjList;
	ArrayList<ArrayList<Node>> adjNodesList;

	public GoingOffice() {
		adjList = new ArrayList<Integer>();
		adjNodesList = new ArrayList<ArrayList<Node>>();
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int T = in.nextInt();
		GoingOffice g = new GoingOffice();
		g.createVertices(N);
		for (int i = 0; i < T; i++) {
			g.addEdge(in.nextInt(), in.nextInt(), in.nextInt());
		}

		int s = in.nextInt();
		int d = in.nextInt();
		int q = in.nextInt();
		for (int i = 0; i < q; i++) {
			int x = in.nextInt();
			int y = in.nextInt();
			int w = g.getWeight(x, y);
			g.removeEdge(x, y);
			System.out.println(g.getMinDistance(s, d));
			g.addEdge(x, y, w);

		}
	}

	public int getWeight(int source, int destination) {
		ArrayList<Node> nodes = adjNodesList.get(source);
		for (int i = 0; i < nodes.size(); i++)
			if (nodes.get(i).node == destination)
				return nodes.get(i).distance;
		return -1;
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
		ArrayList<Node> nodes = adjNodesList.get(source);
		for (int i = 0; i < nodes.size(); i++) {
			if (nodes.get(i).node == destination) {
				nodes.remove(nodes.get(i));
				break;
			}
		}
		nodes = adjNodesList.get(destination);
		for (int i = 0; i < nodes.size(); i++) {
			if (nodes.get(i).node == source) {
				nodes.remove(nodes.get(i));
				break;
			}
		}
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
		// System.out.println(Arrays.toString(dist));
		return dist[d];
	}

	// Node used in priorityQueue
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