package counting_elements;

public class MissingInteger {
	
	public static void main(String[] args) {
		System.out.println(solution(new int[] {1}));
	}
	
	public static int solution(int[] array) {
		// Create a boolean array of equal length.
		boolean[] check = new boolean[array.length];
		
		// Iterate through array, and set corresponding element in check to be true.
		for(int i = 0; i < array.length; i++) {
			if(array[i] > 0 && array[i] <= array.length)
				check[array[i]-1] = true;
		}
		
		// Iterate through check if any element == false, returns i+1.
		for (int i = 0; i < check.length; i++) {
			if(!check[i])
				return i+1;
		}
		
		// Iterated through, hence smallest missing integer is the length + 1.
		return check.length+1;
	}
}
