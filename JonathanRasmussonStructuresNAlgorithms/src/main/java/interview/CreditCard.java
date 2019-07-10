package interview;

import java.util.ArrayList;
import java.util.Arrays;

public class CreditCard {

	private String name;
	private ArrayList<String> prefixes;
	private ArrayList<Integer> lengths;

	public CreditCard(String name, String[] prefixes, Integer[] lengths) {
		this.name = name;
		this.prefixes = new ArrayList<>(Arrays.asList(prefixes));
		this.lengths = new ArrayList<>(Arrays.asList(lengths));
	}

	public boolean mathes(String cardNumber) {
		if (lengths.contains(cardNumber.length())) {
			for (String prefix : prefixes) {
				if (cardNumber.startsWith(prefix)) {
					return true;
				}
			}
		}
		return false;
	}

	public String name() {
		return name;
	}
}
