package datastructures;

public class DynamicArray {

	private String[] data;
	private int size;
	private int initialCapacity;

	public DynamicArray(int capacity) {
		this.initialCapacity = capacity;
		data = new String[initialCapacity];
	}


	public String get(int index) {
		return data[index];
	}

	public void set(int index, String value) {
		if (index < size) {
			data[index] = value;
		}
	}

	public void add(String value) {
		if (size == initialCapacity) {
			resize();
		}
		data[size] = value;
		size++;
	}

	public void insert(int index, String value) {
		if (size == initialCapacity) {
			resize();
		}
		for (int j = size; j > index; j--) {
			data[j] = data[j - 1];
		}
		data[index] = value;
		size++;
	}

	public int getSize() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean contains(String element) {
		for (int i = 0; i < size; i++) {
			if (data[i].equals(element)) {
				return true;
			}
		}
		return false;
	}

	public void delete(int index) {
		if (index < size) {
			for (int i = index; i < size - 1; i++) {
				data[i] = data[i + 1];
			}
			size--;
		}
	}

	private void resize() {
		String[] temp = new String[initialCapacity * 2];
		for (int i = 0; i < initialCapacity; i++) {
			temp[i] = data[i];
		}
		data = temp;
		initialCapacity *= 2;

	}
}
