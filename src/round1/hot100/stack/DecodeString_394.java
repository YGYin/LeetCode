package round1.hot100.stack;

import java.util.Deque;
import java.util.LinkedList;

public class DecodeString_394 {
    public String decodeString(String s) {
        int k = 0;
        StringBuilder res = new StringBuilder();
        // 记录倍数
        Deque<Integer> kStack = new LinkedList<>();
        // 记录字符
        Deque<String> resStack = new LinkedList<>();

        // 遍历字符串
        for (char ch : s.toCharArray()) {
            // 1. 如果是数字，记录为倍数 k
            //      有可能连续为数字，需要进位
            if (ch >= '0' && ch <= '9')
                k = k * 10 + (ch - '0');
                // 2. 如果为字母，加入到 res 的尾部
            else if (ch >= 'a' && ch <= 'z')
                res.append(ch);
                // 3. 如果为 [
            else if (ch == '[') {
                // 将当前的倍数和 res 字符串入栈，并 reset 临时变量
                kStack.push(k);
                resStack.push(res.toString());
                // reset
                k = 0;
                res = new StringBuilder();
            }
            // 4. 如果为 ]
            else {
                // 分别出栈
                int curK = kStack.pop();
                String lastRes = resStack.pop();

                // 拼接字符串，res = lastRes + curK * res
                StringBuilder temp = new StringBuilder();
                for (int i = 0; i < curK; i++)
                    temp.append(res);

                res = new StringBuilder(lastRes + temp);
            }
        }

        return res.toString();
    }
}
