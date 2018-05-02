package zuoShen.jinjie;

import java.util.Arrays;
import java.util.Scanner;

public class BFPRT {
    //    数组，数组下限，数组上限，第k个数
    public static int bfprt(int[] a, int lo, int hi, int k) {
        if (lo == hi)
            return a[lo];
        int pivot = medianOfMedians(a, lo, hi);
        int[] equalPrivotIndex = partition(a, pivot, lo, hi);
        if (k <= equalPrivotIndex[1] && k >= equalPrivotIndex[0])
            return a[k];
        if (k < equalPrivotIndex[0]) {
            return bfprt(a, lo, equalPrivotIndex[0] - 1, k);
        }
        return bfprt(a, equalPrivotIndex[1] + 1, hi, k);
    }

    private static int[] partition(int[] A, int pivot, int lo, int hi) {
        int lt = lo;
        int gt = hi;
        int i = lt;
        while (i <= gt) {
            if (A[i] < pivot)
                exch(A, i++, lt++);
            else if (A[i] > pivot)
                exch(A, i, gt--);
            else if (A[i] == pivot)
                i++;
        }
        return new int[]{lt, i - 1};
    }

    public static int medianOfMedians(int[] arr, int begin, int end) {
        int num = end - begin + 1;  //一共num个数
        int offset = num % 5 == 0 ? 0 : 1; //是否有小尾巴
        int[] mArr = new int[num / 5 + offset];
        for (int i = 0; i < mArr.length; i++) {
            int beginI = begin + i * 5;
            int endI = beginI + 4;
            mArr[i] = getMedian(arr, beginI, Math.min(end, endI));
        }
        return getMedian(mArr,0,mArr.length-1);
    }

    public static int getMedian(int[] arr, int begin, int end) {
        Arrays.sort(arr, begin, end + 1);
        int sum = end + begin;
        int mid = sum / 2 + sum % 2; //上中位数
        return arr[mid];
    }

    // 寻找中位数的中位数
//    首先将a划分成大小为5的子串，最后可能会多一个大小小于5的尾巴数组
//    找到各个子串的中位数，组成中位数数组
//    返回中位数数组的中位数
    private static int findMidMind(int[] a, int lo, int hi) {
        if (lo == hi)
            return a[lo];
//      一共可以划分几个数组
        int arraysNum = (hi - lo) / 5 + 1;
//      一共可以划分多少个长度为5的小数组
        int arrays5Num = (hi - lo + 1) / 5;
//      中位数数组
        int[] mid = new int[arraysNum];
//      对每个小数组排序
        for (int i = lo; (i - lo) / 5 < arrays5Num; i = i + 5) {
            Arrays.sort(a, i, i + 5);
        }
//      如果有小尾巴
        if (arraysNum > arrays5Num) {
            Arrays.sort(a, lo + 5 * arrays5Num, hi + 1);
            mid[arraysNum - 1] = a[lo + 5 * arrays5Num + (hi - lo - 5 * arrays5Num + 1) / 2];
        }

        for (int i = 0; i < arrays5Num; i++) {
            mid[i] = a[lo + 2 + 5 * i];
        }

        Arrays.sort(mid);
//        返回中位数的中位数
        return mid[(mid.length - 1) / 2];
    }

    private static void exch(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a[] = {1, 2, 33, 44, 2, 3, 2, 2, 3, 3, 66, 545, 44, 66, 33, 65, 43, 24, 23};
        printA();
//      第k大的数，第一个数是第一大的数
        while (true) {
            int k = scanner.nextInt();
            System.out.println("第" + k + "个数是： " + bfprt(a, 0, a.length - 1, k - 1));
        }

    }

    public static void printA() {
//        显示，数组a，为了验证程序是否正确
        int a[] = {1, 2, 33, 44, 2, 3, 2, 2, 3, 3, 66, 545, 44, 66, 33, 65, 43, 24, 23};
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(i + ": " + a[i] + "  ");
        }
        System.out.println();
    }
}
