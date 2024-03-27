package round1.backtracking;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses_93 {
    List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        // 简单剪枝
        if (s.length() > 12)
            return res;
        // 返回空，传入字符串，startIndex 以及当前分割的点的数量
        StringBuilder sb = new StringBuilder(s);
        backtracking(sb, 0, 0);
        return res;
    }

    private void backtracking(StringBuilder sb, int startIndex, int pointNum) {
        // 结束条件：当点的数量到 3 时，停止分割
        //  并检查第四段数字是否合法，合法便收集结果加入到 res 当中
        if (pointNum == 3) {
            if (isValid(sb, startIndex, sb.length() - 1))
                res.add(sb.toString());
            return;
        }
        // 遍历单层
        for (int i = startIndex; i < sb.length(); i++) {
            // 将切割子串非判断逻辑放到 for 中
            // 判断当前区间是不是合法 ip 段
            if (isValid(sb, startIndex, i)) {
                // 如果当前合法，用 . 分割
                sb.insert(i + 1, '.');
                backtracking(sb, i + 2, pointNum + 1);
                sb.deleteCharAt(i + 1);
            } else
                break; // 不合法直接停止搜索本层
        }
    }

    // 区间左闭右闭
    private boolean isValid(StringBuilder sb, int start, int end) {
        // 1. start > end 不合法
        if (start > end)
            return false;
        // 2. 有 0 在开头不合法，且不止一位
        if (sb.charAt(start) == '0' && start != end)
            return false;

        int curNum = 0;
        // 左闭右闭区间
        for (int i = start; i <= end; i++) {
            // 3. 有非正整数不合法
            if (sb.charAt(i) > '9' || sb.charAt(i) < '0')
                return false;
            // 求当前位置的正整数
            curNum = curNum * 10 + (sb.charAt(i) - '0');
            // 4. 大于 255 不合法
            if (curNum > 255)
                return false;
        }
        return true;
    }
}
