package sortProblem;

public class HeapApi {
    private int[] pq; //基于堆的完全二叉树
    private int N = 0; //书中结点个数

    private boolean less(int i, int j) {
        return pq[i] < pq[j];
    }

    private void exch(int i, int j) {
        int temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j, j + 1))
                j++;
            if (!less(k, j))
                break;
            exch(k, j);
        }
    }

    public HeapApi(int maxN){
        pq = new int[maxN+1];
    }

    public boolean isEmpty(){
        return N==0;
    }

    public int size(){
        return N;
    }

    public void insert(int v){
        pq[++N] = v;
        swim(N);
    }



    public int delMax(){
        int max = pq[1];
        pq[1] = pq[N--];
        pq[N+1]= Integer.parseInt(null); //防止对象游离
        sink(1);
        return max;
    }
}

