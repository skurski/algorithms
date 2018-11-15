package algorithms.interview.google;

import java.util.*;

/**
 * Google interview questions
 */
public class IntroInterview {

    /**
     * We have collection of integers, asc order
     * Find pair that sum up to some number
     *
     * Simple and O(n2) solution is two loops
     *
     * More advanced solution is to use one loop to iterate over collection, this way we have first element of a pair
     * Then inside loop we use binary search for finding second element of the pair
     * Complexity is N x LOG(N)
     *
     * Fastest solution is to use double pointers and iterate from beginning and the end at the same time
     * Complexity is O(N)
     */
    public static int[] findPair(int[] array, int sum) {
        for (int i = 0; i < array.length-1; i++) {
            int second = binarySearchForSecondElement(array, i+1, array.length-1, array[i], sum);
            if (second > -1) return new int[]{i, second};
        }

        return new int[0];
    }

    private static int binarySearchForSecondElement(int[] array, int start, int end, int firstOfPair, int sum) {
        if (start > end) return -1;
        int middleId = (start + end)  / 2;

        if (array[middleId] + firstOfPair < sum) {
            middleId = binarySearchForSecondElement(array, middleId+1, end, firstOfPair, sum);
        } else if (array[middleId] + firstOfPair > sum) {
            middleId = binarySearchForSecondElement(array, start, middleId-1, firstOfPair, sum);
        }
        return middleId;
    }

    /**
     * Fastest solution is to use double pointers
     */
    public static int[] findPairLinear(int[] array, int sum) {
        int i = 0;
        int j = array.length -1;
        while (i < j){
            while (array[i] + array[j] < sum) i++;
            while (array[i] + array[j] > sum) j--;
            if (array[i] + array[j] == sum) {
                return new int[]{i, j};
            }
        }
        return new int[0];
    }

    /*
	 * The same task but array is not sorted
     */
	 public static int[] findPairInUnsortedArray(int[] array, int sum) {
		Map<Integer, Integer> complements = new HashMap<>();
		
		for (int i = 0; i < array.length; i++) {
			if (complements.containsKey(array[i])) {
				System.out.println("Founded in lookup, first index: " + complements.get(array[i]) + ", second index: " + i);
				return new int[]{complements.get(array[i]), i};
			}
			complements.put(sum - array[i], i);
		}
		return new int[0];
	 }
	 
	/**
	 * Follow up task => find 2 elements that sum up to other element
	 * O(N2)
	 */
	public static boolean hasPairThatSumUp(int[] array) {
		Set<Integer> sums = new HashSet<>();
		Set<Integer> comp = new HashSet<>();
		for (int value : array) {
			sums.add(value);
			for (int sum: sums) {
				comp.add(sum-value);
			}
			if (comp.contains(value)) return true;
		}
		return false;
	}

    public static void main(String[] args) {
        int[] res = findPair(new int[]{1,2,4,4}, 8);
        System.out.println(Arrays.toString(res));


        int[] res2 = findPairLinear(new int[]{1,2,4,4}, 8);
        System.out.println(Arrays.toString(res2));

        int[] res3 = findPairInUnsortedArray(new int[]{-1,4,2,3,1,4,-2}, 8);
        System.out.println(Arrays.toString(res3));
		
		boolean res4 = hasPairThatSumUp(new int[]{10,2,3,-1});
        System.out.println(res4);
    }
}
