package lintCodeProblem.convertStringToInt.oneThreeTwoMode636;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.Buffer;
import java.util.Scanner;
import java.util.Stack;

/*
* 给你一个 n 个整数的序列 a1,a2,...,an，一个 132 模式是对于一个子串 ai,aj,ak，
* 满足 i < j < k 和 ai < ak < aj。设计一个算法来检查输入的这 n 个整数的序列中是否存在132模式。
n 会小于 20,000。
*
* */
public class OneThreeTwoMode {
    public boolean find132pattern(int[] nums) {
        int third = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i]<third)   //只要找到第一个数就ok了
                return true;
            else while (!stack.empty() && nums[i] > stack.peek()) {
                third = stack.pop();
            }
            stack.push(nums[i]);  //如果nums[i]小于栈顶，但是大于third直接压栈
        }
        return false;
    }


    public static void main(String[] args) {
        OneThreeTwoMode oneThreeTwoMode = new OneThreeTwoMode();
        File file = new File("E:\\jianGuoTongBu\\javaproject\\maven\\algorithm\\src\\main\\resources\\636OneThreeTwoMode");
        BufferedReader bf = null;
        String[] splits = null;
        int length = 0;
        try {
            bf = new BufferedReader(new FileReader(file));
            String str = bf.readLine();
            splits = str.split("\\s|,");
            length = splits.length;
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        int a[] = new int[length];
        for (int i = 0; i < length; i++) {
            a[i] = Integer.parseInt(splits[i]);
        }
        System.out.println(oneThreeTwoMode.find132pattern(a));
    }
}
