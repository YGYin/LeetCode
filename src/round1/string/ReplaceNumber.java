package round1.string;

import java.util.Scanner;

public class ReplaceNumber {
    public static void main(String[] args) {
        // 读取字符串
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        // 新建字符串
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // if (Character.isDigit(ch))
            if (ch >= '0' && ch <= '9')
                sb.append("number");
            else
                sb.append(ch);
        }
        System.out.println(sb);
    }
}
