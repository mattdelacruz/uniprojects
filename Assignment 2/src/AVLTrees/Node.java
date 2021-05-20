package AVLTrees;

public class Node {
	Node left, right;
	int value, height;

	public Node(int n) {
		value = n;
		height = 1;
	}
}
