package round2.string;

public class ReverseWords_151 {
    /*
        反转字符串中的单词
        可能存在多个前导，中间或尾随空格，分为三个步骤
        1. 去除首尾以及中间的多余空格
        2. 将整个字符串反转
        3. 再将每个单词反转
     */
    public String reverseWords(String s) {
        // 1. 去除首尾以及中间的多余空格
        StringBuilder sb = removeSpace(s);
        // 2. 反转整个字符串
        reverse(sb, 0, sb.length() - 1);
        // 3. 再将每个单词反转
        reverseEachWord(sb);

        return sb.toString();
    }

    private StringBuilder removeSpace(String s) {
        int left = 0;
        int right = s.length() - 1;
        // 去除头尾多余空格
        while (s.charAt(left) == ' ')
            ++left;
        while (s.charAt(right) == ' ')
            --right;
        // 新建 builder 构建字符串
        StringBuilder sb = new StringBuilder();
        // left == right 时的字符也要加入到 builder 中
        while (left <= right) {
            char ch = s.charAt(left);
            // 如果当前字符不为空格或者 builder 当前字符串末尾不为空格
            // 只要两者不同时为空格时加入当前字符，不会造成有多个空格
            if (ch != ' ' || sb.charAt(sb.length() - 1) != ' ')
                sb.append(ch);
            ++left;
        }
        return sb;
    }

    private void reverse(StringBuilder sb, int left, int right) {
        while (left < right) {
            char temp = sb.charAt(left);
            sb.setCharAt(left++, sb.charAt(right));
            sb.setCharAt(right--, temp);
        }
    }

    private void reverseEachWord(StringBuilder sb) {
        // 用双指针来指向每个单词的开头和结尾
        int strLen = sb.length();
        int start = 0;
        int end = start + 1;
        while (start < strLen) {
            // 找当前单词的结尾
            // 只要 end 没到句子结尾或者没遇到空格 ++end
            while (end < strLen && sb.charAt(end) != ' ')
                ++end;
            // 找到后反转该单词
            reverse(sb, start, end - 1);
            // 更新指针
            start = end + 1;
            end = start + 1;
        }
    }
}