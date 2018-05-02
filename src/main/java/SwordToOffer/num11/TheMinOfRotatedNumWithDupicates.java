package SwordToOffer.num11;

public class TheMinOfRotatedNumWithDupicates {
/*    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start < end) {
            while (nums[start] == nums[end] && start != end)
                end--;
            if (nums[start] < nums[end])
                return nums[start];
            mid = (start + end) / 2;
            if (nums[mid] >= nums[start])
                start = mid + 1;
            else
                end = mid;
        }
        return nums[start];
    }*/


    public static int findMin(int[] nums) {
        return findMin(nums, 0, nums.length - 1);
    }

    public static int findMin(int[] nums, int lo, int hi) {
        if (nums[lo] < nums[hi] || lo == hi) {
            return nums[lo];
        }
        if (nums[lo] == nums[hi] && lo < hi)
            hi--;
        int mid = (lo + hi) / 2;
        if (nums[mid] >= nums[lo])
            return findMin(nums, mid + 1, hi);
        else
            return findMin(nums, lo + 1, mid);
    }
}
