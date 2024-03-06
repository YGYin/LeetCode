package round1.stack_queue;

import java.util.ArrayDeque;

public class RemoveDuplicates_1047 {
    public String removeDuplicates(String s) {
        // 双向队列
        ArrayDeque<Character> deque = new ArrayDeque<>();
        char ch;
        // 遍历字符串，原理类似于消消乐
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            // 如果遇到新元素，栈已经为空或者不相同，直接 push
            if (deque.isEmpty() || ch != deque.peek())
                deque.push(ch);
                // 与栈顶相同，pop 掉
            else
                deque.pop();
        }
        /*
            String str = "";
            while (!deque.isEmpty())
                str = deque.pop() + str;
         */
        StringBuilder str = new StringBuilder();
        while (!deque.isEmpty())
            str.insert(0, deque.pop());

        return str.toString();
    }
}
