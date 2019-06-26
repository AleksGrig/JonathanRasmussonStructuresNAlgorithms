package datastructures;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MaxHeapTest {

	private MaxHeap heap;

	@BeforeMethod
	public void Setup() {
		heap = new MaxHeap();
	}

	@Test
	public void Insert() {
		heap.insert(40);
		heap.insert(22);
		heap.insert(34);
		heap.insert(26);
		heap.insert(48);

		Assert.assertEquals(heap.items[0], 48);
		Assert.assertEquals(heap.items[1], 40);
		Assert.assertEquals(heap.items[2], 34);
		Assert.assertEquals(heap.items[3], 22);
		Assert.assertEquals(heap.items[4], 26);
	}

	@Test
	public void PeekMax() {
		heap.insert(40);
		heap.insert(134);
		heap.insert(212);
		heap.insert(156);
		heap.insert(48);

		Assert.assertEquals(heap.peekMax(), 212);
	}

	@Test
	public void ExtractMax() {
		heap.insert(40);
		heap.insert(134);
		heap.insert(212);
		heap.insert(156);
		heap.insert(48);

		heap.extractMax();
		Assert.assertEquals(heap.peekMax(), 156);
		heap.extractMax();
		Assert.assertEquals(heap.peekMax(), 134);
		heap.extractMax();
		Assert.assertEquals(heap.peekMax(), 48);
		heap.extractMax();
		Assert.assertEquals(heap.peekMax(), 40);
	}
}
