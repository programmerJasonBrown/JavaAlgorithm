package API;

import java.util.Random;

public class SortExample {
    private static Comparable[] aux;

    //小于
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    //交换
    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    //显示
    private static void show(Comparable[] a) {
        for (Comparable x : a) {
            System.out.print(x + " ");
        }
        System.out.println("");
    }

    //测试数组是否有序(增序)
    private static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1]))
                return false;
        }
        return true;
    }

    public static void hashSort(Comparable[] a) {
        int h = 1;
        while (h < a.length) h = h + 3;
        while (h > 0) {
            for (int i = h; i < a.length; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    //qc：只有a[j]<a[j-h]时才进入，否则该h序列序号在j以及j之前的序列是有序的。（类似于动态规划的思想）
                    exch(a, j, j - h);
                }
            }
            System.out.print(h + "-sort: ");
            show(a);
            h = h / 3;
        }
    }

    //归并2个有序序列，a[lo...mid] 和 a[mid+1...hi]
    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        for (int k = lo; k <= hi; k++) {
                //比较N次数组
                if (i > mid) a[k] = aux[j++]; //如果左边已经取完，直接取右边
                else if (j > hi) a[k] = aux[i++];//如果右边已经取完，直接取左边
                else if (less(aux[i], aux[j])) a[k] = aux[i++]; //如果左边小，则取左边
                else a[k] = aux[j++];
        }
        System.out.print("merge(a, " + lo + ", " + mid + ", " + hi + ")  ");
        show(a);
    }
    private static void mergeSortUpToDown(Comparable[] a, int lo, int hi) {
        if (lo >= hi) return;
        int mid = (lo + hi) / 2;
        mergeSortUpToDown(a, lo, mid);
        mergeSortUpToDown(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    public static void mergeSortUpToDown(Comparable[] a) {
        aux = new Comparable[a.length];//额外分配的空间
        mergeSortUpToDown(a, 0, a.length - 1);
    }

    public static void mergeSortDownToUp(Comparable[] a) {
        aux = new Comparable[a.length];//额外分配的空间
        int N = a.length;
        //从一个开始合并,sz子数组的大小,如果a元素个数是奇数个，那么最后一个元素会被当成一个有序序列最后被归并
        for (int sz = 1; sz < N; sz = sz + sz) {
            for (int lo = 0; lo < N - sz; lo = lo + sz + sz) {
                //lo+sz-1 不能超过N-1  所以条件里有lo<N-sz
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
                //merge(a, lo, lo + sz - 1,lo + sz + sz - 1);
            }
        }
    }

    public static void quickSort(Comparable[] a){
        //首先对a随机打乱
        StdRandom.shuffle(a);
        quickSort(a,0,a.length-1);
    }
    private static void quickSort(Comparable[]a,int lo,int hi){
        
    }
    public static void main(String[] args) {
        String[] a = {"S", "H", "E", "L", "L", "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        String[] b = {"M", "E", "R", "G", "E", "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E", "F", "X"};

        SortExample.hashSort(a);
        SortExample.mergeSortUpToDown(b);
        SortExample.mergeSortDownToUp(b);
//        StdRandom.shuffle(a);
//        for (String x : a) {
//            System.out.print(x);
//        }
    }

}
