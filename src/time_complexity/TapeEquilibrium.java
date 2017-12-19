package time_complexity;

public class TapeEquilibrium {
	
	public static void main(String[] args) {
		System.out.println(solution(new int[] {1000,-1000}));
	}
	
	public static int solution(int[] array) {
		
		// Calculating total sum; O(n).
		int totalSum = 0;
		for(int i = 0; i < array.length; i++) {
			totalSum += array[i];
		}
		
		// Initializing leftSum and rightSum.
		int leftSum = 0, rightSum = 0;
		// Set minDiff to the largest possible value: 1000 - (-1000).
		int minDiff = 2000;
		for(int i = 0; i < array.length-1; i++) {
			// Calculate leftSum by continuously adding.
			leftSum += array[i];
			// Calculate rightSum by taking the difference.
			rightSum = totalSum - leftSum;
			// If new difference is smaller, take that value as minDiff.
			if(minDiff > Math.abs(leftSum-rightSum)) {
				minDiff = Math.abs(leftSum-rightSum);
			}
		}
		return minDiff;
	}
}
