package com.code.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Iterative pre order traversal.
 * 
 * @author thirunavukarasu
 * 
 */
public class PreOrderIterativeTraversal {
	public static void main(String[] args) {
		PreOrderIterativeTraversal p = new PreOrderIterativeTraversal();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.right = new TreeNode(3);
		System.out.println(p.preOrderTravesal(root));
	}

	public List<Integer> preOrderTravesal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		Stack<TreeNode> s = new Stack<>();
		s.push(root);
		while (!s.isEmpty()) {
			TreeNode cur = s.pop();
			res.add(cur.val);

			if (cur.right != null)
				s.push(cur.right);

			if (cur.left != null)
				s.push(cur.left);
		}

		return res;
	}
}
