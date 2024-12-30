package round3.hot100.substr;

public class MinWindow_76 {
    /*
        最小覆盖子串
        给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串
        哈希表 + 滑动窗口
        1. 用哈希表 need 记录 t 所有出现的字符，为对应字符所需数量
        2. 在 s 维护滑动窗口从 0 开始扩大右边界直到包含 t
        3. 然后尝试缩小左边界，直到碰到一个 t 中的元素，此时更新长度
        4. i 左边界再收缩一个位置，重复到步骤 1 搜索下一个字符串
     */
    public String minWindow(String s, String t) {
        // 特判
        if (s.isEmpty() || t.isEmpty() || s.length() < t.length())
            return "";

        // 定义 need 记录 t 出现的字符，因为是大写字母 不用做 - 'a' 操作
        int[] need = new int[128];
        for (int i = 0; i < t.length(); i++)
            ++need[t.charAt(i)];

        // 定义左边界指针，结果的左边界，以及记录最小窗口长度
        int i = 0;
        int resStart = 0;
        int minWindowLen = Integer.MAX_VALUE;
        // 定义 count 记录当前所需的字符个数
        int count = t.length();
        // 滑动窗口遍历 s
        for (int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);
            // 看该字符是否包含在 t 中，无论是否包含都会纳入到右窗口范围
            if (need[ch] > 0)
                --count;
            --need[ch];

            // 判断是否满足 count 所有所需字符的个数
            if (count == 0) {
                // 尝试缩小左边界，直到碰到一个 t 中的元素
                // need[ch] < 0 说明则为 t 不需要的元素
                while (i < j && need[s.charAt(i)] < 0) {
                    ++need[s.charAt(i)];
                    ++i;
                }
                // 此时 i 刚好指向 t 所需要的元素，尝试更新最小窗口长度和结果起始坐标
                if (j - i + 1 < minWindowLen) {
                    minWindowLen = j - i + 1;
                    resStart = i;
                }
                // 无论是否更新，在找到第一个所需元素后，释放该元素，继续寻找
                ++count;
                ++need[s.charAt(i)];
                ++i;
            }
        }
        // 最小窗口长度有可能没更新，如果没更新就返回 ""，更新的话就返回子串
        return minWindowLen == Integer.MAX_VALUE ? ""
                : s.substring(resStart, resStart + minWindowLen);
    }
}
