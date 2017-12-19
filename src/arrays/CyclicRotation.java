package arrays;

public class CyclicRotation {

	public static void main(String[] args) {
		int[] ans = solution(new int[] {}, 3);
		for(int i = 0; i< ans.length; i++) {
			System.out.print(ans[i] + " ");
		}
	}
	
	public static int[] solution(int[] a, int k) {
		if(a.length == 0) {
			return a;
		}
		// Iteration of k times, using for-loop
		for(int i = 0; i < k; i++) {
			// Initialize integer temp with the value of last element in the array
			int temp = a[a.length-1];
			for(int j = a.length-1; j > 0; j--) {
				// Starting from the end, for each element in the array, set it to equal the element before it.
				// Stops at the 2nd element in the array.
				a[j] = a[j-1];
			}
			// Set the first element, to be equal to temp, which is the original value of the last element.
			a[0] = temp;  
		}
		return a;
	}
}
