package com.hans.stack;

import java.util.Stack;

/**
 * 문제 : Min Stack
 *
 * 설명
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * Implement the MinStack class:
 * MinStack() initializes the stack object.
 * void push(int val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 *
 * Example 1:
 * Input
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * Output
 * [null,null,null,null,-3,null,0,-2]
 *
 * Explanation
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin(); // return -3
 * minStack.pop();
 * minStack.top();    // return 0
 * minStack.getMin(); // return -2
 */
class MinStack {
    Stack<Integer> stack;
    Stack<Integer> supportingStack;
    public MinStack() {
        this.stack = new Stack<>();
        this.supportingStack = new Stack<>();
    }

    public void push(int val) {
        this.stack.push(val);
        if(this.supportingStack.isEmpty() || this.supportingStack.peek() >= val)
            this.supportingStack.push(val);
    }

    public void pop() {
        if (!this.supportingStack.isEmpty() && stack.peek().equals(supportingStack.peek()))
            this.supportingStack.pop();
        this.stack.pop();
    }

    public int top() {
        if(this.stack.isEmpty())
            return -1;
        return this.stack.peek();

    }

    public int getMin() {
        if(this.supportingStack.isEmpty())
            return -1;
        return this.supportingStack.peek();
    }
}

public class Ex05 {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin(); // return -3
        minStack.pop();
        minStack.top();    // return 0
        minStack.getMin(); // return -2
    }
}
