package test5MinStack;

import java.util.Stack;

public class MinStack {

    long min;
    Stack<Long> stack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new Stack<Long>();
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(0L);
            min = x;
        } else {
            stack.push(x - min);
            min = Math.min(min, x);
        }
    }

    public void pop() {
        if (stack.isEmpty())
            return;
        //<0意味着，当初push的时候x要小于min  当初push(x-minpre); 所以要修正min到minpre
        //minpre = min - (x - minpre); 试中  min = x peek = x - minpre
        long peek = stack.peek();
        if (peek < 0) {
            min = min - peek;
        }
        stack.pop();
    }

    public int top() {
        long peek = stack.peek();
        //peek<0 means min就是当初push进来的x值
        //否则 当初push进来的值为min+peek  因为 push（x-min）但这个x并没有修改min
        if(peek<0)
            return (int)min;
        else
            return (int)(min+peek);

    }

    public int getMin() {
        return (int)min;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(2147483647);
        System.out.println(minStack.getMin());
        minStack.push(-2147483648);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */