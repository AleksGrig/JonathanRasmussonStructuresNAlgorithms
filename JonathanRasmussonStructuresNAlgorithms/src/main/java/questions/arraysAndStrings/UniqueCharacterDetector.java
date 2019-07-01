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
}
