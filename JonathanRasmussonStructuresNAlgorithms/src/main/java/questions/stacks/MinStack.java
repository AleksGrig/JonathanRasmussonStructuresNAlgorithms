package questions.stacks;

public class MinStack {

	private class Node {
		private int data;
		private int min;
		private Node next;

		private Node(int data) {
			this.data = data;
		}
	}

	private Node head;

	public void push(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			head.min = data;
		} else {
			newNode.next = head;
			if (newNode.data < head.min) {
				newNode.min = newNode.data;
			} else {
				newNode.min = head.min;
			}
			head = newNode;
		}
	}

	public int pop() {
		if (head != null) {
		int res = head.data;
		head = head.next;
			return res;
		}
		throw new IllegalStateException("Stack is empty");
	}

	public int min() {
		if (head != null) {
			return head.min;
		}
		throw new IllegalStateException("Stack is empty");
	}
}
