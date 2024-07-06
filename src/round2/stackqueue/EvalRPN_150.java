package round2.stackqueue;

import java.util.Deque;
import java.util.LinkedList;

public class EvalRPN_150 {
    /*
        逆波兰表达式求值
        遇到数字则入栈；遇到算符则取出栈顶两个数字进行计算，并将结果压入栈中
     */
    public int evalRPN(String[] tokens) {
        // 首先定义栈
        Deque<Integer> stack = new LinkedList<>();
        for (String s : tokens) {
            // 如果遇到是 + - * /
            // 弹出栈顶两个数字进行计算，并将结果压入栈中
            if ("+".equals(s))
                stack.push(stack.pop() + stack.pop());
                // - 和 / 第一个 pop 出来的为被减数或者被除数
            else if ("-".equals(s))
                stack.push(-stack.pop() + stack.pop());
            else if ("*".equals(s))
                stack.push(stack.pop() * stack.pop());
            else if ("/".equals(s)) {
                int temp1 = stack.pop();
                int temp2 = stack.pop();
                stack.push(temp2 / temp1);
            }
            // 是数字，记得将 String 转换为 Integer
            else
                stack.push(Integer.valueOf(s));
        }
        // 最后 pop 出来的为结果
        return stack.pop();
    }
}
