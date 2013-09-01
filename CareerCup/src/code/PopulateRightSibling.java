package code;

public class PopulateRightSibling {
	public static void main(String[] args) {
		PopulateRightSibling p = new PopulateRightSibling();
		BinaryTree root = new BinaryTree(1);
		root.left = new BinaryTree(2);
		root.right = new BinaryTree(3);
		root.right.left = new BinaryTree(4);
		root.right.right = new BinaryTree(5);
		root = p.populateSiblingPtr(root);
		System.out.println("Populated");
	}

	public BinaryTree populateSiblingPtr(BinaryTree root) {
		if (root == null)
			return null;
		BinaryTree finalRoot = root;
		root.sibling = null;
		BinaryTree start = root.left != null ? root.left : root.right;
		while (root != null) {
			if (root.left != null)
				root.left.sibling = root.right;
			if (root.right != null)
				root.right.sibling = root.sibling == null ? null
						: root.sibling.left;
			if (start == null)
				start = root.left != null ? root.left : root.right;
			if (root.sibling == null) {
				root = start;
				if (start != null)
					start = start.left != null ? start.left : start.right;
			} else
				root = root.sibling;

		}
		return finalRoot;
	}
}
