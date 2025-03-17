package round4.leetcode.dp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak_139 {
    /*
        单词拆分
        s 字符串长度为背包容量，wordDict 内的单词为物品，看能不能将背包装满
        因为同一个单词可以选用多次，为完全背包问题
        1. dp[j]: 字符串(背包)长度为 j 时是否可以将背包装满
        2. 递推公式
            i < j 情况下
            如果 dp[i] = true 满足装满，且 [i, j) 字串位于 wordDict 中时
                令 dp[j] = true;
        3. 初始化: dp[0] = true，其他为 false
        4. 遍历顺序: 因为和顺序有关，求的为排列，先背包(正序)后物品
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        // 初始化 dp 数组
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        // 需要用 set 来保存字典，用于查看 [i, j] 子串是否位于字典内
        Set<String> set = new HashSet<>(wordDict);

        // 遍历 dp 数组，求排列先背包后物品
        for (int j = 1; j <= s.length(); j++) {
            for (int i = 0; i < j; i++) {
                // 先截取当前字符串，左闭右开
                String substr = s.substring(i, j);
                // 背包长度为 i (对应下标 i - 1)能被装满，[i, j) 子串位于 wordDict 中
                if (dp[i] && set.contains(substr))
                    dp[j] = true;
            }
        }

        return dp[s.length()];
    }
}
