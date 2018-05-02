package zijie;

import java.util.*;

public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        HashMap<Integer, Integer> arr;
        List<HashMap<Integer, Integer>> arrs = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int arrSize = sc.nextInt();
            arr = new HashMap<>();
            for (int j = 0; j < arrSize; j++) {
                arr.put(j, sc.nextInt());
            }
            arrs.add(arr);
        }


        List<Integer> res = process(N, arrs);
        for (int x : res) {
            System.out.println(x);
        }

    }

    public static List<Integer> process(int N, List<HashMap<Integer, Integer>> arrs) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            HashMap<Integer, Integer> cur = arrs.get(i);
            int an = cur.get(cur.size() - 1);
            int a0 = cur.get(0);
            int j;
            for (j = 1; j < an; j++) {
                int k;
                for (k = 0; k < cur.size(); k++) {
                    if (cur.get(k) + j <= an && !cur.containsValue(cur.get(k) + j))
                        break;
                    if (cur.get(k) - j >= a0 && !cur.containsValue(cur.get(k) - j))
                        break;
                }
                if (k != cur.size())
                    continue;
                else
                    break;
            }
            res.add(j);
        }
        return res;
    }
}
