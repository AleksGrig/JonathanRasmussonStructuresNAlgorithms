package questions.trees;

public class BinaryTree {

	private class Node {
		int data;
		Node left, right;

		Node(int value) {
			this.data = value;
			this.left = null;
			this.right = null;
		}
	}

	private Node root;
	private int matches;
	private int depth;

	public void createTree1() {
		root = new Node(10);
		root.left = new Node(5);
		root.right = new Node(-3);
		root.right.right = new Node(11);
		root.left.left = new Node(3);
		root.left.right = new Node(2);
		root.left.left.left = new Node(3);
		root.left.left.right = new Node(-2);
		root.left.right.right = new Node(4);
	}

	public void createTree2() {
		root = new Node(10);
		root.left = new Node(5);
		root.right = new Node(-3);
	}

	public int getDepth() {
		depth = 0;
		int dep = 0;
		getDepth(root, dep);
		return depth;
	}

	private void getDepth(Node root, int dep) {
		if (root != null) {
			if (++dep > depth) {
				depth = dep;
			}
			getDepth(root.left, dep);
			getDepth(root.right, dep);
			dep--;
		}

	}

	public void print() {
		print(root);
	}

	private void print(Node root) {
		if (root != null) {
			System.out.println(root.data);
			print(root.left);
			print(root.right);
		}
	}

	public int waysWithSum(int num) {
		matches = 0;
		traverse(root, num);
		return matches;
	}

	private void traverse(Node root, int num) {
		if (root != null) {
			int sum = 0;
			waysWithSum(root, sum, num);
			traverse(root.left, num);
			traverse(root.right, num);
		}
	}

	private void waysWithSum(Node root, int sum, int num) {
		if (root != null) {
			sum += root.data;
			waysWithSum(root.left, sum, num);
			waysWithSum(root.right, sum, num);
			if (root.left == null && root.right == null && sum == num) {
				matches++;
			}
		}
	}
}
