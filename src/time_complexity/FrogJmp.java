package time_complexity;

public class FrogJmp {
	
	public static void main(String[] args) {
		System.out.println(solution(10,85,30));
	}
	
	
	
	public static int solution(int x, int y, int d) {
		
		int distance = y-x;
		// If distance travelled is not a multiple of d, add additional jump to cover the distance.
		if(distance%d != 0)
			return (distance)/d + 1;
		else
			return (distance)/d;
	}
}
