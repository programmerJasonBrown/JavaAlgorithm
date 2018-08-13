package DPStudy.Day329.Bag01Problem;

public class MyBag {
    public static void main(String[] args) {
        int m = 10; //背包容量
        int n = 3;  //钻石种类
        int w[] = {3, 4, 5};
        int p[] = {4, 5, 6};
//        int c[][] = new int[4][11];
//
//        for (int i = 1; i < n + 1; i++) { //3
//            for (int j = 1; j < m + 1; j++) {
//                if (j >= w[i - 1]) {
//                    c[i][j] = Math.max(c[i - 1][j - w[i - 1]] + p[i - 1], c[i - 1][j]);
//                }
//            }
//        }


//        背包问题最好的解法，从上往下解。
        int mycc[] = new int[m + 1];
        for (int i = 0; i < n; i++) { //3
            for (int j = m; j >=w[i]; j--) {
                    mycc[j] = Math.max(mycc[j], mycc[j - w[i]] + p[i]);
            }
            for (int k = 0; k < 11; k++) {
                System.out.print(k + "-->" + mycc[k] + " ");
            }
            System.out.println();
        }

//        for (int i = 0; i < 11; i++) {
//            System.out.println(i + " " + mycc[i]);
//        }



    }
}
