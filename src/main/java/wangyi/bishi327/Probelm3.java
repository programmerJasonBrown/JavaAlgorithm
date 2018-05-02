package wangyi.bishi327;

import java.util.*;

public class Probelm3 {

    public static void process(int[] D, int[] P, int[] A) {
        for (int i = 0; i < A.length; i++) {
            int maxSalary = 0;
            for (int j = 0; j < D.length; j++) {
                if (A[i] >= D[j])
                    maxSalary = Math.max(maxSalary,P[j]);
            }
            System.out.println(maxSalary);
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N;
        N = scanner.nextInt();
        int M;
        M = scanner.nextInt();
        int[] D = new int[N];
        int[] P = new int[N];
        for (int i = 0; i < N; i++) {
            D[i] = scanner.nextInt();
            P[i] = scanner.nextInt();
        }

        int[] A = new int[M];
        for (int i = 0; i < M; i++) {
            A[i] = scanner.nextInt();
        }
        process(D, P, A);
    }
}
