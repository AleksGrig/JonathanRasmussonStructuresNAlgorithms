package questions.arraysAndStrings;

import java.util.Arrays;

public class PermutationDetector {

	public static boolean isPermutation(String str, String strToCompare) {
		if(str.length() == strToCompare.length()) {
			char[] string = str.toCharArray();
			int[] stringSymbols = new int[127];
			for (int i = 0; i < str.length(); i++) {
				stringSymbols[string[i]] += 1;
			}
			char[] stringToCompare = strToCompare.toCharArray();
			int[] stringToCompareSymbols = new int[127];
			for (int i = 0; i < stringToCompare.length; i++) {
				stringToCompareSymbols[stringToCompare[i]] += 1;
			}
			for (int i = 0; i < stringSymbols.length; i++) {
				if (stringSymbols[i] != stringToCompareSymbols[i]) {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
	}

	public static boolean isPermutationB(String str, String strToCompare) {
		if (str.length() != strToCompare.length()) {
			return false;
		}
		return sort(str).equals(sort(strToCompare));

	}

	private static String sort(String str) {
		char[] string = str.toCharArray();
		Arrays.sort(string);
		return new String(string);
	}
}
