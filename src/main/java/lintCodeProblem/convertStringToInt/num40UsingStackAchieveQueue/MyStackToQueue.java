package lintCodeProblem.convertStringToInt.num40UsingStackAchieveQueue;

import java.util.Stack;

/*
* 正如标题所述，你需要使用两个栈来实现队列的一些操作。

队列应支持push(element)，pop() 和 top()，其中pop是弹出队列中的第一个(最前面的)元素。

pop和top方法都应该返回第一个元素的值。
*
* */
public class MyStackToQueue {
    private Stack<Integer> firstStack;
    private Stack<Integer> secondStack;
    public MyStackToQueue() {
        firstStack = new Stack<Integer>();
        secondStack = new Stack<Integer>();
    }

    public void push(int element) {
        firstStack.push(element);
    }
    public int pop() {
        if (secondStack.isEmpty()){
            if (firstStack.isEmpty())
                return Integer.parseInt(null);
            while(!firstStack.isEmpty())
                secondStack.push(firstStack.pop());
        }

        return secondStack.pop();
    }


    public int top() {
        if (secondStack.isEmpty()){
            if (firstStack.isEmpty())
                return Integer.parseInt(null);
            while(!firstStack.isEmpty())
                secondStack.push(firstStack.pop());
        }
        return secondStack.peek();
    }
}
