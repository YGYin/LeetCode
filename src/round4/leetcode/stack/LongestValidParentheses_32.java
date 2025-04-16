package round4.leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;

public class LongestValidParentheses_32 {
    /*
        最长有效括号
        只包含 ( 和 )，使用 栈，储存该符号对应的下标，
        先压入一个 -1，避免第一个就是 ) 的情况
        1. 遇到左括号，直接将其下标入栈
        2. 遇到右括号，先 pop，
            如果栈为空说明刚刚 pop 的为 -1，右括号落单需要入栈
            如果不为空，则用 当前全部括号 - 未匹配的括号起始位置
            计算时栈顶为未匹配的未匹配的括号起始位置
     */
    public int longestValidParentheses(String s) {
        if (s.length() <= 1)
            return 0;

        // 新建栈，压入 -1，避免一开始为右括号 pop 为空
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);

        int maxLen = 0;
        // 遍历字符串
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // 如果是左括号直接 push 下标
            if (ch == '(')
                stack.push(i);
            else {
                // 先 pop，看是否为空，为空则压回当前右括号下标
                stack.pop();
                if (stack.isEmpty())
                    stack.push(i);
                    // 不为空，计算更新长度
                else
                    maxLen = Math.max(maxLen, i - stack.peek());
            }
        }

        return maxLen;
    }
}
