package coding.string;

public class ReplaceSpace_03 {
    /*
        使用 StringBuilder 复制 str，复制的过程对其判断
        空格则替换，否则直接复制
     */
    public String replaceSpace(String s) {
        if (s.length() == 0)
            return s;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ')
                sb.append("%20");
            else
                sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    /*
        双指针法
            用 string builder 扩充两倍空格的空间
            分别用左右指针指向原字符串和扩充后字符串的尾部
            在左指针没到头之前，从后向前替换空格
                遇到空格右指针在后方填充 %20
                遇到字符直接复制
                然后分别前移两个指针
        p.s 从前向后填充就是 O(n^2) 的算法
            因为每次添加元素都要将添加元素之后的所有元素向后移动

        时间复杂度：O(n)
        空间复杂度：O(1)
     */
    public String replaceSpace_2(String s) {
        if (s.length() == 0)
            return s;
        StringBuilder sb = new StringBuilder();
        // 扩充空间，空格数量两倍
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) == ' ')
                sb.append("  ");
        // 如果 string builder 中没有空格就直接返回
        if (sb.length() == 0)
            return s;
        // string builder 中有空格，定义双指针进行后序处理
        // 左指针指向原始字符串的最后一个位置
        int left = s.length() - 1;
        // 拓展字符串
        s += sb.toString();
        // 指针指向拓展后字符串的最后一个位置
        int right = s.length() - 1;
        char[] strArr = s.toCharArray();
        while (left >= 0) {
            // 如果原字符串为空格则往后填充 %20
            if (strArr[left] == ' ') {
                strArr[right--] = '0';
                strArr[right--] = '2';
                strArr[right] = '%';
            }
            // 普通字符则直接复制
            else
                strArr[right] = strArr[left];
            // 后移指针
            --left;
            --right;
        }
        return new String(strArr);
    }
}
