package coding.string;

public class ReverseWords_04 {
    /*
        思路：
            1. 先去掉首尾以及中间多余的空格
            2. 将整个字符串反转
            3. 再将每个单词都反转
     */
    public String reverseWords(String s) {
        char[] strArr = s.toCharArray();
        // 去掉首尾以及中间多余的空格
        strArr = removeExtraSpace(strArr);
        // 反转整个字符串
        reverse(strArr, 0, strArr.length - 1);
        // 反转单词
        reverseEachWord(strArr);
        return new String(strArr);
    }

    // 快慢指针去除首尾和中间多余的多个空格，类似于移除数组中的指定元素
    private char[] removeExtraSpace(char[] strArr) {
        int slow = 0;
        for (int fast = 0; fast < strArr.length; fast++) {
            // 先用快指针移除所有的空格
            if (strArr[fast] != ' ') {
                // 再用 slow 加空格，除第一个单词外，单词末尾要加空格
                if (slow != 0)
                    strArr[slow++] = ' ';
                // fast 遇到空格或遍历到字符串末尾，则说明遍历完了一个单词
                while (fast < strArr.length && strArr[fast] != ' ')
                    strArr[slow++] = strArr[fast++];
            }
        }
        // 新建数组并拷贝
        char[] newStr = new char[slow];
        System.arraycopy(strArr, 0, newStr, 0, slow);
        return newStr;
    }

    private void reverse(char[] strArr, int left, int right) {
        if (right >= strArr.length)
            return;
        while (left < right) {
            char temp = strArr[left];
            strArr[left++] = strArr[right];
            strArr[right--] = temp;
        }
    }

    // 单词反转
    private void reverseEachWord(char[] strArr) {
        int start = 0;
        // end <= strArr.length 为了让 end 每次指向单词末尾后一个位置
        for (int end = 0; end <= strArr.length; end++) {
            if (end == strArr.length || strArr[end] == ' ') {
                reverse(strArr, start, end - 1);
                start = end + 1;
            }
        }
    }
}
