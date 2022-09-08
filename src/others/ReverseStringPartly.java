package others;

// a bcde f -> a edcb f
public class ReverseStringPartly {
    /*
        1. String -> char[], because char[]'s element can be changed.
        2
     */
    public String reverse(String str, int start, int end) {
        char temp = 0;
        char[] chars = str.toCharArray();
        while (start < end) {
            temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            end--;
            start++;
        }
        return new String(chars);
    }
}
