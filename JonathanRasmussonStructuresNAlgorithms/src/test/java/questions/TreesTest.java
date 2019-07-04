package questions;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import questions.trees.Tree;

public class TreesTest {

	private Tree tree;

	@BeforeMethod
	public void Setup() {
		tree = new Tree();
	}

	@Test
	public void AddNode() {
		tree.addNode(7);
		tree.addNode(6);
		tree.addNode(8);
		tree.addNode(9);

		tree.printTree();
	}

	@Test
	public void HasElement() {
		tree.addNode(5);
		tree.addNode(3);
		tree.addNode(2);
		tree.addNode(4);
		tree.addNode(7);
		tree.addNode(6);
		tree.addNode(8);

		Assert.assertTrue(tree.hasElement(3));
		Assert.assertTrue(tree.hasElement(5));
		Assert.assertTrue(tree.hasElement(4));
		Assert.assertTrue(tree.hasElement(2));
		Assert.assertTrue(tree.hasElement(7));
		Assert.assertTrue(tree.hasElement(6));
		Assert.assertTrue(tree.hasElement(8));
		Assert.assertFalse(tree.hasElement(9));
		Assert.assertFalse(tree.hasElement(0));
		Assert.assertFalse(tree.hasElement(-3));
		Assert.assertFalse(tree.hasElement(15));
	}

	@Test
	public void TreeToString() {
		tree.addNode(5);
		tree.addNode(3);
		tree.addNode(2);
		tree.addNode(4);
		tree.addNode(7);
		tree.addNode(6);
		tree.addNode(8);
		tree.addNode(1);

		System.out.println(tree.treeToString());
	}

	@Test
	public void IsSubTree() {
		tree.addNode(5);
		tree.addNode(3);
		tree.addNode(2);
		tree.addNode(4);
		tree.addNode(7);
		tree.addNode(6);
		tree.addNode(8);

		Tree tree2 = new Tree();
		tree2.addNode(7);
		tree2.addNode(6);
		tree2.addNode(8);

		Assert.assertTrue(tree.hasSubtree(tree2));

		Tree tree3 = new Tree();
		tree3.addNode(7);
		tree3.addNode(6);
		tree3.addNode(8);
		tree3.addNode(9);

		Assert.assertFalse(tree.hasSubtree(tree3));

		Tree tree4 = new Tree();
		tree4.addNode(7);

		Assert.assertFalse(tree.hasSubtree(tree4));
	}

	@Test
	public void GetDepth() {
		Assert.assertEquals(tree.getDepth(), 0);

		tree.addNode(5);
		Assert.assertEquals(tree.getDepth(), 1);

		tree.addNode(7);
		Assert.assertEquals(tree.getDepth(), 2);

		tree.addNode(4);
		Assert.assertEquals(tree.getDepth(), 2);

		tree.addNode(6);
		Assert.assertEquals(tree.getDepth(), 3);
	}
}