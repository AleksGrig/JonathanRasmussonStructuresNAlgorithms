package questions;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import questions.stacks.DoublyLinkedList;
import questions.stacks.MinStack;
import questions.stacks.Stack;
import questions.stacks.StackOfPlates;

public class StacksTest {

	private DoublyLinkedList list;

	@BeforeMethod
	public void Setup() {
		list = new DoublyLinkedList();
	}

	@Test
	public void AddFirst() {
		list.addFirst(10);
		list.addFirst(15);
		list.addFirst(20);

		list.print();
	}

	@Test
	public void AddLast() {
		list.addFirst(10);
		list.addLast(20);
		list.addLast(25);

		list.print();
	}

	@Test
	public void DeleteFirst() {
		list.addFirst(10);

		list.print();
		list.deleteFirst();
		list.print();
	}

	@Test
	public void DeleteLast() {
		list.addFirst(10);
		list.addLast(20);
		list.addLast(25);

		list.print();
		list.deleteLast();
		list.print();

		list.deleteLast();
		list.print();

		list.deleteLast();
		list.print();
	}

	@Test
	public void Stack() {
		Stack stack = new Stack();
		stack.push(10);
		stack.push(25);
		Assert.assertEquals(stack.pop(), 25);
		Assert.assertEquals(stack.pop(), 10);
	}

	@Test
	public void StackOfPlates() {
		StackOfPlates stack = new StackOfPlates(3);
		stack.push(10);
		stack.push(9);
		stack.push(8);
		stack.push(7);
		stack.push(6);
		stack.push(5);
		stack.push(4);

		Assert.assertEquals(stack.pop(), 4);
		Assert.assertEquals(stack.pop(), 5);
		Assert.assertEquals(stack.pop(), 6);
		Assert.assertEquals(stack.pop(), 7);
		Assert.assertEquals(stack.pop(), 8);
		Assert.assertEquals(stack.pop(), 9);
		Assert.assertEquals(stack.pop(), 10);
	}

	@Test
	public void MinStack() {
		MinStack minStack = new MinStack();
		minStack.push(2);
		minStack.push(3);
		minStack.push(1);

		Assert.assertEquals(minStack.min(), 1);

		minStack.pop();
		Assert.assertEquals(minStack.min(), 2);

		minStack.pop();
		Assert.assertEquals(minStack.min(), 2);

	}
}
