package wangyi;

import java.util.*;

public class TwoCore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            arr[i] /= 1024;
            sum += arr[i];
        }
        int dp[] = new int[sum / 2 + 1];
        // 01背包问题。将数组划分为两部分，
        // 要求两部分的和的之差绝对值最小。
        for (int i = 0; i < n; i++)
            for (int j = sum / 2; j >= arr[i]; --j)
                dp[j] = Math.max(dp[j], dp[j - arr[i]] + arr[i]);


        System.out.println((sum - dp[sum / 2]) * 1024);
    }
}
