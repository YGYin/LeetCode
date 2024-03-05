package round1.string;

public class ReverseStr_541 {
    public String reverseStr(String s, int k) {
        // 让 i 每次都加 2k 以方便处理
        // 首先将 s 转化为数组
        char[] charArr = s.toCharArray();
        for (int i = 0; i < charArr.length; i += 2 * k) {
            // 如果剩余字符小于 2k 但大于或等于 k 个
            // 则反转前 k 个
            if (i + k <= charArr.length)
                reverse(charArr, i, i + k - 1);
            else // 剩余字符少于 k 个，全部反转
                reverse(charArr, i, charArr.length - 1);
        }
        return new String(charArr);
    }

    private void reverse(char[] charArr, int left, int right) {
        char temp;
        while (left < right) {
            temp = charArr[left];
            charArr[left++] = charArr[right];
            charArr[right--] = temp;
        }
    }
}
