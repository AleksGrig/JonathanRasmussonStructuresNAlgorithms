package algorithms;

public class Fibonacci {

	private static int[] memo = new int[1001];

	public static int fibonacciNaive(int n) {
		if (n <= 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			return fibonacciNaive(n - 1) + fibonacciNaive(n - 2);
		}
	}

	public static int fibonacciMemoized(int n) {
		if (n <= 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else if (memo[n] == 0) {
			memo[n] = fibonacciNaive(n - 1) + fibonacciNaive(n - 2);
		}
		return memo[n];
	}
}
