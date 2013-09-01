package code.trees;

public class ConstructTreeFromInAndPostOrder {
	public int preIndex = 0;

	public static void main(String[] args) {
		ConstructTreeFromInAndPostOrder c = new ConstructTreeFromInAndPostOrder();
		int inOrder[] = { 4, 2, 5, 1, 6, 3, 7 };
		int preOrder[] = { 1, 2, 4, 5, 3, 6, 7 };
		BinaryTree root = new BinaryTree();
		root = c.constructTree(0, inOrder.length - 1, inOrder, preOrder);
		c.inOrderTraversal(root);
	}

	public BinaryTree constructTree(int inStIndex, int inEndIndex,
			int inOrder[], int preOrder[]) {
		if (inStIndex > inEndIndex)
			return null;
		BinaryTree newNode = new BinaryTree(preOrder[preIndex]);
		preIndex++;
		if (inStIndex == inEndIndex)
			return newNode;
		int elmt = find(inOrder, newNode.data);
		newNode.setLeft(constructTree(inStIndex, elmt - 1, inOrder, preOrder));
		newNode.setRight(constructTree(elmt + 1, inEndIndex, inOrder, preOrder));
		return newNode;
	}

	int find(int a[], int elmt) {
		for (int i = 0; i < a.length; i++)
			if (a[i] == elmt)
				return i;
		return 0;
	}

	public void inOrderTraversal(BinaryTree root) {
		if (root != null) {
			inOrderTraversal(root.left);
			System.out.println(root.data);
			inOrderTraversal(root.right);
		}
	}
}
