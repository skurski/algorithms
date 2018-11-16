package algorithms.interview.bud;

import java.util.*;

public class UnnecessaryWork {

	/**
	 * Print all positive integer solutions to the equation a^3 + b^3 = c^3 + d^3,
	 * where a,b,c and d are integers between 1 and 1000
	 *
	 * Brute force solution - 4 nested loops - O(N4)
	 *
	 * Unnecessary work -> iterate all d posibilities, we can compute it
	 * d = pow(a^3 + b^3 - c^3, 1/3)
	 * Optimize to O(N3)
	 */
	public static void printEquationSolution() {
		int n = 1000;
		for (int a=0; a<n; a++) {
			for (int b=0; b<n; b++) {
				for (int c=0; c<n; c++) {
					//int d = pow(a^3 + b^3 - c^3, 1/3);
					//if (a^3 + b^3 = c^3 + d^3) System.out.println("Solution...");
				}
			}
		}
	}
	
	/**
	 * We can still optimize algorithm seeing duplicate work -> for every a and b pair
	 * we are searching for c and d pair, we can first compute c and d and put in hash table
	 * Then iterate over a and b and check computed c and d in hash table
	 * Complexity decrease to O(N2)
	 */

	public static void main(String[] args) {

	}
}
