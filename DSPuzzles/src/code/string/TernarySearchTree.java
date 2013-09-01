package code.string;

public class TernarySearchTree {

	TNode root;

	public TernarySearchTree() {
		this.root = null;
	}

	public void insert(String key, int pos, TNode node) {
		char s[] = key.toCharArray();
		if (node == null) {
			node = new TNode(s[pos], false);
		}

		if (s[pos] < node.m_char) {
			insert(key, pos, node.left);
		} else if (s[pos] > node.m_char) {
			insert(key, pos, node.right);
		} else {
			if (pos + 1 == key.length()) {
				node.wordEnd = true;
			} else {
				insert(key, pos + 1, node.center);
			}
		}
	}

	public void insert(String s) {
		if (s == null || s == "")
			throw new IllegalArgumentException();

		insert(s, 0, this.root);
	}

	public boolean containsKey(String key) {
		if (key == null || key == "")
			throw new IllegalArgumentException();

		int pos = 0;
		TNode node = this.root;
		char s[] = key.toCharArray();
		while (node != null) {

			if (s[pos] < node.m_char) {
				node = node.left;
			} else if (s[pos] > node.m_char) {
				node = node.right;
			} else {
				if (++pos == key.length())
					return node.wordEnd;
				node = node.center;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		TernarySearchTree tree = new TernarySearchTree();
		tree.insert("AB");
		tree.insert("ABBA");
		tree.insert("ABCD");
		tree.insert("BCD");

		boolean found = tree.containsKey("AB");

		if (found)
			System.out.println("AB is found in the tree");
		else
			System.out.println("AB is not found");

		found = tree.containsKey("ABCD");

		if (found)
			System.out.println("ABCD is found in the tree");
		else
			System.out.println("ABCD is not found");

	}
}

class TNode {
	char m_char;
	TNode left, center, right;
	boolean wordEnd;

	public TNode(char ch, boolean wordEnd) {
		m_char = ch;
		this.wordEnd = wordEnd;
	}
}