package algorithms.interview.google;

import java.util.Arrays;

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

    public static void main(String[] args) {
        int[] res = findPair(new int[]{1,2,4,4}, 8);
        System.out.println(Arrays.toString(res));
    }

}
