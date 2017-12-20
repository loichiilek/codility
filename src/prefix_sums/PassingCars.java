package prefix_sums;

public class PassingCars {
	
	public static void main(String[] args) {
		System.out.println(solution(new int[] {1,0,1,1,1,0,1,0,1}));
	}

	public static int solution(int[] array) {
		// Number of east-bound cars in the array. Starts at 0.
		int eastBound = 0;
		// Number of pairs of cars that passed each other.
		int passingCars = 0;
		for (int i = 0; i < array.length; i++) {
			// If identified a zero, increase east-bound cars by 1.
			if(array[i] == 0) {
				eastBound++;
			// Else, add east-bound number of cars for each west-bound car ('1').
			} else {
				passingCars += eastBound;
			}
			// Over the limit, returns -1.
			if(passingCars > 1000000000) {
				return -1;
			}
		}
		return passingCars;
	}
}
