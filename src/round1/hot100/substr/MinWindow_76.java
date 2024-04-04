package round1.hot100.substr;

public class MinWindow_76 {
    /*
      最小覆盖子串
      主要思想滑动窗口
      1. 从零开始窗口扩大直到包含 t 所有所需字符
      2. i 开始缩小，直到碰到一个 t 中必须包含的字符，此时更新长度
      3. i 再收缩一个位置，重复步骤 1
    */
    public String minWindow(String s, String t) {
        // 参数校验
        if (s == null || t == null || s.length() < t.length())
            return "";
        // 定义哈希表来保存 t 中字符出现的次数，表示每个字符待需要的数量
        // 因为只包含大小写字母，可用数组代替 HashMap
        int[] need = new int[128];
        for (int i = 0; i < t.length(); i++)
            need[t.charAt(i)]++;

        int minWindowSize = Integer.MAX_VALUE;
        int startIndex = 0;
        // count 用于记录需求的字符个数，
        // 可以避免每次移动窗口都去完成遍历哈希表是否全部小于等于 0
        int count = t.length();
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);
            // 1.1 看数组对应位置是否大于 0 判断是否需要 c
            if (need[ch] > 0)
                --count;
            --need[ch]; // 加入到窗口中

            // 1.2 判断窗口是不是已经包含 t 所需的所有字符
            if (count == 0) {
                // 2.1 开始向左移动，只要当前元素不是所需的就移动
                while (i < j && need[s.charAt(i)] < 0) {
                    ++need[s.charAt(i)];
                    ++i;
                }
                // 直到不能移动了，碰到一个 t 中必须包含的字符，此时更新长度
                // 同时更新最短覆盖子串的下标
                if (j - i + 1 < minWindowSize) {
                    minWindowSize = j - i + 1;
                    startIndex = i;
                }
                // i 再向右收缩一个位置，相当于左侧放掉一个所需字符
                // 更新 need 数组和 count，重复步骤 1
                ++need[s.charAt(i)];
                ++count;
                ++i;
            }
        }
        // 返回判断 minWindowSize 有无改变，改变则返回对应下标 (左闭右开)
        return minWindowSize == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minWindowSize);
    }
}
