package round2.hot100.stack;

import java.util.Deque;
import java.util.LinkedList;

public class DecodeString_394 {
    // 字符串解码
    public String decodeString(String s) {
        // 记录倍数
        Deque<Integer> kStack = new LinkedList<>();
        // 记录括号内的字符串
        Deque<String> strStack = new LinkedList<>();
        // 构建目标字符串
        StringBuilder res = new StringBuilder();

        int k = 0;
        // 遍历字符串
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // 有可能为数字，字符，左右括号
            // 如果为数字更新 k，有可能为多位数
            if (Character.isDigit(ch))
                k = k * 10 + (ch - '0');
                // 如果为字符就先加入到 builder 中
            else if (Character.isLowerCase(ch) || Character.isUpperCase(ch))
                res.append(ch);
            else if (ch == '[') {
                // 遇到左括号，k 需要入栈，已有字符串也入栈，然后重置对应变量
                kStack.push(k);
                k = 0;
                strStack.push(res.toString());
                res = new StringBuilder();
            } else {
                // 遇到右括号分别 pop 出栈
                int curK = kStack.pop();
                // 弹出左括号前的字符串，现在 res 记录的为括号内的字符串
                String prevStr = strStack.pop();
                // 先拼接 n 次 括号内的字符串
                StringBuilder temp = new StringBuilder();
                for (int j = 0; j < curK; j++)
                    temp.append(res);

                // 实际字符串则为 prevStr + 当前拼接字符串，更新 res
                res = new StringBuilder(prevStr + temp);
            }
        }
        return res.toString();
    }
}
