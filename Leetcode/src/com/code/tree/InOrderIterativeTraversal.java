package com.code.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Iterative inorder traversal.
 * 
 * @author thirunavukarasu
 * 
 */
public class InOrderIterativeTraversal {
	public static void main(String[] args) {
		InOrderIterativeTraversal in = new InOrderIterativeTraversal();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.right = new TreeNode(3);
		System.out.println(in.inorderTraversal(root));
	}

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		TreeNode cur = root;
		Stack<TreeNode> s = new Stack<>();
		while (!s.isEmpty() || cur != null) {
			if (cur != null) {
				s.push(cur);
				cur = cur.left;
			} else {
				cur = s.pop();
				res.add(cur.val);
				cur = cur.right;
			}
		}

		return res;
	}
}
