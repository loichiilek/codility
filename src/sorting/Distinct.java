package sorting;

public class Distinct {
	
	

	public static int solution(int[] array) {
		// Sort the array using sorting with complexity not larger than O(n*log n)
		mergeSort(array);
		// Check if it is a 0 sized array.
		if (array.length == 0) {
			return 0;
		}
		// Set the number of distinct values to 1 if array's size is not 0.
		int numDistinct = 1;
		for (int i = 1; i < array.length; i++) {
			// If number changes, distinct++.
			if (array[i] != array[i-1]) {
				numDistinct++;
			}
		}
		return numDistinct;
		
	}
	
	// Typical mergesort using auxiliary array.
	private static void mergeSort(int[] array) {
		int start = 0;
		int end = array.length - 1;
		if (end > start) {
			mergeSort(array, new int[array.length], start, end);
		}
	}
	
	private static void mergeSort(int[] array, int[] auxArray, int start, int end) {
		if (end > start) {
			int mid = start + (end - start)/2;
			mergeSort(array, auxArray, start, mid);
			mergeSort(array, auxArray, mid+1, end);
			merge(array, auxArray, start, mid, end);
		}
	}

	private static void merge(int[] array, int[] auxArray, int start, int mid, int end) {
		int leftIndex = start;
		int rightIndex = mid+1;
		int auxIndex = start;
		
		while (leftIndex <= mid && rightIndex <= end) {
			if (array[leftIndex] <= array[rightIndex]) {
				auxArray[auxIndex] = array[leftIndex];
				auxIndex++;
				leftIndex++;
			} else {
				auxArray[auxIndex] = array[rightIndex];
				auxIndex++;
				rightIndex++;
			}
		}
		
		if (leftIndex > mid) {
			while (rightIndex <= end) {
				auxArray[auxIndex] = array[rightIndex];
				auxIndex++;
				rightIndex++;
			}
		} else {
			while (leftIndex <= mid) {
				auxArray[auxIndex] = array[leftIndex];
				auxIndex++;
				leftIndex++;
			}
		}
		
		System.arraycopy(auxArray, start, array, start, end-start+1);
	}
}
