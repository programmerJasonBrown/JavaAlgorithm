package wangyi.bishi327.success;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Problem3 {
/*牛牛找工作*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//      工作数量
        int N;
        N = scanner.nextInt();
//      小伙伴数量
        int M;
        M = scanner.nextInt();
//        D：工作难度 P：报酬
        int[] D = new int[N + M];
        int[] P = new int[N];
        HashMap<Integer, Integer> hs = new HashMap<>();
        for (int i = 0; i < N; i++) {
            D[i] = scanner.nextInt();
            P[i] = scanner.nextInt();
            hs.put(D[i], P[i]);
        }
//        A：能力值
        int[] A = new int[M];
        for (int i = 0; i < M; i++) {
            A[i] = scanner.nextInt();
            D[i + N] = A[i];
//          把A[i]也当成难度
            if (!hs.containsKey(A[i]))
                hs.put(A[i], 0);
        }
        Arrays.sort(D);
        int max = 0;
        for (int i = 0; i < M + N; i++) {
//            及时本来难度和报酬不对应，现在也对应了， 难度越高，报酬越大
            max = Math.max(max, hs.get(D[i]));
            hs.put(D[i], max);
        }

        for (int i = 0; i < M; i++) {
            System.out.println(hs.get(A[i]));
        }

    }
}
