package jingdong;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem1 {


    public static boolean isHui(String str) {
        if (str.length() <= 0)
            return false;
        if (str.length() == 1)
            return true;
        char[] chars = new char[str.length() * 2 + 1];
        for (int i = 0; i < chars.length; i++) {
            if (i % 2 == 0)
                chars[i] = '#';
            else
                chars[i] = str.charAt(i / 2);
        }


        int res = 1;
        int mid = chars.length / 2;
        for (int i = 1; i <= mid; i++) {
            if (chars[mid + i] == chars[mid - i])
                res = res + 2;
        }
        if (res / 2 == str.length())
            return true;
        return false;
    }

    public static int process(String str) {
        int res = 0;
        List<String> list = new ArrayList<>();
        getALlSubsquences(str, 0, new String(), list);

        for (int i = 0; i < list.size(); i++) {
            if (isHui(list.get(i)))
                res++;
        }
        return res;
    }

    public static void getALlSubsquences(String str, int i, String res, List<String> list) {
        if (i == str.length()) {
            if (res != "" || !res.isEmpty()) {
                list.add(res);
            }
            return;
        }
        getALlSubsquences(str, i + 1, res + str.charAt(i), list);
        getALlSubsquences(str, i + 1, res, list);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.print(process(str));
    }
}
