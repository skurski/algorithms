package algorithms.interview.bud;


/**
 * Best Conceivable Runtime
 *
 * This is largely a function of the inputs and outputs.
 * It is not related to specific algorithm and it's important to
 * remember that it might be not necessarily achievable.
 *
 * Example: Given two sorted arrays, find the number of elements in common.
 * The arrays are the same length and each has all distinct elements.
 *
 * Input: We know that we will have to look at each elements at least once so
 *        there are 2N total elements so complexity is O(N)
 *
 * Solutions:
 * 1) 2 nested loops => O(N2), bottleneck is searching for second element
 * 2) We can change nested loop for binary search so O(N) change to O(logN) => overall O(NlogN)
 * 3) We can remove binary search by doing some computation before iteration, put second array to
 *    hash table and do look up which is constant, O(N)
 *    BCR is achieved but we have information not used -> those are SORTED arrays
 *    After BCR is achieved we should move to SPACE complexity
 * 3) Arrays are sorted so we can use 2 pointers and start each searching where previous ended,
 *    O(N) and algorithm works in place, no addition space required
 */
public class BCR {

    /**
     *
     * @param a [13, 27, 35, 40, 49, 55, 59]
     * @param b [17, 35, 39, 40, 55, 58, 60]
     * @return int number of common elements - 3
     */
    public static int findElementInComon(int[] a, int[] b) {
        if (a == null || b == null) return 0;
        int i = 0;
        int j = 0;
        int counter = 0;
        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) {
                counter++;
                i++;
                j++;
            }
            else if (a[i] < b[j]) i++;
            else if (a[i] > b[j]) j++;
        }
        return counter;
    }

    public static void main(String[] args) {
        int res = findElementInComon(new int[]{13,27,35,40,49,55,59}, new int[]{17,35,39,40,55,58,60});
        System.out.println(res);
    }
}
