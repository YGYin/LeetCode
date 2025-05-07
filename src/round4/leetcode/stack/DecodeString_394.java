package round4.leetcode.stack;

public class DecodeString_394 {

    private int index;

    // 字符串解码
    public String decodeString(String s) {
        // 初始化公共 index 为 0
        index = 0;
        return decode(s);
    }

    // 返回解码后的字符串，传入当前字符串 (index 公用)
    private String decode(String s) {
        // 初始化，当前数字和 builder
        int curNum = 0;
        StringBuilder builder = new StringBuilder();

        // 遍历字符串
        while (index < s.length()) {
            // 因为后续递归进入到下一层，需要此处及时更新 index
            char ch = s.charAt(index++);
            // 如果是数字，有可能为多位数倍，将 curNum * 10 再累加
            if (ch >= '0' && ch <= '9')
                curNum = curNum * 10 + (ch - '0');
            else if (ch == '[') {
                // 为左括号，递归解码左括号后的字符串
                // 因为已经有公共 index，不需要传递 index 作为参数
                String decodedStr = decode(s);
                // 根据当前倍数，append curNum 个解码后的字符串
                for (int i = 0; i < curNum; i++)
                    builder.append(decodedStr);
                // 重置当前倍数
                curNum = 0;
            }
            // 遇到右括号直接结束当前层的遍历
            else if (ch == ']')
                break;
                // 遇到字符直接 append
            else
                builder.append(ch);
        }

        // 将当前层解析构造好的字符串返回给上层
        return builder.toString();
    }
}
