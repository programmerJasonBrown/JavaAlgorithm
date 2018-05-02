package aiQiyi;

import java.util.Scanner;

public class Problem22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] lr = new int[n][2];
        int curCapacity = m;
        for (int i = 0; i < n; i++) {
            lr[i][0] = scanner.nextInt(); //li
            lr[i][1] = scanner.nextInt(); //ri
            curCapacity -= lr[i][0];
        }
        int res = 0;
        for (int i = 0; i < n; i++) {

        }

    }
}
