package round4.leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;

public class IsValid_20 {
    /*
        有效的括号
        1. 遇到左括号就压入对应右括号
        2. 遇到右括号，先看栈是否为空，如果栈已经空了或者字符不匹配的话返回 false
        3. 最后判断栈是否为空
     */
    public boolean isValid(String s) {
        // 特判，一定能被 2 整除
        if (s.length() % 2 != 0)
            return false;

        // 新建栈储存括号
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // 遇到对应做括号压入又括号
            if (ch == '(')
                stack.push(')');
            else if (ch == '[')
                stack.push(']');
            else if (ch == '{')
                stack.push('}');
                // 如果栈已经空了，或者字符不匹配的话返回 false
            else if (stack.isEmpty() || stack.peek() != ch)
                return false;
            else // 匹配成功
                stack.pop();
        }

        // 最后看栈是否为空
        return stack.isEmpty();
    }
}
