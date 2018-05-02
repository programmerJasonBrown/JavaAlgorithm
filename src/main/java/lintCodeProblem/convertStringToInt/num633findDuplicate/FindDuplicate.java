package lintCodeProblem.convertStringToInt.num633findDuplicate;
/*
* 给出一个数组 nums 包含 n + 1 个整数，每个整数是从 1 到 n (包括边界)，保证至少存在一个重复的整数。
* 假设只有一个重复的整数，找出这个重复的数。

 注意事项

1.不能修改数组(假设数组只能读)    所以就不能先排序
2.只能用额外的O(1)的空间
3.时间复杂度小于O(n^2)
4.数组中只有一个重复的数，但可能重复超过一次
*
* */

/*
 * 利用抽提原理，一共六种袜子，一个抽屉里有7双袜子则必然重复。
 * */
public class FindDuplicate {
    public int findDuplicate(int[] nums) {
        // write your code here
        return findDuplicate(nums, 0, nums.length);
    }

    private int findDuplicate(int[] nums, int low, int hi) {
        if (low > hi)
            return low;
        int mid = (low + hi) / 2;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < mid)
                count++;
        }
        if (count > mid) {
            //则重复数字在[low，mid]
            return findDuplicate(nums, low, mid);
        } else {
            return findDuplicate(nums, mid, hi);
        }
    }

    //不用递归
    public int findDuplicateNoRecursion(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid)
                    count++;
            }
            if (count > mid) {
                hi = mid - 1;
            } else
                lo = mid + 1;
        }
        return lo;
    }
}
