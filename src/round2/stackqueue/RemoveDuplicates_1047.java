package round2.stackqueue;

import java.util.ArrayDeque;

public class RemoveDuplicates_1047 {
    /*
        删除字符串中的所有相邻重复项
        类似于消消乐
     */
    public String removeDuplicates(String s) {
        ArrayDeque<Character> deque = new ArrayDeque<>();
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            // 相同就 pop 出来，栈不为空且不相同就 push（比较前要先看栈是否为空）
            if (deque.isEmpty() || ch != deque.peek())
                deque.push(ch);
            else // 和栈顶相等
                deque.pop();
        }
        // 因为栈 FILO 需要倒序构建字符串
        StringBuilder res = new StringBuilder();
        while (!deque.isEmpty())
            res.insert(0, deque.pop());

        return res.toString();
    }
}
