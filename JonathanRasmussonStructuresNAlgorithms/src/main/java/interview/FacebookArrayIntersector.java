package interview;

import java.util.ArrayList;
import java.util.Arrays;

public class FacebookArrayIntersector {

	public static ArrayList<Integer> intersect(int[] array1, int[] array2) {
		Arrays.parallelSort(array1);
		Arrays.parallelSort(array2);
		return sortedIntersect(array1, array2);
	}

	private static ArrayList<Integer> sortedIntersect(int[] array1, int[] array2) {
		ArrayList<Integer> collector = new ArrayList<>();
		int i = 0;
		int j = 0;

		while (i < array1.length && j < array2.length) {
			if (array1[i] < array2[j]) {
				i++;
			} else if (array2[j] < array1[i]) {
				j++;
			} else {
				collector.add(array1[i++]);
				j++;
			}
		}
		return collector;
	}
}
