package Test51CreditCard;

import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String x = sc.nextLine();
        char[] chs = x.toCharArray();
        process(chs, 0, chs.length - 1);
        System.out.println(chs);
    }

//    由于按照红绿蓝（RGB）的顺序进行排序，所以只需要按照字典序逆序排列就行
    public static void process(char[] chs, int lo, int hi) {
        if (lo >= hi)
            return;
        int lt = lo;
        int gt = hi;
        int i = lt + 1;
        int v = chs[lo];
        while (i <= gt) {
            if (chs[i] > v)
                exch(chs, i++, lt++);
            else if (chs[i] < v)
                exch(chs, i, gt--);
            else if (chs[i] == v)
                i++;
        }
        process(chs, lo, lt - 1);
        process(chs, gt + 1, hi);
    }

    private static void exch(char[] a, int i, int j) {
        char t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
