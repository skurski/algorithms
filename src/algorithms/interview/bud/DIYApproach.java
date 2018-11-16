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
	 *
	 * Solution: Iterate over B, create helper map with string S characters
	 * 			 Check if B char exists in helper map, if yes create substring from B with length of S
	 * 			 Check if letters from B substring exists in map -> remove after check to resolve problem with duplicates
	 * Complexity: O(B * S)
	 *
	 * TODO: Optimal solution has O(N) 
	 */
	public static Set<String> subStringPerm(String s, String b) {
		Set<String> permutations = new HashSet<>();
		int length = b.length() - s.length();
		
		for (int i = 0; i < length; i++) {
			Map<Integer, Integer> subMap = new HashMap<>();
			boolean wrong = false;
			
			for (int value: s.toCharArray()) {
				Integer count = subMap.get(value);
				count = (count == null) ? 1 : ++count;
				subMap.put(value, count);
			}
			
			Integer bCharAt = (int) b.charAt(i);
			if (subMap.get(bCharAt) != null) {
				String subB = b.substring(i,i + s.length());
				
				for (int bchar: subB.toCharArray()) {
					Integer count = subMap.get(bchar);
					if (count == null || count <= 0) {
						wrong = true;
						break;
					}
					subMap.put(bchar, --count);
				}
				if (!wrong) permutations.add(subB);
			}
		}
		
		return permutations;
	}

	public static void main(String[] args) {
		String s = "abbc";
		String b = "cbabadcbbabbcbabaabccbabc";
		Set<String> perms = subStringPerm(s, b);
		System.out.println(perms);
	}
}
