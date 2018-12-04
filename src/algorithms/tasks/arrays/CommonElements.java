package algorithms.tasks.arrays;

import java.util.*;

public class CommonElements {

    /**
     * Find common elements in two arrays
     * [5,6,7,8]
     * [1,2,3,5]
     */
    public static Set<Integer> findCommonElements(int[] a, int[] b) {
        Set<Integer> commons = new HashSet<>();

        int i, j;
        for (i = 0, j = 0; i < a.length && j < b.length; ) {
            if (a[i] == b[j]) {
                commons.add(a[i]);
                i++;
                j++;
            } else if (a[i] < b[j]) {
                i++;
            } else if (a[i] > b[j]) {
                j++;
            }
        }

        return commons;
    }


    public static void main(String[] args) {
        Set<Integer> commons = findCommonElements(new int[]{13,27,35,40,49,55,59}, new int[]{17,35,39,40,55,58,60});
        System.out.println(commons);
    }
}
