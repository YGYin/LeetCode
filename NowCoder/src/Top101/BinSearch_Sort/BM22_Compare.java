package Top101.BinSearch_Sort;

public class BM22_Compare {
    /*
        1. 利用两个指针表示字符串的下标，分别遍历两个字符串。
        2. 每次截取点之前的数字字符组成数字，即在遇到一个点之前，
           直接取数字，加在前面数字乘10的后面。（因为int会溢出，这里采用long记录数字）
        3. 然后比较两个数字大小，根据大小关系返回1或者-1，
           如果全部比较完都无法比较出大小关系，则返回0.

        时间复杂度: O(max(m, n))
        空间复杂度: O(1)
     */
    public int compare(String version1, String version2) {
        int length1 = version1.length(), length2 = version2.length();
        int ptr1 = 0, ptr2 = 0;
        // 直到某个字符串结束
        while (ptr1 < length1 || ptr2 < length2) {
            long num1 = 0;
            // 从下一个点前截取数字
            while (ptr1 < length1 && version1.charAt(ptr1) != '.')
                num1 = num1 * 10 + (version1.charAt(ptr1++) - '0');

            // 跳过点
            ++ptr1;

            long num2 = 0;
            while (ptr2 < length2 && version2.charAt(ptr2) != '.')
                num2 = num2 * 10 + (version2.charAt(ptr2++) - '0');

            ++ptr2;

            if (num1 > num2)
                return 1;
            if (num1 < num2)
                return -1;

        }
        // 版本号相同
        return 0;
    }
}
