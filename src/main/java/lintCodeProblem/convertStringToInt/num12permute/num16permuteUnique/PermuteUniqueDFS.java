package lintCodeProblem.convertStringToInt.num12permute.num16permuteUnique;

import java.util.ArrayList;
import java.util.List;

public class PermuteUniqueDFS {
    public List<List<Integer>> permuteUnique(int[] nums) {
        // write your code here
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> resOne = new ArrayList<Integer>();
        if (nums.length == 0) {
            res.add(resOne);
            return res;
        }

        return res;
    }
}
