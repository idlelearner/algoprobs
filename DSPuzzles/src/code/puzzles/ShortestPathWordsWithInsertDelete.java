package code.puzzles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Minimum distance of words using shortest path algo
 * 
 * @author Dhass
 * 
 */
public class ShortestPathWordsWithInsertDelete {
	// Cost for substitution
	final int SUBSTITUTION_COST = 2;
	// Cost for insertion/deletion
	final int INSERTION_DELETION_COST = 1;
	// stores the dictionary of words
	ArrayList<String> wordList = new ArrayList<String>();
	// Adjacency node list for graph
	ArrayList<ArrayList<Node>> adjNodesList;
	// No. of dictionary words
	int n;
	// switch to allow insert delete
	boolean allowInsertDelete;

	public ShortestPathWordsWithInsertDelete() {
		wordList = new ArrayList<String>();
		adjNodesList = new ArrayList<ArrayList<Node>>();
		allowInsertDelete = false;
		n = 0;
	}

	public static void main(String[] args) {
		ShortestPathWordsWithInsertDelete shortestPathWords = new ShortestPathWordsWithInsertDelete();

		// Get input
		try {
			shortestPathWords.getDictionaryWords(args[0]);
		} catch (IOException e) {
			e.printStackTrace();
		}

		String source = args[1];
		String dest = args[2];
		String allowIDSwitch = args[3];

		if (allowIDSwitch.equalsIgnoreCase("allowI/D"))
			shortestPathWords.allowInsertDeleteOperation();

		// Construct dictionary graph
		shortestPathWords.constructGraph();

		// Get the shortest path
		if (shortestPathWords.getNoForWord(source) == -1
				|| shortestPathWords.getNoForWord(dest) == -1) {
			System.out
					.println("Source and destination words should be present in word list!");
		} else {

			String shortestPath[] = shortestPathWords.getShortestPath(
					shortestPathWords.getNoForWord(source),
					shortestPathWords.getNoForWord(dest));

			// print output
			if (shortestPath == null)
				System.out.println("No transformation found.");
			else
				for (int i = 0; i < shortestPath.length; i++)
					System.out.println(shortestPath[i]);
		}
	}

	/**
	 * sets coston flag which makes the graph to constructed with insert delete.
	 */
	public void allowInsertDeleteOperation() {
		allowInsertDelete = true;
	}

