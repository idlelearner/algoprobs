package code.trees;

public class MaxPathSum {
	public static int maxSum = 0;
	public static BinaryTree targetNode;

	public static void main(String[] args) {
		MaxPathSum m = new MaxPathSum();
		BinaryTree root = new BinaryTree();
		root.setData(10);
		root.setLeft(new BinaryTree(-2));
		root.setRight(new BinaryTree(7));
		root.getLeft().setLeft(new BinaryTree(8));
		root.getLeft().setRight(new BinaryTree(-4));
		m.maxSumPath(root);
	}

	public void maxSumPath(BinaryTree root) {
		BinaryTree target = maxSumPathUtil(root, 0);
		System.out.println("Maximum sum : " + maxSum);
		// print path
		printPath(root, target);
	}

	public boolean printPath(BinaryTree root, BinaryTree targetNode) {
		if (root == null)
			return false;
		if ((root == targetNode) || printPath(root.getLeft(), targetNode)
				|| printPath(root.getRight(), targetNode)) {
			System.out.println(root.getData());
			return true;
		}
		return false;
	}

	BinaryTree maxSumPathUtil(BinaryTree root, int curSum) {
		if (root == null)
			return targetNode;
		curSum += root.getData();

		if (root.getLeft() == null && root.getRight() == null) {
			if (maxSum < curSum) {
				maxSum = curSum;
				targetNode = root;
			}
		}
		maxSumPathUtil(root.getLeft(), curSum);
		maxSumPathUtil(root.getRight(), curSum);
		return targetNode;
	}

}
