package coding.stackqueue;

import java.util.Stack;

public class RemoveDuplicates_04 {
    public String removeDuplicates(String s) {
        int strlen = s.length();
        if (strlen == 1)
            return s;

        Stack<Character> stack = new Stack<>();
        char ch;
        for (int i = 0; i < strlen; i++) {
            ch = s.charAt(i);
            if (!stack.isEmpty() && ch == stack.peek())
                stack.pop();
            else
                stack.push(ch);
        }

        String res = "";
        while (!stack.isEmpty())
            res = stack.pop() + res;

        return res;
    }
}
