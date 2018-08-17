package allsortproblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * @program: JavaAlgorithm
 * @description: 利用深度优先遍历完成有限个字母的全排列
 * @author: Chao Qian
 * @create: 2018-08-13 16:33
 **/
public class DFSToAllSort {
    public static void main(String[] args) {
        int n = 2; //n个a
        int m = 2; //m个z
        HashSet<String> hashSet = new HashSet<>();
        DFS(hashSet, new String(), n, m);
        List<String> list = new ArrayList<>(hashSet);
        Collections.sort(list);
        System.out.println();
    }

    private static void DFS(HashSet<String> hashSet, String out, int n, int m) {
        if (n == 0 && m == 0) {
            hashSet.add(out.toString());
            return;
        }
        if (n > 0) {
            DFS(hashSet, out + 'a', n - 1, m);
        }
        if (m > 0) {
            DFS(hashSet, out + 'z', n, m - 1);
        }
    }


}

