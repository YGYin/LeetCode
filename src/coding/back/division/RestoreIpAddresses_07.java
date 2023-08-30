package coding.back.division;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses_07 {
    List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12)
            return res;
        backtracking(s, 0, 0);
        return res;
    }

    private void backtracking(String s, int startIndex, int dotNum) {
        // 点个数为 3 的时候，分割结束
        if (dotNum == 3) {
            if (ipIsValid(s, startIndex, s.length() - 1))
                res.add(s);
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            // 左闭右闭
            if (ipIsValid(s, startIndex, i)) {
                // 在原来 str 对应位置插入一个点
                s = s.substring(0, i + 1) + "." + s.substring(i + 1);
                // 因为插入了点，下一个子串的起始位置为 i + 2
                backtracking(s, i + 2, dotNum + 1);
                // 回溯撤回添加的点
                s = s.substring(0, i + 1) + s.substring(i + 2);
            } else
                break;
        }
    }

    private boolean ipIsValid(String s, int start, int end) {
        if (start > end)
            return false;
        // 0 开头的数字不合法
        if (s.charAt(start) == '0' && start != end)
            return false;

        int num = 0;
        for (int i = start; i <= end; i++) {
            // 非数字字符不合法
            if (s.charAt(i) > '9' || s.charAt(i) < '0')
                return false;

            num = num * 10 + (s.charAt(i) - '0');
            //大于 255 不合法
            if (num > 255)
                return false;
        }
        return true;
    }
}
