package round3.hot100.stack;

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

    // 初始化数据栈和最小栈，最小栈需要压入 INT_MAX 作为基底
    public MinStack() {
        data = new LinkedList<>();
        minVal = new LinkedList<>();
        minVal.push(Integer.MAX_VALUE);
    }

    // 同时 push，数据栈直接 push 当前值，最小栈 push 当前值和栈顶两者的较小值
    public void push(int val) {
        data.push(val);
        if (!minVal.isEmpty())
            minVal.push(Math.min(val, minVal.peek()));
        else
            minVal.push(val);
    }

    // 同时 pop，需要检查数据栈是否为空
    public void pop() {
        if (!data.isEmpty()) {
            data.pop();
            minVal.pop();
        }
    }

    // 返回数据栈栈顶
    public int top() {
        if (!data.isEmpty())
            return data.peek();
        throw new RuntimeException("Data Stack is Empty");
    }

    public int getMin() {
        if (!minVal.isEmpty())
            return minVal.peek();
        throw new RuntimeException("MinVal Stack is Empty");
    }
}
