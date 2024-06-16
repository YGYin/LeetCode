package job.top101.binary;

public class BM22_Compare {
    /*
        比较版本号
        因为比较两个字符串之间的数字值的大小，用双指针同时遍历字符串比较
        将点与点之间的部分转化为数字(*10)，方便处理有前导 0 的状况
        1. 两个指针表示字符串的下标，分别遍历两个字符串两个指针表示字符串的下标，分别遍历两个字符串
        2. 每次截取点之前的数字字符组成数字，即在遇到一个点之前，直接取数字，加在前面数字乘10的后面
        3. 然后比较两个数字大小，根据大小关系返回1或者-1
     */
    public int compare(String version1, String version2) {
        int len1 = version1.length();
        int len2 = version2.length();
        int ptr1 = 0;
        int ptr2 = 0;
        // 双指针遍历两个字符串
        while (ptr1 < len1 || ptr2 < len2) {
            // 记录当前段的数字大小
            int num1 = 0;
            // 先遍历第一个版本号截取一段
            while (ptr1 < len1 && version1.charAt(ptr1) != '.') {
                num1 = num1 * 10 + (version1.charAt(ptr1) - '0');
                ++ptr1;
            }
            // 跳过 '.'
            ++ptr1;

            int num2 = 0;
            while (ptr2 < len2 && version2.charAt(ptr2) != '.') {
                num2 = num2 * 10 + (version2.charAt(ptr2) - '0');
                ++ptr2;
            }
            ++ptr2;
            // 比较当前段 num1 和 num2 的大小
            if (num1 < num2)
                return -1;
            if (num1 > num2)
                return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        BM22_Compare comp = new BM22_Compare();
        System.out.println(comp.compare("1.1", "1.10"));
    }
}
