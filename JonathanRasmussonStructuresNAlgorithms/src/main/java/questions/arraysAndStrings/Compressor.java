package questions.arraysAndStrings;

public class Compressor {

	public static String compress(String str) {
		if (str.trim().length() > 1) {
			char[] charArray = str.trim().toCharArray();
			str = "";
			int count = 0;
			for (int i = 1; i < charArray.length; i++) {
				Character previous = charArray[i - 1];
				if (charArray[i] == previous) {
					count++;
				} else {
					str += previous.toString();
					if (count > 0) {
						str = str + (count + 1);
						count = 0;
					}
				}
				if (i == charArray.length - 1) {
					str += charArray[i];
					if (count > 0) {
						str = str + (count + 1);
					}
				}
			}
		}
		return str.trim();
	}

	public static String compressB(String str) {
		StringBuilder compressed = new StringBuilder();
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			count++;
			if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
				compressed.append(str.charAt(i));
				if (count > 1) {
					compressed.append(count);
				}
				count = 0;
			}
		}
		return compressed.toString();
	}
}
