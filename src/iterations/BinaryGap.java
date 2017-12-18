package iterations;

public class BinaryGap {
	public static int solution(int n) {
		char[] binaryString = Integer.toBinaryString(n).toCharArray();
		int count = 0;
		int currentCount = 0;
		for(int i = 0; i<binaryString.length; i++) {
			if(binaryString[i] == '0') {
				currentCount++;

			} else if(binaryString[i] == '1'){
				if(currentCount > count)
					count = currentCount;
				currentCount = 0;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(solution(1041));
	}
}
