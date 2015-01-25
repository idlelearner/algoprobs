package com.code.tree;

/**
 * Build tree from PostOrder and Inrder traversals set the right ptr first and
 * left next - checkout
 * 
 * @author thirunavukarasu
 * 
 */
public class PostOrderTraversal {
	int postIndex = 0;;

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		postIndex = postorder.length - 1;
		return generateTree(inorder, postorder, 0, inorder.length - 1);
	}

	public TreeNode generateTree(int in[], int post[], int inSt, int inEnd) {
		if (inSt > inEnd)
			return null;

		TreeNode newNode = new TreeNode(post[postIndex--]);
		if (inSt == inEnd)
			return newNode;
		int eIndex = find(in, newNode.val);
		newNode.right = generateTree(in, post, eIndex + 1, inEnd);
		newNode.left = generateTree(in, post, inSt, eIndex - 1);
		return newNode;
	}

	public int find(int post[], int elmt) {
		for (int i = 0; i < post.length; i++)
			if (post[i] == elmt)
				return i;
		return -1;
	}
}
