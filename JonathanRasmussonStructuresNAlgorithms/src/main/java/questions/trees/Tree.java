package questions.trees;

public class Tree {

	private class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	private class Properties {
		int depth;

		Properties() {
			this.depth = 0;
		}
	}

	private Node root;
	private Properties properties = new Properties();

	public void addNode(int data) {
		root = addNode(root, data);
	}

	private Node addNode(Node root, int data) {
		if (root == null) {
			Node newNode = new Node(data);
			return newNode;
		}
		if (root.data >= data) {
			root.left = addNode(root.left, data);
		} else {
			root.right = addNode(root.right, data);
		}
		return root;
	}

	public int getDepth() {
		int dep = 0;
		properties.depth = 0;
		getDepth(root, dep);
		return properties.depth;
	}

	private void getDepth(Node root, int dep) {
		if (root != null) {
			if (++dep > properties.depth) {
				properties.depth = dep;
			}
			getDepth(root.left, dep);
			getDepth(root.right, dep);
		}
		dep--;
	}

	public void printTree() {
		print(root);
	}

	private void print(Node root) {
		if (root == null) {
			return;
		}
		System.out.println(root.data);
		print(root.left);
		print(root.right);
	}

	public boolean hasSubtree(Tree subTree) {
		if(subTree != null) {
			Node subTreeRoot = findElement(root, subTree.root.data);
			if (subTreeRoot != null) {
				return isEqualTrees(subTreeRoot, subTree.root);
			}
		}
		return false;
	}

	// Doesn't work properly
	public boolean hasSubtreeB(Tree subtree) {
		String treeString = treeToString(root, "");
		String subtreeString = treeToString(subtree.root, "");
		return treeString.contains(subtreeString);
	}

	private boolean isEqualTrees(Node subTreeRoot, Node root) {
		if (subTreeRoot != null && root != null) {
			if (treeToString(subTreeRoot, "").equals(treeToString(root, ""))) {
				return true;
			}
		}
		return false;
	}

	private String treeToString(Node root, String str) {
		if (root != null) {
			str = str + root.data;
			str = treeToString(root.left, str);
			str = treeToString(root.right, str);
		}
		return str;
	}

	public String treeToString() {
		return treeToString(root, "");
	}

	private Node findElement(Node root, int data) {
		if (root != null && root.data > data) {
			root = findElement(root.left, data);
		} else if (root != null && root.data < data) {
			root = findElement(root.right, data);
		}
		return root;
	}

	public boolean hasElement(int element) {
		Node found = findElement(root, element);
		if (found != null && found.data == element) {
			return true;
		}
		return false;
	}
}
