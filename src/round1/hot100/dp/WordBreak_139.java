package round1.hot100.dp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak_139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        /*
            单词拆分
            s 视为背包，dict 视为物品 -> 完全背包
            1. dp[i] 表示 s 字符串长度为 i 时是否能够被拆分为一个或多个字典里出现的单词
            2. 递推公式: 令 i > j
                    如果 dp[j] = true 且 [j, i] 区间的子串也出现在字典里时，dp[i] = true
                    if(dp[j] && wordDictSet.contains(substr(j, i))
                        dp[i] = true;
            3. 初始化:
                    实际字符串至少长度为 1，dp[0]无实际意义，为方便满足递推公式
                    dp[0] = true
                    others = false
            4. 遍历顺序:
                    严格来说无遍历顺序，但是可视为排列问题，所以先背包后物品
         */

        // 初始化 dp 数组
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        // 使用 set 来储存题目所给字典
        Set<String> dict = new HashSet<>(wordDict);

        // 遍历 dp 数组，先背包后物品
        for (int i = 1; i <= s.length(); i++)
            for (int j = 0; j < i; j++)
                if (dp[j] && dict.contains(s.substring(j, i)))
                    dp[i] = true;

        return dp[s.length()];
    }

}
