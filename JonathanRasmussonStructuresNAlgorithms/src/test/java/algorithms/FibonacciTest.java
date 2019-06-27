package algorithms;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FibonacciTest {

	@Test
	public void FibonacciNaive() {
		Assert.assertEquals(Fibonacci.fibonacciNaive(-1), 0);
		Assert.assertEquals(Fibonacci.fibonacciNaive(0), 0);
		Assert.assertEquals(Fibonacci.fibonacciNaive(1), 1);
		Assert.assertEquals(Fibonacci.fibonacciNaive(2), 1);
		Assert.assertEquals(Fibonacci.fibonacciNaive(3), 2);
		Assert.assertEquals(Fibonacci.fibonacciNaive(4), 3);
		Assert.assertEquals(Fibonacci.fibonacciNaive(10), 55);
		Assert.assertEquals(Fibonacci.fibonacciNaive(13), 233);
	}

	@Test
	public void FibonacciMemoized() {
		Assert.assertEquals(Fibonacci.fibonacciMemoized(-1), 0);
		Assert.assertEquals(Fibonacci.fibonacciMemoized(0), 0);
		Assert.assertEquals(Fibonacci.fibonacciMemoized(1), 1);
		Assert.assertEquals(Fibonacci.fibonacciMemoized(2), 1);
		Assert.assertEquals(Fibonacci.fibonacciMemoized(3), 2);
		Assert.assertEquals(Fibonacci.fibonacciMemoized(4), 3);
		Assert.assertEquals(Fibonacci.fibonacciMemoized(10), 55);
		Assert.assertEquals(Fibonacci.fibonacciMemoized(13), 233);
	}

	@Test
	public void RecordTimeNaive() {
		long startTime = System.currentTimeMillis();
		Fibonacci.fibonacciNaive(47);
		long endTime = System.currentTimeMillis();
		long elapsedTime = (endTime - startTime) / 1000;
		System.out.println("Naive elapsedTime = " + elapsedTime);
	}

	@Test
	public void RecordTimeMemoized() {
		long startTime = System.currentTimeMillis();
		Fibonacci.fibonacciMemoized(47);
		long endTime = System.currentTimeMillis();
		long elapsedTime = (endTime - startTime) / 1000;
		System.out.println("Memoized elapsedTime = " + elapsedTime);
	}

}
