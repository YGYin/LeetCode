package round2.greedy;

public class MonotoneIncreasingDigits_738 {
    /*
        单调递增的数字
        找小于等于N的最大单调递增的整数
        贪心：从后向前遍历，可以利用到遍历结果
              只要不满足单调递增就将当前位置 - 1，后面全变为 9
     */
    public int monotoneIncreasingDigits(int n) {
        String s = String.valueOf(n);
        char[] chars = s.toCharArray();
        // 从后向前遍历，从倒数第二个开始，同时记录需要开始全部变为 9 的下标
        int toNineIndex = s.length();
        for (int i = s.length() - 2; i >= 0; i--) {
            // 如果不满足单调递增
            if (chars[i] > chars[i + 1]) {
                // 将其 - 1
                --chars[i];
                toNineIndex = i + 1;
            }
        }
        // 将后面数字全部变为 9
        for (int i = toNineIndex; i < s.length(); i++)
            chars[i] = '9';

        return Integer.parseInt(String.valueOf(chars));
    }
}
