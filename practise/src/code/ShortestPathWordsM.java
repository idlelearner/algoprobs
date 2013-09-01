package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Using shortest path algo
 * 
 * @author Dhass
 * 
 */
public class ShortestPathWordsM {
	ArrayList<String> wordList = new ArrayList<String>();
	int dictionary[][];
	boolean visited[];

	public static void main(String[] args) throws IOException {
		// helpers for input/output
		Scanner in = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ShortestPathWordsM dictionary = new ShortestPathWordsM();
		int N;
		N = in.nextInt();

		// Get the words and form list
		for (int i = 0; i < N; i++) {
			dictionary.wordList.add(in.next());
		}

		for (String s : dictionary.wordList)
			System.out.println(s + " - " + dictionary.wordList.indexOf(s));

		// Get test cases
		int T = in.nextInt();
		ArrayList<String> testCasesList = new ArrayList<String>();
		for (int i = 0; i < T; i++)
			testCasesList.add(br.readLine());

		// Construct graph
		dictionary.constructGraph();

		for (int i = 0; i < dictionary.dictionary.length; i++) {
			for (int j = 0; j < dictionary.dictionary[0].length; j++)
				System.out.print(dictionary.dictionary[i][j] + " ");
			System.out.println();
		}

		for (int i = 0; i < T; i++) {
			String words[] = testCasesList.get(i).split(" ");
			// No change required if both words are minimum
			if (words[0].equals(words[1]))
				System.out.println(0);
			else
				System.out.println(dictionary.getMinDistance(
						dictionary.wordList.indexOf(words[0]),
						dictionary.wordList.indexOf(words[1])));
		}

		// Get the Java runtime
		Runtime runtime = Runtime.getRuntime();
		// Run the garbage collector
		runtime.gc();
		// Calculate the used memory
		long memory = runtime.totalMemory() - runtime.freeMemory();
		System.out.println("Used memory is bytes: " + memory);
		System.out.println("Used memory is megabytes: " + memory * 1 / 1000000);

	}

	// Construct graph
	// Two nodes are connected if they differ by a letter
	public void constructGraph() {
		int n = wordList.size();
		dictionary = new int[n][n];
		visited = new boolean[n];

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
		char[] aChar = a.toCharArray();
		// Arrays.sort(aChar);
		char[] bChar = b.toCharArray();
		// Arrays.sort(bChar);
		if (aChar.length != bChar.length)
			return false;
		int count = 0, i = 0;
		while (i < aChar.length) {
			if (aChar[i] != bChar[i]) {
				count++;
				if (count > 1)
					return false;
			}
			i++;
		}
		return true;
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
			if (dictionary[i][j] != 0 && !visited[j]) {
				adjNodes.add(new Node(j, dictionary[i][j]));
				visited[j] = true;
			}
		return adjNodes;
	}

	// Dijkstras minimum distance algo
	int getMinDistance(int s, int d) {
		int path[] = new int[dictionary.length];
		int dist[] = new int[dictionary.length];
		for (int i = 0; i < dictionary.length; i++)
			dist[i] = -1;
		// source is 0 and dest is n.
		dist[s] = 0;
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
		for (int i = 0; i < dist.length; i++)
			System.out.print(i + ", ");

		System.out.println("\n" + Arrays.toString(dist));
		System.out.println(Arrays.toString(path));
		if (dist[d] == -1)
			System.out.println("No transformation found.");
		else
			printPath(path, s, d);
		return dist[d] + 1;
	}

	public void printPath(int path[], int s, int i) {
		if (i != s) {
			printPath(path, s, path[i]);
			System.out.println(wordList.get(i));
		} else
			System.out.println(wordList.get(i));
	}
}
