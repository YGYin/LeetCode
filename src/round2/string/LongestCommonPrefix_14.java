package round2.string;

public class LongestCommonPrefix_14 {
    public String longestCommonPrefix(String[] strs) {
        /*
            最长公共前缀
            1. 默认使用第一个 str 作为 prefix
            2. 每次更新 prefix，传入当前 prefix 和 strs[i]
            3. 如果返回的 prefix 为空，输出空字符串
        */
        if (strs.length == 0 || strs == null)
            return "";

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            prefix = getLCP(prefix, strs[i]);
            // prefix 长度为 0 则返回空串
            if (prefix.length() == 0)
                return "";
        }
        return prefix;
    }

    String getLCP(String prefix, String curStr) {
        // 遍历长度应该在 prefix 以及 curStr 之间取短的
        int strlen = Math.min(prefix.length(), curStr.length());
        int index = 0;
        while (index < strlen && curStr.charAt(index) == prefix.charAt(index))
            ++index;

        return curStr.substring(0, index);
    }
}
