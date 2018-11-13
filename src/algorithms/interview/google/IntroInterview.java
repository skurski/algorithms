package algorithms.interview.google;

import java.util.Arrays;

/**
 * Google interview questions
 */
public class IntroInterview {

    /**
     * We have collection of integers, asc order
     * Find pair that sum up to some number
     */
    public static int[] findPair(int[] array, int sum) {
        return binarySearchPair(array, 0, array.length-1, sum);
    }

    public static int[] binarySearchPair(int[] array, int start, int end, int sum) {
        int[] res = new int[]{};
        if (start >= end) return res;
        int middleId = array.length / 2;
        if (array[middleId] + array[middleId+1] == sum) {
            return new int[]{middleId, middleId+1};
        }
        if (array[middleId] + array[middleId+1] < sum) {
            res = binarySearchPair(array, middleId+1, array.length-1, sum);
        }
        if (array[middleId] + array[middleId+1] > sum) {
            res = binarySearchPair(array, 0, middleId, sum);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] res = findPair(new int[]{1,2,4,4}, 8);
        System.out.println(Arrays.toString(res));
    }

}
