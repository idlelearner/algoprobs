package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class DictionaryWords {
	HashMap<String, Integer> wordMapping = new HashMap<String, Integer>();
	ArrayList<String> wordList = new ArrayList<String>();
	int dictionary[][];

	public static void main(String[] args) throws IOException {
		// helpers for input/output
		Scanner in = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		DictionaryWords dictionary = new DictionaryWords();
		int N;
		N = in.nextInt();

		// Get the words and form list
		for (int i = 0; i < N; i++) {
			dictionary.wordList.add(in.next());
			dictionary.wordMapping.put(dictionary.wordList.get(i), i);
		}

		for (String s : dictionary.wordMapping.keySet())
			System.out.println(s + " - " + dictionary.wordMapping.get(s));

		// Get test cases
		int T = in.nextInt();
		ArrayList<String> testCasesList = new ArrayList<String>();
		for (int i = 0; i < T; i++)
			testCasesList.add(br.readLine());

		// Construct graph
		dictionary.constructGraph();

		for (int i = 0; i < T; i++) {
			String words[] = testCasesList.get(i).split(" ");
			// No change required if both words are minimum
			if (words[0].equals(words[1]))
				System.out.println(0);
			else
				System.out.println(dictionary.getMinDistance(
						dictionary.wordMapping.get(words[0]),
						dictionary.wordMapping.get(words[1])));
		}

	}

	// Construct graph
	// Two nodes are connected if they differ by a letter
	public void constructGraph() {
		int n = wordList.size();
		dictionary = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!sameWords(wordList.get(i), wordList.get(j))
						&& differsByLetter(wordList.get(i), wordList.get(j))) {
					addEdge(i, j, 1);
				}
			}
		}
	}

	// Check if both are same word
	boolean sameWords(String a, String b) {
		if (a.equals(b))
			return true;
		else
			return false;
	}

	// checks if the words differ by a letter.
	boolean differsByLetter(String a, String b) {
		if (Math.abs(a.length() - b.length()) > 1)
			return false;
		char[] aChar = a.toCharArray();
		Arrays.sort(aChar);
		char[] bChar = b.toCharArray();
		Arrays.sort(bChar);
		int l = Math.max(aChar.length, bChar.length);
		int s = Math.min(aChar.length, bChar.length);
		int i = 0, count = 0;
		while (i < s) {
			if (aChar[i] == aChar[i])
				count++;
			i++;
		}
		if (l - count <= 1)
			return true;
		else
			return false;
	}

	// add edge to the graph
	public void addEdge(int source, int destination, int weight) {
		dictionary[source][destination] = weight;
		dictionary[destination][source] = weight;
	}

	// get the unvisited adjacent nodes
	public ArrayList<Node> getUnVisitedAdjNode(int i) {
		ArrayList<Node> adjNodes = new ArrayList<Node>();
		for (int j = 0; j < dictionary.length; j++)
			if (dictionary[i][j] != 0)
				adjNodes.add(new Node(j, dictionary[i][j]));
		return adjNodes;
	}

	// Dijkstras minimum distance algo
	int getMinDistance(int s, int d) {
		int path[] = new int[dictionary.length];
		int dist[] = new int[dictionary.length];
		for (int i = 0; i < dictionary.length; i++)
			dist[i] = -1;
		// source is 0 and dest is n.
		dist[s] = s;
		PriorityQueue<Node> pq = new PriorityQueue<Node>(dictionary.length,
				new DistanceComparator());
		pq.add(new Node(s, 0));
		// path[0] = 0;
		while (!pq.isEmpty()) {
			Node cur = pq.remove();
			ArrayList<Node> adjNodes = getUnVisitedAdjNode(cur.node);
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
		// System.out.println(Arrays.toString(dist));
		System.out.println(Arrays.toString(path));
		return dist[d];
	}
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