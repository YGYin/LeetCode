package round2.string;

public class ReverseString_344 {
    /*
        反转字符串
        双指针分别指向两端一一交换
     */
    public void reverseString(char[] s) {
        int strLen = s.length;
        if (strLen == 1)
            return;
        int left = 0;
        int right = strLen - 1;

        while (left < right) {
            char temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }
        return;
    }

}
