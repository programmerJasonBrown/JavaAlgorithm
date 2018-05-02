package wangyi.bishi327.success;

import java.util.Scanner;

public class Problem2 {
    static long count = 0L;

    public static void process(long n, long k) {
        if (k == 0) {
            count = n * n;
        } else
            for (long i = k + 1; i <= n; i++) {
//            i是除数，把整个区域分成n/i段， 每一段里满足条件的个数是一样的 都是i-k个。 k，k+1...,i-1。 结果为 i-1-k+1 = i - k
//            多出来的部分为n%i个数，满足条件的是 n/i * k .. n%i , 所以结果为n % i - k+1， 如果为负数则直接为0
                count += n / i * (i - k) + Math.max(0, n % i - k + 1);
            }
        System.out.println(count);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long k = scanner.nextLong();
        process(n, k);
    }
}
