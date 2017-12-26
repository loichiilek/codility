package sorting;


public class Triangle {
	
	public static void main(String[] args) {
		System.out.println(solution(new int[] {10, 2, 5, 1, 8, 20}));
	}
	
	public static int solution(int[] array) {
		// Start by sorting the given array. 
		// Because of the pre-defined maximum complexity, use sorting algorithm with O(n*log n).
		mergeSort(array);
		// I chose mergesort here. Quicksort will be fine too.
		for (int i = 2; i < array.length; i++) {
			// Originally i wrote (array[i] < array[i-1] + array[i-2]) as the condition.
			// This probably resulted in integer overflow when testing for the extreme cases.
			if(array[i] - (array[i-1] + array[i-2]) < 0) {
				// The idea here is that once sorted, the numbers will be placed together with their closest elements.
				// Also, triangular values can only be found in positive numbers.
				// Hence 3 consecutive elements will give the highest chance of finding triangular values.
				// Taking positive values X1, X2 & X3. 
				// Since X3 > X1    =>     X3 + X2 > X1
				// X3 > X2          =>     X3 + X1 > X2
				// Hence we only need to check if X1 + X2 > X3 and return 1 if true
				return 1;
			}
		}
		return 0;
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
