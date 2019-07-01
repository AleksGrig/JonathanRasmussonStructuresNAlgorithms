package questions.arraysAndStrings;

public class URLConverter {

	public static String urlify(String str) {
		String trimString = str.trim();
		char[] string = trimString.toCharArray();
		String res = "";
		for (int i = 0; i < string.length; i++) {
			if (string[i] == 32) {
				res += "%20";
			} else {
				res += string[i];
			}
		}
		return res;
	}
}
