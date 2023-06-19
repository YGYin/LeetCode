package coding.string;

public class ReverseStr_02 {
    // 每隔 2k 个反转前 k 个，尾数不够 k 个时候全部反转
    // 时间复杂度: O(n)  空间复杂度: O(1)
    public String reverseStr(String s, int k) {
        char[] str = s.toCharArray();
        for (int i = 0; i < str.length; i += 2 * k) {
            int left = i;
            // 看剩下够不够 k 个，够的话反转 k 个，不够全部反转
            int right = Math.min(left + k - 1, str.length - 1);
            while (left < right) {
                char temp = str[left];
                str[left++] = str[right];
                str[right--] = temp;
            }
        }
        return new String(str);
    }
}
