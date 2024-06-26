package round2.string;

public class ReverseStr_541 {
    /*
        反转字符串 II
        传入 s，不能直接修改字符串，需转换为数组
        因为每隔 2k 个字符将前 k 个字符进行反转
        循环上可以定义为 i += 2*k
     */
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        // 每隔 2k 个，i += 2*k
        for (int i = 0; i < chars.length; i += 2 * k) {
            // 看剩余字符是否大于等于 k 没到末尾，是的话反转前 k 个字符
            if (i + k <= chars.length)
                reverse(chars, i, i + k - 1);
                // 否则直接反转剩余字符串
            else
                reverse(chars, i, chars.length - 1);
        }

        return new String(chars);
    }

    // 反转字符床，左闭右闭
    private void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left++] = chars[right];
            chars[right--] = temp;
        }
    }
}
