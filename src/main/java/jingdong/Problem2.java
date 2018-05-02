package jingdong;

import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        long[] num = new long[length];
        long[][] result = new long[length][2];
        for (int i = 0; i < length; i++) {
            num[i] = in.nextLong();
        }
        for (int i = 0; i < length; i++) {
            for (int j = 1; 2 * j <= num[i] && (num[i] % 2 == 0); j++) {
                if (num[i] % (2 * j) == 0) {
                    if ((num[i] / (2 * j)) % 2 == 1) {
                        result[i][0] = num[i] / (2 * j);
                        result[i][1] = 2 * j;
                        break;
                    }
                }

            }

        }
        for (int i = 0; i < length; i++) {
            if (result[i][0] == 0) {
                System.out.println("No");
            } else {
                System.out.println(result[i][0] + " " + result[i][1]);
            }
        }
    }

}

