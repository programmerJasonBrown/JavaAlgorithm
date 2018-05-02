package sortProblem;

public class ReverseSort {
    private int[] aux;

    public long reversePairs(int[] A) {
        aux = new int[A.length];
        long[] nums = new long[1];
        reversePairs(A, 0, A.length - 1, nums);
        return nums[0];
    }

    public void reversePairs(int[] A, int lo, int hi, long[] nums) {
        if (lo >= hi)
            return;
        int mid = (lo + hi) / 2;
        reversePairs(A, lo, mid, nums);
        reversePairs(A, mid + 1, hi, nums);
        merge(A, lo, mid, hi, nums);
    }

    private void merge(int[] A, int lo, int mid, int hi, long[] nums) {
        int i = mid;
        int j = hi;
        for (int ik = lo; ik <= hi; ik++) {
            aux[ik] = A[ik];
        }
        System.out.print("merge(" + lo + ", " + mid + ", " + hi + ") ");
        for (int k = hi; k >= lo; k--) {
            if (j <= mid) A[k] = aux[i--];
            else if (i < lo) A[k] = aux[j--];
            else if (aux[i] <= aux[j]) {
                A[k] = aux[j--];
            } else {
                A[k] = aux[i--];
                nums[0] += j - mid;
            }
        }
        System.out.print("After merge: ");
        for (int x : A) {
            System.out.print(x);
        }
        System.out.println(" nums = " + nums[0]);
    }

    public static void main(String[] args) {
        int[] A = new int[]{4, 3, 2, 1};
        ReverseSort reverseSort = new ReverseSort();
        System.out.println(reverseSort.reversePairs(A));
    }
}
