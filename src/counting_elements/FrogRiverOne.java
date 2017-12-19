package counting_elements;

public class FrogRiverOne {
	
	public static void main(String[] args) {
		System.out.println(solution(5, new int[] {1,3,1,4,2,3,5,4}));
	}

	public static int solution (int x, int[] array) {
		// Create an array of leaves needed to cross river.
		boolean[] hasLeaves = new boolean[x];
		// Iterate through the array of falling leaves.
		for(int i = 0; i < array.length; i++) {
			// If particular location doesn't have leaf yet, set it to has a leaf and reduces leaves needed by one.
			if(!hasLeaves[array[i]-1]) {
				hasLeaves[array[i]-1] = true;
				x -= 1;
				// If leaves needed reaches 0, return the i.
				if(x == 0)
					return i;
			}
		}
		return -1;
	}
}
