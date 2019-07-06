package questions.stacks;

public class Stack {

	private DoublyLinkedList linkedList = new DoublyLinkedList();

	public void push(int data) {
		linkedList.addFirst(data);
	}

	public int pop() {
		return linkedList.deleteFirst();
	}
}
