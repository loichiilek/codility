package stacksandqueues;

import java.util.Stack;

public class Fish {
	
	public static void main(String[] args) {
		System.out.println(solution(new int[] {4,3,2,1,5,6,10,8,9,7}, new int[] {1,0,1,0,1,0,1,0,1,0}));
	}
	
	
	public static int solution(int[] size, int[] direction) {
		
		// Initialize a stack of downstreamFishes.
		Stack<Integer> downstreamFish = new Stack<Integer>();
		// Counter to count fishes that will survive.
		int livingFish = 0;
		
		// Iterate through given array.
		for (int i = 0; i < direction.length; i++) {
			// If is an downstream fish, add the fish to the queue.
			if (direction[i] == 1) {
				System.out.println("add down");
				downstreamFish.push((Integer) size[i]);
			// Else if is a upstream fish and there are no downstream fish in the queue,
			} else {
				if (downstreamFish.isEmpty()) {	
					System.out.println("up survived +");
					// Add 1 to the counter of survived fishes.
					livingFish++;
				} else {
					// While there are downstream fishes, keeps on comparing.
					while (!downstreamFish.isEmpty()) {
						// If upstream fish is bigger size then downstream fish, remove the downstream fish.
						if (size[i] > downstreamFish.peek().intValue()) {
							System.out.println("down eaten");
							downstreamFish.pop();
						// Else upstream fish is removed, and breaks out of the while-loop
						} else {
							System.out.println("up eaten");
							break;
						}
					}
					if (downstreamFish.size() == 0) {
						System.out.println("up survived ++");
						livingFish++;
					}
				}
			}
		}
		System.out.println(livingFish);
		// Increase the number of livingFish by the number of upstream fishes left in the queue
		livingFish += downstreamFish.size();
		return livingFish;
	}
	

}
