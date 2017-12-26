package sorting;

import java.util.Arrays;

public class NumberOfDiscIntersections {
	
	public static void main(String[] args) {
		System.out.println(solution(new int[] {0, 0, 0}));
	}
	
	/*
	 * WARNING! THIS IS THE WORST QUESTION I'VE DONE SO FAR.
	 * AND LEARNT SO LITTLE.
	 * MOST ERRORS, IF NOT ALL, CAME FROM SOME FORM OF INTEGER OVERFLOW.
	 */
	
	
	public static int solution(int[] array) {
		// Initializing number of intersection.
		long intersection = 0;
		
		// Initialized 2 arrays to hold the leftmost and rightmost circumference of the circles.
		long[] leftmostIndex = new long[array.length];
		long[] rightmostIndex = new long[array.length];
		
		// Set the values using and iterative for-loop
		for (int i = 0; i < array.length; i++) {
			leftmostIndex[i] = i - (long) array[i];
			rightmostIndex[i] = i + (long) array[i];
		}
		
		// Generic sort with O(n*log n)
		Arrays.sort(leftmostIndex);
		Arrays.sort(rightmostIndex);

		
		// Check how many leftmostIndexes intersect with rightmostIndexes.
		for (int i = 0; i < rightmostIndex.length; i++) {
			int pos = binarySearch(leftmostIndex, 0, leftmostIndex.length - 1, rightmostIndex[i]);
			// In the case, rightmostIndex[i] > then all values of leftmostIndex[]. Increment the position by 1. 
			if (rightmostIndex[i] >= leftmostIndex[pos]) {
				pos++;
			}
			// In the case, of repeating rightmostIndex[i], increment by 1 for each occurrence.
	        while(pos < array.length && leftmostIndex[pos] == rightmostIndex[i]){
	            pos++;
	          }
			intersection += pos;	
		}
		// To subtract away repeating intersection. E.g. A intersect B & B intersect A.
		intersection = intersection - (long) array.length * (array.length + 1) / 2;
		// Remember to cast it into type long.
		// Check if intersection is greater than 10 000 000
		if (intersection > 10000000) {
			return -1;
		} else {
			// Type casting back to integer
			return (int) intersection;
		}
	}
	
	
	// Binary search returning the position of the searched value
	private static int binarySearch(long[] leftmostIndex, int start, int end, long val) {
		int mid = start + (end - start)/2;
		
		if (leftmostIndex[mid] == val) {
			return mid;
		}
		
		if(start == end) {
			return start;
		}
		
		if (val < leftmostIndex[mid]) {
			return binarySearch(leftmostIndex, start, mid, val);
		} else {
			return binarySearch(leftmostIndex, mid+1, end, val);
		} 
	}

}
