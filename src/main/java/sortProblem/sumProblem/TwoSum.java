package sortProblem.sumProblem;

import java.util.ArrayList;
import java.util.List;

public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        // write your code here
        int[] index = new int[2];
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]);
        }

        for (int i = 0; i < numbers.length-1; i++) {
            int complement = target - numbers[i];
            list.set(i,null);
            if (list.contains(complement)) {
                index[0] = i;
                index[1] = list.indexOf(complement);
                break;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] numbers = { 2, 7, 11, 15};
        TwoSum sum = new TwoSum();
        int[] index = sum.twoSum(numbers, 9);
        for (int x : index) {
            System.out.println(x);
        }
    }
}
