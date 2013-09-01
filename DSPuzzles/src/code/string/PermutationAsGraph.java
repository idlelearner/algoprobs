package code.string;

public class PermutationAsGraph {

	public static void main(String[] args) {
		PermutationAsGraph p = new PermutationAsGraph();
		p.getPermutation("ABCD");

	}

	public void getPermutation(String s) {
		String str = s;
		int n = str.length();
		char[] arr = str.toCharArray();
		boolean[] visited = new boolean[n];
		for (int i = 0; i < n; i++)
			visited[i] = false;
		char[] branch = new char[n];
		generatePermutations(arr, n, branch, -1, visited);
	}

	void generatePermutations(char[] arr, int size, char[] branch, int level,
			boolean[] visited) {
		if (level >= size - 1) {
			System.out.println(branch);
			return;
		}

		for (int i = 0; i < size; i++) {
			if (!visited[i]) {
				branch[++level] = arr[i];
				visited[i] = true;
				generatePermutations(arr, size, branch, level, visited);
				visited[i] = false;
				level--;
			}
		}
	}

}
