package sortProblem;

public class QuickSort {
    private static void exch(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public void sortIntegers2(int[] A) {
        // write your code here
        sortIntegers2(A, 0, A.length - 1);
    }

    public void sortIntegers2(int[] A, int lo, int hi) {
        int axis = A[0];
        for (; lo < hi; ) {
            if (A[lo] > axis) {
                exch(A, lo, hi);
                hi--;
            } else {
                lo++;
            }
        }
    }

    private void twoPartition(int[] A, int lo, int hi) {
        if(lo>=hi)
            return;
        int i = lo + 1;
        int lt = lo;
        int j = hi;
        int v = A[lo];
        while (i <= j) {
            if (A[i] < v)
                exch(A, i++, lt++);
            else if (A[i] >= v)
                exch(A, i, j--);
            System.out.print("处理:[" + lo + ", " + hi + "]: ");
            for (int x : A) {
                System.out.print(x);
            }
            System.out.println("");
        }
        System.out.print("处理结束:[" + lo + ", " + hi + "]: ");
        for (int x : A) {
            System.out.print(x);
        }
        System.out.println("");
        twoPartition(A, lo, lt - 1);
        twoPartition(A, lt+1, hi);
    }
/*
* lo...lt-1中的元素小于v
* lt...i-1中的元素都等于v
* i....gt中的元素都未确定
* gt...hi中的元素都大于v
*
* */
    private void threePartition(int[] A, int lo, int hi) {
        if (lo >= hi)
            return;
        int lt = lo;
        int gt = hi;
        int i = lt + 1;
        int v = A[lo];
        while (i <= gt) {
            if (A[i] < v)
                exch(A, i++, lt++);
            else if (A[i] > v)
                exch(A, i, gt--);
            else if (A[i] == v)
                i++;
            System.out.print("处理:[" + lo +", " + hi + "]: ");
            for (int x : A) {
                System.out.print(x);
            }
            System.out.println("");
        }
        System.out.print("处理结束:[" + lo + ", " + hi + "]: ");
        for (int x : A) {
            System.out.print(x);
        }
        System.out.println("");
        threePartition(A, lo, lt - 1);
        threePartition(A, gt + 1, hi);
    }

    public static void main(String[] args) {
        int[] A = {3, 2, 1, 4, 5};
        QuickSort sort = new QuickSort();
        sort.threePartition(A, 0, A.length - 1);
        System.out.println();
    }

}
