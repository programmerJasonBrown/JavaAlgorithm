package lintCodeProblem.convertStringToInt.num12permute;

import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;

public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> resOne = new ArrayList<Integer>();
        if (nums.length == 0) {
            res.add(resOne);
            return res;
        }
        getResList(res, nums, 0, resOne);
        return res;
    }

    private void getResList(List<List<Integer>> res, int[] nums, int index, List<Integer> resOne) {
        if (index == nums.length - 1) {
            resOne.add(nums[index]);
            List<Integer> restempOne = new ArrayList<Integer>(resOne);
            res.add(restempOne);
            resOne.remove(index);
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            resOne.add(nums[index]);
            getResList(res, nums, index + 1, resOne);
            resOne.remove(index);
            List<Integer> resTemp = resOne;

            swap(nums, index, i); //再换回来

        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Permute permute = new Permute();
        permute.permute(nums);
        System.out.println();
    }
}
