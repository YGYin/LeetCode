package round1.hot100.dp;

public class LongestPalindrome_5 {
    /*
        最长回文子串
        1. 中心扩散法
            基本思想: 遍历每一个下标，以这个下标为中心，
                     利用「回文串」中心对称的特点，往两边扩散，看最多能扩散多远
        2. 注意回文串长度为奇数和偶数时，中心点的心态不一样
           "aba" -> b "abba" -> bb 或者视为两个 b 中间的空隙
           设计中心扩散方法:
               如果传入重合下标进行中心扩散，此时得到回文子串长度为奇数
               如果传入相邻下标进行中心扩散，此时得到回文子串长度为偶数
     */
    public String longestPalindrome(String s) {
        int strLen = s.length();
        if (strLen < 2)
            return s;
        int maxLen = 0;
        // 数组第一位用于记录最长回文子串的起始位置，第二位为长度
        int[] res = new int[2];
        for (int i = 0; i < strLen - 1; i++) {
            int[] odd = centerSpread(s, i, i);
            int[] even = centerSpread(s, i, i + 1);
            // 比较当前下标和相邻下标扩散得到的回文子串长度，保存长的
            int[] curMax = odd[1] > even[1] ? odd : even;
            // 当前最大长度与全局最大回文子串长度作比较，更新变量
            if (curMax[1] > maxLen) {
                maxLen = curMax[1];
                res = curMax;
            }
        }

        return s.substring(res[0], res[0] + res[1]);
    }

    private int[] centerSpread(String s, int left, int right) {
        // 进行扩散
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                --left;
                ++right;
            } else
                break;
        }
        // 最长回文子串的起始位置，以及长度
        return new int[]{left + 1, right - left - 1};
    }

    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right)
            if (s.charAt(left++) != s.charAt(right--))
                return false;
        return true;
    }

    /*
        暴力
        1. n^2 检查每个子字符串是不是回文字符串且比最大长度大
        2. 是的话记录该字符串，并更新最大长度
     */
    public String longestPalindrome_2(String s) {
        // 初始化变量用于记录最长回文字符串以及最长长度
        int maxLen = 0;
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                // 截取每一个字符串作比较
                String subStr = s.substring(i, j);
                // 如果该字符串大于当前最长字符串且为回文字符串
                // 更新记录的回文字符串和最长回文串长度
                if (subStr.length() > maxLen && isPalindrome(subStr)) {
                    res = subStr;
                    maxLen = Math.max(maxLen, subStr.length());
                }
            }
        }
        return res;
    }
}
