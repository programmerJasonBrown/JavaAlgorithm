package SwordToOffer.num11.num14;

public class MaxProductAfterCuttingUsingByDP {
    public static int maxProductAfterCutting(int length) {
        if (length < 2)
            return 0;
        if (length == 2)
            return 1;
        if (length == 3)
            return 2;
        int[] maxProduct = new int[length + 1];
        maxProduct[0] = 0;   //注意和上面不一样
        maxProduct[1] = 1;
        maxProduct[2] = 2;
        maxProduct[3] = 3;
        int max;
        for (int i = 4; i < length + 1; i++) {
            max = 0;
            for (int j = 1; j <= i / 2; j++) {
                max = Math.max(max, maxProduct[j] * maxProduct[i - j]);
            }
            maxProduct[i] = max;
        }
        return maxProduct[length];
    }

    public static void main(String[] args) {
        System.out.println(MaxProductAfterCuttingUsingByDP.maxProductAfterCutting(10));
    }

}
