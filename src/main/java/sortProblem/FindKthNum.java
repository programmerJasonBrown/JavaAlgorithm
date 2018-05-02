package sortProblem;

public class FindKthNum {
    private static void exch(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public int partition(int[] a, int lo, int hi) {
        int v = a[lo];
        int i = lo + 1;
        int j = hi;
        System.out.println("partition(a, " + lo + ", " + hi + "):");
        while (i <= j) {
            if (a[i] >= v) exch(a, i, j--); //等号放在下面也可以
            else if (a[i] < v) i++;   //等号也可以放在这里
        }
        exch(a, lo, j);
        System.out.print("lo: " + lo + " j: " + j + " ");
        System.out.print("a: ");
        for (int x : a) {
            System.out.print(x + " ");
        }
        return j;
    }

    public int kthLargestElement(int k, int[] nums) {
        int mid;
        int lo = 0;
        int hi = nums.length;
        k = nums.length - k;
        int j = partition(nums, lo, hi - 1);
        System.out.println("j = " + j);
        while (j != k) {
            if (j < k) {
                lo = j + 1;
                j = partition(nums, j + 1, hi - 1);
            } else if (j > k) {
                hi = j;   //不用-1 因为 partition调用的时候减了1
                j = partition(nums, lo, j - 1);
            }
            System.out.println("j = " + j);
        }

        return nums[j];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{9,3,2,4,8};
        System.out.println("nums.length = " + nums.length);
        FindKthNum findKthNum = new FindKthNum();
        System.out.println(findKthNum.kthLargestElement(3, nums));
    }
}
