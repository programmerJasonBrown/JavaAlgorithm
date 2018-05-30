package Test51CreditCard;

import java.util.Scanner;

public class Problem3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String x = scanner.nextLine();
        x.trim();
        String[] splits = x.split("\\s+");
        int[] A = new int[splits.length];


        for (int i = 0; i < splits.length; i++) {
            A[Integer.parseInt(splits[i])]++;
        }

        int max = Integer.MIN_VALUE;
        int maxId = 0;

        for (int i = 0; i < splits.length; i++) {
            if (max < A[i]){
                max = A[i];
                maxId = i;
            }
        }
        System.out.println(maxId);
    }
}
