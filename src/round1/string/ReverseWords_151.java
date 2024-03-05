package round1.string;

public class ReverseWords_151 {
    public String reverseWords(String s) {
        // 将整个字符串都反转过来，单词的顺序也变成倒序了，
        // 然后再把单词反转一下，单词变为正常顺序

        // 移除多余空格
        StringBuilder sb = removeSpace(s);
        // 反转整个字符串
        reverseStr(sb, 0, sb.length() - 1);
        // 反转每个单词, sb 可以直接对内部进行修改无需返回
        reverseEachWord(sb);
        return sb.toString();
    }

    private void reverseEachWord(StringBuilder sb) {
        int start = 0;
        int end = 1;
        int strLen = sb.length();

        while (start < strLen) {
            // 获取一个单词，end 会指向单词的空格
            while (end < strLen && sb.charAt(end) != ' ')
                ++end;
            // 反转该单词
            reverseStr(sb, start, end - 1);
            // 反转后更新指针
            // start 到空格后为新单词开端，end 为 start 后一位
            start = end + 1;
            end = start + 1;
        }
    }

    private void reverseStr(StringBuilder sb, int start, int end) {
        char temp;
        while (start < end) {
            temp = sb.charAt(start);
            sb.setCharAt(start++, sb.charAt(end));
            sb.setCharAt(end--, temp);
        }
    }

    private StringBuilder removeSpace(String s) {
        int left = 0, right = s.length() - 1;
        // 去除前后多余空格，将左右指针移到字符串实际开头和末尾
        while (s.charAt(left) == ' ')
            ++left;
        while (s.charAt(right) == ' ')
            --right;

        StringBuilder sb = new StringBuilder();
        while (left <= right) {
            char ch = s.charAt(left);
            // 当前字符不为空格，或新字符串末尾不为空格时 append
            // 这样可以避免读字符串时加入中间多余的空格
            if (ch != ' ' || sb.charAt(sb.length() - 1) != ' ')
                sb.append(ch);
            ++left;
        }
        return sb;
    }
}
