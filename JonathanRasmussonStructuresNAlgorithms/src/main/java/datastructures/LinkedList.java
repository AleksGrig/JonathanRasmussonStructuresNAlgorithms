package datastructures;

public class LinkedList {

	private static class Node {
		private int data;
		private Node next;

		public Node(int data) {
			this.data = data;
			next = null;
		}
	}

	private Node head;
	private Node tail;
	private int size;

	public void addFront(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		if (head == null) {
			tail = newNode;
		}
		head = newNode;
		size++;
	}

	public int getFirst() {
		if (head != null) {
			return head.data;
		} else {
			throw new IllegalStateException("List is empty!");
		}
	}

	public int getLast() {
		if (tail != null) {
			return tail.data;
		} else {
			throw new IllegalStateException("List is empty!");
		}
	}

	public void addBack(int data) {
		Node newNode = new Node(data);
		if (tail == null) {
			tail = newNode;
			head = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
		size++;
	}

	public int size() {
		int count = 0;
		if (head == null) {
			return count;
		} else {
			Node current = head;
			while (current != null) {
				count++;
				current = current.next;
			}
		}
		return count;
	}

	public int getSize() {
		return size;
	}

	public void clear() {
		size = 0;
		head = tail = null;
	}

	public void deleteValue(int value) {
		Node previous = null;
		Node current = head;
		while (current != null) {
			if (current.data == value) {
				if (size == 1) {
					clear();
					return;
				} else if (current == head) {
					head = current.next;
					size--;
					return;
				} else if (current == tail) {
					tail = previous;
					tail.next = null;
					size--;
					return;
				} else {
					previous.next = current.next;
					size--;
					return;
				}
			}
			previous = current;
			current = current.next;
		}
	}

	// Instructor's decision, doesn't process last element, tail
	// Fixed for tail problem, but single linked list better use without tail
	// reference, for that better choose double linked list
	public void deleteValue2(int data) {
		if (head == null) {
			return;
		}
		if (head.data == data) {
			if (head.next == null) {
				tail = head;
			}
			head = head.next;
			size--;
			return;
		}
		Node current = head;
		while (current.next != null) {
			if (current.next.data == data) {
				if (current.next.next == null) {
					tail = current;
				}
				current.next = current.next.next;
				size--;
				return;
			}
			current = current.next;
		}
	}
}
