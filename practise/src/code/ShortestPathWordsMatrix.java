package code;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Finding transformation of a word into another.
 * Given the dictionary of words.
 * Words can be transformed to another by replacing,inserting,deleting a character
 * and the transformed word at each step should be present in the dictionary 
 * Using shortest path algo
 * and using adj matrix representation
 * @author Dhass
 * 
 */
public class ShortestPathWordsMatrix {
	ArrayList<String> wordList = new ArrayList<String>();
	int dictionary[][];
	int n;

	public ShortestPathWordsMatrix() {
	}

	public static void main(String[] args) {
		ShortestPathWordsMatrix dictionary = new ShortestPathWordsMatrix();

		// Get input
		try {
			dictionary.getDictionaryWords(args[0]);
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (String s : dictionary.wordList)
			System.out.println(s + " - " + dictionary.wordList.indexOf(s));

		String source = args[1];
		String dest = args[2];

		// Construct dictionary graph
		dictionary.constructGraph();

		// Get the shortest path
		if (dictionary.getNoForWord(source) == -1
				|| dictionary.getNoForWord(dest) == -1) {
			System.out
					.println("Source and destination words should be present in word list!");
		} else {
			long startTime = System.nanoTime();

			String shortestPath[] = dictionary.getShortestPath(
					dictionary.getNoForWord(source),
					dictionary.getNoForWord(dest));

			long endTime = System.nanoTime();
			long totalTime = endTime - startTime;
			System.out.println(totalTime);

			// print output
			if (shortestPath == null)
				System.out.println("No transformation found.");
			else
				for (int i = 0; i < shortestPath.length; i++)
					System.out.println(shortestPath[i]);
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
		n++;
	}

	/**
	 * Constructs graph using the word list. Nodes are connected if one varies
	 * from another by one letter in same location
	 */
	public void constructGraph() {
		dictionary = new int[n][n];
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
		if (differsByLetter(a, b))
			cost = 1;
		return cost;
	}

	/**
	 * Checks if the given word differs by one letter in same location
	 * 
	 * @param a
	 * @param b
	 * @return true or false
	 */
	boolean differsByLetter(String a, String b) {
		char[] aChar = a.toCharArray();
		char[] bChar = b.toCharArray();
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

	/**
	 * Adds edge to the graph with given weight be node to adjacency list
	 * 
	 * @param source
	 * @param destination
	 * @param weight
	 */
	public void addEdge(int source, int destination, int weight) {
		dictionary[source][destination] = weight;
		dictionary[destination][source] = weight;
	}

	/**
	 * Gets nodes connected to i node
	 * 
	 * @param i
	 * @return list of nodes
	 */
	public ArrayList<Node> getAdjNodes(int i) {
		ArrayList<Node> adjNodes = new ArrayList<Node>();
		for (int j = 0; j < dictionary.length; j++)
			if (dictionary[i][j] != 0) {
				adjNodes.add(new Node(j, dictionary[i][j]));
			}
		return adjNodes;
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
		for (int i = 0; i < dist.length; i++)
			System.out.print(i + ", ");

		System.out.println("\n" + Arrays.toString(dist));
		System.out.println(Arrays.toString(path));
		String[] minPath = null;
		if (dist[d] == -1)
			return null;
		else
			minPath = getPath(path, d, dist[d] + 1);

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
	public String[] getPath(int path[], int d, int size) {
		String[] pathStr = new String[size];
		int j = d;
		for (int i = size - 1; i >= 0; i--) {
			pathStr[i] = getWordForNo(j);
			j = path[j];
		}
		return pathStr;
	}

}
