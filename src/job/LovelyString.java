package job;

public class LovelyString {
    public static long countLovelyStrings(int n) {
        // 至少需要一个'r'、一个'e'、一个'd'，剩下的n-3个字符可以自由选择
        if (n < 3) {
            return 0; // 不可能构成可爱串
        }
        // 使用long类型以防溢出
        long total = (long) Math.pow(3, n - 3);
        return total;
    }

    public static void main(String[] args) {
        int n = 4; // 示例
        System.out.println("Number of lovely strings of length " + n + ": " + countLovelyStrings(n));
    }
}
