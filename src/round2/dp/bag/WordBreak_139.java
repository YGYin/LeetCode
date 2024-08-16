package round2.dp.bag;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak_139 {
    /*
        单词拆分
        和划分回文串类似，本体可以用记忆化回溯的方式优化
        1. 通过 memory 数组保存每次计算以 startIndex 为起始的匹配结果
        2. 通过 set 来保存字典结果，方便查看是否存在
     */

    Set<String> set;
    int[] memory;

    public boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);
        memory = new int[s.length()];
        // 切割类似于组合问题，需要 startIndex 来切分
        return backtracking(s, 0);
    }

    private boolean backtracking(String s, int startIndex) {
        // 当切分到末尾时说明切割完成，找到匹配单词，收获结果
        if (startIndex == s.length())
            return true;

        // 如果 memory[startIndex] == -1，
        // 说明从 startIndex 到 s.length() 都没找到对应的单词
        if (memory[startIndex] == -1)
            return false;

        // 遍历当前层节点
        for (int i = startIndex; i < s.length(); i++) {
            // 切分当前字符串[startIndex, i]，看是否存在单词
            String substr = s.substring(startIndex, i + 1);
            // 如果不符合则在本层继续扩大 i 看 [startIndex, i] 是否为字典的单词
            if (!set.contains(substr))
                continue;
            // 切分到了第一个，向下一层继续切分
            boolean res = backtracking(s, i + 1);
            if (res)
                return true;
        }
        // 搜完从 startIndex～s.length() 都没有找到匹配，标记 startIndex 为 -1
        memory[startIndex] = -1;
        return false;
    }
}
