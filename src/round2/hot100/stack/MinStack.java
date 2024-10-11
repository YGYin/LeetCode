package round2.hot100.stack;

import java.util.Deque;
import java.util.LinkedList;

public class MinStack {
    /*
        最小栈
        可以使用两个栈来实现，一个栈储存实际数据，另外一个栈储存当前的最小值
        最小栈需要先压入一个 MAX 值作为初始值
        这样每次 push 就同时在两个栈分别压入实际数据和当前最小值，pop 同理
        每次 top 就返回数据栈栈顶，getMin 就返回最小栈栈顶
    */
    Deque<Integer> data;
    Deque<Integer> minVal;

    public MinStack() {
        data = new LinkedList<>();
        minVal = new LinkedList<>();
        minVal.push(Integer.MAX_VALUE);
    }

    // 同时 push 实际数据和当前最小值
    public void push(int val) {
        data.push(val);
        minVal.push(Math.min(minVal.peek(), val));
    }

    public void pop() {
        if (!data.isEmpty()) {
            data.pop();
            minVal.pop();
        }
    }

    public int top() {
        if (!data.isEmpty())
            return data.peek();
        throw new RuntimeException("Data stack is empty");
    }

    public int getMin() {
        if (!minVal.isEmpty())
            return minVal.peek();
        throw new RuntimeException("MinVal stack is empty");
    }
}