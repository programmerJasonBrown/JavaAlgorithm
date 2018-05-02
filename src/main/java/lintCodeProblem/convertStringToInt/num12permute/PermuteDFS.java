package lintCodeProblem.convertStringToInt.num12permute;

import java.util.ArrayList;
import java.util.List;

public class PermuteDFS {
    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> resOne = new ArrayList<Integer>();
        if (nums.length == 0) {
            res.add(resOne);
            return res;
        }
        boolean[] isVisted = new boolean[nums.length];
        permuteDFS(res, resOne, isVisted, 0, nums);
        return res;
    }

    private void permuteDFS(List<List<Integer>> res, List<Integer> resOne, boolean[] isVisted, int count, int[] nums) {
        if (count == nums.length) {
            List<Integer> resOneTemp = new ArrayList<Integer>(resOne);
            res.add(resOneTemp);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!isVisted[i]) {
                isVisted[i] = true;
                resOne.add(nums[i]);
                permuteDFS(res, resOne, isVisted, count + 1, nums);
                resOne.remove(resOne.indexOf(nums[i]));
                isVisted[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        PermuteDFS permuteDFS = new PermuteDFS();
        int[] nums = {1,2,3};
        permuteDFS.permute(nums);
        System.out.println();
    }
}
