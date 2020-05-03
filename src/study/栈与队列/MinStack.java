package study.栈与队列;

import java.util.LinkedList;

/**
 * @description:
 * @author: WangPingYin
 * @time: 2020/3/17 16:51
 */

class MinStack {
    private LinkedList<Integer> dataStack = null;
    private LinkedList<Integer> minStack = null;

    /** initialize your data structure here. */
    public MinStack() {
        dataStack = new LinkedList<>();
        minStack = new LinkedList<>();
    }

    public void push(int x) {
        dataStack.push(x);
        if (minStack.isEmpty()) minStack.push(x);
        else                    minStack.push(Math.min(minStack.peek(), x));
    }

    public void pop() {
        if(!minStack.isEmpty()) minStack.pop();
        if(!dataStack.isEmpty()) dataStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}