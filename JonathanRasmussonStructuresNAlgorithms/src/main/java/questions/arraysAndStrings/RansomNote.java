package questions.arraysAndStrings;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {

	// Method determines whether String note can be build from letters in String
	// letters
	public static boolean canWrite(String note, String letters) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int i = 0;
		int match = 0;
		while (i < note.length() || i < letters.length()) {
			if (i < note.length() && note.charAt(i) != ' ') {
				if (!map.containsKey(note.charAt(i))) {
					map.put(note.charAt(i), -1);
					match--;
				} else {
					int amount = map.get(note.charAt(i));
					map.put(note.charAt(i), --amount);
					if (amount < 0) {
						match--;
					}
				}
			}
			if (i < letters.length() && letters.charAt(i) != ' ') {
				if (!map.containsKey(letters.charAt(i))) {
					map.put(letters.charAt(i), 1);
				} else {
					int amount = map.get(letters.charAt(i));
					if (amount < 0) {
						match++;
					}
					map.put(letters.charAt(i), ++amount);
				}
			}
			i++;
		}
		if (match < 0) {
			return false;
		} else {
			return true;
		}
	}
}
