package jingdong;

import java.util.Scanner;

public class Problem3 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int t = scan.nextInt();
        for (int i = 0; i < t; i++) {
            String s = scan.next();
            char[] arr = s.toCharArray();
            int left = 0;
            int right = 0;
            for (int k = 0; k < arr.length; k++) {
                if (arr[k] == '(') {
                    left++;
                } else {
                    right++;
                }
            }
            if (left != right) {
                System.out.println("No");
                continue;
            }
            if (left == 1 && right == 1) {
                if (arr[0] == '(') {
                    System.out.println("No");
                } else {
                    System.out.println("Yes");
                }
                continue;
            }
            left = 0;
            right = 0;
            int rec = 0;
            for (int k = 0; k < arr.length; k++) {
                if (arr[k] == '(') {
                    left++;
                } else {
                    right++;
                }
                if (right > left + 1) {
                    System.out.println("No");
                    break;
                }
                if (right == left + 1) {
                    rec++;
                }
                if (rec > 1) {
                    System.out.println("No");
                    break;
                }
                if (k == arr.length - 1) {
                    System.out.println("Yes");
                }
            }

        }


    }

}
