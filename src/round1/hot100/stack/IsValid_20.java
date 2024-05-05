package round1.hot100.stack;

import java.util.Stack;

public class IsValid_20 {
    public boolean isValid(String s) {
        // 有效的括号
        /*
            考虑三种不匹配的情况
            1. 左括号多了，遍历完栈不为空
            2. 右括号多了，还没遍历完字符串栈已经空了
            3. 符号不匹配，当前符号和栈顶符号不匹配
         */
        // 主要方法：遇到左括号往栈里压对应右括号，遍历到右括号匹配则弹出
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(')
                stack.push(')');
            else if (ch == '[')
                stack.push(']');
            else if (ch == '{')
                stack.push('}');
            else if (stack.isEmpty() || stack.peek() != ch)
                return false;
            else
                stack.pop();
        }
        // 看栈是否为空
        return stack.isEmpty();
    }

}
