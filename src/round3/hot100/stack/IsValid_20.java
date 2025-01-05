package round3.hot100.stack;

import java.util.Deque;
import java.util.LinkedList;

public class IsValid_20 {
    /*
        有效的括号
        1. 遇到左括号就压入对应右括号
        2. 遇到右括号，先看栈是否为空，不为空进行匹配
        3. 最后判断栈是否为空
     */
    public boolean isValid(String s) {
        if (s.length() % 2 == 1)
            return false;

        // 新建栈用于储存括号
        Deque<Character> stack = new LinkedList<>();
        // 遍历字符串 s
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // 如果遇到左括号则压入对应右括号
            if (ch == '(')
                stack.push(')');
            else if (ch == '{')
                stack.push('}');
            else if (ch == '[')
                stack.push(']');
                // 如果为右括号，看栈是否为空（右括号多于左括号的情况），不为空再进行匹配
            else if (stack.isEmpty() || ch != stack.peek())
                return false;
            else
                stack.pop();
        }
        // 最后检查栈是否刚好为空
        return stack.isEmpty();
    }
}
