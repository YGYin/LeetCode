package round4.leetcode.substr;

public class MinWindow_76 {
    /*
        最小覆盖子串
        利用滑动窗口的思想，left, right 表示当前窗口，resLeft，resRight 表示目标位置(左开右闭)
        1. 用 need[128] 记录 t 每个字符出现次数，count 为 t 剩余所需字符个数
        2. 为了便于处理手动更新右边界，用 while，
            判断当前右边界字符是否为 t 所需字符，满足的话 --count；无论是否为所需字符都移动右窗口
        3. 当 count 为 0 说明当前窗口已经包含所有 t 所需字符，不断尝试更新最小长度
            先尝试更新最小长度，resLeft 和 resRight
            再释放左边界字符，看左边界的字符是否为 t 中字符，如果为 t 中字符 need[] 中因为 0，++count
            移动左边界
     */
    public String minWindow(String s, String t) {
        // 记录 t 每个字符出现次数，count 为 t 剩余所需字符个数
        int[] need = new int[128];
        for (int i = 0; i < t.length(); i++)
            need[t.charAt(i)]++;
        int count = t.length();

        // 左右指针，目标左右指针，最小长度
        int left = 0, right = 0, resLeft = 0, resRight = 0;
        int minLen = Integer.MAX_VALUE;

        // 为了便于处理手动更新右边界，用 while
        while (right < s.length()) {
            // 判断当前右边界字符是否为 t 所需字符，满足的话 --count
            if (need[s.charAt(right)] > 0)
                --count;
            // 移动右边界
            --need[s.charAt(right)];
            ++right;

            // 当 count 为 0 说明当前窗口已经包含所有 t 所需字符
            while (count == 0) {
                // 更新最小长度
                if (right - left < minLen) {
                    minLen = right - left;
                    resLeft = left;
                    resRight = right;
                }
                // 先检查当前左边界字符是否为 t 中字符，++count
                if (need[s.charAt(left)] == 0)
                    ++count;
                // 移动左边界
                ++need[s.charAt(left)];
                ++left;
            }
        }
        // 最小长度有可能没更新
        return minLen == Integer.MAX_VALUE ? "" : s.substring(resLeft, resRight);
    }
}
