package javase.extend;

public class Graduate extends Student {
    public Graduate() {
        // super();
        System.out.println("Graduate constructor");
    }

    public void testing() {
        System.out.println("Pupil:" + name);
    }

    public static void main(String[] args) {
        String s1 = new String("hello");
        s1 = s1 + "abc";
        System.out.println(s1);
    }
}
