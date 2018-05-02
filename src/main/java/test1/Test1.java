package test1;

import java.util.HashMap;
import java.util.Map;

public class Test1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0, complement; i < nums.length; i++) {
            complement = target - nums[i];
            //找到了一对
            if (map.containsKey(complement)){
                return new int[]{map.get(complement),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}
