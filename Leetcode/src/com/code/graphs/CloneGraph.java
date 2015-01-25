package com.code.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Clone a given undirected graph Used Hashmap and BFS
 * 
 * @author thirunavukarasu
 * 
 */
public class CloneGraph {

	public static void main(String[] args) {
		UndirectedGraphNode n = new UndirectedGraphNode(-1);
		CloneGraph c = new CloneGraph();
		UndirectedGraphNode r = c.cloneGraph(n);
	}

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		HashMap<Integer, Boolean> visitedMap = new HashMap<Integer, Boolean>();
		HashMap<Integer, UndirectedGraphNode> newGraph = new HashMap<Integer, UndirectedGraphNode>();
		if (node == null)
			return node;

		ArrayDeque<UndirectedGraphNode> queue = new ArrayDeque<UndirectedGraphNode>();
		queue.add(node);
		UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
		newGraph.put(newNode.label, newNode);
		while (!queue.isEmpty()) {

			// Clone the parent nodes
			UndirectedGraphNode cur = queue.pollFirst();
			if (!visitedMap.containsKey(cur.label)) {
				visitedMap.put(cur.label, true);
				UndirectedGraphNode newGraphNode = null;
				if (!newGraph.containsKey(cur.label)) {
					newGraphNode = new UndirectedGraphNode(cur.label);
					newGraph.put(newGraphNode.label, newGraphNode);
				} else
					newGraphNode = newGraph.get(cur.label);

				// Clone the neighbour nodes
				for (UndirectedGraphNode nNode : cur.neighbors) {
					UndirectedGraphNode newNbrNode = null;
					if (!newGraph.containsKey(nNode.label)) {
						newNbrNode = new UndirectedGraphNode(nNode.label);
						newGraph.put(newNbrNode.label, newNbrNode);
					} else
						newNbrNode = newGraph.get(nNode.label);
					newGraphNode.neighbors.add(newNbrNode);
					queue.add(nNode);
				}
			}
		}
		return newNode;
	}
}

class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;

	UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
}