	/**
	 * Reads words from given file
	 * 
	 * @param filePath
	 * @throws IOException
	 */
	public void getDictionaryWords(String filePath) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		String line = null;
		while ((line = reader.readLine()) != null) {
			if (!line.trim().equals(""))
				addWord(line);
		}
	}

	/**
	 * Gets the number mapping for word
	 * 
	 * @param word
	 * @return number
	 */
	public int getNoForWord(String word) {
		return wordList.indexOf(word);
	}

	/**
	 * Gets word for the number mapping
	 * 
	 * @param i
	 * @return corresponding word
	 */
	public String getWordForNo(int i) {
		return wordList.get(i);
	}

	/**
	 * Adds word into wordList
	 * 
	 * @param s
	 */
	public void addWord(String s) {
		wordList.add(s);
		adjNodesList.add(new ArrayList<Node>());
		n++;
	}

	/**
	 * Constructs graph using the word list. Nodes are connected if one varies
	 * from another by one letter in same location or differs by one character
	 */
	public void constructGraph() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int cost = getCostOfEdge(wordList.get(i), wordList.get(j));
				if (cost != -1)
					addEdge(i, j, cost);
			}
		}
	}

	/**
	 * Gets cost of the edge between word a and word b.
	 * 
	 * @param a
	 * @param b
	 * @return cost of edge.-1 for word b cannot be formed from a.
	 */
	int getCostOfEdge(String a, String b) {
		int cost = -1;
		// Check if the words can be formed by substitution
		if (!a.equals(b) && a.length() == b.length() && canSubstitute(a, b))
			cost = SUBSTITUTION_COST;
		if (allowInsertDelete) {
			// Check if words can be formed by insertion deletion
			if (a.length() != b.length() && canInsertOrDelete(a, b))
				cost = INSERTION_DELETION_COST;
		}
		return cost;
	}

	/**
	 * Checks if the given word differs by one letter in same location
	 * 
	 * @param a
	 * @param b
	 * @return true or false
	 */
	boolean canSubstitute(String a, String b) {
		char[] aChar = a.toCharArray();
		char[] bChar = b.toCharArray();
		int count = 0, i = 0;
		while (i < aChar.length) {
			if (aChar[i] != bChar[i])
				count++;
			if (count > 1)
				return false;
			i++;
		}
		return true;
	}

	/**
	 * Find one string can be changed to another by inserting/deleting a
	 * character
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	boolean canInsertOrDelete(String a, String b) {
		if (Math.abs(a.length() - b.length()) > 1)
			return false;
		String ls = a.length() > b.length() ? a : b;
		String ss = a.length() < b.length() ? a : b;
		if (ls.contains(ss))
			return true;
		else
			return false;
	}

	/**
	 * Adds edge to the graph with given weight be node to adjacency list
	 * 
	 * @param source
	 * @param destination
	 * @param weight
	 */
	public void addEdge(int source, int destination, int weight) {
		adjNodesList.get(source).add(new Node(destination, weight));
		adjNodesList.get(destination).add(new Node(source, weight));
	}

	/**
	 * Gets nodes connected to i node
	 * 
	 * @param i
	 * @return list of nodes
	 */
	public ArrayList<Node> getAdjNodes(int i) {
		return adjNodesList.get(i);
	}

	/**
	 * Gets the shortest path between s and d using dijkstra's algo
	 * 
	 * @param s
	 * @param d
	 * @return Array of strings from source string to destination string
	 */
	String[] getShortestPath(int s, int d) {
		int path[] = new int[n];
		int dist[] = new int[n];
		for (int i = 0; i < n; i++)
			dist[i] = -1;
		// distance for source is 0
		dist[s] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<Node>(n,
				new DistanceComparator());
		pq.add(new Node(s, 0));
		while (!pq.isEmpty()) {
			Node cur = pq.remove();
			// Stop once destination is found
			if (cur.node == d)
				break;
			ArrayList<Node> adjNodes = getAdjNodes(cur.node);
			for (Node adjNode : adjNodes) {
				int newDistance = dist[cur.node] + adjNode.distance;
				if (dist[adjNode.node] == -1) {
					dist[adjNode.node] = newDistance;
					pq.add(new Node(adjNode.node, newDistance));
					path[adjNode.node] = cur.node;
				}
				if (dist[adjNode.node] > newDistance) {
					// Update the new values in priorityQueue
					pq.remove(new Node(adjNode.node, dist[adjNode.node]));
					dist[adjNode.node] = newDistance;
					pq.add(new Node(adjNode.node, newDistance));
					path[adjNode.node] = cur.node;
				}
			}
		}

		String[] minPath = null;
		if (dist[d] != -1)
			minPath = getPath(path, s, d, dist[d] + 1);

		return minPath;
	}

	/**
	 * Gets Strings from the path array
	 * 
	 * @param path
	 * @param d
	 * @param size
	 * @return array of path string
	 */
	public String[] getPath(int path[], int s, int d, int size) {
		String[] tempPathStr = new String[size];
		String[] pathStr = null;
		int j = d;
		int count = 0;
		// backtrack the path from destination
		for (int i = size - 1; i >= 0; i--) {
			tempPathStr[i] = getWordForNo(j);
			count++;
			if (j == s) {
				pathStr = new String[count];
				System.arraycopy(tempPathStr, i, pathStr, 0, count);
				break;
			}
			j = path[j];
		}
		return pathStr;
	}

}

/**
 * Node class representing node in graph.
 * 
 * @author Dhass
 * 
 */
class Node {
	/**
	 * node - name of the node
	 */
	int node;
	/**
	 * distance - distance from the adjacent node.
	 */
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

/**
 * Comparator for priority queue based on distance of node
 * 
 * @author Dhass
 * 
 */
class DistanceComparator implements Comparator<Node> {
	public int compare(Node n1, Node n2) {
		return n2.distance > n1.distance ? n1.distance : n2.distance;
	}
}
