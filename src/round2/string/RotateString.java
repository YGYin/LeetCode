package round2.string;

import java.util.Scanner;

public class RotateString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        int k = Integer.parseInt(str1);
        String str2 = sc.nextLine();

        char[] chars = str2.toCharArray();
        // 先反转整个字符串
        reverse(chars, 0, chars.length - 1);
        // 旋转左边头两个
        reverse(chars, 0, k - 1);
        // 旋转右边部分
        reverse(chars, k, chars.length - 1);
        System.out.println(new String(chars));
    }

    private static void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left++] = chars[right];
            chars[right--] = temp;
        }
    }
}
