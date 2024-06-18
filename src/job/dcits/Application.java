package job.dcits;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        int digit = 0;
        int character = 0;
        int other = 0;
        int blank = 0;

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= '0' && chars[i] <= '9')
                ++digit;
            else if ((chars[i] >= 'a' && chars[i] <= 'z') || (chars[i] >= 'A' && chars[i] <= 'Z'))
                ++character;
            else if (chars[i] == ' ')
                ++blank;
            else
                ++other;
        }

        System.out.println(digit);
        System.out.println(character);
        System.out.println(blank);
        System.out.println(other);
    }
}
