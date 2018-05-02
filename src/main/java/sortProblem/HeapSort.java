package sortProblem;

public class HeapSort {

    private boolean less(int[] a, int i, int j) {
        return a[i] < a[j];
    }

    private void exch(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public void sort(int[] a) {
        int N = a.length - 1;
        for (int i = N / 2; i >= 1; i--) {//for循环为建堆过程，大or小根堆由sink函数决定
            sink(a, i, N);   //从倒数第二层（叶子节点那一层的上一层）的最右一个节点）开始sink
        }

        while (N > 1) {
            exch(a, 1, N--);  //将根节点与最后一个节点调换位置，堆规模-1
            sink(a, 1, N);  //将换上来的根节点下沉到合适位置，下沉后又是堆了。
        }
    }

    private void sink(int[] a, int k, int n) {
//        将k节点下沉到合适的位置
        while (2 * k <= n) { //k节点没有子结点了，就不用下沉了
            int j = 2 * k;
            if (j < n && a[j] < a[j + 1]) j++;  //找出k节点子结点中最大的节点
            if (a[k] > a[j]) break;  //若以k为根节点的树已经是堆了，则退出
            exch(a, k, j);
            k = j;
        }
    }

    public static void main(String[] args) {
        int[] a = {0, 1, 6, 5, 4, 3, 2, 7, 8, 9};
        new HeapSort().sort(a);
        System.out.println(a);
    }
}
