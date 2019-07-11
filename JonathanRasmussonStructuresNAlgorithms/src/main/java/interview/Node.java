package interview;

public class Node {
	int key;
	Node left, right;

	public Node(int key) {
		this.key = key;
	}

	public Node copy() {
		Node newNode = new Node(key);
		if (this.left != null) {
			newNode.left = this.left.copy();
		}
		if (this.right != null) {
			newNode.right = this.right.copy();
		}
		return newNode;
	}

	public void inOrderTraversal() {
		if (this != null) {
			if (left != null) {
				left.inOrderTraversal();
			}
			System.out.println(key);
			if (right != null) {
				right.inOrderTraversal();
			}
		}
	}
}
