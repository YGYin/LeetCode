package round1.hot100.greedy;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels_763 {
    public List<Integer> partitionLabels(String s) {
        /*
            如果当前字符串有一个 a，就需要把所有的 a 都包括进来，需要知道最远的 a 的位置
            需要遍历字符串，记录每个字符的最远出现位置
            根据这个最远位置来决定区间的分界线在哪里
         */
        int[] hash = new int[27];
        // 先遍历一遍字符串，记录每个元素出现的最远位置
        for (int i = 0; i < s.length(); i++)
            hash[s.charAt(i) - 'a'] = i;

        List<Integer> res = new ArrayList<>();
        // 遍历字符串 记录左右端
        int left = 0;
        int right = 0;
        // 贪每个字符出现的最后位置，从而得到最长的字符串
        for (int i = 0; i < s.length(); i++) {
            // 遍历过程中更新最右端
            right = Math.max(right, hash[s.charAt(i) - 'a']);
            // 如果当前已经遍历到了包含对应字符的最远位置，记录左右端
            if (i == right) {
                // 当前元素个数加入到 res 中
                res.add(right - left + 1);
                // 更新 left
                left = i + 1;
            }
        }
        return res;
    }
}
