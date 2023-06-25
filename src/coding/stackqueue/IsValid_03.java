package coding.stackqueue;

import java.util.Stack;

public class IsValid_03 {
    /*
        思路：
            不匹配分为三种情况
            1. 左括号多了
            2. 右括号多了
            3. 左右括号数量相等，当不匹配
            每当遍历到一个左括号时，往栈里 push 对应的右括号
            当栈为空或者右符号和栈顶符号不相等时，不匹配
            如果两个符号相等，pop 出栈顶符号
            最后检查栈是否为空，不为空说明左括号多了，不匹配
        时间复杂度: O(n)
        空间复杂度: O(n)
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
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
        return stack.isEmpty();
    }
}
