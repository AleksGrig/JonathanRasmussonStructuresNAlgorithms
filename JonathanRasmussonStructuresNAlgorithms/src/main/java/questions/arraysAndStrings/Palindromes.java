package questions.arraysAndStrings;

public class Palindromes {

	// We don't need to loop through whole word because if it's palindrome first
	// half ot the word should match second one
	public static boolean isPalindrome(String str) {
		for (int i = 0; i < str.length() / 2; i++) {
			if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}
}
