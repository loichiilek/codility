package counting_elements;

public class MaxCounters {
	
	public static void main(String[] args) {
		int[] counter = solution(5, new int[] {3,4,4,6,1,4,4});
		for (int i = 0; i < counter.length; i++) {
			System.out.print(counter[i]);
		}
	}

	public static int[] solution(int n, int[] array) {
		// Max value in the counter array.
		int maxVal = 0;
		// Minimum value of the counter array after a max() is called on the array.
		int maxUpdate = 0;
		// Create new integer array of size n.
		int[] counter = new int[n];
		
		// Iterate through given array.
		for (int i = 0; i < array.length; i++) {
			// Calls a pseudo-max() by updating maxUpdate
			if(array[i] == n+1) {
				maxUpdate = maxVal;
			} else {
				// If counter_value +1 is greater maxUpdate value, take counter_value +1, if not take maxUpdate+1.
				counter[array[i]-1] = (counter[array[i]-1]+1 > maxUpdate) ? counter[array[i]-1]+1 : maxUpdate+1;
				// Update maxVal accordingly if a counter_value becomes greater than it.
				maxVal = (maxVal < counter[array[i]-1]) ? counter[array[i]-1] : maxVal;
			}
		}
		// The idea behind this problem is to NOT call max() every time array[i] = n+1.
		// Instead, stores the value as maxUpdate, and check at the end that the value of each element in 
		// counter >= maxUpdate.
		for (int i = 0; i < counter.length; i++) {
			counter[i] = (counter[i] > maxUpdate) ? counter[i] : maxUpdate;
		}
		// This method will return a complexity of O(n+m) 
		// instead of O(n*m) when max() is called every single array[i] = n+1.
		return counter;
	}
	
}
