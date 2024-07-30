package round2.backtracking;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses_93 {
    /*
        复原 IP 地址
        类似于切割回文子串
        需要用一个 dotNum 记录当前有多少个点
        1. 当 dotNum == 3 时，看剩余字符是否合法，合法就收获结果
        2. 同样使用 startIndex 切割，每次处理子节点前，先判断 [startIndex, i] 是否合法
            合法就用 builder 在后面插入一个 '.' ，但是需要 startIndex + 2 来跳过 '.'
     */
    List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        StringBuilder builder = new StringBuilder(s);
        backtracking(builder, 0, 0);
        return res;
    }

    private void backtracking(StringBuilder builder, int startIndex, int dotNum) {
        if (dotNum == 3) {
            if (isValid(builder, startIndex, builder.length() - 1))
                res.add(builder.toString());
            return;
        }
        // 处理本层节点
        for (int i = startIndex; i < builder.length(); i++) {
            // 看 [startIndex, i] 是否合法，不合法本层后序都无需遍历
            if (isValid(builder, startIndex, i)) {
                // 当前合法，插入一个点
                builder.insert(i + 1, '.');
                backtracking(builder, i + 2, dotNum + 1);
                // 回溯
                builder.deleteCharAt(i + 1);
            } else
                break;
        }
    }

    // 左闭右闭
    private boolean isValid(StringBuilder builder, int left, int right) {
        // 判断左右边界
        if (left > right)
            return false;

        // 开头不能为 0，只有一个 0 除外
        if (builder.charAt(left) == '0' && left != right)
            return false;

        int sum = 0;
        // 左闭右闭
        for (int i = left; i <= right; i++) {
            char ch = builder.charAt(i);
            // 不能为非数字
            if (ch < '0' || ch > '9')
                return false;
            // 不能大于 255
            sum = sum * 10 + (ch - '0');
            if (sum > 255)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        RestoreIpAddresses_93 test = new RestoreIpAddresses_93();
        System.out.println(test.restoreIpAddresses("25525511135"));
    }
}
