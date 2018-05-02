package Meituan;

import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long N = scanner.nextLong();
        int[] A = new int[(int) N + 1];
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int p = scanner.nextInt();
        processA(A, p);
        long sum = 0;
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++) {
                sum += A[(int) gcd(i, j)];
            }
        System.out.println(sum);
    }

    public static void processA(int[] A, int p) {
        A[1] = p;
        for (int i = 2; i < A.length; i++)
            A[i] = (A[i - 1] + 153) % p;
    }

    public static long gcd(long m, long n) {
        while (n != 0) {
            long temp = m % n;
            m = n;
            n = temp;
        }
        return m;
    }
}
