package wangyi.bishi327;

import java.util.Scanner;

public class Problem1 {
    public static void process(int n, int[] x1, int[] y1, int[] x2, int[] y2) {
        int[] same = new int[n];
        for (int i = 0; i < n; i++) {
            same[i] = 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    j++;
                    continue;
                }
                if (isSame(x1, y1, x2, y2, i, j))
                    same[i]++;
            }
        }
        int max = 1;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, same[i]);
        }
        System.out.println(max);
    }

    private static boolean isSame(int[] x1, int[] y1, int[] x2, int[] y2, int i, int j) {
        if (x1[j] < x2[i] && y1[j] < y2[i] && x2[j] > x1[i] && y2[j] > y1[i]) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n > 0) {
            int[] x1 = new int[n];
            int[] y1 = new int[n];
            int[] x2 = new int[n];
            int[] y2 = new int[n];
            for (int i = 0; i < n; i++) {
                x1[i] = scanner.nextInt();
            }
            for (int i = 0; i < n; i++) {
                y1[i] = scanner.nextInt();
            }
            for (int i = 0; i < n; i++) {
                x2[i] = scanner.nextInt();
            }
            for (int i = 0; i < n; i++) {
                y2[i] = scanner.nextInt();
            }
            process(n, x1, y1, x2, y2);
        }
    }
}
