package zhaohang;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        System.out.println(getsteps(x));
    }

    public static int getsteps(int x) {
        int steps = 0;
        while (x != 0) {
            if (x < 0) {
                if ((x & 1) == 0) {
                    x = x / 2;
                    steps++;
                }
                if ((x & 1) == 1) {
                    x = x + 1;
                    steps++;
                }
            }
            if (x > 0) {
                if ((x & 1) == 0) {
                    x = x / 2;
                    steps++;
                }
                if ((x & 1) == 1) {
                    x = x - 1;
                    steps++;
                }
            }
        }
        return steps;
    }
}



