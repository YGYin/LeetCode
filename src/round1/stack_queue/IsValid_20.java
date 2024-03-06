package round1.stack_queue;

import java.util.Stack;

public class IsValid_20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        // 遍历到左括号时，往栈里面压对应右括号
        // 三种情况不匹配
        // 1. 左括号多了，遍历完字符串栈不为空（最后判断即可）
        // 2. 符号不匹配，遍历到右括号时发现和栈弹出元素不一致
        // 3. 右括号多了，遍历到右括号但还未遍历完字符串时，发现栈已经空了
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(')
                stack.push(')');
            else if (ch == '{')
                stack.push('}');
            else if (ch == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.peek() != ch)
                return false;
            else // 栈顶为对应右括号，pop
                stack.pop();
        }
        // 判断栈是否为空
        return stack.isEmpty();
    }
}
