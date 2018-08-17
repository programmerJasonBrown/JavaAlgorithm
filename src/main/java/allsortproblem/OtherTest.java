package allsortproblem;

import java.util.Arrays;
import java.util.Collections;

/**
 * @program: JavaAlgorithm
 * @description: Arrays.sort and collections.reverseOrder
 * @author: Chao Qian
 * @create: 2018-08-13 10:13
 **/
public class OtherTest {
    public static void main(String[] args) {
        Integer[] a = {1, 2, 3, 4, 5, 6};
        Arrays.sort(a, Collections.reverseOrder());
        System.out.println(a[1] / 10.0);
    }
}
