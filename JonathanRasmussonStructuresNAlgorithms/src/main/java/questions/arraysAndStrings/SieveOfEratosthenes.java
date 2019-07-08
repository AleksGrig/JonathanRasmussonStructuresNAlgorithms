package questions.arraysAndStrings;

public class SieveOfEratosthenes {

	public static boolean[] findPrimes(int n) {
		if (n < 2) {
			n = 2;
		}
		boolean[] res = new boolean[n + 1];
		res[0] = true;

		for (int i = 2; i < Math.sqrt(n); i++) {// We don't have to loop through all n, sqrt(n) is enough!
			for (int j = i; j <= n; j++) {
				if (j % i == 0 && j != i) {
					res[j] = true;
				}
			}
		}
		return res;
	}
}
