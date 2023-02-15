package ds_primer;

import java.util.Stack;

public class MyQueue_232 {
    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public MyQueue_232() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if (outStack.isEmpty())
            while (inStack.isEmpty())
                outStack.push(inStack.pop());

        return outStack.pop();
    }

    public int peek() {
        if (outStack.isEmpty())
            while (inStack.isEmpty())
                outStack.push(inStack.pop());

        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }
}
