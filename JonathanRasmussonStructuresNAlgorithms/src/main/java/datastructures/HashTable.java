package datastructures;

public class HashTable {

	private int INITIAL_SIZE = 16;
	private HashEntry[] data; // array of linked lists

	class HashEntry {
		String key;
		String value;
		HashEntry next;

		public HashEntry(String key, String value) {
			this.key = key;
			this.value = value;
			this.next = null;
		}
	}

	public HashTable() {
		data = new HashEntry[INITIAL_SIZE];
	}

	public void put(String key, String value) {
		// Get the index
		int index = getIndex(key);

		// Create linked list entry
		HashEntry entry = new HashEntry(key, value);

		// If no entry there - add it
		if (data[index] == null) {
			data[index] = entry;
		}
		// Else handle collision by adding entry to the end of the list
		else {
			HashEntry entries = data[index];
			// Walk to the last element
			while (entries.next != null) {
				entries = entries.next;
			}
			entries.next = entry;
		}
	}

	private int getIndex(String key) {
		int hashCode = key.hashCode();
		System.out.println("HashCode = " + hashCode);

		int index = hashCode % INITIAL_SIZE;
		if (index < 0) {
			index += INITIAL_SIZE;
		}

		// Hack to force collision for testing
		if (key.equals("John Smith") || key.equals("Sandra Dee")) {
			index = 4;
		}
		System.out.println("Index = " + index);
		return index;
	}

	public String get(String key) {
		// Get the index
		int index = getIndex(key);

		// Get list of entries
		HashEntry entries = data[index];

		if (entries != null) {
			while (!entries.key.equals(key) && entries.next != null) {
				entries = entries.next;
			}
			return entries.value;
		}
		return null;
	}
}
