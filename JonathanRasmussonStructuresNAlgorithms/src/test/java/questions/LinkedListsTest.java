package questions;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import questions.linkedLists.LinkedList;

public class LinkedListsTest {

	private LinkedList list;

	@BeforeMethod
	public void Setup() {
		list = new LinkedList();
	}

	@Test
	public void AddFirstAndLast() {
		list.addFirst(1);
		Assert.assertEquals(list.peekFirst(), 1);
		Assert.assertEquals(list.peekLast(), 1);

		list.addFirst(2);
		Assert.assertEquals(list.peekFirst(), 2);
		Assert.assertEquals(list.peekLast(), 1);

		list.addLast(3);
		Assert.assertEquals(list.peekFirst(), 2);
		Assert.assertEquals(list.peekLast(), 3);

		Assert.assertEquals(list.getSize(), 3);
	}

	@Test
	public void RemoveDuplicates() {
		list.addFirst(5);
		list.addLast(3);
		list.addLast(5);
		list.addLast(5);
		list.addLast(3);
		list.addFirst(7);

		Assert.assertEquals(list.peekFirst(), 7);
		Assert.assertEquals(list.peekLast(), 3);
		Assert.assertEquals(list.getSize(), 6);

		list.removeDuplicates();
		Assert.assertEquals(list.peekFirst(), 7);
		Assert.assertEquals(list.peekLast(), 3);
		Assert.assertEquals(list.getSize(), 3);
	}

	@Test
	public void SumLists() {
		LinkedList list1 = new LinkedList();
		LinkedList list2 = new LinkedList();
		LinkedList res = new LinkedList();

		list1.addFirst(5);
		list1.addFirst(2);
		list1.addFirst(8);

		list2.addFirst(2);
		list2.addFirst(9);
		list2.addFirst(4);

		res = LinkedList.sum(list1, list2);

		Assert.assertEquals(res.getSize(), 3);
		Assert.assertEquals(res.peekFirst(), 2);
		Assert.assertEquals(res.peekLast(), 8);

	}

	@Test
	public void SumLists2() {
		LinkedList list1 = new LinkedList();
		LinkedList list2 = new LinkedList();
		LinkedList res = new LinkedList();

		list1.addFirst(9);
		list1.addFirst(9);
		list1.addFirst(9);

		list2.addFirst(8);
		list2.addFirst(8);
		list2.addFirst(8);

		res = LinkedList.sum(list1, list2);

		Assert.assertEquals(res.getSize(), 4);
		Assert.assertEquals(res.peekFirst(), 7);
		Assert.assertEquals(res.peekLast(), 1);
	}

	@Test
	public void FindLoop() {
		LinkedList loopedList = LinkedList.createLoopedList();
		list.addLast(1);
		list.addLast(5);
		list.addLast(3);
		list.addFirst(9);
		list.addFirst(9);
		list.addFirst(9);
		list.addFirst(8);
		list.addFirst(8);
		list.addFirst(8);

		Assert.assertTrue(loopedList.findLoop());
		Assert.assertFalse(list.findLoop());
	}
}
