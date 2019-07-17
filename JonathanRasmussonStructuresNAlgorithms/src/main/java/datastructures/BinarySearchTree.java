package datastructures;

import java.util.Stack;

public class BinarySearchTree {

	class Node {
		int key;
		String value;
		Node left, right;

		Node(int key, String value) {
			this.key = key;
			this.value = value;
		}
	}

	Node root;

	public BinarySearchTree() {
		root = null;
	}

	public String find(int key) {
		Node node = find(root, key);
		return (node == null) ? null : node.value;
	}

	private Node find(Node node, int key) {
		if (node == null || node.key == key) {
			return node;
		} else if (key < node.key) {
			return find(node.left, key);
		} else if (key > node.key) {
			return find(node.right, key);
		}
		return null;
	}

	public String find2(int key) {
		Node node = find2(root, key);
		return (node == null) ? null : node.value;
	}

	private Node find2(Node node, int key) {
		if (node == null) {
			return null;
		} else {
			if (key < node.key) {
				return find2(node.left, key);
			} else if (key > node.key) {
				return find2(node.right, key);
			} else {
				return node;
			}
		}
	}

	public void insert(int key, String data) {
		Node newNode = new Node(key, data);
		if (root == null) {
			root = newNode;
			return;
		} else {
			Node previous = null;
			Node current = root;
			while (current != null) {
				previous = current;
				if (key > current.key) {
					current = current.right;
				} else {
					current = current.left;
				}
			}
			if (key > previous.key) {
				previous.right = newNode;
			} else {
				previous.left = newNode;
			}
		}
	}

	public void insert2(int key, String value) {
		root = insertNode(root, key, value);
	}

	private Node insertNode(Node node, int key, String value) {
		if (node == null) {
			return new Node(key, value);
		}

		if (key < node.key) {
			node.left = insertNode(node.left, key, value);
		} else {
			node.right = insertNode(node.right, key, value);
		}

		return node;
	}

	public int min() {
		if(root == null) {
			throw new IllegalStateException("Tree is empty");
		} else {
		Node current = root;
			while (current.left != null) {
				current = current.left;
			}
			return current.key;
		}
	}

	public int min2() {
		return min2(root).key;
	}

	private Node min2(Node node) {
		if (node == null || node.left == null) {
			return node;
		}
		return min2(node.left);
	}

	public void print() {
		print(root);
		System.out.println();
	}

	private void print(Node node) {
		if (node == null) {
			return;
		}
		System.out.println("key = " + node.key + " value = " + node.value);

		if (node.left != null) {
			print(node.left);
		}
		if (node.right != null) {
			print(node.right);
		}
	}

	public void printLevel() {
		if (root != null) {
			Stack<Node> stack = new Stack<Node>();
			Stack<Node> help = new Stack<Node>();
			stack.push(root);
			int level = 0;
			boolean first = true;
			boolean procede = true;
			while (procede) {
				procede = false;
				first = true;
				while (!stack.isEmpty()) {
					Node temp = stack.pop();
					if (first) {
						for (int i = 0; i < 32 - level; i++) {
							System.out.print(" ");
						}
					}
					if (temp != null) {
						System.out.print(temp.key);
						help.push(temp.left);
						help.push(temp.right);
						if (temp.left != null || temp.right != null) {
							procede = true;
						}
					} else {
						System.out.print("-");
					}
					for (int i = 0; i < 1; i++) {
						System.out.print(" ");
					}
					first = false;
				}
				level++;
				System.out.println();
				while (!help.isEmpty()) {
					stack.push(help.pop());
				}
			}
		}
	}

	public void delete(int key) {
		root = delete(root, key);
	}

	private Node delete(Node node, int key) {
		if (node == null) {
			return node;
		} else if (key < node.key) {
			node.left = delete(node.left, key);
		} else if (key > node.key) {
			node.right = delete(node.right, key);
		} else { // This is the node we want to delete
			// Case1: No children
			if (node.left == null && node.right == null) {
				node = null;
			}
			// Case2: One child
			else if (node.left == null) {
				node = node.right;
			} else if (node.right == null) {
				node = node.left;
			}
			// Case3: Two children
			else {
				// Find minimum element to the right
				Node rightMin = min2(node.right);

				// Duplicate it in this node
				node.key = rightMin.key;
				node.value = rightMin.value;

				// Go ahead and delete this right minimum element
				node.right = delete(node.right, node.key);
			}
		}
		return node;
	}
}
