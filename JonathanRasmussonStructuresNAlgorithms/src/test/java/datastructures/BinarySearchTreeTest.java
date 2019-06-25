package datastructures;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BinarySearchTreeTest {

	private BinarySearchTree bst;

	@BeforeMethod
	public void Setup() {
		bst = new BinarySearchTree();
	}

	@Test
	public void InsertAndFind() {
		bst.insert2(5, "e");
		bst.insert2(3, "c");
		bst.insert2(7, "g");
		bst.insert2(4, "d");
		bst.insert2(1, "a");
		bst.insert2(8, "h");

		bst.printLevel();
		System.out.println();
		System.out.println("Min key is " + bst.min());
		System.out.println("Min2 key is " + bst.min2());

		Assert.assertEquals(bst.find(1), "a");
		Assert.assertEquals(bst.find(3), "c");
		Assert.assertEquals(bst.find(4), "d");
		Assert.assertEquals(bst.find(5), "e");
		Assert.assertEquals(bst.find(7), "g");
		Assert.assertEquals(bst.find(8), "h");
		Assert.assertEquals(bst.find(10), null);
	}

	@Test
	public void MinAndMin2() {
		bst.insert2(5, "e");
		bst.insert2(3, "c");
		bst.insert2(7, "g");
		bst.insert2(4, "d");
		bst.insert2(1, "a");
		bst.insert2(8, "h");

		Assert.assertEquals(bst.min(), 1);
		Assert.assertEquals(bst.min2(), 1);
	}

	@Test
	public void Delete() {
		bst.insert(5, "Five");
		bst.insert(3, "Three");
		bst.insert(4, "Four");
		bst.insert(1, "One");
		bst.insert(8, "Eight");
		bst.insert(9, "Nine");

		bst.print();

		// Delete node without children
		bst.delete(1);
		bst.print();
		Assert.assertEquals(bst.find(1), null);

		// Delete node with one child
		bst.delete(8);
		bst.print();
		Assert.assertEquals(bst.find(8), null);

		// Delete node with two children
		bst.delete(5);
		bst.print();
		Assert.assertEquals(bst.find(5), null);
	}

	@Test
	public void PrintLevel() {
		bst.insert(7, "seven");
		bst.insert(5, "Five");
		bst.insert(3, "Three");
		bst.insert(4, "Four");
		bst.insert(1, "One");
		bst.insert(8, "Eight");
		bst.insert(9, "Nine");
		bst.insert(6, "Six");
		bst.insert(10, "Ten");

		bst.printLevel();
	}
}
