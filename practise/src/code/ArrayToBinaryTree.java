package code;

/**
 * Convert an array to a balanced binaryTree and other traversals on the tree.
 * If the given array is sorted,it will build a BST
 * 
 * @author Dhass
 * 
 */
public class ArrayToBinaryTree {
	BinaryTree b;

	// Test main method
	public static void main(String[] args) {
		ArrayToBinaryTree a = new ArrayToBinaryTree();
		int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
		a.b = a.createTree(arr, 0, arr.length - 1);
		a.inOrderTraversal(a.b);
		System.out.println();
		a.printpathToElmt(a.b, 2);
		a.calculateSize(a.b);
		a.inOrderTraversalWithSize(a.b);
		System.out.println();
		// a.changeTree(a.b);
		// a.inOrderTraversal(a.b);
		a.trimBST(a.b, 3, 6);
		a.inOrderTraversal(a.b);
		System.out.println();
		// a.sumpathToElmt(b, 7);

	}

	/**
	 * Inorder traversal to print the tree
	 * 
	 * @param root
	 */
	public void inOrderTraversal(BinaryTree root) {
		if (root != null) {
			inOrderTraversal(root.left);
			System.out.print(root.getData() + " ");
			inOrderTraversal(root.right);
		}
	}

	/**
	 * Inorder traversal printing the size below the current node
	 * 
	 * @param root
	 */
	public void inOrderTraversalWithSize(BinaryTree root) {
		if (root != null) {
			inOrderTraversalWithSize(root.left);
			System.out.println(root.getData() + " " + root.size);
			inOrderTraversalWithSize(root.right);
		}
	}

	/**
	 * creates the binary tree from array
	 * 
	 * @param a
	 * @param low
	 * @param high
	 * @return
	 */
	public BinaryTree createTree(int a[], int low, int high) {
		if (low <= high) {
			int mid = (low + high) / 2;
			BinaryTree root = new BinaryTree(a[mid]);
			root.left = createTree(a, low, mid - 1);
			root.right = createTree(a, mid + 1, high);
			return root;
		} else
			return null;
	}

	/**
	 * prints the path from root to the given node
	 * 
	 * @param root
	 * @param n
	 * @return
	 */
	public boolean printpathToElmt(BinaryTree root, int n) {
		if (root != null) {
			if (root.data == n || printpathToElmt(root.getLeft(), n)
					|| printpathToElmt(root.getRight(), n)) {
				System.out.print(root.data + " ");
				return true;
			}
			return false;
		}
		return false;
	}

	/**
	 * Changes the tree's nodes to the sum of the value of the nodes in post
	 * order traversal
	 */
	int sum = 0;

	public void changeTree(BinaryTree root) {
		if (root != null) {
			changeTree(root.right);
			root.data = sum + root.data;
			sum = root.data;
			changeTree(root.left);
		}
	}

	/**
	 * Trims the tree for the given min and max node
	 * 
	 * @param root
	 * @param min
	 * @param max
	 * @return
	 */
	public BinaryTree trimBST(BinaryTree root, int min, int max) {
		if (root == null)
			return root;
		if (root.data > max)
			return trimBST(root.left, min, max);
		if (root.data < min)
			return trimBST(root.right, min, max);
		root.left = trimBST(root.left, min, max);
		root.right = trimBST(root.right, min, max);
		return root;
	}

	/**
	 * Calculates number of nodes in tree
	 * 
	 * @param root
	 * @return
	 */
	public int calculateSize(BinaryTree root) {
		if (root == null)
			return 0;
		root.size = calculateSize(root.left) + calculateSize(root.right) + 1;
		return root.size;
	}

	/**
	 * Prints the Kth smallest elmt in BST
	 * 
	 * @param root
	 * @param K
	 * @return
	 */
	public BinaryTree getKthSmallestElmt(BinaryTree root, int K) {
		int s = (root.left == null ? 0 : root.left.size) + 1;
		if (s == K)
			return root;
		if (K > s)
			return getKthSmallestElmt(root.left, K);
		else
			return getKthSmallestElmt(root.right, K - s);
	}

	//TODO : Find the given sum exists in the path in the tree
	// public boolean sumpathToElmt(BinaryTree root, int sum) {
	// if (root != null) {
	// if (sum == 0 || sumpathToElmt(root.getLeft(), sum - root.data)
	// || sumpathToElmt(root.getRight(), sum - root.data)) {
	// System.out.print(root.data + " ");
	// return true;
	// }
	// return false;
	// }
	// return false;
	// }
}
