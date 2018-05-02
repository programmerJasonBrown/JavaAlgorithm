package aiQiyi;

import java.util.Arrays;
import java.util.Scanner;

public class Problem3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] data = new int[3];
        for (int i = 0; i < 3; i++) {
            data[i] = scanner.nextInt();
        }
        Arrays.sort(data);
        int step = 0;
        while (data[1] < data[2]) {
//            先让1 和 2的位置相等
            data[0]++;
            data[1]++;
            step++;
        }
        while (data[0] < data[2]) {
//            在让0 和 2 的位置相等
            data[0] += 2;
            step++;
        }
        if (data[0] != data[2]) // 此时1 和 2 是相等的，而0位置要么大于1位置的，要么等于
            step += data[2] - data[0];
        System.out.println(step);
    }
}
