package counting_elements;

public class PermCheck {
	
	public static void main(String[] args) {
		System.out.println(solution(new int[] {2 ,5, 3, 4}));
	}
	
	public static int solution(int[] array) {
		// Create an array of the same size.
		int[] copy = new int[array.length];
		
		// Iterate through original array.
		for(int i = 0; i < array.length; i++) {
			// If array value is larger than the length, returns 0. It cannot be a permutation.
			if(array[i] > array.length) {
				return 0;
			// Places array value in copy array if yet to be placed.
			}else if(copy[array[i]-1] == 0)
				copy[array[i]-1] = array[i];
			// Else (spot has already been taken), indicating a repetition of value.
			else
				return 0;
		}
		return 1;
	}
}
