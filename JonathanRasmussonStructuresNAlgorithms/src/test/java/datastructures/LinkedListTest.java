package datastructures;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LinkedListTest {

	private LinkedList linkedList;

	@BeforeMethod
	public void Setup() {
		linkedList = new LinkedList();
	}

	@Test
	public void AddFront() {
		linkedList.addFront(1);
		linkedList.addFront(2);
		linkedList.addFront(3);

		Assert.assertEquals(linkedList.getFirst(), 3);
		Assert.assertEquals(linkedList.getLast(), 1);
	}

	@Test
	public void AddBack() {
		linkedList.addBack(1);
		linkedList.addBack(2);
		linkedList.addBack(3);

		Assert.assertEquals(linkedList.getFirst(), 1);
		Assert.assertEquals(linkedList.getLast(), 3);
	}

	@Test
	public void SizeAndGetSize() {
		Assert.assertEquals(linkedList.size(), 0);
		Assert.assertEquals(linkedList.getSize(), 0);
		linkedList.addBack(1);
		Assert.assertEquals(linkedList.size(), 1);
		Assert.assertEquals(linkedList.getSize(), 1);
		linkedList.addBack(2);
		Assert.assertEquals(linkedList.size(), 2);
		Assert.assertEquals(linkedList.getSize(), 2);
		linkedList.addBack(3);
		Assert.assertEquals(linkedList.size(), 3);
		Assert.assertEquals(linkedList.getSize(), 3);
	}

	@Test
	public void Clear() {
		linkedList.addBack(1);
		linkedList.addBack(2);
		linkedList.addBack(3);

		linkedList.clear();

		Assert.assertEquals(linkedList.size(), 0);
		Assert.assertEquals(linkedList.getSize(), 0);
	}

	@Test
	public void DeleteValue() {
		linkedList.addBack(1);
		linkedList.addBack(2);
		linkedList.addBack(3);

		linkedList.deleteValue2(3);

		Assert.assertEquals(linkedList.size(), 2);
		Assert.assertEquals(linkedList.getSize(), 2);
		Assert.assertEquals(linkedList.getFirst(), 1);
		Assert.assertEquals(linkedList.getLast(), 2);

		linkedList.deleteValue2(2);

		Assert.assertEquals(linkedList.size(), 1);
		Assert.assertEquals(linkedList.getSize(), 1);
		Assert.assertEquals(linkedList.getFirst(), 1);
		Assert.assertEquals(linkedList.getLast(), 1);

		linkedList.deleteValue2(1);

		Assert.assertEquals(linkedList.size(), 0);
		Assert.assertEquals(linkedList.getSize(), 0);
	}
}
