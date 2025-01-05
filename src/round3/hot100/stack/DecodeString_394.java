package round3.hot100.stack;

import java.util.Deque;
import java.util.LinkedList;

public class DecodeString_394 {
    /*
        字符串解码
        分别用两个栈来储存数字和储存字符串
        1. 遇到数字(多位)，数字 * 10 后再累加当前数字
        2. 遇到左括号，将当前的字符串和当前的倍数分别入栈，并重置当前字符串和当前倍数
        3. 遇到右括号，解码
            - 弹出数字 times 为对应倍数
            - 弹出字符串为左括号前的字符串，也就是原来的字符串，当前字符串为括号内的字符串
            - 再将原来的字符串拼接对应 times 个当前字符串
        4. 遇到字母，直接 append 到当前字符串
     */
    public String decodeString(String s) {
        if (s.length() <= 1)
            return s;

        // 新建栈用于储存字符串和数字
        Deque<String> strStack = new LinkedList<>();
        Deque<Integer> countStack = new LinkedList<>();
        // 定义变量用于记录当前括号内的字符串和当前的倍数
        String curStr = "";
        int k = 0;
        // 读取字符串
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // 遇到多位数字，更新 k
            if (Character.isDigit(ch))
                k = k * 10 + (ch - '0');
                // 遇到左括号，将当前的字符串和当前的倍数分别入栈，并重置当前字符串和当前倍数
            else if (ch == '[') {
                strStack.push(curStr);
                curStr = "";
                countStack.push(k);
                k = 0;
            }
            // 遇到右括号，解码
            else if (ch == ']') {
                // 弹出左括号前的之前的字符串
                String prevStr = strStack.pop();
                StringBuilder builder = new StringBuilder(prevStr);
                // 弹出对应倍数，prev 拼接 kTimes * curStr
                int kTimes = countStack.pop();
                for (int j = 0; j < kTimes; j++)
                    builder.append(curStr);
                // 更新当前字符串
                curStr = builder.toString();
            }
            // 遇到字母，直接 append 到当前字符串
            else
                curStr += ch;
        }
        return curStr;
    }
}
