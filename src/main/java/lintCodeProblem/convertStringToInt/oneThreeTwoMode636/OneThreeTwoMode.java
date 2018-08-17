package lintCodeProblem.convertStringToInt.oneThreeTwoMode636;

import org.omg.CORBA.INTERNAL;

import java.util.Stack;

/*
* 给你一个 n 个整数的序列 a1,a2,...,an，一个 132 模式是对于一个子串 ai,aj,ak，
* 满足 i < j < k 和 ai < ak < aj。设计一个算法来检查输入的这 n 个整数的序列中是否存在132模式。
n 会小于 20,000。
*
* */
public class OneThreeTwoMode {
//    public boolean find132pattern(int[] nums) {
////        int third = Integer.MIN_VALUE;
////        Stack<Integer> stack = new Stack<Integer>();
////        for (int i = nums.length - 1; i >= 0; i--) {
////            if (nums[i]<third)   //只要找到第一个数就ok了
////                return true;
////            else while (!stack.empty() && nums[i] > stack.peek()) {
////                third = stack.pop();
////            }
////            stack.push(nums[i]);  //如果nums[i]小于栈顶，但是大于third直接压栈
////        }
////        return false;
////    }

    public static boolean is132pattern(int[] nums) {
        int third = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < third)
                return true;
            else if (!stack.isEmpty() && nums[i] > stack.peek()){
                third = stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }


    public static void main(String[] args) {

    }
}
