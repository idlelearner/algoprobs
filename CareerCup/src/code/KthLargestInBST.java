package code;

public class KthLargestInBST {

	int count;

	public static void main(String[] args) {
		KthLargestInBST l = new KthLargestInBST();
		BinaryTree root = new BinaryTree(5);
		root.left = new BinaryTree(3);
		root.right = new BinaryTree(8);
		root.left.left = new BinaryTree(1);
		root.left.right = new BinaryTree(4);
		root.right.left = new BinaryTree(6);
		root.right.right = new BinaryTree(9);
		l.findKthLargest(root, 6);
	}

	public void findKthLargest(BinaryTree root, int K) {
		if (root != null) {
			findKthLargest(root.getRight(), K);
			count++;
			if (count == K)
				System.out.println(root.getData());
			findKthLargest(root.getLeft(), K);
		}
	}

}
