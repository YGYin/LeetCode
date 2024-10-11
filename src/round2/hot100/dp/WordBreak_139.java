package round2.hot100.dp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak_139 {
    /*
        单词拆分
        优点类似于划分回文串，加上记忆化回溯
        1. 通过 memory 数组来保存每次以 startIndex 为起始的匹配结果
        2. 通过 set 保存字典结果，用于判断是否存在
     */
    Set<String> set;
    int[] memory;

    public boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);
        memory = new int[s.length()];
        return backtracking(s, 0);
    }

    private boolean backtracking(String s, int startIndex) {
        // 如果切到末尾说明切割完成，找到匹配单词收获结果
        if (startIndex == s.length())
            return true;

        // 检查 memory 数组对应位置是否标记为 -1，
        // -1 代表从 startIndex 到 末尾 都没找到对应单词
        if (memory[startIndex] == -1)
            return false;

        // 遍历当前层
        for (int i = startIndex; i < s.length(); i++) {
            // 截取当前子串，看在 set 中是否存在
            String substr = s.substring(startIndex, i + 1);
            // 如果还不存在，继续在同一层往后搜
            if (!set.contains(substr))
                continue;
            // 存在的话，隔板隔开在下一层继续搜
            boolean res = backtracking(s, i + 1);
            if (res)
                return true;
        }
        // 搜完本层发现仍然不存在，标记 memory 数组起始点为 -1，返回 false
        memory[startIndex] = -1;
        return false;
    }
}
