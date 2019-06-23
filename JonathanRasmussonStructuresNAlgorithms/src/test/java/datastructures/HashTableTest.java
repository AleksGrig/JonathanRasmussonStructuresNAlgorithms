package datastructures;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HashTableTest {

	private HashTable hashTable;

	@BeforeMethod
	public void Setup() {
		hashTable = new HashTable();
	}

	@Test
	public void PutAndGet() {
		hashTable.put("John Lock", "555-3496");
		hashTable.put("Emma Doe", "523-1155");
		hashTable.put("Paul Wood", "521-3683");
		hashTable.put("Raul Garcia", "234-2095");

		Assert.assertEquals("555-3496", hashTable.get("John Lock"));
		Assert.assertEquals("523-1155", hashTable.get("Emma Doe"));
		Assert.assertEquals("521-3683", hashTable.get("Paul Wood"));
		Assert.assertEquals("234-2095", hashTable.get("Raul Garcia"));
	}

	@Test
	public void Collisions() {
		// these keys will collide
		hashTable.put("John Smith", "500-1111");
		hashTable.put("Sandra Dee", "500-9999");

		Assert.assertEquals("500-1111", hashTable.get("John Smith"));
		Assert.assertEquals("500-9999", hashTable.get("Sandra Dee"));
	}
}
