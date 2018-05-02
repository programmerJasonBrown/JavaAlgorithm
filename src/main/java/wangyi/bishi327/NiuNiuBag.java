package wangyi.bishi327;

import java.util.Arrays;
import java.util.Scanner;

public class NiuNiuBag {

    private static int count = 0;

    //    当前指向的零食，背包剩余容量，零食重量
    public static void process(int index, int w, int[] v) {
        if (index == v.length) {
            count++;
            return;
        }
        if (v[index] > w) {
            count++;
            return;
        }
        process(index + 1, w - v[index], v);
        process(index + 1, w, v);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int w = scanner.nextInt();
        int[] v = new int[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            v[i] = scanner.nextInt();
            sum += v[i];
        }
        if (sum<=w)
            System.out.println(1<<n);
        else {
            Arrays.sort(v);
            if (w < v[0])
                System.out.println(1);
            else {
                process(0, w, v);
                System.out.println(count);
            }
        }

    }
}
