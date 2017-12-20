package prefix_sums;

public class GenomicRangeQuery {
	
	public static void main(String[] args) {
		int[] result = solution("CAGCCTA", new int[] {2,5,0}, new int[] {4,5,6});
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i]);
			
		}
	}
	
	public static int[] solution(String s, int[] p, int[] q) {
		// Create essentially 3 character arrays(A,C,G) of size = s.length+1.
		int[][] ACGT = new int[3][s.length()+1];
		char[] sArray = s.toCharArray();
		
		// For each character in the string, add 1 to the character array, at corresponding index.
		for (int i = 0; i < sArray.length; i++) {
			switch (sArray[i]) {
			case 'A':
				ACGT[0][i+1] = 1;
				break;
			case 'C':
				ACGT[1][i+1] = 1;
				break;
			case 'G':
				ACGT[2][i+1] = 1;
				break;
			default:
				break;
			}
			// Create prefix sum.
			for (int j = 0; j < 3; j++) {
				ACGT[j][i+1] += ACGT[j][i];
			}
		}
		

				
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < s.length()+1; j++) {		
				System.out.print(ACGT[i][j]);
			}
			System.out.println();
		}
		
		/* * * * * * * * * * * * * *
			Prefix Sums Table
			    
		index:  0 1 2 3 4 5 6 7  
			   ----------------- 		
		  A  	0 0 1 1 1 1 1 2  		*table starts padded with 0 to allow comparison
		  C 	0 1 1 1 2 3 3 3
		  G 	0 0 0 1 1 1 1 1  
	  
		 * * * * * * * * * * * * * */
	
		// Array for returning.
		int[] impact = new int[p.length];
		
		// Check if the prefix sum table's value increased for respective character. 
		for (int i = 0; i < p.length; i++) {
			// Starting from A.
			if(ACGT[0][q[i]+1] - ACGT[0][p[i]] > 0) {
				impact[i] = 1;
			} else if (ACGT[1][q[i]+1] - ACGT[1][p[i]] > 0) {
				impact[i] =  2;
			} else if (ACGT[2][q[i]+1] - ACGT[2][p[i]] > 0) {
				impact[i] =  3;
			} else {
				impact[i] =  4;
			}
		}
		return impact;
	}
}
