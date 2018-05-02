package aiQiyi;

import java.util.Scanner;

public class problem2 {
    static class Res {
        static long count = 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] lr = new int[n][2];
        int curCapacity = m;
        int riMax = 0;
        for (int i = 0; i < n; i++) {
            lr[i][0] = scanner.nextInt(); //li
            lr[i][1] = scanner.nextInt(); //ri
            curCapacity -= lr[i][0];
            riMax += lr[i][1];
        }
        if (riMax < m || curCapacity < 0)
            System.out.println(0);
        else if (riMax == m || curCapacity == 0)
            System.out.println(1);
        else {
            Res res = new Res();
            process(res, lr, curCapacity, 0);
            System.out.println(Res.count);
        }

    }

    public static void process(Res res, int[][] lr, int capacity, int index) {
        if (capacity == 0) {
            res.count++;
            return;
        } else if (index == lr.length - 1) {
//            如果放到最后Capacity还不为0的话
            if (capacity + lr[index][0] <= lr[index][1]) {
                res.count++;
            }
            return;
        }
        for (int i = 0; i <= Math.min(lr[index][1] - lr[index][0], capacity); i++) {
            process(res, lr, capacity - i, index + 1);
        }

    }
}
