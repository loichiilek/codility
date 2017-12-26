package sorting;

public class MaxProductOfThree {
	

	public static int solution(int[] array) {
		// Sort the array using sorting with complexity not larger than O(n*log n)
		mergeSort(array);
		// Max negative is for the product of two largest negative numbers and the largest positive number.
		int maxNeg = array[0] * array[1] * array[array.length - 1];
		// Max positive is for the product of 3 largest positive numbers.
		int maxPos = array[array.length - 1] * array[array.length - 2] * array[array.length - 3];
		// Return larger number of the two.
		return (maxPos > maxNeg) ? maxPos : maxNeg;
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
