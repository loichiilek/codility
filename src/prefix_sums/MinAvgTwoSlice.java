package prefix_sums;

public class MinAvgTwoSlice {

	
	public static void main(String[] args) {
		System.out.println(solution(new int[] {4,2,2,5,1,5,8}));
	}
	
	public static int solution(int[] array) {
		
		// Set minAvg as a huge integer that will not be exceeded.
		double minAvg = 100000;
		// Initialize the index to return. Starting value does not matter, as the first iteration will override it.
		int index = 0;
		
		// Iterate through given array to find the smallest avg.
		for (int i = 0; i < array.length -2; i++) {
			System.out.println(array[i] + " " + array[i+1]);
			// Smallest average from sum of 2 elements
			if(((double) array[i] + array[i+1])/2 < minAvg) {
				minAvg = (double) (array[i] + array[i+1])/2;
				index = i;
			}
			System.out.println(minAvg);
			// Smallest average from sum of 3 elements
			if(((double) array[i] + array[i+1] + array[i+2])/3 < minAvg) {
				minAvg = (double) (array[i] + array[i+1] + array[i+2])/3;
				index = i;
			}
			System.out.println(minAvg);
		}
		
		// Checks last 2 elements here instead of the within the for-loop. To prevent null pointer exception.
		if((array[array.length-2] + array[array.length-1])/2 < minAvg) {
			minAvg = (array[array.length-2] + array[array.length-1])/2;
			index = array.length-2;
		}
		
		return index;

	}
}
