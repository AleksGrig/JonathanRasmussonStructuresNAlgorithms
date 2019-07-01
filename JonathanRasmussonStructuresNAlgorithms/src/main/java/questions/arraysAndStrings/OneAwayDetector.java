package questions.arraysAndStrings;

public class OneAwayDetector {

	// If we don't care about chars order
	public static boolean oneAwayA(String str1, String str2) {
		char[] char1 = str1.toCharArray();
		int[] str1Sym = new int[127];
		for (int i = 0; i < char1.length; i++) {
			str1Sym[char1[i]]++;
		}
		char[] char2 = str2.toCharArray();
		int[] str2Sym = new int[127];
		for (int i = 0; i < char2.length; i++) {
			str2Sym[char2[i]]++;
		}
		int dif = 0;
		for (int j = 0; j < str1Sym.length; j++) {
			if (str1Sym[j] != str2Sym[j]) {
				dif += (str1Sym[j] > str2Sym[j]) ? (str1Sym[j] - str2Sym[j]) : (str2Sym[j] - str1Sym[j]);
			}
		}
		if (dif < 2 || (dif == 2 && str1.length() == str2.length())) {
			return true;
		}
		return false;
	}

	// If chars should be in the same order
	public static boolean oneAwayB(String str1, String str2) {
		if (str1.length() == str2.length()) {
			if (oneReplace(str1, str2)) {
				return true;
			}
		} else if (str1.length() - str2.length() == 1) {
			if (oneInsertOrDelete(str1, str2)) {
				return true;
			}
		} else if (str2.length() - str1.length() == 1) {
			if (oneInsertOrDelete(str2, str1)) {
				return true;
			}
		}
		return false;
	}

	// Strings have equal length
	private static boolean oneReplace(String str1, String str2) {
		boolean dif = false;
		char[] char1 = str1.toCharArray();
		char[] char2 = str2.toCharArray();
		for(int i=0; i<str1.length(); i++) {
			if(char1[i] != char2[i]) {
				if(dif) {
					return false;
				} else {
					dif = true;
				}
			}
		}
		return true;
	}

	// First string 1 char longer than second one
	private static boolean oneInsertOrDelete(String str1, String str2) {
		boolean dif = false;
		char[] char1 = str1.toCharArray();
		char[] char2 = str2.toCharArray();
		int i = 0;
		int j = 0;
		while (i < char1.length) {
			if (char1[i] != char2[j]) {
				if (dif) {
					return false;
				} else {
					dif = true;
					i++;
					continue;
				}
			}
			i++;
			j++;
		}
		return true;
	}
}
