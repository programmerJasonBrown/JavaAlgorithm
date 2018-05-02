package testDP;

public class TestDP {
    public void moneyProblem() {
        int[] a = {1, 3, 5};
        int[] d = new int[11];
        for (int i = 0; i < 11; i++) {
            d[i] = i;
        }
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 3; j++) {
                if (i >= a[j] && d[i - a[j]] + 1 < d[i])
                    d[i] = d[i - a[j]] + 1;
            }
        }
        for (int x : d) {
            System.out.println(x);
        }
    }

    public int recursionMaxSum(int i, int j, int n) {
        int[][] a = {{9}, {12, 15}, {10, 6, 8}, {2, 18, 9, 5}, {19, 7, 10, 4, 16}};
        if (i == n || j == n)
            return a[i][j];
        int left = recursionMaxSum(i + 1, j, n);
        int right = recursionMaxSum(i + 1, j + 1, n);
        return (left > right) ? (left + a[i][j]) : (right + a[i][j]);
    }

    public void dPMaxSum() {
        int[][] a = {{9}, {12, 15}, {10, 6, 8}, {2, 18, 9, 5}, {19, 7, 10, 4, 16}};
        for (int i = 4; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                a[i - 1][j] += Math.max(a[i][j], a[i][j + 1]);
            }
        }
        System.out.println(a[0][0]);
    }

    public void lISProblem() {
        int[] a = {5, 3, 4, 8, 6, 7};
        int[] dp = new int[6];
        for (int i = 0; i < 6; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        for (int x : dp) {
            System.out.println(x);
        }
    }
}
