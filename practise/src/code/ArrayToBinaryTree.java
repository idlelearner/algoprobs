package code;

public class ArrayToBinaryTree {
	BinaryTree b;

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

	public void inOrderTraversal(BinaryTree root) {
		if (root != null) {
			inOrderTraversal(root.left);
			System.out.print(root.getData() + " ");
			inOrderTraversal(root.right);
		}
	}

	public void inOrderTraversalWithSize(BinaryTree root) {
		if (root != null) {
			inOrderTraversalWithSize(root.left);
			System.out.println(root.getData() + " " + root.size);
			inOrderTraversalWithSize(root.right);
		}
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

	int sum = 0;

	public void changeTree(BinaryTree root) {
		if (root != null) {
			changeTree(root.right);
			root.data = sum + root.data;
			sum = root.data;
			changeTree(root.left);
		}
	}

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

	public int calculateSize(BinaryTree root) {
		if (root == null)
			return 0;
		root.size = calculateSize(root.left) + calculateSize(root.right) + 1;
		return root.size;
	}

	public BinaryTree getKthSmallestElmt(BinaryTree root, int K) {
		int s = (root.left == null ? 0 : root.left.size) + 1;
		if (s == K)
			return root;
		if (K > s)
			return getKthSmallestElmt(root.left, K);
		else
			return getKthSmallestElmt(root.right, K - s);
	}

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
