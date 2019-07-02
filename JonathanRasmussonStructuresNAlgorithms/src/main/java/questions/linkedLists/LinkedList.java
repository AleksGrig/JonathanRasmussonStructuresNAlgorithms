package questions.linkedLists;

import java.util.HashSet;
import java.util.Set;

public class LinkedList {

	class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	private Node first;
	private Node last;
	private int size;

	public void addFirst(int data) {
		Node newNode = new Node(data);
		newNode.next = first;
		first = newNode;
		if (first.next == null) {
			last = first;
		}
		size++;
	}

	public void addLast(int data) {
		Node newNode = new Node(data);
		if (last == null) {
			last = newNode;
			first = last;
		} else {
			last.next = newNode;
			last = newNode;
		}
		size++;
	}

	public int peekFirst() {
		if (first == null) {
			throw new IllegalStateException("List is empty");
		} else {
			return first.data;
		}
	}

	public int peekLast() {
		if (last == null) {
			throw new IllegalStateException("List is empty");
		} else {
			return last.data;
		}
	}

	public int getSize() {
		return this.size;
	}

	// Better solution is to use doubly linked list
	public void removeDuplicates() {
		if (first != null && first.next != null) {
			Set<Integer> set = new HashSet<Integer>();
			set.add(first.data);
			Node current = first;
			while (current.next != null) {
				if (set.contains(current.next.data)) {
					current.next = current.next.next;
					size--;
					if (current.next == null) {
						last = current;
						break;
					}
				} else {
					set.add(current.next.data);
					current = current.next;
				}
			}
		}
	}
	
	public static LinkedList sum(LinkedList list1, LinkedList list2) {
		Node current1 = list1.first;
		Node current2 = list2.first;
		int remainder = 0;
		LinkedList res = new LinkedList();
		while (current1 != null || current2 != null || remainder > 0) {
			int sum = 0;
			int data = 0;
			if (current1 != null && current2 != null) {
				sum = current1.data + current2.data + remainder;
				current1 = current1.next;
				current2 = current2.next;
			} else if (current1 != null) {
				sum = current1.data + remainder;
				current1 = current1.next;
			} else if (current2 != null) {
				sum = current2.data + remainder;
				current2 = current2.next;
			} else {
				res.addLast(remainder);
				break;
			}
			remainder = 0;
			if (sum > 9) {
				data = sum - 10;
				remainder = 1;
			} else {
				data = sum;
			}
			res.addLast(data);
		}
		return res;
	}
}
