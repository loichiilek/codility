package time_complexity;

public class PermMissingElem {
	
	public static void main(String[] args) {
		System.out.println(solution(new int[] {1,2,4,5,6,3,8}));
	}
	
	
	// Solution returns poor performance as it computes the maxValue which can result in integer overflow.
	public static int sadSolution(int[] array) {
		int totalSum = 0;
		for(int i = 0; i < array.length; i++) {
			totalSum += array[i];
		}
		int maxValue = (1+array.length+1)*(array.length+1)/2;
		return  maxValue - totalSum;
	}
	
	
	
	public static int solution(int[] array) {
		int value = 0;
		
		// Calculate the summation of the difference.
		for(int i = 0; i < array.length; i++) {
			value += (i+1-array[i]);
		}
		
		// Return value + N+1
		return value + array.length+1;
	}
}
