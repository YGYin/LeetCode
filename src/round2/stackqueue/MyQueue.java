package round2.stackqueue;

import java.util.Stack;

public class MyQueue {
    /*
        用栈实现队列
        1. 用两个栈，分别为入栈和出栈
        2. push 正常推入入栈
        3. peek 的时候看出栈是否为空，不为空直接获取出栈顶部元素
            出栈为空时将入栈元素全部推入出栈，再获取出栈顶部元素
            pop 同理，直接复用 peek
        4. 为空直接检查出入栈是否都为空
     */

    Stack<Integer> in;
    Stack<Integer> out;

    public MyQueue() {
        // 对出入栈初始化
        this.in = new Stack<>();
        this.out = new Stack<>();
    }

    public void push(int x) {
        in.push(x);
    }

    public int pop() {
        // 复用 peek 再 pop 出栈栈顶元素
        peek();
        return out.pop();
    }

    public int peek() {
        if (!out.isEmpty())
            return out.peek();

        // 出栈为空时，将入栈的元素全部倒入出栈
        while (!in.isEmpty())
            out.push(in.pop());

        return out.peek();
    }

    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}
