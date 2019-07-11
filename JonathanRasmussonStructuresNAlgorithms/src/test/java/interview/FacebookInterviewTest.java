package interview;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FacebookInterviewTest {

	@Test
	public void ArrayIntersector() {
		int[] array1 = { 2, 1, 4, 5, 6, 7, 7 };
		int[] array2 = { 2, 3, 7, 5 };
		ArrayList<Integer> expected = new ArrayList<>();

		ArrayList<Integer> result = new ArrayList<>();
		expected.add(2);
		expected.add(5);
		expected.add(7);

		result = FacebookArrayIntersector.intersect(array1, array2);
		Assert.assertEquals(result, expected);

	}

	@Test
	public void CopyNode() {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);

		Node copy = root.copy();
		Node leftCopy = root.left.copy();

		Assert.assertEquals(copy.key, root.key);
		Assert.assertEquals(copy.left.key, root.left.key);
		Assert.assertEquals(copy.right.key, root.right.key);

		Assert.assertEquals(leftCopy.key, root.left.key);
		Assert.assertTrue(leftCopy.left == null);
		Assert.assertTrue(leftCopy.right == null);
	}

	@Test
	public void InOrderTraversal() {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);

		root.inOrderTraversal();

	}
}
