package algorithms;

public class Sort {

	public static void bubbleSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - 1 - i; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
	}

	public static void selectionSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			int min = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] <= array[min]) {
					min = j;
				}
			}
			int temp = array[i];
			array[i] = array[min];
			array[min] = temp;
		}
	}

	public static void insertionSort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int j = i - 1;
			int k = i;
			while (j >= 0 && array[k] < array[j]) {
				int temp = array[j];
				array[j--] = array[k];
				array[k--] = temp;
			}
		}
	}

	public static void mergeSort(int[] array, int p, int r) {
		if (p < r) {
			int q = (r + p) / 2;
			mergeSort(array, p, q);
			mergeSort(array, q + 1, r);
			mergeArrays(array, p, q, r);
		}
	}

	private static void mergeArrays(int[] array, int p, int q, int r) {
		int[] temp = new int[r - p + 1];
		int i = p;
		int j = q + 1;
		int k = 0;
		while (i <= q && j <= r) {
			if (array[i] < array[j]) {
				temp[k++] = array[i++];
			} else {
				temp[k++] = array[j++];
			}
		}

		while (j <= r) {
			temp[k++] = array[j++];
		}
		while (i <= q) {
			temp[k++] = array[i++];
		}

		for (int l = 0; l < temp.length; l++) {
			array[p + l] = temp[l];
		}
	}

	public static void quickSort(int[] array, int p, int r) {
		if (p < r) {
			int q = partition(array, p, r);
			quickSort(array, p, q - 1);
			quickSort(array, q + 1, r);
		}
	}

	private static int partition(int[] array, int p, int r) {
		int i = p - 1;
		int j = p;
		while (j < r) {
			if (array[j] <= array[r]) {
				int temp = array[++i];
				array[i] = array[j];
				array[j] = temp;
			}
			j++;
		}
		int temp = array[++i];
		array[i] = array[j];
		array[j] = temp;
		return i;
	}
}
