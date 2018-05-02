package zuoShen.jinjie;

public class KMP {
    public static int[] getNextArray(String str2) {
//        next数组的下一个元素最多比上一个数组大1
        if (str2.length() <= 0) {
            return new int[]{-1};
        }
        int[] next = new int[str2.length()];
        next[0] = -1;
        next[1] = 0;
        int cn = 0; //跳到的位置。
        int i = 2;
        while (i < str2.length()) {
            if (str2.charAt(cn) == str2.charAt(i - 1)) {
//                跳到的位置和当前位置的前一个位置比较，若相等则值等于cn++，因为cn之前有还cn个数。
                next[i++] = ++cn;
            } else if (cn > 0) {
//                如果不等，则找上一个cn的位置
                cn = next[cn];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }

    public static int getIndexof(String str1, String str2) {
//        str1是否包含子串str2，返回str1中的下标
        if (str1.length() <= 0 || str2.length() <= 0)
            return -1;
        int[] next = getNextArray(str2);
        int l1 = 0;
        int l2 = 0;
        while (l1 < str1.length() && l2 < str2.length()) {
            if (str1.charAt(l1) == str2.charAt(l2)) {
                l1++;
                l2++;
            } else if (next[l2] == -1) {
                l1++;
            } else {
                l2 = next[l2];
            }
        }
        return l2 == str2.length() ? l1 - l2 : -1;
        }

    public static void main(String[] args) {
        String str1 = "abaxabacxababacxaba";
        String str2 = "ababac";
        System.out.println(getNextArray(str2));
        System.out.println(getIndexof(str1,str2));
    }
}
