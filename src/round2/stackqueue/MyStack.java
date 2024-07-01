package round2.stackqueue;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    /*
        用队列实现栈
        1. 不用双端队列 deque 的话，同样也只需要一个 queue
        2. 每次 push 时除了入队元素，其他元素全部重新排队到后面
     */

    Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        // 先将元素加入到队列
        queue.offer(x);
        // 再重新将前面的元素重新排列
        int qSize = queue.size();
        while (qSize-- > 1)
            queue.offer(queue.poll());
    }

    public int pop() {
        if (!queue.isEmpty())
            return queue.poll();
        return -1;
    }

    public int top() {
        if (!queue.isEmpty())
            return queue.peek();
        return -1;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
