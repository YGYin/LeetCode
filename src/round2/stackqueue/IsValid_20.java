package round2.stackqueue;

import java.util.Stack;

public class IsValid_20 {
    public boolean isValid(String s) {
        /*
            有效的括号
            主要思路：遇到左括号将对应右括号 push 入栈，遇到右括号 pop 出栈
            不匹配的情况
            1. 左括号多于右括号 -> 最后栈不为空
            2. 右括号多余左括号 -> 还未遍历完字符串遇到右括号时栈已经为空
            3. 左右符号不匹配
         */
        if (s.length() == 1)
            return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(')
                stack.push(')');
            else if (ch == '[')
                stack.push(']');
            else if (ch == '{')
                stack.push('}');
                // 遇到右括号
            else if (stack.isEmpty() || stack.peek() != ch)
                return false;
            else
                stack.pop();
        }

        // 最后看栈是否为空
        return stack.isEmpty();
    }
}
