package algorithms.hackerrank.string;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class StringAlgo {

    public static Set<String> stringPerm = new HashSet<>();
    private static AtomicInteger counter = new AtomicInteger(0);

    /**
     * Find all string permutations without repetition
     * @param str
     */
    public static void findAllPermutations(String str) {
        if (str == null) return;
        doPerm("", str);
    }

    private static void doPerm(String prefix, String str) {
        counter.getAndIncrement();
        if (str.length() == 0) {
            stringPerm.add(prefix);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            doPerm(prefix + str.charAt(i), str.substring(0,i) + str.substring(i+1));
        }
    }
    
    private static Set<String> perms = new HashSet<>();

    public static void permutation(String text) {
        permutation(text, "");
    }

    private static void permutation(String text, String prefix) {
        if (text.length() == 0) {
            perms.add(prefix);
            return;
        }
        for (int i = 0; i < text.length(); i++) {
            String remains = text.substring(0, i) + text.substring(i + 1);
            permutation(remains, prefix + text.charAt(i));
        }
    }

    public static void main(String[] args) {
        findAllPermutations("ABCD");
        System.out.println(stringPerm);

        System.out.println("Recursion executed: " + counter.get());
    }
}
