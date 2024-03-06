package round1.stack_queue;

import java.util.Stack;

public class MyQueue {
    // 使用两个栈模拟队列
    Stack<Integer> in;
    Stack<Integer> out;

    public MyQueue() {
        this.in = new Stack<>();
        this.out = new Stack<>();
    }

    public void push(int x) {
        // 直接 push 进入栈
        in.push(x);
    }

    public int pop() {
        // 出栈不为空时，直接从出栈 pop 获取元素
        if (!out.isEmpty())
            return out.pop();
        // 出栈为空时，将入栈中的元素全部倒进出栈中
        while (!in.isEmpty())
            out.push(in.pop());
        // 然后再 pop 获取第一个元素
        return out.pop();
    }

    public int peek() {
        // 复用 pop 操作，再把弹出的元素重新加入到出栈的栈顶
        int res = this.pop();
        out.push(res);
        return res;
    }

    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}
