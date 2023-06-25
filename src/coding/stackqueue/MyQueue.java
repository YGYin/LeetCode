package coding.stackqueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
    用两个栈，一个输入栈一个输出栈来模拟队列的行为
    当输入栈的元素全部导入到输出栈时，可改变出口方向
 */
public class MyQueue {

    Stack<Integer> stackIn;
    Stack<Integer> stackOut;

    public MyQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    public void push(int x) {
        stackIn.push(x);
    }

    // 输出栈为空时，需要把输入栈里面的元素全部导入进来，再弹出数据
    public int pop() {
        inToOut();
        return stackOut.pop();
    }

    public int peek() {
        inToOut();
        return stackOut.peek();
    }

    // 出入栈都为空的时候说明模拟的队列为空
    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }

    private void inToOut() {
        // 如果出栈不为空再加入元素的话顺序会乱
        if (!stackOut.isEmpty())
            return;
        // 出栈为空时，把入栈的所有元素都放到出栈中
        while (!stackIn.isEmpty())
            stackOut.push(stackIn.pop());
    }
}
