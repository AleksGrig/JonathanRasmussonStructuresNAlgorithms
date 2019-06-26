package datastructures;

public class MaxHeap {

	private int capacity = 10;
	private int size = 0;

	public int[] items = new int[capacity];

	public void insert(int data) {
		if (size == capacity) {
			throw new IllegalStateException("insert: Heap is full");
		}
		items[size++] = data;
		heapifyUp();
	}

	private void heapifyUp() {
		int index = size - 1;
		int parent = (index - 1) / 2;
		while (parent >= 0 && items[index] > items[parent]) {
			int temp = items[parent];
			items[parent] = items[index];
			items[index] = temp;
			index = parent;
			parent = (parent - 1) / 2;
		}
	}

	public int peekMax() {
		if (size != 0) {
			return items[0];
		} else {
			throw new IllegalStateException("peekMax: Heap is empty");
		}
	}

	public int extractMax() {
		if (size == 0) {
			throw new IllegalStateException("extractMax: Heap is empty");
		} else if(size == 1) {
			size--;
			return items[size];
		} else {
			int max = items[0];
			items[0] = items[--size];
			heapifyDown();
			return max;
		}
	}

	private void heapifyDown() {
		int index = 0;
		int leftChild = index * 2 + 1;
		int rightChild = index * 2 + 2;
		while (leftChild < size && (items[index] < items[leftChild] || items[index] < items[rightChild])) {
			if (rightChild < size) {
				int maxIndex = (items[leftChild] > items[rightChild]) ? leftChild : rightChild;
				int temp = items[maxIndex];
				items[maxIndex] = items[index];
				items[index] = temp;
				index = maxIndex;
			} else {
				int temp = items[leftChild];
				items[leftChild] = items[index];
				items[index] = temp;
				index = leftChild;
			}
			leftChild = index * 2 + 1;
			rightChild = index * 2 + 2;
		}
	}
}
