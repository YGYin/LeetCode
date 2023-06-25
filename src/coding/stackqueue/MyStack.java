package coding.stackqueue;

import java.util.LinkedList;
import java.util.Queue;

/*
    用一个队列模拟栈的行为
    核心在于，每次 pop 前将前面 size - 1 个元素再重新加入到队列尾部
    实现 top 时要注意，通过 poll 获取了队列尾(栈顶)元素时，需要再将其加入到队列尾部
 */
public class MyStack {
    Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<Integer>();
    }

    public void push(int x) {
        queue.add(x);
    }

    public int pop() {
        rePosition();
        return queue.poll();
    }

    public int top() {
        rePosition();
        int res = queue.poll();
        queue.add(res);
        return res;
    }

    public boolean empty() {
        return queue.isEmpty();
    }

    private void rePosition() {
        int size = queue.size() - 1;
        while (size-- > 0)
            queue.add(queue.poll());
    }
}
