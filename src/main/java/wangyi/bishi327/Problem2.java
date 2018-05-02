package wangyi.bishi327;

import java.util.Scanner;

public class Problem2 {
    static int count = 0;

    public static void process(int n, int k) {
        for (int i = k; i <= n ; i++) {
            for (int j = i%k + 2; j <= n; j++) {
                if (i % j >= k)
                    count++;
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        process(n, k);
    }
}
