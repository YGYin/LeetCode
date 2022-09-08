package others;

import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

public class Register {

    public static void main(String[] args) {
        String name = "YG";
        String pwd = "112233";
        String email = "yg@yg.com";

        try {
            userRegister(name, pwd, email);
            System.out.println("Successfully registered.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void userRegister(String name, String pwd, String email) {
        int nameLength = name.length();
        if (!(nameLength >= 2 && nameLength <= 4))
            throw new RuntimeException("Not valid name length");


        if (!(pwd.length() == 6 && isDigit(pwd)))
            throw new RuntimeException("pwd should be digit and its length should be 6");

        int i = email.indexOf('@');
        int j = email.indexOf('.');
        if (!(i > 0 && j > i))
            throw new RuntimeException("@ and . is needed, and @ should be in front of '.'. ");
    }

    public static boolean isDigit(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++)
            if (chars[i] < '0' || chars[i] > '9')
                return false;

        return true;
    }
}
