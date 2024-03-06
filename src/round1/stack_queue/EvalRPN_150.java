package round1.stack_queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class EvalRPN_150 {
    public int evalRPN(String[] tokens) {
        // 逆波兰表达式为后序表达式
        // 遇到数字则入栈
        // 遇到算符则取出栈顶两个数字进行计算，并将结果压入栈中
        Deque<Integer> deque = new LinkedList<>();
        String str;
        for (int i = 0; i < tokens.length; i++) {
            // token 为合法 token，无需额外处理意外情况
            str = tokens[i];
            if ("+".equals(str))
                deque.push(deque.pop() + deque.pop());
                // - pop 出来的第一个为减数
            else if ("-".equals(str))
                deque.push(-deque.pop() + deque.pop());
            else if ("*".equals(str))
                deque.push(deque.pop() * deque.pop());
            else if ("/".equals(str)) {
                // 除数和被除数
                int temp1 = deque.pop();
                int temp2 = deque.pop();
                deque.push(temp2 / temp1);
            }
            // 如果是数字直接 push
            else
                deque.push(Integer.valueOf(str));
        }
        // 栈剩下的最后一个数则为最终运算结果
        return deque.pop();
    }
}
