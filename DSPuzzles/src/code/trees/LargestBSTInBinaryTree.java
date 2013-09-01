package code.trees;

public class LargestBSTInBinaryTree {
	static int maxNodes = 0;
	static int max = Integer.MAX_VALUE;
	static int min = Integer.MIN_VALUE;
	static BinaryTree bst = null;

	public static void main(String[] args) {
		LargestBSTInBinaryTree a = new LargestBSTInBinaryTree();
		int arr[] = { 1, 5, 3, 4, 5, 6, 7 };
		BinaryTree root = a.createTree(arr, 0, arr.length - 1);
		LargestBSTInBinaryTree l = new LargestBSTInBinaryTree();
		l.findLargestBSTSubTree(root);
		System.out.println("No of nodes : " + maxNodes);
	}

	int findLargestBSTSubTree(BinaryTree p) {
		if (p == null)
			return 0;
		boolean isBst = true;
		int leftNodes = findLargestBSTSubTree(p.left);
		int currMin = leftNodes == 0 ? p.data : min;
		if (leftNodes == -1 || (leftNodes != 0 && p.data <= max))
			isBst = false;
		int rightNodes = findLargestBSTSubTree(p.right);
		int currMax = rightNodes == 0 ? p.data : max;
		if (rightNodes == -1 || (rightNodes != 0 && p.data >= min))
			isBst = false;
		if (isBst) {
			min = currMin;
			max = currMax;
			int totalNodes = leftNodes + rightNodes + 1;
			if (maxNodes < totalNodes) {
				maxNodes = totalNodes;
				bst = p;
			}
			return totalNodes;
		} else
			return -1;
	}

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
}
