package zuoShen.class07;


import java.util.HashSet;

public class PrintPermutation {
    private static int count = 0;
    private static int count2= 0;


    public static void process(char[] str, int N) {
        if (N == str.length) {
            count++;
            System.out.println(str);
            return;
        }
        for (int i = N; i < str.length; i++) {
            if (isNotSwap(str, N, i)) {
                swap(str, N, i);
                process(str, N + 1);
                swap(str, N, i);
            }
        }
    }

    public static void process2(char[] str, int N) {
        if (N == str.length) {
            System.out.println(String.valueOf(str));
            count2++;
            return;
        }
        HashSet<Character> hs = new HashSet<>();
        for (int i = N; i < str.length; i++) {
            if (!hs.contains(str[i])){
                hs.add(str[i]);
                swap(str, N, i);
                process2(str, N + 1);
                swap(str, N, i);
            }
        }
    }

    private static boolean isNotSwap(char[] str, int i, int j) {
//        判断从[i,j)是否出现过与[j]位置相同的数
        for (int k = i; k < j; k++) {
            if (str[k] == str[j])
                return false;
        }
        return true;
    }

    public static void permutation(String str) {
        if (str == null)
            return;
        char[] c = str.toCharArray();
        System.out.println("===========process1=========");
        process(c, 0);
        System.out.println("count = " + count);
        System.out.println("===========process2=========");
        process2(c, 0);
        System.out.println("count2 = " + count2);

    }

    private static void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

    public static void main(String[] args) {
        String str = "abac";
        permutation(str);
    }
}
