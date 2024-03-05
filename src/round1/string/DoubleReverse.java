package round1.string;

import java.util.Scanner;

public class DoubleReverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 右旋转的长度
        int rotateLen = Integer.parseInt(sc.nextLine());
        String str = sc.nextLine();
        int strLen = str.length();

        // 转换为数组便于操作
        char[] chars = str.toCharArray();
        reverseStr(chars, 0, strLen - rotateLen - 1);
        reverseStr(chars, strLen - rotateLen, strLen - 1);
        reverseStr(chars, 0, strLen - 1);
        System.out.println(chars);
    }

    private static void reverseStr(char[] chars, int start, int end) {
        char temp;
        while (start < end) {
            temp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = temp;
        }
    }
}
