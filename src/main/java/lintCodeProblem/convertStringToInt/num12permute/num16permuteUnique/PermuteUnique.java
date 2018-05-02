package lintCodeProblem.convertStringToInt.num12permute.num16permuteUnique;

import java.util.ArrayList;
import java.util.List;

public class PermuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        // write your code here
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> resOne = new ArrayList<Integer>();
        if (nums.length == 0) {
            res.add(resOne);
            return res;
        }
        sort(nums, 0, nums.length - 1);
        getList(res, resOne, nums, 0);
        return res;
    }

    private void sort(int[] nums, int lo, int hi) {
        if (lo>=hi)
            return;
        int lt = lo, gt = hi, i = lo + 1;
        int v = nums[lo];
        while (i <= gt) {
            if (nums[i] > v) swap(nums,i,gt--);
            else if (nums[i] < v) swap(nums,i++,lt++);
            else i++;
        }
        sort(nums,lo,lt-1);
        sort(nums,gt+1,hi);
    }

    private void getList(List<List<Integer>> res, List<Integer> resOne, int[] nums, int count) {
        if (count == nums.length - 1) {
            resOne.add(nums[count]);
            List<Integer> resTemp = new ArrayList<Integer>(resOne);
            res.add(resTemp);
            resOne.remove(count);
            return;
        }
        for (int i = count; i < nums.length; i++) {
            if (i != count && nums[i] == nums[count])
                continue;
            if (i > count && nums[i] == nums[i - 1])
                continue;
            swap(nums, count, i);
            resOne.add(nums[count]);
            getList(res, resOne, nums, count + 1);
            swap(nums, count, i);
            resOne.remove(count);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2,1};
        PermuteUnique permuteUnique = new PermuteUnique();
        permuteUnique.permuteUnique(nums);

    }
}
