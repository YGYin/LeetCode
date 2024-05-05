package round1.hot100.stack;

import java.util.Stack;

public class MinStack {
    // 定义数据栈和辅助栈
    private Stack<Integer> data;
    private Stack<Integer> helper;

    // 155. 最小栈，要维持栈顶为最小元素

    // 初始化两个栈
    public MinStack() {
        data = new Stack<>();
        helper = new Stack<>();
    }

    public void push(int val) {
        // 数据栈直接 push
        data.push(val);
        // 辅助栈为空，或者加入的元素小于栈顶元素时直接加入辅助栈
        if (helper.isEmpty() || val <= helper.peek())
            helper.push(val);
        else // 同步添加元素，但复制当前最小值
            helper.push(helper.peek());
    }

    public void pop() {
        // 只要不为空，两个栈同时 pop
        if (!data.isEmpty()) {
            data.pop();
            helper.pop();
        }
    }

    public int top() {
        // 返回实际的数据栈顶，即当前最小元素
        if (!data.isEmpty())
            return data.peek();
        throw new RuntimeException("Data stack is empty");
    }

    public int getMin() {
        // 返回辅助栈顶，即当前最小元素
        if (!helper.isEmpty())
            return helper.peek();
        throw new RuntimeException("Data stack is empty");
    }
}

