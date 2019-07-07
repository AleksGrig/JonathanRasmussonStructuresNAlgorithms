package questions.arraysAndStrings;

public class CaesarCipher {

	// Use only capital letters
	public static String encrypt(String str, int code) {
		StringBuilder encrypted = new StringBuilder();
		code %= 26; // code should be less then number of letters in alphabet
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch >= 65 && ch <= 90) {
				ch += code;
				if (ch < 65) {
					ch = (char) (90 - (65 - ch - 1));
				} else if (ch > 90) {
					ch = (char) (65 + (ch - 90 - 1));
				}
			}
			encrypted.append(ch);
		}
		return encrypted.toString();
	}

	public static String decrypt(String str, int code) {
		StringBuilder decrypted = new StringBuilder();
		code %= 26;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch >= 65 && ch <= 90) {
				ch -= code;
				if (ch < 65) {
					ch = (char) (90 - (65 - ch - 1));
				} else if (ch > 90) {
					ch = (char) (65 + (ch - 90 - 1));
				}
			}
			decrypted.append(ch);
		}
		return decrypted.toString();
	}
}
