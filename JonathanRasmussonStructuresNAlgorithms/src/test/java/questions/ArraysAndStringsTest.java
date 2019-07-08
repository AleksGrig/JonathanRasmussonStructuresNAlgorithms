package questions;

import org.testng.Assert;
import org.testng.annotations.Test;

import questions.arraysAndStrings.CaesarCipher;
import questions.arraysAndStrings.Compressor;
import questions.arraysAndStrings.FizzBuzz;
import questions.arraysAndStrings.OneAwayDetector;
import questions.arraysAndStrings.Palindromes;
import questions.arraysAndStrings.PermutationDetector;
import questions.arraysAndStrings.RansomNote;
import questions.arraysAndStrings.Reverse;
import questions.arraysAndStrings.SieveOfEratosthenes;
import questions.arraysAndStrings.URLConverter;
import questions.arraysAndStrings.UniqueCharacterDetector;

public class ArraysAndStringsTest {

	@Test
	public void UniqueCharacters() {
		Assert.assertTrue(UniqueCharacterDetector.isUnique("ab"));
		Assert.assertFalse(UniqueCharacterDetector.isUnique("aa"));
		Assert.assertFalse(UniqueCharacterDetector.isUnique("az23 tyui567890,.=+xcvbnm."));
		Assert.assertTrue(UniqueCharacterDetector.isUniqueB("ab"));
		Assert.assertFalse(UniqueCharacterDetector.isUniqueB("aa"));
		Assert.assertFalse(UniqueCharacterDetector.isUniqueB("az23 tyui567890,.=+xcvbnm."));
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

	@Test
	public void Palindromes() {
		Assert.assertTrue(Palindromes.isPalindrome("abba"));
		Assert.assertTrue(Palindromes.isPalindrome("dad"));
		Assert.assertFalse(Palindromes.isPalindrome("false"));
	}

	@Test
	public void FizzBuzz() {
		FizzBuzz.fizzBuzz();
	}

	@Test
	public void RansomNote() {
		Assert.assertTrue(RansomNote.canWrite("Pay", "yaP"));
		Assert.assertTrue(RansomNote.canWrite("Pay me money", "ymaPmeynoe"));
		Assert.assertFalse(RansomNote.canWrite("I want 100000", "twI1000"));
	}

	@Test
	public void CaesarCipher() {
		Assert.assertEquals(CaesarCipher.encrypt("A BC", -3), "X YZ");
		Assert.assertEquals(CaesarCipher.encrypt("XYZ", 3), "ABC");

		Assert.assertEquals(CaesarCipher.decrypt("XYZ", -3), "ABC");
		Assert.assertEquals(CaesarCipher.decrypt("A BC", 3), "X YZ");
	}

	@Test
	public void SieveOfEratosthenes() {
		boolean[] res = SieveOfEratosthenes.findPrimes(100);
		for (int i = 0; i < res.length; i++) {
			if (!res[i]) {
				System.out.println(i);
			}
		}
	}

	@Test
	public void Reverse() {
		Assert.assertEquals(Reverse.reverse("Hello!"), "!olleH");
	}
}
