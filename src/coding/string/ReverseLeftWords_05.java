package coding.string;

public class ReverseLeftWords_05 {
    /*
        思路：
            先反转整个字符串，然后反转前 strlen - n 个，再反转剩下部分
     */
    public String reverseLeftWords(String s, int n) {
        int strlen = s.length();
        if (n >= strlen)
            n %= strlen;
        if (n == 0)
            return s;
        char[] chars = s.toCharArray();
        reverse(chars, 0, strlen - 1);
        reverse(chars, 0, strlen - n - 1);
        reverse(chars, strlen - n, strlen - 1);
        return new String(chars);
    }

    private void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left++] = chars[right];
            chars[right--] = temp;
        }
    }
}
