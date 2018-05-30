package Test51CreditCard;

import java.util.HashSet;
import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String x = sc.nextLine();
        String[] splits = x.split(";");
        process(splits[0], splits[1]);
    }

    public static void process(String A, String B) {
//        if (A.length() < B.length())
//            System.out.println(false);
        HashSet<Character> hs = new HashSet<>();
        for (int i = 0; i < A.length(); i++) {
            hs.add(A.charAt(i));
        }
        for (int i = 0; i < B.length(); i++) {
            if (hs.contains(B.charAt(i)))
                continue;
            else{
                System.out.println(false);
                return;
            }
        }
        System.out.println(true);
    }
}
