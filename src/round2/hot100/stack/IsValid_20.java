package round2.hot100.stack;

import java.util.Deque;
import java.util.LinkedList;

public class IsValid_20 {
    public boolean isValid(String s) {
        /*
         * 1. 遇到左括号就压入对应右括号
         * 2. 遇到右括号，先看栈是否为空，不为空进行匹配
         * 3. 最后判断栈是否为空
         */
        if (s.length() == 1)
            return false;

        // 新建栈
        Deque<Character> stack = new LinkedList<>();
        // 遍历字符串
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(')
                stack.push(')');
            else if (ch == '[')
                stack.push(']');
            else if (ch == '{')
                stack.push('}');
            else if (stack.isEmpty() || ch != stack.peek())
                return false;
            else
                stack.pop();
        }
        // 最后检查栈是否为空
        return stack.isEmpty();
    }
}
