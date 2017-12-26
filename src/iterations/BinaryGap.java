package iterations;

public class BinaryGap {
	
	public static int solution(int n) {
		// Format the integer into a binary string, then into a character array.
		char[] binaryString = Integer.toBinaryString(n).toCharArray();
		// Initializing count.
		int count = 0;
		int currentCount = 0;
		// Traverse the array, find the largest length of zeroes.
		for(int i = 0; i<binaryString.length; i++) {
			// If zero, increase current count by 1;
			if(binaryString[i] == '0') {
				currentCount++;
			// If equals to one, checks if currentCount is larger than count. Replace if true.
			} else if(binaryString[i] == '1'){
				if(currentCount > count)
					count = currentCount;
				currentCount = 0;
			}
		}
		return count;
	}
	
	// For Jef my friend, who sucks dick.
	public static void main(String[] args) {
		System.out.println(solution(1041));
	}
}
