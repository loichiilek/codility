package prefix_sums;

public class CountDiv {

	public static void main(String[] args) {
		System.out.println(solution(11,345,17));
	}
	
	
	public static int solution(int a, int b, int k) {
		// Check if a is divisible by k (without any remainder).
		// If divisible, add 1. Else, add 0.
		int divA = (a % k == 0) ? 1 : 0;
		// Find how many numbers are divisible by k from the range of a to b.
		int divAB = b/k - a/k;
		// If a is divisible with any remainder, add 1.
		return divA + divAB;
	}
}
