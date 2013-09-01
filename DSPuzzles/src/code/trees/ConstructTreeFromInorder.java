package code.trees;

/**
 * Construct Binary Tree from inorder traversal It is a special type of tree
 * with root has values greater than it childrens
 * 
 * @author Dhass
 * 
 */

public class ConstructTreeFromInorder {
	public static void main(String[] args) {
		ConstructTreeFromInorder c = new ConstructTreeFromInorder();
		int inOrder[] = { 5, 10, 40, 30, 28 };
		BinaryTree root = c.constructTreeFromInorder(inOrder, 0,
				inOrder.length - 1);
		c.inOrderTraversal(root);
	}

	// Construct Binary tree from inorder
	BinaryTree constructTreeFromInorder(int[] inorder, int start, int end) {
		if (start > end)
			return null;

		int index = max(inorder, start, end);
		BinaryTree root = new BinaryTree();
		root.setData(inorder[index]);

		if (start == end) {
			root.setLeft(null);
			root.setRight(null);
			return root;
		}

		root.setLeft(constructTreeFromInorder(inorder, start, index - 1));
		root.setRight(constructTreeFromInorder(inorder, index + 1, end));
		return root;
	}

	public void inOrderTraversal(BinaryTree root) {
		if (root != null) {
			inOrderTraversal(root.getLeft());
			System.out.print(root.getData() + " ");
			inOrderTraversal(root.getRight());
		}
	}

	int max(int a[], int start, int end) {
		int maximum = Integer.MIN_VALUE;
		int n = 0;
		for (int i = start; i <= end; i++) {
			if (maximum < a[i]) {
				maximum = a[i];
				n = i;
			}
		
		}
		
		return n;
		
	}
}
