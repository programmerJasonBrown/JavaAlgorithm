package sortProblem.easyProblemUsingQuickSortThink;
/*
*
给定一个只包含字母的字符串，按照先小写字母后大写字母的顺序进行排序。
注意事项
小写字母或者大写字母他们之间不一定要保持在原始字符串中的相对位置。
样例
给出"abAcD"，一个可能的答案为"acbAD"
挑战
在原地扫描一遍完成
* */

public class SortLetter {
    private static void exch(char[] a, int i, int j) {
        char t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public void sortLetters(char[] chars) {
        int i = 0;
        int j = chars.length - 1;
        while (i <= j) {
            if (chars[i] > 'Z') {
                i++;
            } else {
                exch(chars, i, j--);
            }
        }
        for (char x : chars) {
            System.out.print(x);
        }
    }

}
