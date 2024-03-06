package round1.stack_queue;

import java.util.*;

public class MyStack {
    // 使用一个双向队列实现，但不能从后面 pop
    Deque<Integer> queue;

    public MyStack() {
        queue = new ArrayDeque<>();
    }

    public void push(int x) {
        queue.addLast(x);
    }

    public int pop() {
        // pop 时，将前 size - 1 个元素全部重新塞回到队列末尾
        int size = queue.size();
        for (int i = 0; i < size - 1; i++)
            queue.addLast(queue.pollFirst());

        // 不存在非法操作
        return queue.pollFirst();
    }

    public int top() {
        // 不存在非法操作
        return queue.peekLast();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
