package questions.arraysAndStrings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Anagram {

	public static boolean isAnagram(String str1, String str2) {
		if (str1.length() == str2.length() && str1 != null && str2 != null) {
			Map<Character, Integer> matcher = new HashMap<Character, Integer>();
			int match = 0;
			for (int i = 0; i < str1.length(); i++) {
				if (!matcher.containsKey(str1.charAt(i))) {
					matcher.put(str1.charAt(i), -1);
					match--;
				} else {
					int count = matcher.get(str1.charAt(i));
					matcher.put(str1.charAt(i), --count);
					if (count < 0) {
						match--;
					}
				}
				if (!matcher.containsKey(str2.charAt(i))) {
					matcher.put(str2.charAt(i), 1);
				} else {
					int count = matcher.get(str2.charAt(i));
					matcher.put(str2.charAt(i), ++count);
					if (count <= 0) {
						match++;
					}
				}
			}
			if (match == 0) {
				return true;
			}
		}
		return false;
	}

	public static boolean isAnagramB(String str1, String str2) {
		return sort(str1).equals(sort(str2)) ? true : false;
	}

	private static String sort(String str) {
		char[] charArray = str.toCharArray();
		Arrays.parallelSort(charArray);
		return new String(charArray);
	}
}
