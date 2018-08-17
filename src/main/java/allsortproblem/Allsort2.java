package allsortproblem;

/**
 * @program: JavaAlgorithm
 * @description: https://blog.csdn.net/duoduo18up/article/details/79735229
 * 将 s[start] 与[start,end](包括start，是因为第一个输出也要)中的元素依次交换 之后，在进行全排列（递归）
 *
 * 1 2 3     -------1 【2，3】
 *
 * 1 2 3 ----------2【1，3】
 *
 * 1 2 3     -------3 【2，1】
 * 【】里的元素当成子数组，再次递归，知道只有一个元素，就不需要递归了（递归终止条件）
 *
 * 这里未考虑去重
 * @author: Chao Qian
 * @create: 2018-08-13 09:43
 **/
public class Allsort2 {
    public static void main(String[] args) {
        String s = "ABB";
        fullPermutation(s);
    }

    private static void fullPermutation(String s) {
        permutation(s.toCharArray(), 0, s.length() - 1);

    }

    private static void permutation(char[] c, int start, int end) {
        if (start == end)
            System.out.println(new String(c));

        else {
            for (int i = start; i <= end; i++) {
                swap(c, i, start);
                permutation(c, start + 1, end);    //继续深度搜索
                swap(c, i, start);
            }
        }

    }

    private static void swap(char[] c, int i, int start) {
        char temp = c[i];
        c[i] = c[start];
        c[start] = temp;
    }


}
