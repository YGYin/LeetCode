package round2.hot100.stack;

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
        // 特判
        if (s.isEmpty())
            return 0;
        // 新建栈储存下标
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        int res = 0;
        // 遍历 str
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // 左括号直接入栈
            if (ch == '(')
                stack.push(i);
            else {
                // 先 pop
                stack.pop();
                // 为空说明没有匹配或者 pop 的为 -1，将当前右括号 push 回栈
                if (stack.isEmpty())
                    stack.push(i);
                else
                    res = Math.max(res, i - stack.peek());
            }
        }
        return res;
    }
}
