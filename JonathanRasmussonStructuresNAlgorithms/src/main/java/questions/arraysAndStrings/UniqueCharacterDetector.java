package questions.arraysAndStrings;

public class UniqueCharacterDetector {

	public static boolean isUnique(String str) {
		char[] string = str.toCharArray();
		boolean[] symbols = new boolean[127];
		for (int i = 0; i < string.length; i++) {
			if (symbols[string[i]]) {
				return false;
			} else {
				symbols[string[i]] = true;
			}
		}
		return true;
	}

	public static boolean isUniqueB(String str) {
		boolean[] symbols = new boolean[127];
		for (int i = 0; i < str.length(); i++) {
			if (symbols[str.charAt(i)]) {
				return false;
			} else {
				symbols[str.charAt(i)] = true;
			}
		}
		return true;
	}
}
