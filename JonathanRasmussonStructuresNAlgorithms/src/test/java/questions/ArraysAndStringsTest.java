package questions;

import org.testng.Assert;
import org.testng.annotations.Test;

import questions.arraysAndStrings.Compressor;
import questions.arraysAndStrings.OneAwayDetector;
import questions.arraysAndStrings.PermutationDetector;
import questions.arraysAndStrings.URLConverter;
import questions.arraysAndStrings.UniqueCharacterDetector;

public class ArraysAndStringsTest {

	@Test
	public void UniqueCharacters() {
		Assert.assertTrue(UniqueCharacterDetector.isUnique("ab"));
		Assert.assertFalse(UniqueCharacterDetector.isUnique("aa"));
		Assert.assertFalse(UniqueCharacterDetector.isUnique("az23 tyui567890,.=+xcvbnm."));
	}

	@Test
	public void IsPermutation() {
		Assert.assertTrue(PermutationDetector.isPermutation("abc", "cab"));
		Assert.assertFalse(PermutationDetector.isPermutation("abcde ", "dcabe1"));
		Assert.assertTrue(PermutationDetector.isPermutationB("abc", "cab"));
		Assert.assertFalse(PermutationDetector.isPermutationB("abcde ", "dcabe1"));
	}

	@Test
	public void URLify() {
		Assert.assertEquals(URLConverter.urlify(" My home page"), "My%20home%20page");
		Assert.assertNotEquals(URLConverter.urlify("My home page "), "%20My%20home%20page");
	}

	@Test
	public void OneAway() {
		Assert.assertTrue(OneAwayDetector.oneAwayA("pale", "able"));
		Assert.assertFalse(OneAwayDetector.oneAwayA("pale", "pad"));
		Assert.assertTrue(OneAwayDetector.oneAwayB("pale", "bale"));
		Assert.assertFalse(OneAwayDetector.oneAwayB("pale", "able"));
		Assert.assertTrue(OneAwayDetector.oneAwayB("pale", "pae"));
		Assert.assertTrue(OneAwayDetector.oneAwayA("pale", "paled"));
	}

	@Test
	public void Compress() {
		Assert.assertEquals(Compressor.compress(" aabcccddk"), "a2bc3d2k");
		Assert.assertEquals(Compressor.compress(" a"), "a");
		Assert.assertEquals(Compressor.compress(" "), "");
		Assert.assertEquals(Compressor.compressB("aabcccddk"), "a2bc3d2k");
		Assert.assertEquals(Compressor.compressB("a"), "a");
		Assert.assertEquals(Compressor.compressB(""), "");
	}
}
