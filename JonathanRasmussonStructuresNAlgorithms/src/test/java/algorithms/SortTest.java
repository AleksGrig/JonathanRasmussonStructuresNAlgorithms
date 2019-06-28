package algorithms;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SortTest {

	private int[] array;

	@BeforeMethod
	public void Setup() {
		array = new int[] { 10, 50, 1, 0, 66, -5, 100 };
	}

	@Test
	public void BubbleSortTest() {
		Sort.bubbleSort(array);
		Assert.assertEquals(array, new int[] { -5, 0, 1, 10, 50, 66, 100 });
	}

	@Test
	public void SelectionSort() {
		Sort.selectionSort(array);
		Assert.assertEquals(array, new int[] { -5, 0, 1, 10, 50, 66, 100 });
	}

	@Test
	public void InsertionSort() {
		Sort.insertionSort(array);
		Assert.assertEquals(array, new int[] { -5, 0, 1, 10, 50, 66, 100 });
	}

	@Test
	public void MergeSortTest() {
		Sort.mergeSort(array, 0, array.length - 1);
		Assert.assertEquals(array, new int[] { -5, 0, 1, 10, 50, 66, 100 });
	}

	@Test
	public void QuickSort() {
		Sort.quickSort(array, 0, array.length - 1);
		Assert.assertEquals(array, new int[] { -5, 0, 1, 10, 50, 66, 100 });
	}
}
