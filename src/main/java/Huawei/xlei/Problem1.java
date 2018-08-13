package Huawei.xlei;

import java.util.Scanner;

/**
 * @program: JavaAlgorithm
 * @description:
 * @author: Chao Qian
 * @create: 2018-08-08 18:48
 **/
public class Problem1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                System.out.printf("%c", s.charAt(i) - 32);
            } else if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')
                System.out.printf("%c", s.charAt(i) + 32);
            else
                System.out.print(s.charAt(i));
        }
    }
}
