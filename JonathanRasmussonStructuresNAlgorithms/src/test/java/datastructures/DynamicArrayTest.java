package datastructures;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DynamicArrayTest {

	private DynamicArray array;

	@BeforeMethod
	public void setup() {
		array = new DynamicArray(2);
	}

	@Test
	public void GetAndSet() {
		array.set(0, "A");
		Assert.assertTrue(array.isEmpty());
	}

	@Test
	public void Insert() {
		array.add("C");
		array.add("D");
		array.insert(1, "B");

		Assert.assertEquals(3, array.getSize());
		Assert.assertEquals("C", array.get(0));
		Assert.assertEquals("B", array.get(1));
		Assert.assertEquals("D", array.get(2));
	}

	@Test
	public void Contains() {
		array.add("A");
		array.add("D");
		Assert.assertTrue(array.contains("D"));
		Assert.assertFalse(array.contains("E"));
	}

	@Test
	public void Delete() {
		array.add("A");
		array.add("D");
		Assert.assertEquals(2, array.getSize());
		Assert.assertTrue(array.contains("D"));
		Assert.assertTrue(array.contains("A"));

		array.delete(0);
		Assert.assertEquals(1, array.getSize());
		Assert.assertTrue(array.contains("D"));
		Assert.assertFalse(array.contains("A"));

		array.delete(0);
		Assert.assertEquals(0, array.getSize());
		Assert.assertFalse(array.contains("D"));
		Assert.assertFalse(array.contains("A"));
	}
}
