package round2.greedy;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels_763 {
    /*
        划分字母区间
        统计每一个字符最后出现的位置
        从头遍历字符，并更新字符的最远出现下标，如果找到字符最远出现位置下标和当前下标相等，则找到了分割点
     */
    public List<Integer> partitionLabels(String s) {
        // 先遍历一次数组记录每个字符最后出现的位置
        int[] map = new int[27];
        // 统计每个字符最后出现的位置
        for (int i = 0; i < s.length(); i++)
            map[s.charAt(i) - 'a'] = i;

        List<Integer> res = new ArrayList<>();
        // 记录左边界和右边界
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            // 找到当前字符出现的最远边界
            right = Math.max(right, map[s.charAt(i) - 'a']);
            // 如果当前位置就是该字符出现的最远边界，则找到分割点，记录字符串长度
            if (i == right) {
                res.add(right - left + 1);
                // 更新左边界
                left = i + 1;
            }
        }

        return res;
    }
}
