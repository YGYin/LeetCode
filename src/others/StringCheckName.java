package others;

import java.text.Format;

public class StringCheckName {
    public static void main(String[] args) {
        String name = "Kobe Bean Bryant";
        StringCheckName stringCheckName = new StringCheckName();
        stringCheckName.printName(name);
    }

    /*
        1. 对字符串进行分割split(" ")
        2. 对得到的 String 进行格式化 String.format()
        3。 对输入字符串进行检验
     */
    public void printName(String str) {
        if (str == null) {
            System.out.println("String should not be null.");
            return;
        }
        String[] names = str.split(" ");
        if (names.length != 3) {
            System.out.println("String Format is not valid.");
            return;
        }

        String format = String.format("%s, %s .%c", names[2], names[0], names[1].toUpperCase().charAt(0));
        System.out.println(format);
    }
}
