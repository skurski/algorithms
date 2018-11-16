package algorithms.interview.bud;

import java.util.*;

public class DIYApproach {

	/**
	 * Given a smaller string S and a bigger B, design an algorithm to find
	 * all permutations of the shorter string within the longer one. Print
	 * the location of each permutation.
	 *
	 * Brute force solution: Find all permutation of S and then check if exists in B
	 * Complexity -> O(S! * B)
	 *
	 * Try to solve problem on piece of paper, checking how your mind resolve the issue
	 * s: abbc
	 * b: cbabadcbbabbcbabaabccbabc
	 *
	 * 1) Walk through B and check if there is a character in S, if yes then check
	 * 	  if 4 next chars (the length of S) are a permutation of S
	 *
	 * Perform reverse engineering -> think how your mind resolved it and try to design algorithm
	 * Solution: put chars from S to set, iterate B and check if char exists in set,
	 * if exists check if all 4 are the same as in set
	 *
	 * TODO: implement
	 */
	public static void subStringPerm(String s, String b) {

	}

	public static void main(String[] args) {

	}
}
