package arrays;

public class OddOccurrencesInArray {
	
	
	public static void main(String[] args) {
		System.out.println(solution(new int[] { 9, 3, 9, 9, 7, 3, 9 }));
	}
	
    public static int solution(int[] A) {
        // write your code in Java SE 8
		int elem = 0;

		for (int i = 0; i < A.length; i++) {
			elem ^= A[i];
			// XOR of same number returns 0
			System.out.println(Integer.toBinaryString(elem));
		}
		return elem;
    }
}
