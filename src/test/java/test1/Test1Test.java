package test1;

import org.junit.Test;

public class Test1Test {

    @Test
    public void twoSum() {
        Test1 test1 = new Test1();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] ints = test1.twoSum(nums, target);
        System.out.println(ints[0]+" "+ints[1]);
    }

}