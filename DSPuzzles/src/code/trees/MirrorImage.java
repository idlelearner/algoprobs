package code.trees;


public class MirrorImage {
	public static void main(String[] args) {
		MirrorImage a = new MirrorImage();
		int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
		BinaryTree b = a.createTree(arr, 0, arr.length - 1);
		a.inOrderTraversal(b);
		System.out.println();
		BinaryTree mirror = a.makeMirrorImage(b);
		a.inOrderTraversal(mirror);
	}

	public BinaryTree makeMirrorImage(BinaryTree root) {
		if (root != null) {
			makeMirrorImage(root.left);
			makeMirrorImage(root.right);
			BinaryTree temp = root.left;
			root.left = root.right;
			root.right = temp;
		}
		return root;
	}

	public void inOrderTraversal(BinaryTree root) {
		if (root != null) {
			inOrderTraversal(root.left);
			System.out.print(root.getData() + " ");
			inOrderTraversal(root.right);
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

}
