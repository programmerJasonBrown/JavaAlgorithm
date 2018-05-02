package SwordToOffer.num11;

public class TheMinOfRotatedNumWithoutDupicates {
    public static int minNum(int[] nums) {
        return minNum(nums, 0, nums.length - 1);
    }

    public static int minNum(int[] nums, int lo, int hi) {
        if (nums[lo] < nums[hi] || lo == hi) {
            return nums[lo];
        }
        int mid = (lo + hi) / 2;
        if (nums[mid] >= nums[lo])
            return minNum(nums, mid + 1, hi);
        else
            return minNum(nums, lo + 1, mid);
    }

    public static void main(String[] args) {
        int[] nums = {10,1,10,10,10};
        System.out.println("min = " + TheMinOfRotatedNumWithoutDupicates.minNum(nums));
    }
}
