package coding.string;

public class ReverseString_01 {
    public void reverseString(char[] s) {
        if (s.length == 1)
            return;
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }
        return;
    }
}
