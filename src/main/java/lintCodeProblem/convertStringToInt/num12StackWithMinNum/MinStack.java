package lintCodeProblem.convertStringToInt.num12StackWithMinNum;

import java.util.Stack;

public class MinStack {
    private int min;
    private Stack<Long> stack;

    public MinStack() {
        // do intialization if necessary
        min = Integer.MAX_VALUE;
        stack = new Stack<Long>();
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        if (stack.empty()) {
            stack.push(0L);
            min = number;
        } else {
            stack.push((long) (min - number));
            if (min > number)
                min = number;
        }

    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        if (stack.empty())
            return Integer.parseInt(null);
        int popNum;
        if (stack.peek() > 0) {
            popNum = min;
            min = (int) (min + stack.pop());
        } else {
            //表示要出栈的元素大于最小值。
            popNum = (int) (min - stack.pop());
        }
        return popNum;
    }

    /*
     * @return: An integer
     */
    public int min() {
        // write your code here
        return min;
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(-1);
        stack.push(-2);
        System.out.println(stack.min());
        System.out.println(stack.pop());
        stack.push(-3);
        stack.push(3);
        stack.push(2);
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }

}
