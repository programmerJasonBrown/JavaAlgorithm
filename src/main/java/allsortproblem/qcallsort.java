package allsortproblem;

import java.util.*;

/**
 * @program: JavaAlgorithm
 * @description:
 * @author: Chao Qian
 * @create: 2018-08-13 09:48
 **/
public class qcallsort {
    private static List<String> lists = new ArrayList<>();
    private static HashSet<String> hashSet = new HashSet<>();

    public static void main(String[] args) {
        String str = "abb";
        permutation(str.toCharArray(), 0, str.length() - 1);
        lists.addAll(hashSet);
//        for (String x : lists) {
//            System.out.println(x);
//        }
        Collections.sort(lists);
        System.out.println(lists.get(2));
    }

    public static void permutation(char[] chars, int lo, int hi) {
        if (lo == hi) {
            hashSet.add(String.valueOf(chars));
            //System.out.println(String.valueOf(chars));
        }
        for (int i = lo; i <= hi; i++) {
            swap(chars, lo, i);
            permutation(chars, lo + 1, hi);
            swap(chars, lo, i);
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
