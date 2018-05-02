package lintCodeProblem.convertStringToInt.num12StackWithMinNum;

import java.util.Stack;

public class MinStackUsingTwoStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStackUsingTwoStack() {
        // do intialization if necessary
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int number) {
        if (stack.isEmpty()) {
            stack.push(number);
            minStack.push(number);
        } else {
            stack.push(number);
            if (minStack.peek() > number)
                minStack.push(number);
            else
                minStack.push(minStack.peek());
    }
    }

    public int pop() {
        if (stack.isEmpty())
            return Integer.parseInt(null);
        minStack.pop();
        return stack.pop();
    }

    public int min() {
        return minStack.peek();
    }

}
