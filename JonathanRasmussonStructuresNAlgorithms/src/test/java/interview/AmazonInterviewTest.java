package interview;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonInterviewTest {

	@Test
	public void MergeLists() {
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();

		list1.add(3);
		list1.add(5);
		list1.add(7);

		list2.add(1);
		list2.add(2);
		list2.add(7);

		ArrayList<Integer> expected = new ArrayList<Integer>();

		expected.add(1);
		expected.add(2);
		expected.add(3);
		expected.add(5);
		expected.add(7);
		expected.add(7);

		Assert.assertEquals(AmazonMergeLists.mergeLists(list1, list2), expected);
	}
}
