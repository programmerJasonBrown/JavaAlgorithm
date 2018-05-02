package Meituan;

import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int[] n = new int[T];
        for (int i = 0; i < T; i++) {
            n[i] = scanner.nextInt();
            System.out.println(process(n[i]));
        }
    }

    public static long process(int n) {
        int bits = 0;
        int temp = n;
        while (temp != 0) {
            bits++;
            temp = temp / 10;
        }
        if (bits == 1) {
            return n;
        } else if (bits == 2) {
            return 9 + (n - 10 + 1) * 2;
        } else if (bits >= 3) {
            long count = 0;
            for (int i = 0; i < bits - 1; i++) {
                count += 9 * (long) Math.pow(10, i) * (i + 1);
            }
            count += (n - (long) Math.pow(10, bits - 1) + 1) * bits;
            return count;
        }
        return 0;
    }

}
