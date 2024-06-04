package round1.hot100.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestValidParentheses_32 {
    // 建立一个栈，利用找到一对（）就出栈的原则
    // 找出最长有效（格式正确且连续！）括号子串的长度
    // 因为存入的是下标，通过栈将问题转化为求解最大间隔的问题
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0)
            return 0;
        // 用来存放下标
        Deque<Integer> stack = new ArrayDeque<>();
        // 防止第一个字符为 ')' 栈为空产生异常
        stack.push(-1);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // 如果为左括号，则把对应的的下标入栈
            if (ch == '(')
                stack.push(i);
                // 如果为右括号
            else {
                // 遇到右括号先出栈，栈顶弹出的有可能为 -1
                stack.pop();
                // 如果栈为空，说明刚弹出的为 -1，该右括号落单需重新入栈
                if (stack.isEmpty())
                    stack.push(i);
                    // 当前全部括号 - 剩余未配对的括号的最后位置
                else
                    res = Math.max(res, i - stack.peek());
            }
        }
        return res;
    }
}
