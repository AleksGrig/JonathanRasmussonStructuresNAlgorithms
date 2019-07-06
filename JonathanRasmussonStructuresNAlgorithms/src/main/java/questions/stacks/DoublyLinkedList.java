package questions.stacks;

public class DoublyLinkedList {

	private class Node {
		int data;
		Node next, previous;

		Node(int data) {
			this.data = data;
			next = null;
			previous = null;
		}
	}

	private Node first;
	private Node last;

	public void addFirst(int data) {
		Node newNode = new Node(data);
		newNode.next = first;
		if (first != null) {
			first.previous = newNode;
		} else {
			last = newNode;
		}
		first = newNode;
	}

	public void addLast(int data) {
		Node newNode = new Node(data);
		newNode.previous = last;
		if (last != null) {
			last.next = newNode;
		} else {
			first = newNode;
		}
		last = newNode;
	}

	public void print() {
		if (first != null) {
			Node current = first;
			while (current != null) {
				System.out.print(current.data + " ");
				current = current.next;
			}
			System.out.println();
		} else {
			System.out.println("print(): List is empty");
		}
	}

	public int deleteFirst() {
		if (first != null) {
			int res = first.data;
			if (first == last) {
				first = null;
				last = null;
			} else {
				first = first.next;
				first.previous = null;
			}
			return res;
		} else {
			throw new IllegalStateException("deleteFirst(): List is empty");
		}
	}

	public int deleteLast() {
		if (last != null) {
			int res = last.data;
			if (last == first) {
				last = null;
				first = null;
			} else {
				last.previous.next = null;
				last = last.previous;
			}
			return res;
		} else {
			throw new IllegalStateException("deleteLast(): List is empty");
		}
	}
}
