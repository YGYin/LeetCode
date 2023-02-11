package ds_primer;

import java.util.Stack;

public class IsValid_20 {
    public boolean isValid(String s) {
        if (s.length() == 1)
            return false;

        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(')
                stack.push(')');
            else if (ch == '[')
                stack.push(']');
            else if (ch == '{')
                stack.push('}');
            else if (stack.isEmpty() || stack.pop() != ch)
                return false;
        }

        return stack.isEmpty();
    }
}
