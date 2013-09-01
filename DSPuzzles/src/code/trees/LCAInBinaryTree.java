package code.trees;

/**
 * Find least common ancestor in binary tree.
 * 
 * @author Dhass
 * 
 */
public class LCAInBinaryTree {

	public static void main(String[] args) {
		BinaryTree root = new BinaryTree(5);
		root.left = new BinaryTree(4);
		root.right = new BinaryTree(8);
		root.left.left = new BinaryTree(1);
		root.left.right = new BinaryTree(3);
		root.right.left = new BinaryTree(6);
		root.right.right = new BinaryTree(9);

		LCAInBinaryTree l = new LCAInBinaryTree();
		System.out.println(l.LCA(root, root.left.data,
				12).getData());
	}

	// Use bottom up approach
	BinaryTree LCA(BinaryTree root, int p, int q) {
		if (root == null)
			return null;
		if (root.data == p || root.data == q)
			return root;
		BinaryTree left = LCA(root.getLeft(), p, q);
		BinaryTree right = LCA(root.getRight(), p, q);
		if (left != null && right != null)
			return root;
		return left != null ? left : right;
	}
}
