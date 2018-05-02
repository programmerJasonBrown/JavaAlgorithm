package sortProblem.InsertSort;

public class InsertSort {
    public static void sort(int[] a) {
        if (a.length <= 1)
            return;
        for (int i = 1; i < a.length; i++) {
            int temp = a[i]; //其中[0，i-1]已经有序
            int j;
            for (j = i; j >= 0 && temp < a[j - 1]; j--) {
//               与前一个比较，若小于前一个则后移，空出一位
                a[j] = a[j - 1];
            }
//            在空出的那一位插入temp
            a[j] = temp;
        }
    }

}
