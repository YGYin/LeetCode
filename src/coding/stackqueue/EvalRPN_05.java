package coding.stackqueue;

import java.util.Stack;

public class EvalRPN_05 {
    /*
        逆波兰表达式为后序表达式，左右中
        用栈操作运算：遇到数字则入栈；遇到算符则取出栈顶两个数字进行计算，并将结果压入栈中
        所以入栈后遇到运算符号 pop 出来的第一个数为减数或除数
        第二个 pop 出来的数才为被操作数
        导致减法和除法需要注意处理
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+"))
                stack.push(stack.pop() + stack.pop());
            else if (tokens[i].equals("-"))
                stack.push(-stack.pop() + stack.pop());
            else if (tokens[i].equals("*"))
                stack.push(stack.pop() * stack.pop());
            else if (tokens[i].equals("/")) {
                int temp1 = stack.pop();
                int temp2 = stack.pop();
                stack.push(temp2 / temp1);
            } else
                stack.push(Integer.valueOf(tokens[i]));
        }

        return stack.pop();
    }
}
