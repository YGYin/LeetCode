package round2.hot100.substr;

public class MinWindow_76 {
    /*
        最小覆盖子串
        给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串
        哈希表 + 滑动窗口
        1. 用哈希表记录 t 所有出现的字符
        2. 在 s 维护滑动窗口从 0 开始扩大右边界直到包含 t
        3. 然后尝试缩小左边界，直到碰到一个 t 中的元素，此时更新长度
        4. i 左边界再收缩一个位置，重复到步骤 1 搜索下一个字符串
     */
    public String minWindow(String s, String t) {
        // 先特判
        if (s.isEmpty() || t.isEmpty() || s.length() < t.length())
            return "";

        // 定义哈希表记录 t 中字符串的出现次数，为对应字符所需数量
        // 因为只包含大小写，可以直接开数组来储存
        int[] need = new int[128];
        // 记录大写字母不做 - 'a' 操作
        for (int i = 0; i < t.length(); i++)
            need[t.charAt(i)]++;

        // 因为最后返回子串，需要记录其目标子串的起始位置以及最小长度
        int resStart = 0;
        int minWindowLen = Integer.MAX_VALUE;
        // 为了避免每次都遍历整个 need 数组是否为 0，定义 count 记录需要的字符个数
        int count = t.length();
        // 左边界
        int i = 0;
        // 开始遍历字符串 s
        for (int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);
            // 看该字符是否包含在 t 中，无论是否包含都会纳入到右窗口范围
            if (need[ch] > 0)
                --count;
            --need[ch];

            // 看是否已经包含 t 所有字符
            if (count == 0) {
                // 然后尝试缩小左边界，不是需要的就移动
                // 直到碰到一个 t 中的元素，此时更新长度
                while (i < j && need[s.charAt(i)] < 0) {
                    ++need[s.charAt(i)];
                    ++i;
                }

                // 现在 i 指向 t 需要的元素，更新最小长度和起始坐标
                if (j - i + 1 < minWindowLen) {
                    minWindowLen = j - i + 1;
                    resStart = i;
                }
                // 移动左边界，释放刚刚 t 所需要的元素
                // 已跳回到步骤 1 尝试寻找下一个最短子串
                ++need[s.charAt(i)];
                ++i;
                ++count;
            }
        }
        // 有可能没更新，没更新的话最小长度仍然是初始值
        // 说明没有找到符合的最短子串
        return minWindowLen == Integer.MAX_VALUE ?
                "" : s.substring(resStart, resStart + minWindowLen);
    }
}
