package code;

public class SumOfAllChilNodes {

	public static void main(String[] args) {
		SumOfAllChilNodes s = new SumOfAllChilNodes();
		int a[] = { 1, 2, 3, 4, 5, 6, 7 };
		BinaryTree root = s.createTree(a, 0, a.length - 1);
		s.getSumOfChildNodes(root);
	}

	public int getSumOfChildNodes(BinaryTree root) {
		if (root == null)
			return 0;
		int left = getSumOfChildNodes(root.left);
		int right = getSumOfChildNodes(root.right);
		int sum = left + right + root.data;
		System.out.println(root.data + " " + sum);
		return sum;
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
